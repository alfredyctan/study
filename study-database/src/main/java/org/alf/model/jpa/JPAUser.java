package org.alf.model.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.alf.model.User;
import org.alf.model.UserGroup;

@Entity
@Table(name = "User")
public class JPAUser implements User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = User.ID)
	private Integer id;

	@Column(name = User.NAME)
	private String name;

	@Column(name = User.EMAIL)
	private String email;

	@Column(name = User.DOB)
	private Date dob;

	@JoinTable(
		name="UserGroupAssn",
		joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="USERGROUP_ID", referencedColumnName="ID")
	)
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<JPAUserGroup> userGroups;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Collection<JPAUserAttribute> userAttributes;
	
	public JPAUser() {
	}

	public JPAUser(String name, String email, String dob) {
		this.name = name;
		this.email = email;
		try {
			this.dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public JPAUser(String name, String email, Date dob) {
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public JPAUser(int id, String name, String email, String dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		try {
			this.dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public JPAUser(int id, String name, String email, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
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
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Date getDob() {
		return dob;
	}

	@Override
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public Collection<UserGroup> getUserGroups() {
		return (Collection) userGroups;
	}

	@Override
	public void setUserGroups(Collection<UserGroup> userGroups) {
		this.userGroups = (Collection) userGroups;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JPAUser [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (dob != null)
			builder.append(dob.getClass().getName() + ": dob=").append(dob).append(", ");
		if (userGroups != null)
			builder.append("userGroups=").append(userGroups.size()).append(", ");
		if (userAttributes != null)
			builder.append("userAttributes=").append(userAttributes);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		JPAUser other = (JPAUser) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (dob.getTime() != other.dob.getTime())
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
