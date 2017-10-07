package org.alf.model;

import java.util.Date;

public interface User {
	
	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public Date getDob();

	public void setDob(Date dob);
	
}
