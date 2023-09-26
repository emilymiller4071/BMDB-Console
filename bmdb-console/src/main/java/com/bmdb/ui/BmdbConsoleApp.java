package com.bmdb.ui;

import com.bmdb.console.Console;
import com.bmdb.business.Movie;

import java.util.ArrayList;


public class BmdbConsoleApp {
    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();

        Console console = new Console();
        displayWelcome();

        String wantsToContinue = "y";
        while (wantsToContinue.equalsIgnoreCase("y")) {
            Movie newMovie = new Movie();
            console.println("Enter data for a movie:\n");

            int id = console.getInt("ID: ");
            newMovie.setId(id);
            String title = console.getString("Title: ");
            newMovie.setTitle(title);
            int year = console.getInt("Year: ");
            newMovie.setYear(year);
            String rating = console.getString("Rating: ");
            newMovie.setRating(rating);
            String director = console.getString("Director: ");
            newMovie.setDirector(director);
            console.println(newMovie.toString());
            console.println();
            movies.add(newMovie);
            displayMovies(movies);

            System.out.println();

            console.println();
            wantsToContinue = console.getString("Try again? (y/n): ", "y", "n");
        }

        displayGoodbye();
    }

    private static void displayMovies(ArrayList<Movie> movies) {
        Console.println("\nMovie List:");
        Console.println("ID     TITLE               YEAR    RATING  DIRECTOR");
        Console.println("=====  =================== ====    ======  ================");
        for (Movie movie : movies) {
            Console.println(
                    String.format("%-6d %-20s %-6d %-8s %-20s",
                            movie.getId(), movie.getTitle(), movie.getYear(),
                            movie.getRating().toUpperCase(), movie.getDirector())
            );
        }
        Console.println(); // Add a newline after displaying movies
    }
    private static void displayWelcome() {
        Console.println("Welcome to BMDB Console Application!\n");
    }

    private static void displayGoodbye() {
        Console.print("\nGoodbye!");
    }
}