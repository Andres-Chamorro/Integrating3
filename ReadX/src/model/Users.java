package model;

import java.util.Calendar;

public abstract class Users {
    private String nameUser;
    private String id;
    private Calendar dateVinculation;

    public Users(String nameUser, String id, Calendar dateVinculation) {
        this.nameUser = nameUser;
        this.id = id;
        this.dateVinculation = dateVinculation;
    }

    public Users() {
    }

    public String getNameUser() {
        return this.nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getDateVinculation() {
        return this.dateVinculation;
    }

    public void setDateVinculation(Calendar dateVinculation) {
        this.dateVinculation = dateVinculation;
    }

}