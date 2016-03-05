package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testUserManager {

    Library lib = new Library();
    User user1 = Mockito.spy(new User("Ringo Starr", "ringo@email.com", "06534374857", "333-2345", "letmein"));

    ArrayList<User> userList = new ArrayList<User>();

    @Before
    public void setUp() {
        userList.add(user1);
    }

    @Test
    public void testUserCanSuccessfullySignIn() {
        lib.addToUserList(user1);
        UserManager userMgr = new UserManager(userList);
        assertEquals(true, userMgr.signIn("333-2345", "letmein"));
    }

    @Test
    public void testUnsuccessfulUserLogin() {
        lib.addToUserList(user1);
        UserManager userMgr = new UserManager(userList);
        assertEquals(false, userMgr.signIn("333-2345", "password"));
    }

}