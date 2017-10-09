package org.alf.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.alf.model.UserGroup;

@Entity
@Table(name = "UserGroup")
public class JPAUserGroup implements UserGroup {

	@Id
	@Column(name = UserGroup.ID)
	private int id;
	
	@Column(name = UserGroup.NAME)
	private String name;

	public JPAUserGroup() {
	}
	
	public JPAUserGroup(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JPAUserGroup [id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
