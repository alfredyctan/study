package org.alf.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.alf.model.Group;

@Entity
@Table(name = "Group")
public class JPAGroup implements Group {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	public JPAGroup() {
	}
	
	public JPAGroup(int id, String name) {
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
}
