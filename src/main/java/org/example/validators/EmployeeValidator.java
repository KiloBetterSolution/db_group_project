package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.EmployeeRequest;

public class EmployeeValidator {

    private static final int ID_11 = 11;

    EmployeeRequest employeeRequest;

    public EmployeeValidator() {
        this.employeeRequest = employeeRequest;
    }

    public void validateEmployee(EmployeeRequest employeeRequest)
            throws InvalidException {

        int bankAccountNumberLength = employeeRequest.getBankAccountNumber()
                .length();
        if (bankAccountNumberLength != ID_11) {
            throw new InvalidException(Entity.EMPLOYEE,
                    "Invalid Bank Account Number");
        }
    }
}
