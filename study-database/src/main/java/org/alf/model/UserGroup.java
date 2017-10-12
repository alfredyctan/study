package org.alf.model;

import java.util.Collection;

public interface UserGroup {
	
	public static final String ID = "id";
	
	public static final String NAME = "name";

	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public Collection<User> getUsers();

	public void setUsers(Collection<User> users);
}
