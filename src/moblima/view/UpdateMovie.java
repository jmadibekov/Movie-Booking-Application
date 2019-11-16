package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Movie;
import moblima.model.Staff;

import java.lang.*;
import java.util.Scanner;

import java.util.ArrayList;

public class UpdateMovie extends View{

    /**
     * Instantiates a new UpdateMovie
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public UpdateMovie(int userType, View nextView) {
        super("updateMovie", userType, nextView);
    }

    /**
     * Displays a list of movies, and check which movie is to be updated
     */
    public void display() {
        outputPageName("Choose A Movie");

        System.out.println("Choosen cineplex: '" + BookingController.getChosenCineplex().getCineplexName() + "'\n");

        ArrayList<Movie> movieList = BookingController.getMovies();
        if (movieList.isEmpty()) {
            System.out.println("No movies are currently showing in this cinema. Please try another cineplex\n");
            Navigation.goBack();
            return;
        }
        System.out.println("(0) Back");
        int index = 1;
        for (Movie i : movieList) {
            System.out.printf("(%s) %s\n", index, i.getTitle());
            index++;
        }
        while (true) {
            int input = getChoice("Please select an option: ");
            if (input == 0) {
                Navigation.goBack();
                break;
            } else if (input <= movieList.size() && input > 0){
                StaffController.setChosenMovie(movieList.get(input - 1));
                editWhat();
            }
            else
                System.out.println("\nPlease enter a valid input\n");
        }
    }

    /**
     * Interface for the Staff to choose what to edit next. Takes in Staff's input and passes to Controller.
     */
    private void editWhat(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\nChoose what to edit for %s:\n", StaffController.getChosenMovie().getTitle());
        System.out.println("(0) Back");
        System.out.println("(1) Showing status");
        System.out.println("(2) Title");
        System.out.println("(3) Synopsis");
        System.out.println("(4) Director");
        System.out.println("(5) Cast");
        System.out.println("(6) Age Requirement");
        System.out.println("(7) Duration");

        while(true){
            int input;
            String update;
            int option = getChoice("What you would like to edit: \n");
            switch (option){
                case 0:
                    display();
                    break;
                case 1:
                    System.out.printf("\nCurrent Showing Status: %s\n", StaffController.getChosenMovie().getShowingStatus());
                    System.out.println("Select a showing status (0 to go back): ");
                    System.out.println("(1) Now Showing");
                    System.out.println("(2) Preview");
                    System.out.println("(3) Coming Soon");
                    System.out.println("(4) End of Showing");
                    input = getChoice("Showing Status: ");
                    if (input == 0)
                        editWhat();
                    else if (input == 1)
                        StaffController.setShowingStatus("Now Showing");
                    else if (input == 2)
                        StaffController.setShowingStatus("Preview");
                    else if (input == 3)
                        StaffController.setShowingStatus("Coming Soon");
                    else if (input == 4)
                        StaffController.setShowingStatus("End of Showing");
                    else
                        System.out.println("Please enter a valid input");
                    System.out.println("Update Successful.");
                    editWhat();
                    break;
                case 2:
                    System.out.printf("Current Title: %s\n", StaffController.getChosenMovie().getTitle());
                    System.out.println("Update Title (0 to go back): ");
                    update = sc.nextLine();
                    if (update.contentEquals("0"))
                        editWhat();
                    StaffController.getChosenMovie().setTitle(update);
                    System.out.println("Update Successful.");
                    editWhat();
                    break;
                case 3:
                    System.out.printf("Current Synopsis: %s\n", StaffController.getChosenMovie().getSynopsis());
                    System.out.println("Update Synopsis (0 to go back): ");
                    update = sc.nextLine();
                    if (update.contentEquals("0"))
                        editWhat();
                    StaffController.getChosenMovie().setSynopsis(update);
                    System.out.println("Update Successful.");
                    editWhat();
                    break;
                case 4:
                    System.out.printf("Current Director (0 to go back): ");
                    for (int i = 0; i < StaffController.getChosenMovie().getDirector().length; i++)
                        System.out.printf(StaffController.getChosenMovie().getDirector()[i] + " . ");
                    System.out.printf("\n");
                    while(true){
                        input = getChoice("Enter the number of directors: ");
                        if (input == 0)
                            editWhat();
                        else if (input < 0)
                            System.out.println("Please enter a valid input");
                        else {
                            String[] directorList = new String[input];
                            for (int i = 0; i < input; i++){
                                System.out.printf("Enter the name of Director number %d: ", i+1);
                                update = sc.nextLine();
                                directorList[i] = update;
                            }
                            StaffController.getChosenMovie().setDirector(directorList);
                            System.out.println("Update Successful.");
                            editWhat();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.printf("Current Cast (0 to go back): ");
                    for (int i = 0; i < StaffController.getChosenMovie().getCast().length; i++)
                        System.out.printf(StaffController.getChosenMovie().getCast()[i] + " . ");
                    System.out.printf("\n");
                    while (true) {
                        input = getChoice("Enter the number of casts: ");
                        if (input == 0)
                            editWhat();
                        else if (input < 0)
                            System.out.println("Please enter a valid input");
                        else {
                            String[] castList = new String[input];
                            for (int i = 0; i < input; i++) {
                                System.out.printf("Enter the name of Cast number %d: ", i + 1);
                                update = sc.nextLine();
                                castList[i] = update;
                            }
                            StaffController.getChosenMovie().setCast(castList);
                            System.out.println("Update Successful.");
                            editWhat();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.printf("Current Age Rating: %s", StaffController.getChosenMovie().getAgeRequirement());
                    System.out.println("Select an age rating (0 to go back): ");
                    System.out.println("(1) PG13");
                    System.out.println("(2) NC16");
                    System.out.println("(3) M18");
                    System.out.println("(4) R21");
                    while(true) {
                        int selected = getChoice("Movie Rating: ");
                        if (selected == 0)
                            editWhat();
                        else if (selected == 1){
                            StaffController.getChosenMovie().setAgeRequirement("PG13");
                            break;
                        }
                        else if (selected == 2){
                            StaffController.getChosenMovie().setAgeRequirement("NC16");
                            break;
                        }
                        else if (selected == 3){
                            StaffController.getChosenMovie().setAgeRequirement("M18");
                            break;
                        }
                        else if (selected == 4){
                            StaffController.getChosenMovie().setAgeRequirement("R21");
                            break;
                        }
                        else
                            System.out.println("Please enter a valid input");
                    }
                    System.out.println("Update Successful.");
                    editWhat();
                    break;
                case 7:
                    System.out.println("Enter 0 to go back");
                    System.out.printf("Current Duration: %d\n", StaffController.getChosenMovie().getDuration());
                    while(true) {
                        input = getChoice("Update duration in minutes: ");
                        if (input == 0)
                            editWhat();
                        else if (input < 0)
                            System.out.println("Please enter a valid input");
                        else {
                            StaffController.getChosenMovie().setDuration(input);
                            System.out.println("Update Successful.");
                            editWhat();
                        }
                    }
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

}

