package com.CustomerManagement.dal;

import com.CustomerManagement.model.Customer;

import java.io.*;
import java.util.ArrayList;

public class CustomerDB {
    ArrayList<Customer> customers;
    static final String PATH = "customer_list.csv";

    public CustomerDB(){
        customers = new ArrayList<>();
    }

    public void createFile() throws IOException {
        File file = new File(PATH);
        if (file.exists()){
            System.out.println("File is already exists.");
        } else {
            file.createNewFile();
        }
    }

    public void writeFile() throws IOException {
        createFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));

        for (int i = 0; i < customers.size(); i++) {
            bufferedWriter.write(customers.get(i).toStringCSV());
        }

        bufferedWriter.close();
    }

    public void readFile() throws IOException {
        createFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] str = line.split(",");
            customers.add(new Customer(str[0], str[1], str[2], str[3], str[4]));
        }
        bufferedReader.close();
    }

    public void add(Customer customer){
        customers.add(customer);
    }

    public Customer findCustomer(String phoneNumber){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().equals(phoneNumber)){
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean checkPhoneNumber(String phoneNumber){
        return customers.contains(findCustomer(phoneNumber));
    }

    public void printInfo(String phoneNumber){
        System.out.println(findCustomer(phoneNumber).toString());
    }

    public void printList(){
        System.out.println(customers.toString());
    }

}
