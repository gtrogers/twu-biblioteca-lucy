package com.twu.biblioteca;

import com.twu.biblioteca.stubs.StubOutput;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class testLibrary {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Book book1 = Mockito.mock(Book.class);
    private Book book2 = Mockito.mock(Book.class);
    private Movie movie1 = Mockito.mock(Movie.class);
    private Movie movie2 = Mockito.mock(Movie.class);
    private StubOutput testOutput = new StubOutput();
    Library library = new Library(testOutput);

    @Test
    public void testAddMenuItem() throws IOException {
        library.menuItems.add("Quit");
        library.printMenu();

        //TODO test more - also brittle because of numbering
        assertEquals(true, testOutput.containsMessage("2. Quit"));
    }

    @Test
    public void canAddBookToLibraryBookList() {
        library.bookList.add(book1);
        library.bookList.add(book2);
        assertEquals(book1, library.bookList.get(0));
        assertEquals(book2, library.bookList.get(1));
        assertEquals(2, library.bookList.size());
    }

    @Test
    public void canAddMovieToLibraryMovieList() {
        library.movieList.add(movie1);
        library.movieList.add(movie2);
        assertEquals(movie1, library.movieList.get(0));
        assertEquals(movie2, library.movieList.get(1));
        assertEquals(2, library.movieList.size());
    }

    Book book3 = Mockito.spy(new Book("LIFE OF PI", "Yann Martel", "2001"));
    Book book4 = Mockito.spy(new Book("THE CATCHER IN THE RYE", "J.D. Salinger", "1951"));
    Book book5 = Mockito.spy(new Book("TO KILL A MOCKINGBIRD", "Harper Lee", "1960"));
    String expectedBookList =
            "1. LIFE OF PI                 Yann Martel      2001\n" +
            "2. THE CATCHER IN THE RYE     J.D. Salinger    1951\n" +
            "3. TO KILL A MOCKINGBIRD      Harper Lee       1960";

    @Test
    public void canRemoveBorrowedBooksFromList() {
        library.bookList.add(book1);
        library.removeBookFromList(book1);
        assertEquals(false, library.bookList.contains(book1));
    }

    @Test
    public void canRemoveBorrowedMovieFromList() {
        library.movieList.add(movie1);
        library.removeMovieFromList(movie1);
        assertEquals(false, library.movieList.contains(movie1));
    }

    @Test
    public void canPrintLibraryBookList() {
        library.bookList.add(book3);
        library.bookList.add(book4);
        library.bookList.add(book5);
        library.printBookList();

        // TODO - needs more comprehensive testing
        assertEquals(true, testOutput.containsMessage("2. THE CATCHER IN THE RYE     J.D. Salinger    1951\n"));
    }

    Movie movie3 = Mockito.spy(new Movie("THE LIVES OF OTHERS", "2006", "Florian Henckel von Donnersmarck", "8"));
    Movie movie4 = Mockito.spy(new Movie("28 DAYS LATER", "2002", "Danny Boyle", "7"));
    String expectedMovieList =
            "1. THE LIVES OF OTHERS        2006   Florian Henckel von Donnersmarck  8\n" +
            "2. 28 DAYS LATER              2002   Danny Boyle                7";

    @Test
    public void canPrintLibraryMovieList() {
        library.movieList.add(movie3);
        library.movieList.add(movie4);
        library.printMovieList();

        String movie3Description = "1. THE LIVES OF OTHERS        2006   Florian Henckel von Donnersmarck  8\n";

        //TODO - needs more comprehensive testing
        assertEquals(true, testOutput.containsMessage(movie3Description));
    }

    private User user1 = Mockito.mock(User.class);

    @Test
    public void canAddAndGetUserList() {
        library.addToUserList(user1);
        assertEquals(user1, library.getUserList().get(0));
    }

}
