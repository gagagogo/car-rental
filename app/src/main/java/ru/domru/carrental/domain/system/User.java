package ru.domru.carrental.domain.system;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="\"USER\"")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select o from User o") })
public class User implements Serializable {
    private static final long serialVersionUID = 63592899178651170L;
    
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "DESCR", nullable = false)
    @NotNull
    private String descr;
    
    @JsonView(DataTablesOutput.View.class)
    @Id
    @Column(name = "ID_USER", nullable = false)
    private int idUser;
    
    @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<History> historyList;
    
    @JsonView(DataTablesOutput.View.class)
    @Column(name = "NAME", nullable = false)
    @NotNull
    @Size(min=2, max=32)
    private String name;

    @JsonView(DataTablesOutput.View.class)
    @Column(name = "PASS", nullable = false)
    @NotNull
    private String password;

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

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public History addHistory(History history) {
        getHistoryList().add(history);
        history.setUser(this);
        return history;
    }

    public History removeHistory(History history) {
        getHistoryList().remove(history);
        history.setUser(null);
        return history;
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
