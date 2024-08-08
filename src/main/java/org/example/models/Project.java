package org.example.models;

public class Project {

    private int id;
    private String name;
    private double value;
    private Status status;
    private int clientId;
    private int teachLeadId;

    public Project(int id, int clientId, Status status, String name,
                   double value, int teachLead_id) {
        this.id = id;
        this.clientId = clientId;
        this.status = status;
        this.name = name;
        this.value = value;
        this.teachLeadId = teachLead_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTeachLeadId() {
        return teachLeadId;
    }

    public void setTeachLeadId(int teachLeadId) {
        this.teachLeadId = teachLeadId;
    }
}

