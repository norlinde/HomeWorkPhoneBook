import users.PhoneBook;
import users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    Scanner scanner = new Scanner(System.in);
    PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {
        String userInput = "";

        do {
            System.out.println("WELCOME!");
            System.out.println("\nYou are in the Phone Book. What would you wish to do?");
            System.out.println("\n1. Add contact");
            System.out.println("2. View all contacts");
            System.out.println("3. View single contact");
            System.out.println("4. Remove contact");
            System.out.println("5. Update contact");
            System.out.println("6. Sort by name");
            System.out.println("7. Search");
            System.out.println("8. Exit the Phone Book");


            System.out.print("Choose activity number:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "8":
                    System.out.println("\nHave a great day!");
                    break;
                case "1":
                    addContact();
                    break;
                case "2":
                    getAllContacts();
                    break;
                case "3":
                    getSingleContact();
                    break;

                case "4":
                    removeContact();
                    break;

                case "5":
                    updateContacts();
                case "6":
                    sortByName();
                    break;
                case "7":
                    search();
                    break;
                default:
                    break;
            }
            System.out.print("\n Enter C to continue\n");
            scanner.nextLine();
        } while (!userInput.equals("7"));

        return;
    }

    void addContact() {

        System.out.println("\nAdd contact!");

        User user = new User();
        System.out.print("\nEnter name: ");
        user.name = scanner.nextLine();

        System.out.print("\nEnter phone number: ");
        user.phoneNumber = scanner.nextInt();

        scanner.nextLine();
        System.out.print("\nEnter e-mail: ");
        user.email = scanner.nextLine();

        user.id = UUID.randomUUID();

        String message = phoneBook.addContact(user);
        System.out.println(message);
    }

    void getAllContacts() {
        ArrayList<User> allUser = phoneBook.getAllContacts();

        System.out.println("\nYou have accessed to all contacts in The Phone Book\n");
        System.out.println("Id\t Name\t Phone Number\t E-mail\t");
        int counter = 0;

        for (User user : allUser) {
            System.out.println(counter + ". \t" + user.name + " \t" + user.phoneNumber + " \t" + user.email);
            counter++;
        }
    }

    void getSingleContact() {
        System.out.println("View Contact\n");
        System.out.println("Enter contact's ID");

        int userId = scanner.nextInt();
        User user = phoneBook.getSingleContact(userId);

        System.out.print("Contact ID: " + user.id + " | ");
        System.out.print("Contact Name: " + user.name + " | ");
        System.out.print("Contact Phone Number: " + user.phoneNumber + " | ");
        System.out.print("Contact E-mail: " + user.email + " | ");
    }

    void removeContact() {
        System.out.println("Delete Contact\n");
        System.out.println("Enter ID");

        int userId = scanner.nextInt();
        String message = phoneBook.removeContact(userId);
        System.out.println(message);

    }

    void updateContacts() {
        User user = new User();

        this.getAllContacts();

        System.out.println("Update contact");
        System.out.println("Enter contact's ID");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new name");
        user.name = scanner.nextLine();
        System.out.println("Enter new phone number");
        user.phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new email");
        user.email = scanner.nextLine();

        String response = phoneBook.updateContact(userId, user);
        System.out.println(response);
    }

    void sortByName() {
        System.out.println("Sort contacts by name");
        phoneBook.sortByName();
        getAllContacts();
    }

    void search() {

        System.out.println("What ever it is, we will find it!");
        System.out.print("Write here: ");

        String findContact = scanner.nextLine();
        for (User user : phoneBook.users) {
            if (user.name.contains(findContact))
                System.out.println("We found it for you:  " + user.name + " | " + user.phoneNumber + " | " +user.email  + " | " );

            else {
                System.out.println("Sorry. Couldn't find - " + findContact + ". " + " Try again!");


            }
        }
    }
}