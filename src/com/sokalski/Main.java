package com.sokalski;

import java.util.Scanner;

public class Main {
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("666 777 888");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit) {
            System.out.println("Enter actions. Press 6 to see all possible options.");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void addNewContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String number = scanner.nextLine();

        Contact newContact = Contact.createContact(name, number);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ number);
        }
        else {
            System.out.println("Cannot add, " + name + " already on file");
        }

    }

    private static void updateContact() {
        System.out.println("Enter contact name ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Contact updated");

        }
        else {
            System.out.println("Error updating");
        }

    }

    private static void removeContact() {
        System.out.println("Enter contact name ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.deleteContact(existingContact)) System.out.println("Contact deleted");
        else System.out.println("Error deleting record");
    }

    private static void queryContact() {
        System.out.println("Enter contact name ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + "\nPhone number: " + existingContact.getPhoneNumber());

    }



    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

}
