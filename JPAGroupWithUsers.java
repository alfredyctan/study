package org.alf.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.alf.model.GroupWithUsers;
import org.alf.model.User;

@Entity
public class JPAGroupWithUsers extends JPAGroup implements GroupWithUsers {

	private List<User> users;
	
	public JPAGroupWithUsers() {
		super();
	}

	
	public JPAGroupWithUsers(int id, String name, List<User> users) {
		super(id, name);
		this.users = users;
	}


	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
