package com.CustomerManagement.presentation;

import com.CustomerManagement.model.Customer;
import com.CustomerManagement.service.CustomerService;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            customerService.loadFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("WELCOME TO OUR CUSTOMER MANAGEMENT SYSTEM!!");
        System.out.println("Please choose your order.");
        int choose = 1;
        while (choose != 0){
            createMenu();
            System.out.println("Please enter number: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    try {
                        add();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: findCustomer();
                    break;
                case 3: printCustomerInformation();
                    break;
                case 4: printList();
                    break;
                case 5:
                    try {
                        addTransaction();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("Exit out of Customer Management System.");

    }

    public static void createMenu(){

        System.out.println("------------------MENU------------------");
        System.out.println("\t 1. Add new Customer.");
        System.out.println("\t 2. Find Customer by phone number.");
        System.out.println("\t 3. Print Customer information.");
        System.out.println("\t 4. Print Customer list.");
        System.out.println("\t 5. Add more transaction to Customer.");
        System.out.println("\t 0. Exit system!");
        System.out.println();
    }

    public static void add() throws IOException {
        System.out.println("Enter customer name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter customer address: ");
        String address = new Scanner(System.in).nextLine();
        System.out.println("Enter customer phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Enter customer email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Enter customer gender: ");
        String gender = new Scanner(System.in).nextLine();
        if (customerService.checkPhoneNumber(phoneNumber)){
            System.out.println("This phone number already exist.");
        } else {
            customerService.add(new Customer(name,address,phoneNumber,email,gender));
            System.out.println("Register new customer successfully.");
        }
    }

    public static void findCustomer(){
        System.out.println("Please enter your phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        if (customerService.checkPhoneNumber(phoneNumber)){
            System.out.println("Customer name: "+ customerService.getCustomerByPhoneNumber(phoneNumber).getName() +
                    ", Address: " + customerService.getCustomerByPhoneNumber(phoneNumber).getAddress() +
                    ", Phone number: " + customerService.getCustomerByPhoneNumber(phoneNumber).getPhoneNumber() +
                    ", Email: " + customerService.getCustomerByPhoneNumber(phoneNumber).getEmail() +
                    ", Gender: " + customerService.getCustomerByPhoneNumber(phoneNumber).getGender());
        } else {
            System.out.println("Don't have this phone number!");
        }
    }

    public static void printCustomerInformation(){
        System.out.println("Please enter your phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        if (customerService.checkPhoneNumber(phoneNumber)){
            System.out.println(customerService.getCustomerByPhoneNumber(phoneNumber).toString());
        } else {
            System.out.println("Don't have this phone number!");
        }
    }

    public static void printList(){
        customerService.printList();
    }
    public static void addTransaction() throws IOException {
        System.out.println("Please enter your phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        if (!customerService.checkPhoneNumber(phoneNumber)) {
            System.out.println("Don't have this phone number.");
        } else {
            customerService.getCustomerByPhoneNumber(phoneNumber).setNumTransaction(customerService.getCustomerByPhoneNumber(phoneNumber).getNumTransaction()+1);
            System.out.println("Your information updated: " + customerService.getCustomerByPhoneNumber(phoneNumber).toString());
            customerService.updateFile();
        }
    }
}
