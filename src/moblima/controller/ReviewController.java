package moblima.controller;

import moblima.model.*;

/**
 * Represents a controller that assist moviegoer when it comes to reviews
 */
public class ReviewController {

    /**
     * Movie chosen by a moviegoer
     */
    private static Movie chosenMovie;


    /**
     * Gets chosen movie of a moviegoer
     *
     * @return the chosen movie of a moviegoer
     */
    public static Movie getChosenMovie() {
        return chosenMovie;
    }

    /**
     * Sets chosen movie of a moviegoer
     *
     * @param chosenMovie the chosen Movie of a moviegoer
     */
    public static void setChosenMovie(Movie chosenMovie) {
        ReviewController.chosenMovie = chosenMovie;
    }

    /**
     * Adjust the overall rating of the movie when a moviegoer sends in a new review with a rating
     * Increments the number of users that left a review for the movie
     * Round up the overall rating to two decimal places
     *
     * @param rating
     */
    public static void setAvgRating(double rating) {
        double totalRating = chosenMovie.getOverallRating()*chosenMovie.getUserCount() + rating;
        chosenMovie.setUserCount(chosenMovie.getUserCount()+1);
        chosenMovie.setOverallRating(Math.round((totalRating/chosenMovie.getUserCount())*100.0)/100.0);
    }

}
