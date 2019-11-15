package moblima.controller;
import moblima.model.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Represents a controller that assist staff as they navigate the views specifically assigned to staff
 */
public class StaffController {

    /**
     * Cineplex chosen by a staff
     */
    private static Cineplex chosenCineplex;
    /**
     * Cinema chosen by a staff
     */
    public static Cinema chosenCinema;
    /**
     * Movie chosen by a staff
     */
    public static Movie chosenMovie;
    /**
     *
     */
    public static String date;
    private static int[][] startEndTime;
    private static int pos;

    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    public static void setChosenCineplex(Cineplex chosenCineplex) {
        StaffController.chosenCineplex = chosenCineplex;
    }

    public static Cinema getChosenCinema() { return chosenCinema; }

    public static void setChosenCinema(Cinema chosenCinema) { StaffController.chosenCinema = chosenCinema; }

    public static Movie getChosenMovie() { return chosenMovie; }

    public static void setChosenMovie(Movie chosenMovie) { StaffController.chosenMovie = chosenMovie; }

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



    public static String getDate(){
        return date;
    }

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

    public static int[][] getStartEndTime(){
        return StaffController.startEndTime;
    }

    public static boolean login(String username, String password) {
        for (Staff i : chosenCineplex.getStaffList()) {
            if (username.contentEquals(i.getUser()) && password.contentEquals((i.getPassword())))
                return true;
        }
        return false;
    }

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

}