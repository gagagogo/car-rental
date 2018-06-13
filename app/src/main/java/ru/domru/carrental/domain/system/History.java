package ru.domru.carrental.domain.system;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "History.findAll", query = "select o from History o") })
@Table(name="`HISTORY`")
public class History implements Serializable {
    private static final long serialVersionUID = -8818549657781801106L;
    @Column(nullable = false)
    private String action;
    @Column(name = "CREATE_AT", nullable = false)
    private Timestamp createAt;
    @Column(nullable = false)
    private String field;
    @Id
    @Column(name = "ID_HISTORY", nullable = false)
    private int idHistory;
    @Column(name = "ID_RECORD")
    private int idRecord;
    @Column(name = "ID_TABLE", nullable = false)
    private int idTable;
    @Column(name = "VAL_FROM", nullable = false)
    private String valFrom;
    @Column(name = "VAL_TO", nullable = false)
    private String valTo;
    @ManyToOne
    @JoinColumn(name = "CREATE_BY")
    private User user;

    public History() {
    }

    public History(String action, Timestamp createAt, User user, String field, int idHistory, int idRecord, int idTable,
                   String valFrom, String valTo) {
        this.action = action;
        this.createAt = createAt;
        this.user = user;
        this.field = field;
        this.idHistory = idHistory;
        this.idRecord = idRecord;
        this.idTable = idTable;
        this.valFrom = valFrom;
        this.valTo = valTo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getValFrom() {
        return valFrom;
    }

    public void setValFrom(String valFrom) {
        this.valFrom = valFrom;
    }

    public String getValTo() {
        return valTo;
    }

    public void setValTo(String valTo) {
        this.valTo = valTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
