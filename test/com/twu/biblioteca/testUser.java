package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class testUser {

    User user = new User("Ringo Starr", "ringo@email.com", "06534374857", "333-2345", "letmein");
    Book book = Mockito.mock(Book.class);

    @Test
    public void canGetUserLibraryNumber() {
        assertEquals("333-2345", user.getLibraryNumber());
    }

    @Test
    public void canGetUserPassword() {
        assertEquals("letmein", user.getPassword());
    }

    @Test
    public void usersShouldNotBeLoggedInAsDefault() {
        assertEquals(false, user.getStatus());
    }

    @Test
    public void userLoginStatusCanBeUpdated() {
        user.changeStatus();
        assertEquals(true, user.getStatus());
    }

    @Test
    public void canKeepTrackOfItemsBorrowedByUser() {
        user.addToBorrowedItems(book);
        assertEquals(book, user.getBorrowedItems().get(0));
    }

    @Test
    public void shouldSeeUserInfoIfLoggedOn() {
        assertEquals("Please sign in to see your details.", user.getUserInfo());
    }

//    @Test
//    public void shouldSeeDetailsIfSignedIn() {
//        ArrayList<User> userList = new ArrayList<User>() {{
//            add(user);
//        }};
//        Library lib = new Library();
//        UserManager userMgr = new UserManager();
//        userMgr.signIn("333-2345", "letmein");
//        String expected = "Ringo Starr      ringo@email.com            06534374857\n";
//        assertEquals(expected, user.getUserInfo());
//        user.signOut();
//        assertEquals(false, user.getStatus());
//    }

}
