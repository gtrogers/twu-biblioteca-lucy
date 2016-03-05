package com.twu.biblioteca.stubs;

import com.twu.biblioteca.LibraryOutput;

import java.util.ArrayList;

public class StubOutput implements LibraryOutput {

    private ArrayList<String> messages;

    public StubOutput() {
        this.messages = new ArrayList<String>();
    }

    @Override
    public String write(String message) {
        this.messages.add(message);
        System.out.println(message);
        return message;
    }

    public String getLastMessage() {
        return this.messages.get(this.messages.size() - 1);
    }

    public boolean containsMessage(String message) {
        return this.messages.contains(message);
    }
}
