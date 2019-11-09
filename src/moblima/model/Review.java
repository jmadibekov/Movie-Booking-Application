package moblima.model;

import java.util.Calendar;

public class Review {
	private String name;
	private String title;
	private String body;
	private String date;
	private double rating;
	
	public Review(String name, String title, String body, double rating) {
		this.name = name;
		this.title = title;
		this.body = body;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		if (month < 10) {
			date = Integer.toString(year) + "0" +
					Integer.toString(month) + Integer.toString(day);
		}
		else {
			date = Integer.toString(year) + 
					Integer.toString(month) + Integer.toString(day);
		}
		this.rating = rating;
	}

	public Review(String name, String title, String body, String date, double rating) {
	    this.name = name;
	    this.title = title;
	    this.body = body;
	    this.date = date;
	    this.rating = rating;
    }

    public void output() {
		System.out.printf("Date of review: %s\n", date);
		System.out.printf("Name: %s\n", name);
		System.out.printf("Review Rating: %.2f\n", rating);
		System.out.printf("Title: %s\n", title);
		System.out.printf("Body: %s\n\n", body);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
