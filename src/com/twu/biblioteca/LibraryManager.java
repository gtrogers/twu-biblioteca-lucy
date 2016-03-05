package com.twu.biblioteca;

import com.twu.biblioteca.io.LibraryOutput;

import java.util.ArrayList;

public class LibraryManager extends Library {

    public LibraryManager(LibraryOutput output) {
        super(output);
    }

    private static final String UNAVAILABLE_MSG = "That item is not available.";
    private static final String INVALID_RETURN_MSG = "That is not a valid item to return";
    private static final String USER_NOT_SIGNED_IN = "Please sign in first. Enter your library number and password separated by a comma";

    ArrayList<LibraryItem> checkedOutItems = new ArrayList<LibraryItem>();

    public void checkUserSignIn(User user) {
        if (user.getStatus()) {
            printMenu(); //print checkout menu
        }
        this.output.write(USER_NOT_SIGNED_IN);
    }




    public Object checkOutItem(ArrayList categoryList, LibraryItem itemToCheckOut, User user) {
        for (Object categoryItem : categoryList)
            if (categoryItem.equals(itemToCheckOut)) {
                checkedOutItems.add(itemToCheckOut);
                user.addToBorrowedItems(itemToCheckOut);
                this.output.write("You've successfully checked out" + itemToCheckOut + ". Enjoy!");
                return itemToCheckOut;
            }
        return UNAVAILABLE_MSG;
    }

    public Object returnItem(LibraryItem itemToReturn) {
        for (LibraryItem item : checkedOutItems) {
            if (item.equals(itemToReturn)) {
                this.output.write("Thank you for returning" + itemToReturn);
                return itemToReturn;
            }
        }
        return INVALID_RETURN_MSG;
    }

}
