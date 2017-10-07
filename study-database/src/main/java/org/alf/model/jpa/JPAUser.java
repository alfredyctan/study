package org.alf.model.jpa;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.alf.model.User;

@Entity
@Table(name = "User")
public class JPAUser implements User {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private Date dob;
	
	public JPAUser() {
	}
	
	public JPAUser(int id, String name, String email, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [ID=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (dob != null)
			builder.append("dob=").append(dob);
		builder.append("]");
		return builder.toString();
	}

}
