package org.alf.model;

import java.util.List;

public interface GroupWithUsers extends Group {

	public List<User> getUsers();

	public void setUsers(List<User> users);

}
