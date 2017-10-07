package org.alf.model;

import java.util.List;

public interface UserWithGroups extends User {

	public List<Group> getGroups();

	public void setGroups(List<Group> groups);
	
}
