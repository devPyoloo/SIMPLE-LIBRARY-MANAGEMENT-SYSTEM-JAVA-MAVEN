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
        }

    }
}
