package org.alf.dao;

import java.util.List;

import org.alf.model.UserAttribute;

public interface UserAttributeDAO {

	public List<UserAttribute> getUserAttributesByUserId(int id);
	
	public void removeUserAttributesByUserId(int id);

	public void removeUserAttributes(int id, String name);
}
