package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testLibraryManager {

//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    LibraryManager libraryMgr = new LibraryManager();
    Book book1 = Mockito.mock(Book.class);
    Movie movie1 = Mockito.mock(Movie.class);
    Book book2 = Mockito.mock(Book.class);
    Movie movie2 = Mockito.mock(Movie.class);
    User user = Mockito.mock(User.class);
    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Movie> movieList = new ArrayList<Movie>();

    @Before
    public void setUp() {
        bookList.add(book1);
        movieList.add(movie1);
    }

    @Test
    public void whenUserIsNotSignedIn() {
//        assertEquals("Please sign in first.", libraryMgr.checkUserSignIn(user));
    }


    @Test
    public void canCheckOutOnlyIfUserIsSignedIn() {
        assertEquals(book1, libraryMgr.checkOutItem(bookList, book1, user));
        assertEquals(movie1, libraryMgr.checkOutItem(movieList, movie1, user));
    }

    @Test
    public void cannotReturnUnavailableItems() {
        assertEquals("That item is not available.", libraryMgr.checkOutItem(bookList, book2, user));
        assertEquals("That item is not available.", libraryMgr.checkOutItem(movieList, movie2, user));
    }


    @Test
    public void itemsCanBeReturned() {
        libraryMgr.checkOutItem(bookList, book1, user);
        libraryMgr.checkOutItem(movieList, movie1, user);
        assertEquals(book1, libraryMgr.returnItem(book1));
        assertEquals(movie1, libraryMgr.returnItem(movie1));
    }

    @Test
    public void invalidItemToReturn() {
        assertEquals("That is not a valid item to return", libraryMgr.returnItem(book2));
        assertEquals("That is not a valid item to return", libraryMgr.returnItem(movie2));
    }

}
