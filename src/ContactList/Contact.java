package ContactList;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Contact {
    private String lastName, firstName, phoneNumber;

    public Contact(String lastName, String firstName, String phoneNumber){
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
    public Contact(){

    };

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Path toOurDataPlace = Paths.get("src/src/ContactList");

    Path toOurContactFile = Paths.get(String.valueOf(toOurDataPlace), "contactList.txt");

//    static void write(){
//
//    }

}
