package org.learning;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        UserService userService = new UserService();

        while(running) {
            System.out.println();
            System.out.println("1. Add new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add new user");
            System.out.println("5. View list of books");
            System.out.println("6. View list of users");
            System.out.println("7. Search book");
            System.out.println("8. Search user");
            System.out.println("9. Exit");
            System.out.println();
            System.out.println("Please select an option (1-7)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Selected Option: "+choice);
                    boolean addingBook = true;

                    while(addingBook) {
                        System.out.println("Please enter a book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Please enter the author: ");
                        String author = scanner.nextLine();
                        System.out.print("Please enter the genre: ");
                        String genre = scanner.nextLine();

                        Book book = new Book(title, author, genre, true);
                        bookService.addBook(book);

                        System.out.println("Do you still want to add book? (yes/no) ");

                        String continueAddingBook = scanner.nextLine();

                        if(!continueAddingBook.equalsIgnoreCase("yes")) {
                            addingBook = false;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Selected Option: "+choice);
                    System.out.println("Enter the book you want to borrowed: ");
                    String bookName = scanner.nextLine();
                bookService.borrowBook(bookName);
                    break;
                case 3:
                    System.out.println("Selected Option: "+choice);
                    System.out.println("Enter the book title you want to return: ");
                    String borrowedBook = scanner.nextLine();

                    bookService.returnBook(borrowedBook);
                    break;

                case 4:
                    System.out.println("Selected Option: "+choice);
                    boolean addingUSer = true;
                    while(addingUSer){
                        System.out.println("Add new user: ");
                        String userName = scanner.nextLine();
                        User user = new User(userName);
                        userService.addUser(user);

                        System.out.println("Do you still want to add user? (yes/no) ");

                        String continueAddingUser = scanner.nextLine();

                        if(!continueAddingUser.equalsIgnoreCase("yes")) {
                            addingUSer = false;
                        }
                    }

                    break;

                case 5:
                    System.out.println("Selected Option: "+choice);
                    bookService.viewListBooks();
                    System.out.println("Do you want to save it to file? (yes/no)");
                    String saveBooks = scanner.nextLine();
                    if(saveBooks.equalsIgnoreCase("yes")) {
                        bookService.saveBookList();
                    }
                    break;

                case 6:
                    System.out.println("Selected Option: "+choice);
                    userService.viewListUsers();
                    System.out.println("Do you want to save it to file? (yes/no)");
                    String saveUsers = scanner.nextLine();
                    if(saveUsers.equalsIgnoreCase("yes")) {
                        userService.saveUsers();
                    }
                    break;

                case 7:
                    System.out.println("Selected Option: "+choice);

                    System.out.println("Search/Find Book");
                    String findBook = scanner.nextLine();

                    bookService.searchBook(findBook);



                    break;

                case 8:
                    System.out.println("Selected Option: "+choice);
                    System.out.println("Search/Find");
                    String findUser = scanner.nextLine();

                    userService.searchUser(findUser);
                    break;

                case 9:
                    System.out.println("Selected Option: "+choice);
                    System.out.println("Exiting the application. Thank you for using it!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();



    }
}
