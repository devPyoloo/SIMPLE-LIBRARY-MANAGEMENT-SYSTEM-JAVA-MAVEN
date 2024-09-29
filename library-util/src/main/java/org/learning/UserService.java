package org.learning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    List<User> users;

    public UserService() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewListUsers() {
        users.forEach((user) -> System.out.println("Username: " + user.getName()));
    }

    public void saveUsers() throws IOException {
        // This uses Stream API works natively with the Collection Framework types (List, Set, Map, etc.) also support supports the standard array;
        String result = users.stream().map(User::toString).collect(Collectors.joining("\n"));

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("userLists", true))) {
                writer.write(result + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file " + e.getMessage());
            throw new RuntimeException("could not save user list", e);
        }
    }

    public void searchUser(String name) {
       List<User> foundUser = users.stream().filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

        if(!foundUser.isEmpty()) {
           foundUser.forEach(userName -> System.out.println("Found user: "+ userName));
        } else {
            System.out.println("There is no user registered name " + name + " in our library.");
        }
    }
}
