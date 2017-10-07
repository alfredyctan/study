package org.alf.model.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.alf.model.Group;
import org.alf.model.UserWithGroups;

@Entity
public class JPAUserWithGroups extends JPAUser implements UserWithGroups {

	private List<Group> groups;
	
	public JPAUserWithGroups() {
		super();
	}

	public JPAUserWithGroups(int id, String name, String email, Date dob, List<Group> groups) {
		super(id, name, email, dob);
		this.groups = groups;
	}

	@Override
	public List<Group> getGroups() {
		return groups;
	}

	@Override
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

}
