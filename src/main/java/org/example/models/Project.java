package org.example.models;

public class Project {

    private int id;
    private String name;
    private double value;
    private Status status;
    private int client_id;
    private int teachLead_id;

    public Project(int id, int client_id, Status status, String name, double value, int teachLead_id) {
        this.id = id;
        this.client_id = client_id;
        this.status = status;
        this.name = name;
        this.value = value;
        this.teachLead_id = teachLead_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getTeachLead_id() {
        return teachLead_id;
    }

    public void setTeachLead_id(int teachLead_id) {
        this.teachLead_id = teachLead_id;
    }
}

