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

    public static void setAvgRating(double rating) {
        double totalRating = chosenMovie.getOverallRating()*chosenMovie.getUserCount() + rating;
        chosenMovie.setUserCount(chosenMovie.getUserCount()+1);
        chosenMovie.setOverallRating(Math.round((totalRating/chosenMovie.getUserCount())*100.0)/100.0);
    }

}
