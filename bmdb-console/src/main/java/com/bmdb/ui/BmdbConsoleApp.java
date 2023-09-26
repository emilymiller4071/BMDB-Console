package com.bmdb.ui;

import com.bmdb.console.Console;
import com.bmdb.business.Movie;

import java.util.ArrayList;


public class BmdbConsoleApp {
    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();

        Console console = new Console();
        displayWelcome();

        boolean wantsToContinue = true;
        while (wantsToContinue) {
            wantsToContinue = displayMenu(movies, console);
        }

        displayGoodbye();
    }

    private static boolean displayMenu(ArrayList<Movie> movies, Console console) {
        boolean wantsToContinue = true;
        console.println("COMMAND MENU:");
        console.println("=============");
        console.println("1  - List All Movies");
        console.println("2  - Add a Movie");
        console.println("3  - Find Movie by ID");
        console.println("4  - Delete a Movie");
        console.println("99 - Exit");
        console.println();
        int choice = console.getInt("Enter Your Selection: ");
        switch (choice) {
            case 1:
                displayMovies(movies, console);
                break;
            case 2:
                addMovie(movies, console);
                break;
            case 3:
                findMovieById(movies, console);
                break;
            case 4:
                deleteMovie(movies, console);
                break;
            case 99:
                return false;
            default:
                console.println("Invalid choice. Please enter a valid option.");
        }
        return wantsToContinue;
    }

        private static void addMovie(ArrayList < Movie > movies, Console console){
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
            movies.add(newMovie);
            console.println();
        }

        private static void displayMovies (ArrayList < Movie > movies, Console console) {
            console.println("\nMovie List:");
            console.println("ID     TITLE               YEAR    RATING  DIRECTOR");
            console.println("=====  =================== ====    ======  ================");
            for (Movie movie : movies) {
                console.println(
                        String.format("%-6d %-20s %-6d %-8s %-20s",
                                movie.getId(), movie.getTitle(), movie.getYear(),
                                movie.getRating().toUpperCase(), movie.getDirector())
                );
            }
            console.println();
        }

        public static void findMovieById(ArrayList<Movie> movies, Console console) {
            int searchId = console.getInt("Enter Movie ID to Find: ");
            boolean isValid = false;

                for (Movie movie : movies) {
                    if (movie.getId() == searchId) {
                        System.out.println("Movie Detail: " + movie.toString().substring(24));
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) {
                    System.out.println("Movie by that ID not found.\n");
                }
            }

        public static void deleteMovie(ArrayList<Movie> movies, Console console) {
            int idToDelete = console.getInt("Enter Movie ID to Delete: ");
            boolean isValid = false;

            for (int currentMovie = 0; currentMovie < movies.size(); currentMovie++) {
                Movie movie = movies.get(currentMovie);
                if (movie.getId() == idToDelete) {
                    console.println("Movie Deleted: " + movie.getTitle());
                    movies.remove(currentMovie);
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Movie by that ID not found. No movies deleted.\n");
            }

//            for (Movie movie : movies) {
//                if (movie.getId() == idToDelete) {
//                    console.println("Movie Deleted: " + movie.getTitle());
//                    movies.remove(idToDelete);
//                }
//            }
        }
        private static void displayWelcome () {
            Console.println("Welcome to BMDB Console Application!\n");
        }

        private static void displayGoodbye () {
            Console.print("\nGoodbye!");
        }
    }
