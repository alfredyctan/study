package org.alf.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.alf.dao.UserDAO;
import org.alf.model.User;
import org.alf.model.jpa.JPAUser;
import org.alf.model.jpa.JPAUser_;

public class JPACriteriaAPIUserDAO implements UserDAO {

	private EntityManagerFactory factory;
	
	public JPACriteriaAPIUserDAO(Map<String, Object> jpaProps) {
		/*		 
		 * https://docs.jboss.org/hibernate/orm/4.0/hem/en-US/html/transactions.html
		 * 
		 * A EntityManagerFactory is an expensive-to-create, threadsafe object intended 
		 * to be shared by all application threads. It is created once, usually on application startup.
		 * An EntityManager is an inexpensive, non-threadsafe object that should be used once, for a
		 * single business process, a single unit of work, and then discarded. An EntityManager will
		 * not obtain a JDBC Connection (or a Datasource) unless it is needed, so you may safely open
		 * and close an EntityManager even if you are not sure that data access will be needed to serve a particular request.
		 * 
		 */		
		this.factory = Persistence.createEntityManagerFactory("User", jpaProps);
	}

	@Override
	public User getUserById(int id) {
		return factory.createEntityManager().find(JPAUser.class, id);
	}

	@Override
	public List<User> getUsersByIdRange(int from, int to) {
		// if you want to reuse the EntityManager, you need invoke 
		// entityManager.clear() to remove stale data if same entityManager 
		// is used to update data  
		
		EntityManager entityManager = factory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JPAUser> criteria = builder.createQuery(JPAUser.class);
		Root<JPAUser> table = criteria.from(JPAUser.class);
		criteria.select(table);
		criteria.where(builder.between(table.get(JPAUser_.id), from, to));
		TypedQuery<JPAUser> query = entityManager.createQuery(criteria);
		List<JPAUser> results = query.getResultList();
		return (List)results;
	}

	@Override
	public void addUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager .getTransaction().begin();
		entityManager .persist(user);
		entityManager .getTransaction().commit();
	}

	@Override
	public void addUsers(List<User> users) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager .getTransaction().begin();
		for (User user:users) {
			entityManager .persist(user);
		}
		entityManager .getTransaction().commit();
	}

	@Override
	public void removeUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(user.getClass(), user.getId()));
		entityManager.getTransaction().commit();
	}

	@Override
	public void removeUsersByIdRange(int from, int to) {
		EntityManager entityManager = factory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete<JPAUser> criteria = builder.createCriteriaDelete(JPAUser.class);
		Root<JPAUser> table = criteria.from(JPAUser.class);
		criteria.where(builder.between(table.get(JPAUser_.id), from, to));
		
		entityManager.getTransaction().begin();
		entityManager.createQuery(criteria).executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void modifyUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		User entityUser = getUserById(user.getId());
		entityManager.getTransaction().begin();
		entityUser.setName(user.getName());
		entityUser.setEmail(user.getEmail());
		entityUser.setDob(user.getDob());
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> void modifyUsersByIdRange(int from, int to, SingularAttribute<?, T> attr, T value) {
		EntityManager entityManager = factory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<JPAUser> criteria = builder.createCriteriaUpdate(JPAUser.class);
		Root<JPAUser> table = criteria.from(JPAUser.class);
		
		//set value
		criteria.set((SingularAttribute)attr, value);
		
		//where clause
		criteria.where(builder.between(table.get(JPAUser_.id), from, to));
		
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery(criteria);
		query.setFlushMode(FlushModeType.COMMIT);
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
	
}
