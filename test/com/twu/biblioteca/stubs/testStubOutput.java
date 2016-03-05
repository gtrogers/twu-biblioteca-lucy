package com.twu.biblioteca.stubs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStubOutput {
    @Test
    public void testStoresLastOutputLine() {
        // Given
        StubOutput stubOutput = new StubOutput();
        stubOutput.write("Hello");

        // When
        String lastMessage = stubOutput.getLastMessage();

        // Then
        assertEquals("Hello", lastMessage);
    }

    @Test
    public void testStoresLastOutputLineForManyLines() {
        // Given
        StubOutput stubOutput = new StubOutput();
        stubOutput.write("foo");
        stubOutput.write("bar");
        stubOutput.write("zap");

        // When
        String lastMessage = stubOutput.getLastMessage();

        // Then
        assertEquals("zap", lastMessage);
    }

    @Test
    public void testOutputContainsAMessage() {
        // Given
        StubOutput stubOutput = new StubOutput();
        stubOutput.write("woozle");
        stubOutput.write("wozzle");

        // When
        boolean containsPresentMessage = stubOutput.containsMessage("woozle");
        boolean containsMissingMessage = stubOutput.containsMessage("missing");

        // Then
        assertEquals(containsMissingMessage, false);
        assertEquals(containsPresentMessage, true);
    }

}
