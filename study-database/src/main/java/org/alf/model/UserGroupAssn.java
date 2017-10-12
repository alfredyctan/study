package org.alf.model;

public interface UserGroupAssn {

	public static final String USER_ID = "user_id";
	
	public static final String GROUP_ID = "group_id";

	public int getUserId();

	public void setUserId(int userId);

	public int getGroupId();

	public void setGroupId(int groupId);

}
