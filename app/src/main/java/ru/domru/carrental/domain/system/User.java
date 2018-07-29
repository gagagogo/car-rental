package ru.domru.carrental.domain.system;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="\"USER\"")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select o from User o") })
@Audited
public class User implements Serializable {
    private static final long serialVersionUID = 63592899178651170L;
    
    @Id
    @Column(name = "ID_USER", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUser;
    
    @Column(name = "DESCR", nullable = false)
    @NotEmpty
    private String descr;


    @Column(name = "NAME", nullable = false)
    @NotNull
    @Size(min=2, max=32)
    private String name;

    @Column(name = "PASS", nullable = false)
    @JsonProperty(access=Access.WRITE_ONLY)
    @NotNull
    @NotAudited
    private String password;

    @JsonIgnore
    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "USER_ROLE", 
    	joinColumns = @JoinColumn(name = "ID_USER"), 
    	inverseJoinColumns = @JoinColumn(name = "ID_ROLE")
    )
    private List<Role> roleList;
    
    public User() {
    }

    public User(String descr, int idUser) {
        this.descr = descr;
        this.idUser = idUser;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
    
    
}
