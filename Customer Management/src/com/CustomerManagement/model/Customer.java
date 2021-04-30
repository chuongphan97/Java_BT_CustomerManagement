package com.CustomerManagement.model;

public class Customer {
    String name;
    String address;
    String phoneNumber;
    String email;
    String gender;
    int numTransaction;

    public Customer() {
    }

    public Customer(String name, String address, String phoneNumber, String email, String gender) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.numTransaction = 0;
    }

    public Customer(String name, String address, String phoneNumber, String email, String gender, int numTransaction) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.numTransaction = numTransaction;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumTransaction() {
        return numTransaction;
    }

    public void setNumTransaction(int numTransaction) {
        this.numTransaction = numTransaction;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", numTransaction=" + numTransaction +
                '}';
    }

    public String toStringCSV(){
        return name + "," +
                address + "," +
                phoneNumber + ","+
                email + "," +
                gender + "," +
                numTransaction + "\n";
    }
}
