package org.alf.dao.jpa;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;

import org.alf.dao.UserDAO;
import org.alf.model.User;
import org.alf.model.jpa.JPAUser;

//@NamedQueries ({
//	@NamedQuery(name="getUserById", query= ),
//	@NamedQuery(name="getUsersByIdRange", query= "")
//})
public class JPAQueryUserDAO implements UserDAO {

	private EntityManagerFactory factory;

	public JPAQueryUserDAO(Map<String, Object> jpaProps) {
		this.factory = Persistence.createEntityManagerFactory("User", jpaProps);
	}

	@Override
	public User getUserById(int id) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM User WHERE id = ?", JPAUser.class);
		query.setParameter(1, id);
		return (User) query.getSingleResult();
	}

	@Override
	public List<User> getUsersByIdRange(int from, int to) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM User WHERE id BETWEEN ? AND ?", JPAUser.class);
		query.setParameter(1, from);
		query.setParameter(2, to);
		return (List<User>) query.getResultList();
	}

	@Override
	public void addUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("INSERT INTO User (id, name, email, dob) VALUES (?, ?, ?, ?)");
		
		entityManager.getTransaction().begin();
		int i = 1;
		query.setParameter(i++, user.getId());
		query.setParameter(i++, user.getName());
		query.setParameter(i++, user.getEmail());
		query.setParameter(i++, user.getDob());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void addUsers(List<User> users) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("INSERT INTO User (id, name, email, dob) VALUES (?, ?, ?, ?)");
		
		entityManager.getTransaction().begin();
		for (User user : users) {
			int i = 1;
			query.setParameter(i++, user.getId());
			query.setParameter(i++, user.getName());
			query.setParameter(i++, user.getEmail());
			query.setParameter(i++, user.getDob());
			query.executeUpdate();
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public void removeUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("DELETE FROM User WHERE id = ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, user.getId());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void removeUsersByIdRange(int from, int to) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("DELETE FROM User WHERE id BETWEEN ? AND ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, from);
		query.setParameter(2, to);
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void modifyUser(User user) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("UPDATE User SET name = ?, email = ?, dob = ? WHERE id = ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, user.getName());
		query.setParameter(2, user.getEmail());
		query.setParameter(3, new SimpleDateFormat("yyyy-MM-dd").format(user.getDob()));
		query.setParameter(4, user.getId());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public <T> void modifyUsersAttributeByIdRange(int from, int to, SingularAttribute<?, T> attr, T value) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("UPDATE User SET " + attr.getName() + " = ? WHERE id BETWEEN ? AND ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, value);
		query.setParameter(2, from);
		query.setParameter(3, to);
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
}
