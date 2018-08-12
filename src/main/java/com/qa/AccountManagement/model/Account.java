package com.qa.AccountManagement.model;


import com.qa.AccountManagement.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;

@Entity
@Table(name = Constants.table_name)
public class Account {

    @Id
    @Column(name = Constants.account_number, columnDefinition = "text", unique = true)
    private String accountNumber;


    @Column(name = Constants.first_name, columnDefinition = "text")
    private String firstName;

    @Column(name = Constants.last_name, columnDefinition = "text")
    private String lastName;


    public Account(){

    }

    public Account(String accountNumber, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
