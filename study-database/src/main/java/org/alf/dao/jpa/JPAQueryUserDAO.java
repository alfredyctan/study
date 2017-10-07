package org.alf.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.SingularAttribute;

import org.alf.dao.UserDAO;
import org.alf.model.User;

public class JPAQueryUserDAO implements UserDAO {

	private EntityManagerFactory factory;
	
	public JPAQueryUserDAO(Map<String, Object> jpaProps) {
		this.factory = Persistence.createEntityManagerFactory("User", jpaProps);
	}

	
//	@Modifying
//	@Query(" UPDATE WikiPage w set name = :name ")
//	public void updateName(@Param("name")String name);
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByIdRange(int from, int to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUsers(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUsersByIdRange(int from, int to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void modifyUsersByIdRange(int from, int to, SingularAttribute<?, T> attr, T value) {
		// TODO Auto-generated method stub
		
	}
	
}
