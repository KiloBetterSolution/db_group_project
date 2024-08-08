package org.example.models;

public enum Role {
    SALES("sales"),
    DELIVERY("delivery"),
    TECHLEAD("techlead");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
