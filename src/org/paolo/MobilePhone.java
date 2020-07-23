package org.paolo;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

  private ArrayList<Contacts> mobilePhone = new ArrayList<Contacts>();

  public void printMobilePhone() {
    System.out.println("You have " + mobilePhone.size() + " contact in your list.");
    for (Contacts contacts : mobilePhone) {
      System.out.println(
          mobilePhone.indexOf(contacts)
              + 1
              + " - Name:  "
              + contacts.getName()
              + " and the phone Number:  "
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

  public boolean findContact(String name) {
    for (Contacts contacts : mobilePhone) {
      if (contacts.getName().equals(name)) {
        System.out.println("The name is in the list");
        return true;
      }
    }
    return false;
  }
}
