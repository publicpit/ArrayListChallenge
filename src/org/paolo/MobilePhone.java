package org.paolo;

import java.util.ArrayList;

public class MobilePhone {

  private ArrayList<Contacts> mobilePhone = new ArrayList<Contacts>();

  public void printMobilePhone() {
    System.out.println(mobilePhone.size() + " contact/s in your list.");
    if (mobilePhone.size() > 0){
      System.out.println("N°\tName\t\t\t\t\t\tPhone Number");
    }
    for (Contacts contacts : mobilePhone) {
      System.out.println(
		      (mobilePhone.indexOf(contacts)
              + 1)
              + "\t\tName: "
              + contacts.getName() + " - "
              + "\tPhone Number: "
              + contacts.getPhoneNumber());
    }

    // ******* un modo di stampare list.forEach(System.out::println);
    // ******* un modo di stampare list.forEach(System.out::println);
    //    mobilePhones.forEach(m -> System.out.println(m.getName()))
    //    for (int i = 0; i< mobilePhone.size(); i++){
    //      System.out.println((i+1) + " - Name:  " + mobilePhone.get(i).getName() + " and the phone
    // Number:  " + mobilePhone.get(i).getPhoneNumber());
    //    }
  }

  public void addMobilePhone(Contacts contacts) {
    mobilePhone.add(contacts);
  }

  public Contacts findContact(String name) {

    for (Contacts contacts : mobilePhone) {
      if (contacts.getName().equals(name)) {
        return contacts;
      }
    }
    System.out.println("No contacts match your selection");
    return null;
  }

  public boolean findContactFlag(String name) {
    for (Contacts contacts : mobilePhone) {
      if (contacts.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

//  public void findContact1(String name) {
//    Contacts contacts = new Contacts(name, "123");
//    if (mobilePhone.contains(name)) {
//      System.out.println("The name is in the list");
//    } else {
//      System.out.println("The name is NOT in the list");
//    }
//  }


  public void removeMobileContact(String name) {
    Contacts toRemoveContact = findContact(name);
    mobilePhone.remove(toRemoveContact);
  }
}
