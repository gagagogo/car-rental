package ru.domru.carrental.domain.system;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Table(name="ROLE")
@Audited
public class Role {
	
	@Id
	@Column(name="ID_ROLE",nullable=false)
	int idRole;
	
	@Column(name="ROLE",nullable=false)
	String name;
	
    @ManyToMany(mappedBy = "roleList")
    private List<User> usersList;

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
