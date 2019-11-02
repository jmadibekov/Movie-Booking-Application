package moblima.controller;

import moblima.model.*;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DBController {
    public static final String SEPARATOR = "|";

    public static ArrayList readStaff(String filename, String cineplexId) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexDBId = star.nextToken().trim();
            if (cineplexDBId == cineplexId) {
                String userName = star.nextToken().trim();
                String password = star.nextToken().trim();
                // create Staff object from file data
                Staff sta = new Staff(userName, password, cineplexId);
                // add to Movie list
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

            // create Cinema object from file data
            Customer cus = new Customer(email, name, phoneNum);
            // add to Movie list
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
            if (cineplexDBId == cineplexId && movieDBId == movieId){
                String cinemaId = star.nextToken().trim();
                String date = star.nextToken().trim();
                int time = Integer.parseInt(star.nextToken().trim());
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
            if (cineplexDBId == cineplexId){
                String cinemaId = star.nextToken().trim();
                String cinemaClass = star.nextToken().trim();
                // create Cinema object from file data
                Cinema cinema = new Cinema(cinemaId, cinemaClass);
                // add to Movie list
                alr.add(cinema) ;
            }
        }
        return alr ;
    }

    public static ArrayList readMovies(String filename) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cineplexId = star.nextToken().trim();
            String movieId = star.nextToken(). trim();
            String  title = star.nextToken().trim();
            String  synopsis = star.nextToken().trim();
            String  directorTemp = star.nextToken().trim();
            String[] director = convertToStringArray(directorTemp);
            String  castTemp = star.nextToken().trim();
            String[] cast = convertToStringArray(castTemp);
            String  showingStatus = star.nextToken().trim();
            String  ageRequirement = star.nextToken().trim();
            int numReview = Integer.parseInt(star.nextToken().trim());
            double overallRating = Double.parseDouble(star.nextToken().trim());
            int ticketSales = Integer.parseInt(star.nextToken().trim());

            // create Movie object from file data
            Movie movie = new Movie(0, numReview, showingStatus, title, synopsis,
                    director, cast, overallRating, ageRequirement, ticketSales, cineplexId, movieId);
            // add to Movie list
            alr.add(movie) ;
        }
        return alr ;
    }

    /** Read the contents of the given file. */
    public static List read(String fileName) throws IOException {
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

    private static String[] convertToStringArray(String text) {
        return text.split(",");
    }

    public static void main(String[] args) {
        DBController DBController = new DBController();
        String fileName = "src/MovieData.txt";
        try {
            ArrayList<Movie> moviemodel = DBController.readMovies(fileName);
            Movie a = moviemodel.get(1);
            System.out.println(a.getDirector());
        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

}
