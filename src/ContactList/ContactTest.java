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
        Path toOurDataPlace = Paths.get("src/ContactList");

        Path toOurContactFile = Paths.get(String.valueOf(toOurDataPlace), "contactList.txt");

        ArrayList<String> contacts = new ArrayList<String>();
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

            if (action <= 0 || action >= 6 ){
                System.out.println("Invalid Selection");
            }

            List<String> currentList = new ArrayList<>();

            switch(action) {

                case 1: {
                    //list of contacts
                    //what i thought would work but did not hve to get help in AM
//                    List<String> currentList = new ArrayList<>();

                    try {
                        currentList = Files.readAllLines(toOurContactFile);
                    } catch (IOException ioe){
                       ioe.printStackTrace();
                    }

                    for(String line: currentList){
                        System.out.println(line);
                    }
                    break;


                }

                case 2:{
                    //add contact

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

                    contacts.add(String.valueOf(contact));

                    try {

//                        Contact c = contact;


                        // If file doesn't exists, then create it.
                        if (Files.notExists(toOurContactFile)) {
                            Files.createFile(toOurContactFile);
                        }

                       try {
                           Files.write(toOurContactFile, contacts);
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
                    //search contact by name
                    try {
                        System.out.println("\nEnter the "
                                + "name to search for: ");
                        String searchterm = reader.next();

                        // Open the file as a buffered reader
                        BufferedReader bf = new BufferedReader(new FileReader(
                                "contactList.txt"));

                        // Start a line count and declare a string to hold our
                        // current line.
                        int linecount = 0;
                        String line;

                        // Let the user know what we are searching for
                        System.out.println("Searching for " + searchterm
                                + " in file...");
                        // Loop through each line, putting the line into our line
                        // variable.
                        boolean noMatches = true;
                        while ((line = bf.readLine()) != null) {
                            // Increment the count and find the index of the word.
                            linecount++;
                            int indexfound = line.indexOf(searchterm.toLowerCase());

                            // If greater than -1, means we found a match.
                            if (indexfound > -1) {
                                System.out.println("\nContact was FOUND\n"
                                        + "\nContact " + linecount + ": " + line);
                                noMatches = false;
                            }

                        }

                        // Close the file after done searching
                        bf.close();
                        if (noMatches) {
                            System.out.println("\nNO MATCH FOUND.\n");
                        }
                    }

                    catch (IOException e) {
                        System.out.println("IO Error Occurred: " + e.toString());
                    }

                    break;

                }
                case 4: {
                    Scanner delete = new Scanner(System.in);

                    //delete a existing contact
                    System.out.println("Enter name of contact to be deleted: ");
                    String contactToDelete = delete.nextLine();
                    Iterator<String> listIterator = currentList.iterator();
                    while(listIterator.hasNext()){
                        String contacts1 = listIterator.next();
                        if (contacts1.equals(contactToDelete)){
                           listIterator.remove();
                        }
                    }
                    break;

                }
                case 5:{
                    //exit
                    System.out.println("Thanks for using the contact list! Goodbye!");

                }



            }
        }

    }
}
