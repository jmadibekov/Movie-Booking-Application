package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the screen for staff to add a new movie
 */
public class AddMovie extends View{

    /**
     * Instantiates a new Add movie view.
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public AddMovie(int userType, View nextView) {
        super("addMovie", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {

        outputPageName("Add Movie");
        System.out.println("(0) Back\n");

        String indexStr;

        ArrayList< Movie > temp = StaffController.getChosenCineplex().getMovieList();
        /*Find the latest movie index*/
        int index = 0;
        for (int i = 0; i < temp.size(); i++)
            if(index < Integer.parseInt(temp.get(i).getMovieId()))
                index = Integer.parseInt(temp.get(i).getMovieId());
        index++;
        if (index/100 > 0)
            indexStr = String.valueOf(index);
        else if (index/10 > 0)
            indexStr = "0" + index;
        else
            indexStr = "00" + index;
        setShowingStatus(indexStr);
    }

    /**
     * Sets showing status for a new movie
     *
     * @param indexStr the staff's input
     */
    private void setShowingStatus(String indexStr){
        Scanner sc = new Scanner(System.in);
        String showingStatus;
        System.out.println("Select a showing status (0 to go back): ");
        System.out.println("(1) Now Showing");
        System.out.println("(2) Preview");
        System.out.println("(3) Coming Soon");
        while (true){
            int option = getChoice("Showing Status: ");
            if (option == 0)
                Navigation.goBack();
            else if (option == 1)
                setTitle("Now Showing", indexStr);
            else if (option == 2)
                setTitle("Preview", indexStr);
            else if (option == 3)
                setTitle("Coming Soon", indexStr);
            else
                System.out.println("Please enter a valid input");
        }
    }

    /**
     * Sets title for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param indexStr the staff's input
     */
    private void setTitle(String showingStatus, String indexStr){
        Scanner sc = new Scanner(System.in);
        String title;
        System.out.printf("Enter the title (0 to go back): ");
        title = sc.nextLine();
        if (title.contentEquals("0"))
            setShowingStatus(indexStr);
        setSynopsis(showingStatus, title, indexStr);
    }

    /**
     * Sets synopsis for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param title the new movie's title
     * @param indexStr the staff's input
     */
    private void setSynopsis(String showingStatus, String title, String indexStr){
        Scanner sc = new Scanner(System.in);
        String synopsis;
        System.out.printf("Enter the synopsis (0 to go back): ");
        synopsis = sc.nextLine();
        if (synopsis.contentEquals("0"))
            setTitle(showingStatus, indexStr);
        setDirector(showingStatus, title, synopsis, indexStr);
        String buffer = sc.nextLine();
    }

    /**
     * Sets director for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param title the new movie's title
     * @param synopsis the new movie's synopsis
     * @param indexStr the staff's input
     */
    private void setDirector(String showingStatus, String title, String synopsis, String indexStr){
        Scanner sc = new Scanner(System.in);
        int number;
        String director;
        String[] directorList;
        int input;
        while(true){
            input = getChoice("Enter the number of directors (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setSynopsis(showingStatus, title, indexStr);
            else if (input > 0)
                break;
        }
        directorList = new String[input];
        for (int i = 0; i < input; i++){
            System.out.printf("Enter the name of director number %d (0 to go back): ", i+1);
            director = sc.nextLine();
            if (director.contentEquals("0"))
                setSynopsis(showingStatus, title, indexStr);
            directorList[i] = director;
        }
        setCast(showingStatus, title, synopsis, directorList, indexStr);
    }

    /**
     * Sets cast for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param title the new movie's title
     * @param synopsis the new movie's synopsis
     * @param directorList the new movie's director list
     * @param indexStr the staff's input
     */
    private void setCast(String showingStatus, String title, String synopsis, String[] directorList, String indexStr) {
        Scanner sc = new Scanner(System.in);
        int input;
        String cast;
        String[] castList;
        while (true) {
            input = getChoice("Enter the number of actors/actresses (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setDirector(showingStatus, title, synopsis, indexStr);
            else
                break;
        }
        castList = new String[input];
        for (int i = 0; i < input; i++) {
            System.out.printf("Enter the name of actor/actress number %d (0 to go back): ", i+1);
            cast = sc.nextLine();
            if (cast.contentEquals("0"))
                setDirector(showingStatus, title, synopsis, indexStr);
            castList[i] = cast;
        }
        setAgeRequirement(showingStatus,title,synopsis,directorList,castList, indexStr);
    }

    /**
     * Sets age requirement for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param title the new movie's title
     * @param synopsis the new movie's synopsis
     * @param directorList the new movie's director list
     * @param castList the new movie's cast list
     * @param indexStr the staff's input
     */
    private void setAgeRequirement(String showingStatus, String title, String synopsis, String[] directorList, String[] castList, String indexStr){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select an age rating (0 to go back): ");
        System.out.println("(1) PG13");
        System.out.println("(2) NC16");
        System.out.println("(3) M18");
        System.out.println("(4) R21");
        while(true) {
            int selected = getChoice("Movie Rating: ");
            if (selected == 0)
                setCast(showingStatus, title, synopsis, directorList, indexStr);
            else if (selected == 1)
                setDuration(sc, showingStatus, title, synopsis, directorList, castList, "PG13", indexStr);
            else if (selected == 2)
                setDuration(sc, showingStatus, title, synopsis, directorList, castList, "NC16", indexStr);
            else if (selected == 3)
                setDuration(sc, showingStatus, title, synopsis, directorList, castList, "M18", indexStr);
            else if (selected == 4)
                setDuration(sc, showingStatus, title, synopsis, directorList, castList, "R21", indexStr);
            else
                System.out.println("Please enter a valid input");
        }
    }

    /**
     * Sets duration for a new movie
     *
     * @param showingStatus the new movie's showing status
     * @param title the new movie's title
     * @param synopsis the new movie's synopsis
     * @param directorList the new movie's director list
     * @param castList the new movie's cast list
     * @param ageRequirement the new movie's age requirement
     * @param indexStr the staff's input
     */
    private void setDuration(Scanner sc, String showingStatus, String title, String synopsis, String[] directorList, String[] castList, String ageRequirement, String indexStr){
        int duration;
        int input;
        while(true){
            duration = getChoice("Enter the duration (0 to go back): ");
            if (duration < 0 )
                System.out.println("Please enter a valid input");
            else if (duration == 0)
                setAgeRequirement(showingStatus,title,synopsis,directorList,castList, indexStr);
            else{
                Movie toBeCreated = new Movie(0,showingStatus,title,synopsis,directorList,castList,0,ageRequirement,0,StaffController.getChosenCineplex().getCineplexId(),indexStr,duration);
                ArrayList < Movie > movieList = StaffController.getChosenCineplex().getMovieList();
                movieList.add(toBeCreated);
                System.out.println("Creating Movie...");
                System.out.println("Movie Created Successfully!");
                nextScreen();
                break;
            }
        }
    }

    /**
     * Displays the view after a new movie is added
     * Allow staff to create a new movie or go back to main menu
     */
    private void nextScreen(){
        while(true){
            int input = getChoice("\n(0) Return to Main Menu\n(1) Create a new movie\n ");
            if (input ==  0)
                Navigation.goBack();
            else if (input == 1)
                display();
        }
    }
}
