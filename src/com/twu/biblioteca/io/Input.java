package com.twu.biblioteca.io;

import java.util.Scanner;

public class Input implements LibraryInput {
    @Override
    public String GetInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
