package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {

//    private final PrintStream out;
    PrintStream out = new PrintStream(System.out);
    ArrayList<String> menuItems = new ArrayList<String>(Arrays.asList("List library items"));
    ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem>();
    ArrayList<LibraryItem> movieList = new ArrayList<LibraryItem>();
    private ArrayList<User> userList = new ArrayList<User>();

//    public Library(PrintStream out) {
//        this.out = out;
//    }
//

    public void printMenu() {
        out.println("MAIN MENU");
        int index = 0;
        for (String item : menuItems) {
            index += 1;
            out.println(index + ". " + item);
        }
        out.println("Please make a selection by entering the number:");
    }

    public void printBookList() {
        int index = 0;
        for (LibraryItem book : bookList) {
            index += 1;
            out.print(index + ". " + book.getInfo());
        }
    }

    public void printMovieList() {
        int index = 0;
        for (LibraryItem movie : movieList) {
            index += 1;
            out.print(index + ". " + movie.getInfo());
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
