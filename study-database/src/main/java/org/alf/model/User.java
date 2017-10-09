package org.alf.model;

import java.util.Date;

public interface User {

	public static final String ID = "id";
	
	public static final String NAME = "name";
	
	public static final String EMAIL = "email";
	
	public static final String DOB = "dob";
	
	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public Date getDob();

	public void setDob(Date dob);
	
}