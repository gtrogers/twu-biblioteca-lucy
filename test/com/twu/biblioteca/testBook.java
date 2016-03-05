package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testBook {

    Book book = new Book("THE LIFE OF PI", "Yann Martel", "2001");

    @Test
    public void shouldDisplayBookTitleAuthorYear() {
        String expected = "THE LIFE OF PI             Yann Martel      2001\n";
        assertEquals(expected, book.getInfo());
    }

}
