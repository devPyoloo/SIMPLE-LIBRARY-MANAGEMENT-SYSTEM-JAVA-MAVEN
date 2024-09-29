package org.learning;

public class User {
    private String name;

    public User(String userName) {
        this.name = userName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Username: " + name;
    }
}
