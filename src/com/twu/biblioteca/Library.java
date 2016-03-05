package com.twu.biblioteca;

import com.twu.biblioteca.io.LibraryOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    // TODO - making this protected for now but should be private once inheritance is removed
    protected LibraryOutput output;

    ArrayList<String> menuItems = new ArrayList<String>(Arrays.asList("List library items"));
    ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem>();
    ArrayList<LibraryItem> movieList = new ArrayList<LibraryItem>();
    private ArrayList<User> userList = new ArrayList<User>();

    public Library(LibraryOutput output) {
        this.output = output;
    }

    public void printMenu() {
        output.write("MAIN MENU");
        int index = 0;
        for (String item : menuItems) {
            index += 1;
            output.write(index + ". " + item);
        }
        output.write("Please make a selection by entering the number:");
    }

    public void printBookList() {
        int index = 0;
        for (LibraryItem book : bookList) {
            index += 1;
            output.write(index + ". " + book.getInfo());
        }
    }

    public void printMovieList() {
        int index = 0;
        for (LibraryItem movie : movieList) {
            index += 1;
            output.write(index + ". " + movie.getInfo());
        }
    }

    public void addToUserList(User user) {
        userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public boolean removeBookFromList(Book book) {
        for (LibraryItem item : bookList) {
            if (item.equals(book)) {
                bookList.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean removeMovieFromList(Movie movie) {
        for (LibraryItem item : movieList) {
            if (item.equals(movie)) {
                movieList.remove(item);
                return true;
            }
        }
        return false;
    }

}
