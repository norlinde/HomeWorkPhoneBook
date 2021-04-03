package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {

    public ArrayList<User> users = new ArrayList<User>();

    public String addContact(User user) {
        this.users.add(user);
        return user.name + " Added successfully";
    }

    public ArrayList<User> getAllContacts() {
        return users;
    }

    public User getSingleContact(int userId) {
        return this.users.get(userId);
    }

    public String removeContact(int userId) {
        try {
            users.remove(userId);
        } catch (Exception ex) {
            return "Typing error! Try again";
        }
        return "You did it! " + "Contact with ID number " + userId + " is gone now!";
    }

    public String updateContact(int userIndex, User newUser) {
        if (this.users.get(userIndex) != null) {
            User oldUser = this.users.get(userIndex);
            oldUser.name = newUser.name;
            oldUser.phoneNumber = newUser.phoneNumber;
            oldUser.email = newUser.email;
            return "Contact updated successfully";
        }
        return "Contact not found";
    }

    public String sortByName (){
        Collections.sort(users, Comparator.comparing(user -> user.name));
    return "We found it!";
    }


}
