package org.example.exceptions;

public enum Entity {
    EMPLOYEE("Employee");

    private final String entity;

    Entity(String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
