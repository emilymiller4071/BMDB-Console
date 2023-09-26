package com.bmdb.ui;

import com.bmdb.console.Console;
import com.bmdb.business.Movie;

public class BmdbConsoleApp {
    public static void main(String[] args) {

        Console console = new Console();
        displayWelcome();

        String wantsToContinue = "y";
        while (wantsToContinue.equalsIgnoreCase("y")) {
            Movie movie = new Movie();
            console.println("Enter data for a movie:\n");

            int id = console.getInt("ID: ");
            movie.setId(id);
            String title = console.getString("Title: ");
            movie.setTitle(title);
            int year = console.getInt("Year: ");
            movie.setYear(year);
            String rating = console.getString("Rating: ");
            movie.setRating(rating);
            String director = console.getString("Director: ");
            movie.setDirector(director);
            console.println(movie.toString());
            console.println();
            wantsToContinue = console.getString("Try again? (y/n): ", "y", "n");
        }

        displayGoodbye();
    }

    private static void displayWelcome() {
        Console.println("Welcome to BMDB Console Application!\n");
    }

    private static void displayGoodbye() {
        Console.print("\nGoodbye!");
    }
}