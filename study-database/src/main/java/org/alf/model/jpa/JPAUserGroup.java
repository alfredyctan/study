package org.alf.model.jpa;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.alf.model.User;
import org.alf.model.UserGroup;

@Entity
@Table(name = "UserGroup")
public class JPAUserGroup implements UserGroup {

	@Id
	@Column(name = UserGroup.ID)
	private int id;
	
	@Column(name = UserGroup.NAME)
	private String name;

	@ManyToMany(mappedBy = "userGroups")
	private Collection<JPAUser> users;	
	
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
	public Collection<User> getUsers() {
		return (Collection)users;
	}

	@Override
	public void setUsers(Collection<User> users) {
		this.users = (Collection)users;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JPAUserGroup [id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (users != null)
			builder.append("users=").append(users.size());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JPAUserGroup other = (JPAUserGroup) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
