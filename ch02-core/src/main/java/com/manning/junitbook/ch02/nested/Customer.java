package com.manning.junitbook.ch02.nested;

import java.util.Date;
import java.util.Objects;

public class Customer {
    private Gender gender;
    private String lastName;
    private String firstName;

    private String middleName;
    private Date becomeCustomer;

    public static class Builder {
        private Gender gender;
        private String lastName;
        private String firstName;

        private String middleName;
        private Date becomeCustomer;

        public Builder(Gender gender, String lastName, String firstName) {
            this.gender = gender;
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withBecomeCustomer(Date date) {
            this.becomeCustomer = date;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.gender = builder.gender;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.becomeCustomer = builder.becomeCustomer;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBecomeCustomer() {
        return becomeCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return gender == customer.gender &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(middleName, customer.middleName) &&
                Objects.equals(becomeCustomer, customer.becomeCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, firstName, lastName, middleName, becomeCustomer);
    }
}
