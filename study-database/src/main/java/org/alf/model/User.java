package org.alf.model;

import java.util.Date;

public interface User {

	public enum Attr {
		
		ID("id"), NAME("name"), EMAIL("email"), DOB("dob"); 

		private String value;
		
		private Attr(String value) {
			this.value = value;
		}
		
		public String value() {
			return value;
		}
	}
	
	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public Date getDob();

	public void setDob(Date dob);
	
}
