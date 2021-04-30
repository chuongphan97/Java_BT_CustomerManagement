package com.CustomerManagement.service;

import com.CustomerManagement.dal.CustomerDB;
import com.CustomerManagement.model.Customer;

import java.io.IOException;

public class CustomerService {
    CustomerDB customerDB = new CustomerDB();

    public void loadFile() throws IOException {
        customerDB.readFile();
    }

    public void updateFile() throws IOException {
        customerDB.writeFile();
    }

    public void add(Customer customer) throws IOException {
        customerDB.add(customer);
        customerDB.writeFile();
    }



    public boolean checkPhoneNumber(String phoneNumber){
        return customerDB.checkPhoneNumber(phoneNumber);
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber){
        return customerDB.findCustomer(phoneNumber);
    }

    public void printList(){
        customerDB.printList();
    }
}
