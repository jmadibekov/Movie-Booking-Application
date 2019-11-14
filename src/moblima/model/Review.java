package moblima.model;

import java.util.Calendar;

/**
 * Represents a review for a particular movie belonging to a particular cineplex.
 */
public class Review {
	/**
	 * Name of the reviewer
	 */
	private String name;
	/**
	 * Title of the review
	 */
	private String title;
	/**
	 * Body of the review
	 */
	private String body;
	/**
	 * Date of review made
	 */
	private String date;
	/**
	 * Rating of the review
	 */
	private double rating;

	/**
	 * Instantiates a new Review.
	 *
	 * @param name   Reviewer's name
	 * @param title  Title of the review
	 * @param body   Body of the review
	 * @param date   Date of review made
	 * @param rating Rating of the review
	 */
	public Review(String name, String title, String body, String date, double rating) {
	    this.name = name;
	    this.title = title;
	    this.body = body;
	    this.date = date;
	    this.rating = rating;
    }

	/**
	 * Print output information of relevant attributes of the review
	 * Also for debugging purposes
	 */
	public void output() {
		System.out.printf("Date of review: %s\n", date);
		System.out.printf("Name: %s\n", name);
		System.out.printf("Review Rating: %.2f\n", rating);
		System.out.printf("Title: %s\n", title);
		System.out.printf("Body: %s\n\n", body);
	}

	/**
	 * Sets new Title of the review.
	 *
	 * @param title New value of Title of the review.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets Title of the review.
	 *
	 * @return Value of Title of the review.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets Date of review made.
	 *
	 * @return Value of Date of review made.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets new Date of review made.
	 *
	 * @param date New value of Date of review made.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets new Rating of the review.
	 *
	 * @param rating New value of Rating of the review.
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Sets new Name of the reviewer.
	 *
	 * @param name New value of Name of the reviewer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets Rating of the review.
	 *
	 * @return Value of Rating of the review.
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets new Body of the review.
	 *
	 * @param body New value of Body of the review.
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets Name of the reviewer.
	 *
	 * @return Value of Name of the reviewer.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets Body of the review.
	 *
	 * @return Value of Body of the review.
	 */
	public String getBody() {
		return body;
	}
}
