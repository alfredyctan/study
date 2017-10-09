package org.alf.dao;

import java.util.List;

import org.alf.model.UserGroup;

public interface UserGroupDAO {

	public UserGroup getUserGroupById(int id);
	
	public List<UserGroup> getUserGroupsByIdRange(int from, int to);

	public void addUserGroup(UserGroup userGroup);

	public void removeUserGroup(UserGroup userGroup);

	public void modifyUserGroup(UserGroup userGroup);
	
}
