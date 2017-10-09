package org.alf.model.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.alf.model.User;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
