package ContactList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTest extends Contact{
    public ContactTest(String lastName, String firstName, String phoneNumber) {
        super(lastName, firstName, phoneNumber);
    }

    public static void main(String[] args) {
        Contact contact;
        contact = new Contact();
        int action = 0;
        Path toOurDataPlace = Paths.get("src/src/ContactList");

        Path toOurContactFile = Paths.get(String.valueOf(toOurDataPlace), "contactList.txt");

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while(action != 5){

            System.out.println("Welcome to the Contact list \n" + "What would you like to do?");

            System.out.println("1. View Contacts" + "\n"
                    + "2. Add a new contact" + "\n"
                    + "3. Search a contact by name" + "\n"
                    + "4. Delete an existing contact" + "\n"
                    + "5. Exit");

            Scanner reader = new Scanner(System.in);
            reader.useDelimiter("\n");
            action = reader.nextInt();

            if (action <= 0 || action >= 5 ){
                System.out.println("Invalid Selection");
            }

            switch(action) {

                case 1: {


                }

                case 2:{
                    System.out.println("\n Enter the contacts last name.");
                    String lastname = reader.next();
                    if(lastname == null){
                        System.out.println("\n Invalid Entry");
                        break;
                    } else {
                        contact.setLastName(lastname);
                    }
                    System.out.println("\n Enter the contacts first name.");
                    String firstname = reader.next();
                    if(firstname == null){
                        System.out.println("\n Invalid Entry");
                        break;
                    } else {
                        contact.setFirstName(firstname);
                    }
                    System.out.println("\n Enter the contacts phone number.");
                    String phonenumber = reader.next();
                    if(phonenumber == null){
                        System.out.println("\n Invalid Entry");
                        break;
                    } else {
                        contact.setPhoneNumber(phonenumber);
                    }

                    contacts.add(contact);

                    try {

//                        Contact c = contact;


                        // If file doesn't exists, then create it.
                        if (Files.notExists(toOurContactFile)) {
                            Files.createFile(toOurContactFile);
                        }

                       try {
                           Files.write(toOurContactFile, contact);
                       } catch (IOException ioe){
                           ioe.printStackTrace();
                       }

                        System.out.println("Your contact has been saved.");
                    }

                    catch (IOException e) {
                        e.printStackTrace();
                    }


                break;




                }

                case 3: {

                }
                case 4:{

                }
                case 5:{

                }



            }
        }

    }
}
