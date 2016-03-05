package com.twu.biblioteca;

import java.io.PrintStream;

public class Output implements LibraryOutput {

    private PrintStream out;

    public Output() {
        this.out = new PrintStream(System.out);
    }

    @Override
    public String write(String message) {
        this.out.println(message);
        return message;
    }
}
