package moblima.controller;

import moblima.model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Top5Controller {

    private static Cineplex chosenCineplex;

    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    public static void setChosenCineplex(Cineplex chosenCineplex) {
        Top5Controller.chosenCineplex = chosenCineplex;
    }

    public static ArrayList<Movie> getTop5MoviesSales() {
        chosenCineplex.getMovieList().sort(Comparator.comparingInt(Movie::getTicketSales).reversed());
        return chosenCineplex.getMovieList();
    }

    public static ArrayList<Movie> getTop5MoviesRating() {
        chosenCineplex.getMovieList().sort(Comparator.comparingDouble(Movie::getOverallRating).reversed());
        return chosenCineplex.getMovieList();
    }

    public static void undoTop5Movies() {
        chosenCineplex.getMovieList().sort(Comparator.comparing(Movie::getMovieId));
    }

    public static ArrayList < Movie > getMovies() {
        return chosenCineplex.getMovieList();
    }

}
