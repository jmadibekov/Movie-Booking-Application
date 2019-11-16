package moblima.controller;

import moblima.model.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a controller that helps to read/write data from and to database
 * Assist in instantiating all instances of every classes using data stored in database
 * Assist in saving all instances of every classes into database
 */
public class DBController {

    /**
     * Char used to separate an attribute from another in an instance
     * Necessary to separate data so as to know which belongs to which attribute when creating an instance of a class
     */
    public static final String SEPARATOR = "|";

    /**
     * Read cineplex data from txt file and use the data accordingly to create new cineplex instances
     * Store the cineplex instances into an arrayList to be passed to the MainModel to instantiate Cineplex List
     *
     * @param filename Path to a file containing attributes of all cineplexes
     * @return array of cineplex instances
     * @throws IOException the io exception
     */
    public static ArrayList readCineplex(String filename) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String cinemaName = star.nextToken().trim();
            String cineplexId = star.nextToken().trim();
            double baseTicketCost = Double.parseDouble(star.nextToken().trim());

            // create Cineplex object from file data
            Cineplex cineplex = new Cineplex(cinemaName, cineplexId, baseTicketCost);
            // add to Cineplex list
            alr.add(cineplex) ;
        }
        return alr ;
    }

    /**
     * Read Review data from txt file and use the data accordingly to create new review instances
     * Store the review instances into an arrayList to be passed to the Movie model to instantiate review List
     * Cineplex ID and MovieID are necessary to know which review belongs to which movie from which cineplex
     *
     * @param filename   Path to a file containing attributes of all reviews
     * @param cineplexId the cineplex id
     * @param movieId    the movie id
     * @return array of review instances
     * @throws IOException the io exception
     */
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
                double rating = Double.parseDouble(star.nextToken().trim());
                // create Review object from file data
                Review review = new Review(userName, reviewTitle, reviewBody, date, rating);
                // add to Review list
                alr.add(review) ;
            }
        }
        return alr ;
    }

    /**
     * Read Staff data from txt file and use the data accordingly to create new Staff instances
     * Store the Staff instances into an arrayList to be passed to the Cineplex model to instantiate staff List
     * Cineplex ID is necessary to know which Staff belongs to which cineplex
     *
     * @param filename   Path to a file containing attributes of all staff
     * @param cineplexId the cineplex id
     * @return array of staff instances
     * @throws IOException the io exception
     */
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

    /**
     * Read Customer data from txt file and use the data accordingly to create new Customer instances
     * Store the Customer instances into an arrayList to be passed to the Main model to instantiate customer List
     *
     * @param filename Path to a file containing attributes of all customer
     * @return array of customer instances
     * @throws IOException the io exception
     */
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

    /**
     * Read Showtime data from txt file and use the data accordingly to create new showtime instances
     * Store the showtime instances into an arrayList to be passed to the Movie model to instantiate showtime List
     * Cineplex ID and MovieID are necessary to know which showtime belongs to which movie from which cineplex
     *
     * @param filename   Path to a file containing attributes of all showtimes
     * @param cineplexId the cineplex id
     * @param movieId    the movie id
     * @return array of showtime instances
     * @throws IOException the io exception
     */
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

    /**
     *  Read Booking history data from txt file and use the data accordingly to create new Booking instances
     *  Store the booking instances into an arrayList to be passed to the Customer model to instantiate booking List
     *  Email is necessary to know which booking history belongs to which customer
     *
     * @param filename Path to a file containing attributes of all Bookings
     * @param email the email of a customer
     * @return array of all booking instances
     * @throws IOException the io exception
     */
    public static ArrayList readBookingHistory(String filename, String email) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store bookingHistory data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String emailDB = star.nextToken().trim();
            if (emailDB.compareTo(email) == 0){
                String date = star.nextToken().trim();
                String theatreClass = star.nextToken().trim();
                double totalPrice = Double.parseDouble(star.nextToken().trim());
                String cineplexId = star.nextToken().trim();
                String movieId = star.nextToken().trim();
                String cinemaId = star.nextToken().trim();
                String TID = star.nextToken().trim();
                String chosenSeats = star.nextToken().trim();

                ArrayList<ArrayList<Integer>> seats = new ArrayList<ArrayList<Integer>>();
                ArrayList<String> aList =
                        Stream.of(chosenSeats.split(","))
                                .collect(Collectors.toCollection(ArrayList<String>::new));
                for (int j = 0 ; j<aList.size() ; j++) {
                    ArrayList<String> bList =
                            Stream.of(aList.get(j).split("/"))
                                    .collect(Collectors.toCollection(ArrayList<String>::new));
                    ArrayList<Integer> seat = new ArrayList<Integer>();
                    seat.add(Integer.parseInt(bList.get(0)));
                    seat.add(Integer.parseInt(bList.get(1)));
                    seat.add(Integer.parseInt(bList.get(2)));
                    seats.add(seat);
                }

                // create Booking object from file data
                Booking booking = new Booking(emailDB, date, theatreClass, totalPrice, cineplexId,
                        movieId, cinemaId, TID, seats);
                // add to Booking list
                alr.add(booking) ;
            }
        }
        return alr ;
    }

    /**
     * Read Cinema data from txt file and use the data accordingly to create new Cinema instances
     * Store the Cinema instances into an arrayList to be passed to the Cineplex model to instantiate cinema List
     * Cineplex ID is necessary to know which Cinema belongs to which cineplex
     *
     * @param filename   Path to a file containing attributes of all cinemas
     * @param cineplexId the cineplex id
     * @return array of Cinema instances
     * @throws IOException the io exception
     */
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

    /**
     * Read Holiday data from txt file and use the data accordingly to create new Holiday instances
     * Store the Holiday instances into an arrayList to be passed to the Main model to instantiate holiday List
     *
     * @param filename Path to a file containing attributes of all holidays
     * @return array of holiday instances
     * @throws IOException the io exception
     */
    public static ArrayList readHoliday(String filename) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList)read(filename);
        ArrayList alr = new ArrayList() ;// to store Holiday data

        for (int i = 0 ; i < stringArray.size() ; i++) {
            String st = (String)stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

            String holidayName = star.nextToken().trim();
            String holidayDate = star.nextToken().trim();

            // create Holiday object from file data
            Holiday holiday = new Holiday(holidayName, holidayDate);
            // add to Holiday list
            alr.add(holiday);
        }
        return alr ;
    }

    /**
     * Read Movies data from txt file and use the data accordingly to create new Movie instances
     * Store the Movie instances into an arrayList to be passed to the Cineplex model to instantiate movie List
     * Cineplex id is necessary to know which movie belongs to which cineplex
     *
     * @param filename Path to a file containing attributes of all movies
     * @param cineplexId the cineplex id
     * @return array of Movie instances
     * @throws IOException the io exception
     */
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

    /**
     * Save all cineplex instances into a txt file associated with the filename
     *
     * @param filename Txt file to save all instances of cineplex
     * @param cineplexList the cineplexList
     * @param append   the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveCineplex(String filename, List cineplexList, Boolean append) throws IOException {
//        System.out.println("Saving Cineplex");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < cineplexList.size() ; i++) {
            Cineplex cineplex = (Cineplex)cineplexList.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplex.getCineplexName().trim());
            st.append(SEPARATOR);
            st.append(cineplex.getCineplexId().trim());
            st.append(SEPARATOR);
            st.append(cineplex.getBaseTicketCost());
            alw.add(st.toString()) ;
        }
        write(filename, alw, append);
    }

    /**
     * Save all review instances into a txt file associated with the filename
     * Cineplex id and movie id is necessary to be stored together in the txt file
     * so that we know which review belongs to which movie from which cineplex when reading the txt file
     *
     * @param filename   Txt file to save all instances of review
     * @param reviewList the reviewList
     * @param cineplexId the cineplex id
     * @param movieId    the movie id
     * @param append     the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveReview(String filename, List reviewList, String cineplexId, String movieId, Boolean append) throws IOException {
//        System.out.println("Saving Review");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < reviewList.size() ; i++) {
            Review review = (Review)reviewList.get(i);
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
        write(filename, alw, append);
    }

    /**
     * Save all staff instances into a txt file associated with the filename
     * Cineplex id is necessary to be stored together in the txt file
     * so that we know which staff belongs to which cineplex when reading the txt file
     *
     * @param filename   Txt file to save all instances of staff
     * @param staffList the staffList
     * @param cineplexId the cineplex id
     * @param append the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveStaff(String filename, List staffList, String cineplexId, Boolean append) throws IOException {
//        System.out.println("Saving Staff");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < staffList.size() ; i++) {
            Staff sta = (Staff)staffList.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cineplexId.trim());
            st.append(SEPARATOR);
            st.append(sta.getUser().trim());
            st.append(SEPARATOR);
            st.append(sta.getPassword().trim());
            alw.add(st.toString()) ;
        }
        write(filename, alw, append);
    }

    /**
     * Save all customer instances into a txt file associated with the filename
     *
     * @param filename Txt file to save all instances of customer
     * @param customerList the customerList
     * @param append   the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveCustomer(String filename, List customerList, Boolean append) throws IOException {
//        System.out.println("Saving Customer");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < customerList.size() ; i++) {
            Customer cus = (Customer)customerList.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(cus.getEmail().trim());
            st.append(SEPARATOR);
            st.append(cus.getName().trim());
            st.append(SEPARATOR);
            st.append(cus.getPhoneNumber().trim());
            alw.add(st.toString()) ;
        }
        write(filename, alw, append);
    }

    /**
     * Save all showtime instances into a txt file associated with the filename
     * Cineplex id and movie id is necessary to be stored together in the txt file
     * so that we know which showtime belongs to which movie from which cineplex when reading the txt file
     *
     * @param filename   Txt file to save all instances of showtime
     * @param showtimeList the showtimeList
     * @param cineplexId the cineplex id
     * @param movieId    the movie id
     * @param append     the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveShowtime(String filename, List showtimeList, String cineplexId, String movieId, Boolean append) throws IOException {
//        System.out.println("Saving Showtime");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < showtimeList.size() ; i++) {
            Showtime showtime = (Showtime)showtimeList.get(i);
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
        write(filename, alw, append);
    }

    /**
     * Save all booking instances into a txt file associated with the filename
     * Email is necessary to be stored together in the txt file
     * so that we know which booking belongs to which customer identified by email
     *
     * @param filename   Txt file to save all instances of booking
     * @param bookingList the bookingList
     * @param email the email of a customer
     * @param append the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveBookingHistory(String filename, List bookingList, String email, Boolean append) throws IOException {
//        System.out.println("Saving Booking History");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < bookingList.size() ; i++) {
            Booking book = (Booking)bookingList.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(email.trim());
            st.append(SEPARATOR);
            st.append(book.getDate().trim());
            st.append(SEPARATOR);
            st.append(book.getCinemaClass().trim());
            st.append(SEPARATOR);
            st.append(book.getTotalPrice());
            st.append(SEPARATOR);
            st.append(book.getCineplexName().trim());
            st.append(SEPARATOR);
            st.append(book.getMovieName().trim());
            st.append(SEPARATOR);
            st.append(book.getCinemaId().trim());
            st.append(SEPARATOR);
            st.append(book.getTID().trim());
            st.append(SEPARATOR);

            ArrayList<ArrayList<Integer>> chosenSeats = new ArrayList<ArrayList<Integer>>();
            chosenSeats = book.getChosenSeats();
            StringBuilder chosenSeatsStr = new StringBuilder();
            for (int j = 0 ; j < chosenSeats.size() ; j++) {
                for (int k = 0; k < 3; k++) {
                    chosenSeatsStr.append(String.valueOf(chosenSeats.get(j).get(k)));
                    if (k != 2)
                        chosenSeatsStr.append("/");
                }
                if (j != chosenSeats.size() - 1)
                    chosenSeatsStr.append(",");
            }
            st.append(chosenSeatsStr);
            alw.add(st.toString()) ;
        }
        write(filename, alw, append);
    }

    /**
     * Saves the Cinema to Cineplex.
     * @param filename The directory to save to.
     * @param al The content to be saved in directory.
     * @param cineplexId The Cineplex to store the Cinema in.
     * @param append If true, add List to the end of existing text, else replace all text in directory with List.
     * @throws IOException Exception thrown if IO exception failed or interrupted.
     */
    public static void saveCinema(String filename, List al, String cineplexId, Boolean append) throws IOException {
//        System.out.println("Saving Cinema");
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
        write(filename, alw, append);
    }

    /**
     * Saves all Holidays.
     * @param filename The directory to save to.
     * @param al The content to be saved in directory.
     * @param append If true, add List to the end of existing text, else replace all text in directory with List.
     * @throws IOException Exception thrown if IO exception failed or interrupted.
     */
    public static void saveHoliday(String filename, List al, Boolean append) throws IOException {
//        System.out.println("Saving Holiday");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < al.size() ; i++) {
            Holiday hol = (Holiday)al.get(i);
            StringBuilder st =  new StringBuilder();
            st.append(hol.getHolidayName());
            st.append(SEPARATOR);
            st.append(hol.getHolidayDate());
            alw.add(st.toString()) ;
        }
        write(filename, alw, append);
    }

    /**
     * Save all movie instances into a txt file associated with the filename
     *
     * @param filename Txt file to save all instances of movie
     * @param movieList the movieList
     * @param append the boolean value of append
     * @throws IOException the io exception
     */
    public static void saveMovies(String filename, List movieList, Boolean append) throws IOException {
//        System.out.println("Saving Movie");
        List alw = new ArrayList() ;

        for (int i = 0 ; i < movieList.size() ; i++) {
            Movie movie = (Movie)movieList.get(i);
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
        write(filename, alw, append);
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
    private static void write(String fileName, List data, Boolean append) throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter(fileName, append));
        try {
            for (int i =0; i < data.size() ; i++) {
                out.println((String)data.get(i));
            }
        }
        finally {
            out.close();
        }
    }

    /**
     * Convert a string text to an array (eg. "a,b,c" to {a,b,c} )
     *
     * @param text a string of text
     * @return an array of string
     */
    private static String[] convertToStringArray(String text) {
        return text.split(",");
    }

    /**
     * Convert an array of strings to string text (eg. {a,b,c} to "a,b,c" )
     *
     * @param array array of strings
     * @return string text
     */
    private static String convertStringArrayToString(String[] array) { return String.join(",", array);}
}
