package org.alf.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.alf.dao.UserGroupDAO;
import org.alf.model.UserGroup;
import org.alf.model.User;
import org.alf.model.jpa.JPAUserGroup;
import org.alf.model.jpa.JPAUser;

public class JPAQueryUserGroupDAO implements UserGroupDAO {

	private EntityManagerFactory factory;

	public JPAQueryUserGroupDAO(Map<String, Object> jpaProps) {
		this.factory = Persistence.createEntityManagerFactory("Hibernate", jpaProps);
	}

	@Override
	public UserGroup getUserGroupById(int id) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM UserGroup WHERE id = ?", JPAUserGroup.class);
		query.setParameter(1, id);
		return (UserGroup) query.getSingleResult();
	}

	@Override
	public List<UserGroup> getUserGroupsByIdRange(int from, int to) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM UserGroup WHERE id BETWEEN ? AND ?", JPAUserGroup.class);
		query.setParameter(1, from);
		query.setParameter(2, to);
		return (List<UserGroup>) query.getResultList();
	}

	@Override
	public void addUserGroup(UserGroup userGroup) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("INSERT INTO UserGroup (id, name) VALUES (?, ?)");
		
		entityManager.getTransaction().begin();
		int i = 1;
		query.setParameter(i++, userGroup.getId());
		query.setParameter(i++, userGroup.getName());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void removeUserGroup(UserGroup userGroup) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("DELETE FROM UserGroup WHERE id = ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, userGroup.getId());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void modifyUserGroup(UserGroup userGroup) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNativeQuery("UPDATE UserGroup SET name = ? WHERE id = ?");
		
		entityManager.getTransaction().begin();
		query.setParameter(1, userGroup.getName());
		query.setParameter(2, userGroup.getId());
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
}
