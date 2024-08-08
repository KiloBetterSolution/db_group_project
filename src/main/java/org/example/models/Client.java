package org.example.models;

import java.sql.Date;

public class Client {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private Date createDate;
    private int acquiredBy;

    public Client(int id, String name, String address, String phoneNumber,
                  Date createDate, int acquiredBy) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
        this.acquiredBy = acquiredBy;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getAcquiredBy() {
        return acquiredBy;
    }

    public void setAcquiredBy(int acquiredBy) {
        this.acquiredBy = acquiredBy;
    }
}
