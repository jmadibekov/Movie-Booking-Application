package moblima.model;

import java.util.Calendar;

public class Review {
	private String name;
	private String title;
	private String body;
	private String date;
	private int rating;
	
	public Review(String name, String title, String body, int rating) {
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

	public Review(String name, String title, String body, String date, int rating) {
	    this.name = name;
	    this.title = title;
	    this.body = body;
	    this.date = date;
	    this.rating = rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
