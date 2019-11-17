package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Showtime;
import moblima.model.Cinema;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Represents the screen for staff to add a new showtime.
 */
public class AddShowtime extends View {
    /**
     * Instantiates a new Add showtime view.
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public AddShowtime(int userType, View nextView) {
        super("addShowtime", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {
        System.out.println("\n(0) Back");
        System.out.println("(1) Remove Showtime");
        System.out.println("(2) Add Showtime");
        while(true){
            int choice = getChoice("What would you like to do? ");
            if (choice == 0)
                Navigation.goBack();
            else if (choice == 1 || choice == 2){
                if(choice == 1)
                    outputPageName("Remove Showtime");
                else if (choice == 2)
                    outputPageName("Add Showtime");
                String[][] seatLayout = new String[8][9];
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 9; j++)
                        seatLayout[i][j] = "0";
                Showtime curShowtime = new Showtime(0, "", "", "", seatLayout);
                chooseCinema(curShowtime, choice);
            }
            else
                System.out.println("Please enter a valid input");
        }

    }

    /**
     * Display the view for staff to choose which cinema the new showtime will be shown
     *
     * @param curShowtime the new showtime
     * @param choice The choice the user chose for cinema.
     */
    private void chooseCinema(Showtime curShowtime, int choice) {
        ArrayList<Cinema> cinemaList = StaffController.getChosenCineplex().getCinemaList();

        System.out.printf("Chosen movie: '%s'\n\n", StaffController.getChosenMovie().getTitle());
        System.out.println("(0) Back");
        int index = 1;
        for (Cinema i : cinemaList) {
            System.out.printf("(%s) Cinema ID: %s, Cinema Class: %s\n",
                    index, i.getCinemaId(), i.getCinemaClass());
            index++;
        }

        while (true) {
            int input = getChoice("Please select a cinema: ");
            if (input == 0) {
                Navigation.goBack();
                break;
            } else if (input <= cinemaList.size() && input > 0) {
                StaffController.setChosenCinema(cinemaList.get(input - 1));
                if (choice == 2) {
                    curShowtime.setCinemaId(cinemaList.get(input - 1).getCinemaId());
                    chooseType(curShowtime);
                }
                else
                    removeShowtime();

            } else {
                System.out.println("\nPlease enter a valid input\n");
            }
        }
    }

    /**
     * Removes the selected showtime.
     */
    private void removeShowtime(){
        int index = 1;
        int choice;
        ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
        ArrayList<Showtime> tempList = StaffController.getChosenMovie().getShowtimeList();

        System.out.println("\nChosen CinemaId: " + StaffController.getChosenCinema().getCinemaId());
        System.out.println("(0) Back");
        for (Showtime i : tempList){
            if (i.getCinemaId().contentEquals(StaffController.getChosenCinema().getCinemaId())){
                showtimeList.add(i);
                System.out.printf("(%d) %s, Start Time: %s\n", index, i.getDate(), i.getTime());
                index++;
            }
        }
        while(true){
            choice = getChoice("Choose a showtime to remove: ");
            if (choice == 0)
                display();
            else if (choice > 0 && choice <= showtimeList.size()){
                System.out.printf("\nDate: %s, CinemaId: %s. Successfully Removed.\n", showtimeList.get(choice-1).getDate(), showtimeList.get(choice-1).getCinemaId());
                tempList.remove(showtimeList.get(choice-1));
                StaffController.getChosenMovie().setShowtimeList(tempList);
                break;
            }
            else
                System.out.println("Please enter a valid input");
        }
        Navigation.goBack();
        }


    /**
     * Display the view for staff to choose the type for a new showtime
     *
     * @param curShowtime the new showtime
     */
    private void chooseType(Showtime curShowtime){
        while (true) {
            System.out.println("\n(0) Back");
            System.out.println("(1) Digital");
            System.out.println("(2) 3D");
            System.out.println("(3) IMAX");
            int input = getChoice("Choose type of movie: ");
            switch (input){
                case 0:
                    chooseCinema(curShowtime, 2);
                case 1:
                    curShowtime.setType("Digital");
                    chooseDate(curShowtime);
                    break;
                case 2:
                    curShowtime.setType("3D");
                    chooseDate(curShowtime);
                    break;
                case 3:
                    curShowtime.setType("IMAX");
                    chooseDate(curShowtime);
                    break;
                default:
                    System.out.println("\nEnter a valid input\n");
                    break;
            }
        }
    }

    /**
     * Display the view for staff to choose the date for the a new showtime
     *
     * @param curShowtime the new showtime
     */
    private void chooseDate(Showtime curShowtime){
        System.out.println("\n(0) Back");
        System.out.println("Enter a date (dd/mm/yyyy): ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String date = sc.nextLine();
            boolean dateCheck = false;
            dateCheck = StaffController.setDate(date);
            if (date.contentEquals("0"))
                chooseType(curShowtime);
            else if (dateCheck) {
                curShowtime.setDate(date);
                chooseShowtime(curShowtime);
            }
            else
                System.out.println("Please enter a valid input");
        }
    }

    /**
     * Display the view to choose the start time of a new showtime
     *
     * @param curShowtime the new showtime
     */
    private void chooseShowtime(Showtime curShowtime) {
        System.out.printf("\nChosen Movie: '%s'\n", StaffController.getChosenMovie().getTitle());
        System.out.printf("Movie Duration: %d\n", StaffController.getChosenMovie().getDuration());
        System.out.printf("Chosen Date: %s\n", StaffController.getDate());
        System.out.printf("Chosen Cinema: %s (%s)\n", StaffController.getChosenCinema().getCinemaId(), StaffController.getChosenCinema().getCinemaClass());

        System.out.printf("\nCurrent showtime for Cinema ID %s (%s):\n", StaffController.getChosenCinema().getCinemaId(), StaffController.getDate());
        printShowtime();

        System.out.printf("\nEnter start time of movie (duration: %d minutes): \n", StaffController.getChosenMovie().getDuration());
        System.out.println("Cinema Opening Hours: 8am to 2am");

        //showtimeList shall be an ArrayList of EVERY showtime, as the DBController is programmed that way.
        ArrayList < Showtime > showtimeList = StaffController.getChosenMovie().getShowtimeList();

        while (true) {
            int input = getChoice("Start Time in HHMM format (enter -1 to go back): ");
            if (input == -1)
                chooseDate(curShowtime);
            else if (input < 0 || input >= 2400)
                System.out.println("Please enter a valid input!");
            else{
                curShowtime.setTime(input);
                int end = curShowtime.calcEnd(StaffController.getChosenMovie().getDuration());

                if ((end > 200 && end < 800) || (input > 200 && input < 800))
                    System.out.println("Unable to add as showtime exceeds opening hours!");
                else {
                    if (StaffController.addShowtime(curShowtime, showtimeList))
                        break;
                    else
                        System.out.println("Unable to add showtime as it overlaps with an existing showtime. Please re-enter a show timing!");
                }
            }
        }

        //update model for user to access if user remains in app after adding showtime
        StaffController.getChosenMovie().setShowtimeList(showtimeList);
        System.out.printf("\nUpdated showtime for Cinema ID %s (%s):\n", StaffController.getChosenCinema().getCinemaId(), StaffController.getDate());
        printShowtime();
        Navigation.goBack();
        //print all new showtime
        //return to main menu or something
    }

    /**
     * Print showtime
     */
    private void printShowtime() {
        //get movie list to check through showtime
        int[][] startEndTime = StaffController.printShowtime();
        if (startEndTime.length == 0) {
            System.out.println("No showtime available on this day on this Cinema ID");
            return;
        }

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
