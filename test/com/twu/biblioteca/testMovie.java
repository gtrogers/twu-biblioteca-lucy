package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMovie {

    Movie movie = new Movie("THE LIVES OF OTHERS", "2006", "Florian Henckel von Donnersmarck", "8");

    @Test
    public void shouldDisplayMovieInfo() {
        String expected = "THE LIVES OF OTHERS        2006   Florian Henckel von Donnersmarck  8\n";
        assertEquals(expected, movie.getInfo());
    }

}


