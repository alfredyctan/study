package org.alf.model;

public interface UserAttribute {

	public static final String USER_ID = "user_id";
	
	public static final String NAME = "name";
	
	public static final String VALUE = "value";
	
	public int getUserId();

	public void setUserId(int userId);

	public String getName();

	public void setName(String name);

	public String getValue();

	public void setValue(String value);
}
