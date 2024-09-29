package org.learning;

public class Book {
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String title, String author, String genre, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean getIsAvailability() {
        return isAvailable;
    }

    public void setIsAvailable(boolean availability) {
        this.isAvailable = availability;
    }

    public void successMessage() {
        System.out.println("Book successfully added.");
    }

    public String toString() {
        return "Book title: " + title + "\n" + "Author: " + author + "\n" + "Genre: " + genre + "\n" + "Availability: " + isAvailable;
    }

}
