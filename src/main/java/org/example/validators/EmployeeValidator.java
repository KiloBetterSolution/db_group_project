package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.EmployeeRequest;

public class EmployeeValidator {

    EmployeeRequest employeeRequest;

    public EmployeeValidator() {
        this.employeeRequest = employeeRequest;
    }

    public void validateEmployee(EmployeeRequest employeeRequest)
            throws InvalidException {

        int bankAccountNumberLength = employeeRequest.getBankAccountNumber()
                .length();
        if (bankAccountNumberLength != 11) {
            throw new InvalidException(Entity.EMPLOYEE,
                    "Invalid Bank Account Number");
        }
    }
}
