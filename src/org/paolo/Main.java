package org.paolo;

import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  private static MobilePhone mobilePhone = new MobilePhone();

  public static void main(String[] args) {
    // write your code here
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove
    // contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.
    yourChoice();
  }

  private static void yourChoice() {
    printInstructions();
    boolean quit = false;
    while (!quit) {
      System.out.println("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 0:
          printInstructions();
          break;
        case 1:
          printContact();
          break;
        case 2:
          addContact();
          break;
        case 3:
          modifyContact();
          break;
        case 4:
          removeContact();
          break;
        case 5:
          searchContact();
          break;
        case 6:
          System.out.println("Leaving the application...");
          quit = true;
          break;
        default:
          System.out.println("No correct choice. Enter a number following the instruction...");
          yourChoice();
          break;
      }
    }
  }

  private static void printInstructions() {
    System.out.println("\nPress ");
    System.out.println("\t 0  - To print choice options.");
    System.out.println("\t 1  - To print the list of contact.");
    System.out.println("\t 2  - To add a contact to the list, verifying it is not already there.");
    System.out.println("\t 3  - To modify a contact in the list..");
    System.out.println("\t 4  - To remove a contact from the list.");
    System.out.println("\t 5  - To search for a contact in the list.");
    System.out.println("\t 6  - To quit the application.");
  }

  private static void printContact() {
    mobilePhone.printMobilePhone();
  }

  private static void addContact() {
    Contacts contacts = new Contacts();

    System.out.println("Enter the name");
    String name = scanner.nextLine();
    contacts.setName(name);

    System.out.println("Enter phone number");
    String phoneNumber = scanner.nextLine();
    contacts.setPhoneNumber(phoneNumber);

    mobilePhone.addMobilePhone(contacts);
  }

  private static Contacts modifyContact() {
    System.out.println("Enter the contact name you want to modify");
    String name = scanner.nextLine();

    if (mobilePhone.findContactFlag(name)) {
      Contacts modContacts = mobilePhone.findContact(name);
      modifyingMenu(modContacts);
      return modContacts;
    } else {
      System.out.println("This contact is not present");
    }
    return null;
  }

  private static void modifyingMenu(Contacts modContacts) {
    System.out.println("What do you want to modify?");
    System.out.println("\nPress ");
    System.out.println("\t 0  - To modify name.");
    System.out.println("\t 1  - To modify phoneNumber.");
    int modifyChoice = scanner.nextInt();
    scanner.nextLine();

    switch (modifyChoice) {
      case 0:
        System.out.println("Enter new name: ");
        String modName = scanner.nextLine();
        modContacts.setName(modName);
        break;
      case 1:
        System.out.println("Enter new phoneNumber: ");
        String modPhoneNumber = scanner.nextLine();
        modContacts.setPhoneNumber(modPhoneNumber);
        break;
      default:
        break;
    }
  }

  private static void removeContact() {
    System.out.println("Enter the contact name you want to remove");
    String name = scanner.nextLine();
    mobilePhone.removeMobileContact(name);
  }

  private static void searchContact() {
    System.out.println("Enter the name to search for");
    String name = scanner.nextLine();
    if (mobilePhone.findContactFlag(name)) {
      mobilePhone.findContact(name);
      System.out.println(
          "The contact in the list: "
              + "Name: "
              + mobilePhone.findContact(name).getName()
              + " PhoneNumber: "
              + mobilePhone.findContact(name).getPhoneNumber());
    } else {
      System.out.println("The contact is NOT in the list.");
    }
  }
}
