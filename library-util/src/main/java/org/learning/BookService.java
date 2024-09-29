package org.learning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    List<Book> books;


    public BookService() {
       books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
        book.successMessage();
    }

    public void borrowBook(String title) {
        if(title == null || title.isEmpty()) {
            System.out.println("Please provide a valid book title");
            return;
        }
        boolean found = false;
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                if(book.getIsAvailability()) {
                    book.setIsAvailable(false);
                    System.out.println("You have successfully borrowed the book "+ title);

                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
            }

            break;

        }
        if(!found) {
            System.out.println("The book title "+title+ " is not found in out library.");
        }
    }

    public void returnBook(String title){
        boolean found = false;
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                if(!book.getIsAvailability()) {
                    book.setIsAvailable(true);
                    System.out.println("You have successfully returned the book "+ title);

                } else {
                    System.out.println("Sorry, this book is not currently borrowed.");
                }
                break;
            }
        }
        if(!found) {
            System.out.println("The book title "+title+ " is not found in out library.");
        }
    }

    public void viewListBooks() {
        books.forEach((book) -> System.out.println("Book: "+book.getTitle()+"\n"+"Author: "+book.getAuthor()+"\n"+"Genre: "+book.getGenre()+ "\n"+"Availability:  "+book.getIsAvailability()));
    }

    public void saveBookList() throws IOException {
        String result = books.stream().map(Book::toString).collect(Collectors.joining("\n"));

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("bookLists"))){
            writer.write(result + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file" + e.getMessage());
            throw new RuntimeException("Could not save book list", e);
        }
    }

    public void searchBook(String name) {
        List<Book> foundBook = books.stream().filter(book -> book.getTitle().toLowerCase().contains(name.toLowerCase()) ||
                                                            book.getAuthor().toLowerCase().contains(name.toLowerCase()) || book.getGenre().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

        if(!foundBook.isEmpty()) {
            foundBook.forEach(book -> System.out.println("Book Title: "+book.getTitle()+"\n"+"Author: "+book.getAuthor()+"\n"+"Genre: "+book.getGenre()+ "\n"+"Availability:  "+book.getIsAvailability()));
        } else {
            System.out.println("Cannot find "+name+ " in the library. Not found");
        }
    }

}
