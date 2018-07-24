package ru.domru.carrental.audit;

import javax.persistence.Entity;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import ru.domru.carrental.domain.system.User;

/**
 * Custom revision entity supplemented by {@link User} identificator 
 * */
@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevision extends DefaultRevisionEntity {

	private int idUser;

	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}