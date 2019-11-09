package moblima.controller;


import moblima.model.*;

public class ReviewController {

    private static Movie chosenMovie;

    public static Movie getChosenMovie() {
        return chosenMovie;
    }

    public static void setChosenMovie(Movie chosenMovie) {
        ReviewController.chosenMovie = chosenMovie;
    }

}
