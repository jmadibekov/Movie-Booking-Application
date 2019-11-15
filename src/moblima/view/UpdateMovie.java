package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Movie;

import java.lang.*;
import java.util.Scanner;

import java.util.ArrayList;

public class UpdateMovie extends View {

    public UpdateMovie(int userType, View nextView) {
        super("updateMovie", userType, nextView);
    }

    public void display() {

        outputPageName("Choose A Movie");
        System.out.println("The Cineplex: '" + BookingController.getChosenCineplex().getCineplexName() + "'\n");

        ArrayList<Movie> movieList = BookingController.getMovies();
        if (movieList.isEmpty()) {
            System.out.println("No movies are currently showing in this cinema. Please try another cineplex\n");
            Navigation.goBack();
            return;
        }

        printMovies(movieList);

        while (true) {
            int input = getChoice("Please select an option: ");
            if (input == 0) {
                Navigation.goBack();
                break;
            } else if (input <= movieList.size() && input > 0) {
                StaffController.setChosenMovie(movieList.get(input - 1));
                editWhat();
            } else {
                System.out.println("\nPlease enter a valid input!\n");
            }
        }
    }

    private void printMovies(ArrayList<Movie> movieList) {
        System.out.println("(0) Back");
        int index = 1;
        for (Movie i : movieList) {
            System.out.printf("(%s) '%s'\n", index, i.getTitle());
            index++;
        }
    }

    private void editWhat(){
        System.out.printf("\nChosen movie: '%s'\n\n", StaffController.getChosenMovie().getTitle());
        System.out.println("(0) Back");
        System.out.println("(1) Showing status");
        System.out.println("(2) Title");
        System.out.println("(3) Synopsis");
        System.out.println("(4) Director");
        System.out.println("(5) Cast");
        System.out.println("(6) Age Requirement");
        System.out.println("(7) Duration");

        while(true){
            int input = getChoice("What you would like to edit: ");
            switch (input){
                case 0:
                    display();
                    break;
                case 1:
                    editShowingStatus();
                    break;
                case 2:
                    editTitle();
                    break;
                case 3:
                    editSynopsis();
                    break;
                case 4:
                    editDirector();
                    break;
                case 5:
                    editCast();
                    break;
                case 6:
                    editAgeRequirement();
                    break;
                case 7:
                    editDuration();
                    break;
                default:
                    System.out.println("\nPlease enter a valid input!\n");
            }
        }
    }

    private void editShowingStatus(){
        System.out.printf("Current showing status: %s\n", StaffController.getChosenMovie().getShowingStatus());
        System.out.println("Select a showing status (enter 0 to go back): ");
        System.out.println("(1) Now Showing");
        System.out.println("(2) Preview");
        System.out.println("(3) Coming Soon");
        System.out.println("(4) End of Showing");
        while(true) {
            int selected = getChoice("Showing Status: ");
            if (selected == 0)
                editWhat();
            else if (selected == 1){
                StaffController.getChosenMovie().setShowingStatus("Now Showing");
                break;
            }
            else if (selected == 2){
                StaffController.getChosenMovie().setShowingStatus("Preview");
                break;
            }
            else if (selected == 3){
                StaffController.getChosenMovie().setShowingStatus("Coming Soon");
                break;
            }
            else if (selected == 4){
                StaffController.getChosenMovie().setShowingStatus("End of Showing");
                break;
            }
            else
                System.out.println("\nPlease enter a valid input!\n");
        }
        System.out.println("Update Successful.");
        editWhat();
    }

    private void editTitle(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Current Title: %s\n", StaffController.getChosenMovie().getTitle());
        System.out.println("Update Title (enter 0 to go back): ");
        String update = sc.nextLine();
        if (update.contentEquals("0"))
            editWhat();
        StaffController.getChosenMovie().setTitle(update);
        StaffController.updateAllMoviesToChosenMovie();
        System.out.println("Update Successful.");
        editWhat();
    }

    private void editSynopsis(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Current Synopsis: %s\n", StaffController.getChosenMovie().getSynopsis());
        System.out.println("Update Synopsis (enter 0 to go back): ");
        String update = sc.nextLine();
        if (update.contentEquals("0"))
            editWhat();
        StaffController.getChosenMovie().setSynopsis(update);
        StaffController.updateAllMoviesToChosenMovie();
        System.out.println("Update Successful.");
        editWhat();
    }

    private void editDirector(){
        String update;
        int number;
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Current Director (enter 0 to go back): ");
        for (int i = 0; i < StaffController.getChosenMovie().getDirector().length; i++)
            System.out.printf(StaffController.getChosenMovie().getDirector()[i] + " . ");
        System.out.printf("\n");
        while(true){
            number = getChoice("Enter the number of directors: ");
            if (number == 0)
                editWhat();
            else if (number < 0)
                System.out.println("\nPlease enter a valid input!\n");
            else {
                String[] directorList = new String[number];
                for (int i = 0; i < number; i++){
                    System.out.printf("Enter the name of Director number %d: ", i+1);
                    update = sc.nextLine();
                    directorList[i] = update;
                }
                StaffController.getChosenMovie().setDirector(directorList);
                StaffController.updateAllMoviesToChosenMovie();
                System.out.println("Update Successful.");
                editWhat();
                break;
            }
        }
    }

    private void editCast() {
        String update;
        int number;
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Current Cast (enter 0 to go back): ");
        for (int i = 0; i < StaffController.getChosenMovie().getCast().length; i++)
            System.out.printf(StaffController.getChosenMovie().getCast()[i] + " . ");
        System.out.printf("\n");
        while (true) {
            number = getChoice("Enter the number of casts: ");
            if (number == 0)
                editWhat();
            else if (number < 0)
                System.out.println("Please enter a valid input");
            else {
                String[] castList = new String[number];
                for (int i = 0; i < number; i++) {
                    System.out.printf("Enter the name of Cast number %d: ", i + 1);
                    update = sc.nextLine();
                    castList[i] = update;
                }
                StaffController.getChosenMovie().setCast(castList);
                StaffController.updateAllMoviesToChosenMovie();
                System.out.println("Update Successful.");
                editWhat();
                break;
            }
        }
    }

    private void editAgeRequirement(){
        System.out.printf("Current age requirement: %s\n", StaffController.getChosenMovie().getAgeRequirement());
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
                System.out.println("\nPlease enter a valid input!\n");
        }
        StaffController.updateAllMoviesToChosenMovie();
        System.out.println("Update Successful.");
        editWhat();
    }

    private void editDuration(){
        Scanner sc = new Scanner(System.in);
        int update;
        System.out.println("Enter 0 to go back");
        System.out.printf("Current Duration: %d\n", StaffController.getChosenMovie().getDuration());
        while(true) {
             update = getChoice("Update duration in minutes: ");
             if (update == 0)
                 editWhat();
             else if (update < 0)
                 System.out.println("Please enter a valid input");
             else {
                 StaffController.getChosenMovie().setDuration(update);
                 StaffController.updateAllMoviesToChosenMovie();
                 System.out.println("Update Successful.");
                 editWhat();
             }
        }
    }
}

