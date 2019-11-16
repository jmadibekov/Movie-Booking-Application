package moblima.controller;
import moblima.model.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StaffController {
    private static Cineplex chosenCineplex;
    public static Cinema chosenCinema;
    public static Movie chosenMovie;
    public static String date;
    private static int[][] startEndTime;
    private static int pos;
    private static String showingStatus;
    private static String title;
    private static String synopsis;
    private static String[] director;
    private static String[] cast;
    private static String ageRequirement;
    private static int duration;

    /**
     * Returns the current Staff's Cineplex in Cineplex.
     *
     * @return Returns the current Staff's Cineplex in Cineplex.
     */
    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    /**
     * Set the Staff's Cineplex upon login.
     *
     * @param chosenCineplex Sets the Staff's Cineplex upon login.
     */
    public static void setChosenCineplex(Cineplex chosenCineplex) {
        StaffController.chosenCineplex = chosenCineplex;
    }

    /**
     * Gets the selected Cinema as Cinema type.
     *
     * @return Gets the selected Cinema as Cinema type.
     */
    public static Cinema getChosenCinema() { return chosenCinema; }

    /**
     * Sets the selected Cinema.
     *
     * @param chosenCinema Sets the selected Cinema.
     */
    public static void setChosenCinema(Cinema chosenCinema) { StaffController.chosenCinema = chosenCinema; }

    /**
     * Gets the selected Movie as Movie.
     *
     * @return Gets the selected Movie as Movie.
     */
    public static Movie getChosenMovie() { return chosenMovie; }

    /**
     * Sets the selected Movie.
     *
     * @param chosenMovie Sets the selected Movie.
     */
    public static void setChosenMovie(Movie chosenMovie) { StaffController.chosenMovie = chosenMovie; }

    /**
     * Checks the input date, if date is valid, return true, else return false.
     *
     * @param date The argument passed as a String to be checked if valid as a date.
     * @return If date is valid, return true, else return false.
     */
    public static boolean setDate(String date) {
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date dateCheck = dateFormat.parse(date);
            if (date.length() == 10){
                if (dateCheck.after(todayDate)){
                    StaffController.date = date;
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        } catch (ParseException pe) {
            return false;
        }
    }

    /**
     * Returns the date attribute as String.
     *
     * @return Returns the date attribute as String.
     */
    public static String getDate(){
        return date;
    }

    /**
     * Sets the Start Time, End Time and Duration of each movie shown in the selected Cinema.
     *
     * @param startEndTime 2-D Array of Integers for Start Time [0] and End Time [1]
     * @param length The Duration of each show.
     */
    public static void setStartEndTime(int[][] startEndTime, int length) {
        StaffController.startEndTime = startEndTime;
        int [] temp = new int[3];
        for (int i = 0; i < length; i++){
            for (int k = i; k < length; k++){
                if(startEndTime[i][0] > startEndTime[k][0]){
                    temp[0] = startEndTime[k][0];
                    temp[1] = startEndTime[k][1];
                    temp[2] = startEndTime[k][2];
                    startEndTime[k][0] = startEndTime[i][0];
                    startEndTime[k][1] = startEndTime[i][1];
                    startEndTime[k][2] = startEndTime[i][2];
                    startEndTime[i][0] = temp[0];
                    startEndTime[i][1] = temp[1];
                    startEndTime[i][2] = temp[2];
                }
            }
        }
    }

    /**
     * Gets 2-D Array of Integers of Start Time[0] and End Time[1]
     *
     * @return Gets 2-D Array of Integers of Start Time[0] and End Time[1]
     */
    public static int[][] getStartEndTime(){
        return StaffController.startEndTime;
    }

    /**
     * Login Verification to check if Username&&Password exists. If exists, return true, else return false
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return Login Verification to check if Username&&Password exists. If exists, return true, else return false
     */
    public static boolean login(String username, String password) {
        for (Staff i : chosenCineplex.getStaffList()) {
            if (username.contentEquals(i.getUser()) && password.contentEquals((i.getPassword())))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entered Showtime is valid,
     * if valid add to existing Showtime model, and return True
     * else return False.
     *
     * @param input The start time of the showtime.
     * @param curShowtime Showtime object to be inserted if showtime is valid.
     * @param showtimeList ArrayList of the existing Showtimes.
     * @return * Checks if the entered Showtime is valid,
     * if valid add to existing Showtime model, and return True
     * else return False.
     */
    public static boolean addShowtime (int input, Showtime curShowtime, ArrayList< Showtime > showtimeList ){
        int[][] time = getStartEndTime();
        int end = input + (((getChosenMovie().getDuration()) / 60) * 100) + (getChosenMovie().getDuration() % 60);
        if ((end - 60) % 100 == 0)
            end = end + 40;

        //if input is earlier than the earliest showtime
        if (end <= time[0][0]){
            if (end < 1200)
                System.out.printf("Showtime successfully added. Start time: 0%d and end time: 0%d\n", input, end);
            else
                System.out.printf("Showtime successfully added. Start time: %d and end time: %d\n", input, end);
            curShowtime.setTime(input);
            showtimeList.add(curShowtime);
            return true;
        }
        //if input is later than the latest showtime's end time
        else if (input >= time[pos-1][1]){
            if (end >= 2400 && end < 2500)
                System.out.printf("Showtime successfully added. Start time: %d and end time: 00%d\n", input, end-2400);
            else if (end >= 2500)
                System.out.printf("Showtime successfully added. Start time: %d and end time: 0%d\n", input, end-2400);
            else
                System.out.printf("Showtime successfully added. Start time: %d and end time: %d\n", input, end);
            curShowtime.setTime(input);
            showtimeList.add(curShowtime);
            return true;
        }
        //if input is somewhere between showtimes
        else{
            boolean successful = false;
            for (int i = 0; i < pos-1; i++) {
                //if input time is between the end time of a show, and the start time of a show
                //it is valid, and slot it into that slot.
                if (input >= time[i][1] && end <= time[i+1][0]){
                    curShowtime.setTime(input);
                    showtimeList.add(curShowtime);
                    successful = true;
                    break;
                }
            }
            if (successful) {
                if (end >= 2400 && end < 2500)
                    System.out.printf("Showtime successfully added. Start time: %d and end time: 00%d\n", input, end - 2400);
                else if (end >= 2500)
                    System.out.printf("Showtime successfully added. Start time: %d and end time: 0%d\n", input, end - 2400);
                else
                    System.out.printf("Showtime successfully added. Start time: %d and end time: %d\n", input, end);
                return true;
            }
            else
                return false;
        }
    }

    /**
     * Prints all current Showtime for the selected Cinema and returns the 2-D Array of Start Time[0] and End Time[1]
     * @param temp The index to be used for printing.
     * @return Prints all current Showtime for the selected Cinema and returns the 2-D Array of Start Time[0] and End Time[1]
     */
    public static int[][] printShowtime(int temp){
        ArrayList<Movie> movieList = getChosenCineplex().getMovieList();
        int totalArraySize = 0;
        int[] tempArray = new int[3];
        for (int k = 0; k < movieList.size(); k++)
            totalArraySize += movieList.get(k).getShowtimeList().size();
        //create an empty array for start and end time. It must be large enough so we give it the maximum possible size.
        int[][] startEndTime = new int[totalArraySize * movieList.size()][totalArraySize * movieList.size()];

        for (int i = 0; i < getChosenCineplex().getMovieList().size(); i++) {
            //for each movie, create a showtimeList
            ArrayList<Showtime> showtimeList = movieList.get(i).getShowtimeList();
            for (int j = 0; j < showtimeList.size(); j++) {
                //if cinemaId for particular showtime == chosen cinemaId AND
                //date for that particular showtime == staff input of date
                //add to the empty array
                if (showtimeList.get(j).getCinemaId().contentEquals(getChosenCinema().getCinemaId()) && (showtimeList.get(j).getDate().contentEquals(getDate()))) {
                    int start = showtimeList.get(j).getTime();
                    int end = start + ((movieList.get(i).getDuration()) / 60) * 100 + ((movieList.get(i).getDuration()) % 60);
                    if ((end - 60) % 100 == 0)
                        end = end + 40;
                    tempArray[0] = start;
                    tempArray[1] = end;
                    tempArray[2] = movieList.get(i).getDuration();
                    startEndTime[temp][0] = tempArray[0];
                    startEndTime[temp][1] = tempArray[1];
                    startEndTime[temp][2] = tempArray[2];
                    temp++;
                }
            }
        }
        setStartEndTime(startEndTime, temp);
        StaffController.pos = temp;
        return startEndTime;
    }

    /**
     * Sets the ShowingStatus as String. To be used for adding a new Movie.
     * @param input ShowingStatus to be stored.
     */
    public static void setShowingStatus(String input){
        showingStatus = input;
    }

    /**
     * Sets the Title as String. To be used for adding a new Movie.
     * @param input Title to be stored.
     */
    public static void setTitle(String input){
        title = input;
    }

    /**
     * Sets the Synopsis as String. To be used for adding a new Movie.
     * @param input Synopsis to be stored.
     */
    public static void setSynopsis(String input){
        synopsis = input;
    }

    /**
     * Sets the Directors as String[]. An Array of Director Names. To be used for adding a new Movie.
     * @param input Array of Director names to be stored.
     */
    public static void setDirector(String[] input){
        director = input;
    }

    /**
     * Sets the Casts as String[]. An Array of Cast Names. To be used for adding a new Movie.
     * @param input Array of Casts names to be stored.
     */
    public static void setCast(String[] input){
        cast = input;
    }

    /**
     * Sets the AgeRequirement as String. To be used for adding a new Movie.
     * @param input AgeRequirement to be stored.
     */
    public static void setAgeRequirement(String input){
        ageRequirement = input;
    }

    /**
     * Sets the Duration as int. To be used for adding a new Movie.
     * @param input Duration to be stored.
     */
    public static void setDuration(int input){
        duration = input;
    }

    /**
     * Adds a new Movie to existing ArrayList<Movie>.
     */
    public static void addMovie() {
        String indexStr;
        ArrayList<Movie> temp = chosenCineplex.getMovieList();
        /*Find the latest movie index*/
        int index = 0;
        for (int i = 0; i < temp.size(); i++)
            if (index < Integer.parseInt(temp.get(i).getMovieId()))
                index = Integer.parseInt(temp.get(i).getMovieId());
        index++;
        if (index / 100 > 0)
            indexStr = String.valueOf(index);
        else if (index / 10 > 0)
            indexStr = "0" + index;
        else
            indexStr = "00" + index;

        chosenMovie = new Movie(0, showingStatus, title,
                synopsis, director, cast, 0,
                ageRequirement, 0, chosenCineplex.getCineplexId(), indexStr, duration);

        ArrayList < Movie > movieList = chosenCineplex.getMovieList();
        movieList.add(chosenMovie);
    }

}