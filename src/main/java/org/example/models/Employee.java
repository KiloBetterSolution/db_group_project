package org.example.models;

public class Employee {

    private final int id;
    private final String name;
    private final double salary;
    private final String bankAccountNumber;
    private final String nationalInsuranceNumber;

    public Employee(int id, String name, double salary,
                    String bankAccountNumber,
                    String nationalInsuranceNumber) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }
}
