package moblima.controller;

import moblima.model.*;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DBController {
    public static final String SEPARATOR = "|";

    public static ArrayList readReview(String filename, String cineplexId, String movieId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            String movieDBId = star.nextToken().trim();
            if (cineplexDBId.compareTo(cineplexId) == 0 && movieDBId.compareTo(movieId) == 0) {
                String userName = star.nextToken().trim();
                String reviewTitle = star.nextToken().trim();
                String reviewBody = star.nextToken().trim();
                String date = star.nextToken().trim();
                int rating = Integer.parseInt(star.nextToken().trim());
                // create Review object from file data
                Review review = new Review(userName, reviewTitle, reviewBody, date, rating);
                // add to Review list
                alr.add(review) ;
            }
        }
        return alr ;
    }

    public static ArrayList readStaff(String filename, String cineplexId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            if (cineplexDBId.compareTo(cineplexId) == 0) {
                String userName = star.nextToken().trim();
                String password = star.nextToken().trim();
                // create Staff object from file data
                Staff sta = new Staff(userName, password, cineplexId);
                // add to Staff list
                alr.add(sta) ;
            }
        }
        return alr ;
    }

    public static ArrayList readCustomer(String filename) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String email = star.nextToken().trim();
            String name = star.nextToken().trim();
            String phoneNum = star.nextToken().trim();

            // create Customer object from file data
            Customer cus = new Customer(email, name, phoneNum);
            // add to Customer list
            alr.add(cus) ;
        }
        return alr ;
    }

    public static ArrayList readShowtime(String filename, String cineplexId, String movieId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            String movieDBId = star.nextToken().trim();
            if (cineplexDBId.compareTo(cineplexId) == 0 && movieDBId.compareTo(movieId) == 0){
                String cinemaId = star.nextToken().trim();
                int time = Integer.parseInt(star.nextToken().trim());
                String date = star.nextToken().trim();
                String type = star.nextToken().trim();
                String[][] seatLayout = new String[8][];
                for (int j = 0; j < 8; j++) {
                    String rowTemp = star.nextToken().trim();
                    String[] row = convertToStringArray(rowTemp);
                    seatLayout[j] = row;
                }

                // create Showtime object from file data
                Showtime showtime = new Showtime(time, date, type, cinemaId, seatLayout);
                // add to Showtime list
                alr.add(showtime) ;
            }
        }
        return alr ;
    }

    public static ArrayList readCinema(String filename, String cineplexId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            if (cineplexDBId.compareTo(cineplexId) == 0) {
                String cinemaId = star.nextToken().trim();
                String cinemaClass = star.nextToken().trim();
                // create Cinema object from file data
                Cinema cinema = new Cinema(cinemaId, cinemaClass);
                // add to Cinema list
                alr.add(cinema);
            }
        }
        return alr ;
    }

    public static ArrayList readMovies(String filename, String cineplexId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            if (cineplexDBId.compareTo(cineplexId) == 0) {
                String movieId = star.nextToken().trim();
                int numReview = Integer.parseInt(star.nextToken().trim());
                int ticketSales = Integer.parseInt(star.nextToken().trim());
                String  showingStatus = star.nextToken().trim();
                String  title = star.nextToken().trim();
                String  synopsis = star.nextToken().trim();
                String  directorTemp = star.nextToken().trim();
                String[] director = convertToStringArray(directorTemp);
                String  castTemp = star.nextToken().trim();
                String[] cast = convertToStringArray(castTemp);
                double overallRating = Double.parseDouble(star.nextToken().trim());
                String  ageRequirement = star.nextToken().trim();
                int duration = Integer.parseInt(star.nextToken().trim());

                // create Movie object from file data
                Movie movie = new Movie(numReview, showingStatus, title, synopsis,
                        director, cast, overallRating, ageRequirement, ticketSales, cineplexId, movieId, duration);
                // add to Movie list
                alr.add(movie) ;
            }
        }
        return alr ;
    }

    public static void saveReview(String filename, List al, String cineplexId, String movieId) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Review review = (Review)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplexId.trim());
            st.append(SEPARATOR);
            st.append(movieId.trim());
            st.append(SEPARATOR);
            st.append(review.getName().trim());
            st.append(SEPARATOR);
            st.append(review.getTitle().trim());
            st.append(SEPARATOR);
            st.append(review.getBody());
            st.append(SEPARATOR);
            st.append(review.getDate());
            st.append(SEPARATOR);
            st.append(review.getRating());
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    public static void saveStaff(String filename, List al, String cineplexId) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Staff sta = (Staff)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplexId.trim());
            st.append(SEPARATOR);
            st.append(sta.getUser().trim());
            st.append(SEPARATOR);
            st.append(sta.getPassword().trim());
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    public static void saveCustomer(String filename, List al) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Customer cus = (Customer)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cus.getEmail().trim());
            st.append(SEPARATOR);
            st.append(cus.getName().trim());
            st.append(SEPARATOR);
            st.append(cus.getPhoneNumber().trim());
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    public static void saveShowtime(String filename, List al, String cineplexId, String movieId) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Showtime showtime = (Showtime)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplexId.trim());
            st.append(SEPARATOR);
            st.append(movieId.trim());
            st.append(SEPARATOR);
            st.append(showtime.getCinemaId().trim());
            st.append(SEPARATOR);
            st.append(showtime.getDate().trim());
            st.append(SEPARATOR);
            st.append(showtime.getTime());
            st.append(SEPARATOR);
            st.append(showtime.getType().trim());
            st.append(SEPARATOR);
            String[][] seatLayout = showtime.getSeatLayout();
            for (int j = 0; j < 8; j++) {
                if (j != 0) {st.append(SEPARATOR);}
                String[] rowTemp = seatLayout[j];
                String row = convertStringArrayToString(rowTemp);
                st.append(row.trim());
            }
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    public static void saveCinema(String filename, List al, String cineplexId) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Cinema cinema = (Cinema)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplexId.trim());
            st.append(SEPARATOR);
            st.append(cinema.getCinemaId().trim());
            st.append(SEPARATOR);
            st.append(cinema.getCinemaClass().trim());
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    public static void saveMovies(String filename, List al) throws IOException {
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Movie movie = (Movie)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(movie.getCineplexId().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieId().trim());
            st.append(SEPARATOR);
            st.append(movie.getUserCount());
            st.append(SEPARATOR);
            st.append(movie.getTicketSales());
            st.append(SEPARATOR);
            st.append(movie.getShowingStatus().trim());
            st.append(SEPARATOR);
            st.append(movie.getTitle().trim());
            st.append(SEPARATOR);
            st.append(movie.getSynopsis().trim());
            st.append(SEPARATOR);
            st.append(convertStringArrayToString(movie.getDirector()));
            st.append(SEPARATOR);
            st.append(convertStringArrayToString(movie.getCast()));
            st.append(SEPARATOR);
            st.append(movie.getOverallRating());
            st.append(SEPARATOR);
            st.append(movie.getAgeRequirement().trim());
            st.append(SEPARATOR);
            st.append(movie.getDuration());
            alw.add(st.toString()) ;
        }
        write(filename,alw);
    }

    /** Read the contents of the given file. */
    private static List read(String fileName) throws IOException {
        List data = new ArrayList() ;
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
        }
        finally{
            scanner.close();
        }
        return data;
    }

    /** Write fixed content to the given file. */
    private static void write(String fileName, List data) throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        try {
            for (int i =0; i < data.size() ; i++) {
                out.println((String)data.get(i));
            }
        }
        finally {
            out.close();
        }
    }

    private static String[] convertToStringArray(String text) {
        return text.split(",");
    }

    private static String convertStringArrayToString(String[] array) { return String.join(",", array);}

    public static void main(String[] args) {
    }
}
