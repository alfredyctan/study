package org.alf.dao;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.alf.model.User;

public interface UserDAO {

	public User getUserById(int id);
	
	public List<User> getUsersByIdRange(int from, int to);
	
	public void addUser(User user);

	public void addUsers(List<User> users);

	public void removeUser(User user);

	public void removeUsersByIdRange(int from, int to);
	
	public void modifyUser(User user);
	
	public <T> void modifyUsersByIdRange(int from, int to, SingularAttribute<?, T> attr, T value);
}
