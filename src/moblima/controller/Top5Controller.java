package moblima.controller;

import moblima.model.*;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a controller that assist moviegoer and staff to view the top5 movies by sales or rating.
 * Top5 movies are based on a cineplex chosen by staff or moviegoer.
 */
public class Top5Controller {

    /**
     * Cineplex chosen by a moviegoer or a staff.
     */
    private static Cineplex chosenCineplex;


    /**
     * Gets chosen cineplex of a moviegoer or staff.
     *
     * @return the chosen cineplex of a moviegoer or staff
     */
    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    /**
     * Sets chosen cineplex of a moviegoer or staff.
     *
     * @param chosenCineplex the chosen cineplex of a moviegoer or staff
     */
    public static void setChosenCineplex(Cineplex chosenCineplex) {
        Top5Controller.chosenCineplex = chosenCineplex;
    }

    /**
     * Gets top 5 movies of a cineplex by sales.
     *
     * @return the top 5 movies of a cineplex by sales
     */
    public static ArrayList<Movie> getTop5MoviesSales() {
        chosenCineplex.getMovieList().sort(Comparator.comparingInt(Movie::getTicketSales).reversed());
        return chosenCineplex.getMovieList();
    }

    /**
     * Gets top 5 movies of a cineplex by rating.
     *
     * @return the top 5 movies of a cineplex by rating
     */
    public static ArrayList<Movie> getTop5MoviesRating() {
        chosenCineplex.getMovieList().sort(Comparator.comparingDouble(Movie::getOverallRating).reversed());
        return chosenCineplex.getMovieList();
    }

    /**
     * Undo top 5 movies to be sorted back based on movie ID
     */
    public static void undoTop5Movies() {
        chosenCineplex.getMovieList().sort(Comparator.comparing(Movie::getMovieId));
    }

    /**
     * Gets all movies of a cineplex in arrayList
     *
     * @return all movies of a cineplex in arrayList
     */
    public static ArrayList < Movie > getMovies() {
        return chosenCineplex.getMovieList();
    }

}
