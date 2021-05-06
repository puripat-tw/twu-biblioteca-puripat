package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppTest {
    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() throws Exception {
        outputContent = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(outputContent);
        System.setOut(outStream);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        BibliotecaApp.printWelcome();
        String expectedValue = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldListAllBooks() {
        ArrayList<Book> books = new ArrayList<>() {{
            add(new Book("Hello", "Mr. A", 2021));
            add(new Book("World", "Ms. B", 2021));
        }};

        BibliotecaApp.listAllBooks(books);
        String expectedValue = "Hello     Mr. A     2021\nWorld     Ms. B     2021\n";
        assertEquals(expectedValue, outputContent.toString());
    }

    @Test
    public void shouldShowMainMenuOfOptions() {
        String expectedValue = "Main Menu\n1. List of books\n";
        BibliotecaApp.showMainMenu();
        assertEquals(expectedValue, outputContent.toString());
    }
}
