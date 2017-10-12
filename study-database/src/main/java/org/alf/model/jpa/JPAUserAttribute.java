package org.alf.model.jpa;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.alf.model.UserAttribute;

@Entity
@IdClass(JPAUserAttribute.PrimaryKey.class)
@Table(name = "UserAttribute")
public class JPAUserAttribute implements UserAttribute {

	public static class PrimaryKey implements Serializable {
		
		private static final long serialVersionUID = 8803994831216246415L;
		
		private int userId;
		
		private String name;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + userId;
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
			PrimaryKey other = (PrimaryKey) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (userId != other.userId)
				return false;
			return true;
		}
	}
	
	@Id
	@Basic(optional = false)
	@Column(name = UserAttribute.USER_ID, insertable=false, updatable=false)
	private int userId;

	@Id
	@Basic(optional = false)
	@Column(name = UserAttribute.NAME)
	private String name;

	@Basic(optional = false)
	@Column(name = UserAttribute.VALUE)
	private String value;

	@JoinColumn(name = "user_id", referencedColumnName="id")
	@ManyToOne(optional = false)
	private JPAUser user;


	public JPAUserAttribute() {
	}
	
	public JPAUserAttribute(int userId, String name, String value) {
		this.userId = userId;
		this.name = name;
		this.value = value;
	}

	@Override
	public int getUserId() {
		return userId;
	}
	
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setUser(JPAUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JPAUserAttribute [");
		builder.append("userId=").append(userId).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (value != null)
			builder.append("value=").append(value);
		builder.append("]");
		return builder.toString();
	}
}
