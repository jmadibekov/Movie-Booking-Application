package moblima.view;

import moblima.controller.StaffController;
import moblima.model.Showtime;
import moblima.model.Cinema;
import java.util.Scanner;
import java.util.ArrayList;


public class AddShowtime {
    int pos = 0;

    public AddShowtime() {
    }

    public void display(Navigation navigation) {
        String[][] seatLayout = new String[8][9];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 9; j++)
                seatLayout[i][j] = "0";
        Showtime curShowtime = new Showtime(0, "", "", "", seatLayout);
        chooseCinema(navigation, seatLayout, curShowtime);
    }

    private void chooseCinema(Navigation navigation, String[][] seatLayout, Showtime curShowtime) {
        ArrayList<Cinema> cinemaList = StaffController.getChosenCineplex().getCinemaList();

        System.out.printf("\nChosen movie: %s\n\n", StaffController.getChosenMovie().getTitle());
        System.out.println("(0) Back");
        int index = 1;
        for (Cinema i : cinemaList) {
            System.out.printf("(%s) Cinema ID: %s, Cinema Class: %s\n",
                    index, i.getCinemaId(), i.getCinemaClass());
            index++;
        }

        while (true) {
            int input = navigation.getChoice("Please select a cinema: ");
            if (input == 0) {
                display(navigation);
                break;
            } else if (input <= cinemaList.size() && input > 0) {
                StaffController.setChosenCinema(cinemaList.get(input - 1));
                curShowtime.setCinemaId(cinemaList.get(input - 1).getCinemaId());
                chooseType(navigation, seatLayout, curShowtime);
            } else {
                System.out.println("\nPlease enter a valid input\n");
            }
        }
    }

    private void chooseType(Navigation navigation, String[][] seatLayout, Showtime curShowtime){
        while (true) {
            System.out.println("\n(0) Back");
            System.out.println("(1) Digital");
            System.out.println("(2) 3D");
            System.out.println("(3) IMAX");
            int input = navigation.getChoice("Choose type of movie: ");
            switch (input){
                case 0:
                    chooseCinema(navigation, seatLayout, curShowtime);
                case 1:
                    curShowtime.setType("Digital");
                    chooseDate(navigation, seatLayout, curShowtime);
                    break;
                case 2:
                    curShowtime.setType("3D");
                    chooseDate(navigation, seatLayout, curShowtime);
                    break;
                case 3:
                    curShowtime.setType("IMAX");
                    chooseDate(navigation, seatLayout, curShowtime);
                    break;
                default:
                    System.out.println("\nEnter a valid input\n");
                    break;
            }
        }
    }

    private void chooseDate(Navigation navigation, String[][] seatLayout, Showtime curShowtime){
        System.out.println("\n(0) Back");
        System.out.println("Enter a date (dd/mm/yyyy): ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String date = sc.nextLine();
            boolean dateCheck = false;
            dateCheck = StaffController.setDate(date);
            if (date.contentEquals("0"))
                chooseType(navigation, seatLayout, curShowtime);
            else if (dateCheck) {
                curShowtime.setDate(date);
                chooseShowtime(navigation, seatLayout, curShowtime);
            }
            else
                System.out.println("Please enter a valid input");
        }
    }

    private void chooseShowtime(Navigation navigation, String[][] seatLayout, Showtime curShowtime) {
        System.out.printf("\nChosen Movie: %s\n", StaffController.getChosenMovie().getTitle());
        System.out.printf("Movie Duration: %d\n", StaffController.getChosenMovie().getDuration());
        System.out.printf("Chosen Date: %s\n", StaffController.getDate());
        System.out.printf("Chosen Cinema: %s (%s)\n", StaffController.getChosenCinema().getCinemaId(), StaffController.getChosenCinema().getCinemaClass());
        System.out.printf("\nCurrent showtime for Cinema %s (%s):\n", StaffController.getChosenCinema().getCinemaId(), StaffController.getDate());
        printShowtime();
        System.out.printf("\nEnter start time of movie (duration: %d minutes): \n", StaffController.getChosenMovie().getDuration());
        System.out.println("Cinema Opening Hours: 8am to 2am");
        //showtimeList shall be an ArrayList of EVERY showtime, as the DBController is programmed that way.
        ArrayList < Showtime > showtimeList = StaffController.getChosenMovie().getShowtimeList();

        while (true) {
            int input = navigation.getChoice("Start Time (enter -1 to go back): ");
            if (input == -1)
                chooseDate(navigation, seatLayout, curShowtime);
            else if (input < 0)
                System.out.println("Enter a non-negative integer.");
            else{
                int end = input + (((StaffController.getChosenMovie().getDuration()) / 60) * 100) + (StaffController.getChosenMovie().getDuration() % 60);
                if ((end > 200 && end < 800) || (input > 200 && input < 800))
                    System.out.println("Unable to add as showtime exceeds opening hours");
                else {
                    if (StaffController.addShowtime(input, curShowtime, showtimeList))
                        break;
                    else
                        System.out.println("Unable to add showtime as it overlaps with an existing showtime. Please re-enter a show timing: ");
                }
            }
        }
        //update model for user to access if user remains in app after adding showtime
        StaffController.getChosenMovie().setShowtimeList(showtimeList);
        printShowtime();
        navigation.goBack();
        //print all new showtime
        //return to main menu or something
    }

    private void printShowtime() {
        System.out.println("(0) Back");
        //get movie list to check through showtime
        int[][] startEndTime = StaffController.printShowtime(pos);
        for (int i = 0; i < startEndTime.length; i++)
            //check if end time exceeds 12am, print accordingly.
            if (startEndTime[i][0] != 0){
                if (startEndTime[i][1] < 2400)
                    System.out.printf("%s:%s%s " + "to" + " %s:%s%s, Duration: %d minutes\n",
                            startEndTime[i][0]/100, (startEndTime[i][0]/10)%10, startEndTime[i][0]%10,
                            startEndTime[i][1]/100, (startEndTime[i][1]/10)%10, (startEndTime[i][1])%10,
                            startEndTime[i][2]);
                else if (startEndTime[i][1] >= 2400)
                    System.out.printf("%s:%s%s " + "to" + " %s:%s%s, Duration: %d minutes\n",
                            startEndTime[i][0]/100, (startEndTime[i][0]/10)%10, startEndTime[i][0]%10,
                            (startEndTime[i][1]-2400)/100, ((startEndTime[i][1]-2400)/10)%10, (startEndTime[i][1]-2400)%10,
                            startEndTime[i][2]);
            }

    }
}
