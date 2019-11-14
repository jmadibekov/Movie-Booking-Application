package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMovie {

    public AddMovie() {

    }

    public void display(Navigation navigation) {
        String indexStr;
        System.out.println(
                "=====================================\n"
                        + "--------------Add Movie--------------\n"
                        + "=====================================\n"
                        + "(0) Back\n");
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
        setShowingStatus(navigation, indexStr);
    }

    private void setShowingStatus(Navigation navigation, String indexStr){
        Scanner sc = new Scanner(System.in);
        String showingStatus;
        System.out.println("Select a showing status (0 to go back): ");
        System.out.println("(1) Now Showing");
        System.out.println("(2) Preview");
        System.out.println("(3) Coming Soon");
        while (true){
            int option = navigation.getChoice("Showing Status: ");
            if (option == 0)
                navigation.goBack();
            else if (option == 1)
                setTitle(navigation, sc, "Now Showing", indexStr);
            else if (option == 2)
                setTitle(navigation, sc, "Preview", indexStr);
            else if (option == 3)
                setTitle(navigation, sc, "Coming Soon", indexStr);
            else
                System.out.println("Please enter a valid input");
        }
    }

    private void setTitle(Navigation navigation, Scanner sc, String showingStatus, String indexStr){
        String title;
        System.out.printf("Enter the title (0 to go back): ");
        title = sc.nextLine();
        if (title.contentEquals("0"))
            setShowingStatus(navigation, indexStr);
        setSynopsis(navigation, sc, showingStatus, title, indexStr);
    }

    private void setSynopsis(Navigation navigation, Scanner sc, String showingStatus, String title, String indexStr){
        String synopsis;
        System.out.printf("Enter the synopsis (0 to go back): ");
        synopsis = sc.nextLine();
        if (synopsis.contentEquals("0"))
            setTitle(navigation, sc, showingStatus, indexStr);
        setDirector(navigation, sc, showingStatus, title, synopsis, indexStr);
        String buffer = sc.nextLine();
    }

    private void setDirector(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis, String indexStr){
        int number;
        String director;
        String[] directorList;
        int input;
        while(true){
            input = navigation.getChoice("Enter the number of directors (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setSynopsis(navigation, sc, showingStatus, title, indexStr);
            else if (input > 0)
                break;
        }
        directorList = new String[input];
        for (int i = 0; i < input; i++){
            System.out.printf("Enter the name of director number %d (0 to go back): ", i+1);
            director = sc.nextLine();
            if (director.contentEquals("0"))
                setSynopsis(navigation, sc, showingStatus, title, indexStr);
            directorList[i] = director;
        }
        setCast(navigation, showingStatus, title, synopsis, directorList, indexStr);
    }

    private void setCast(Navigation navigation, String showingStatus, String title, String synopsis, String[] directorList, String indexStr) {
        Scanner sc = new Scanner(System.in);
        int input;
        String cast;
        String[] castList;
        while (true) {
            input = navigation.getChoice("Enter the number of actors/actresses (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setDirector(navigation, sc, showingStatus, title, synopsis, indexStr);
            else
                break;
        }
        castList = new String[input];
        for (int i = 0; i < input; i++) {
            System.out.printf("Enter the name of actor/actress number %d (0 to go back): ", i+1);
            cast = sc.nextLine();
            if (cast.contentEquals("0"))
                setDirector(navigation, sc, showingStatus, title, synopsis, indexStr);
            castList[i] = cast;
        }
        setAgeRequirement(navigation,sc,showingStatus,title,synopsis,directorList,castList, indexStr);
    }

    private void setAgeRequirement(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis, String[] directorList, String[] castList, String indexStr){
        System.out.println("Select an age rating (0 to go back): ");
        System.out.println("(1) PG13");
        System.out.println("(2) NC16");
        System.out.println("(3) M18");
        System.out.println("(4) R21");
        while(true) {
            int selected = navigation.getChoice("Movie Rating: ");
            if (selected == 0)
                setCast(navigation, showingStatus, title, synopsis, directorList, indexStr);
            else if (selected == 1)
                setDuration(navigation, sc, showingStatus, title, synopsis, directorList, castList, "PG13", indexStr);
            else if (selected == 2)
                setDuration(navigation, sc, showingStatus, title, synopsis, directorList, castList, "NC16", indexStr);
            else if (selected == 3)
                setDuration(navigation, sc, showingStatus, title, synopsis, directorList, castList, "M18", indexStr);
            else if (selected == 4)
                setDuration(navigation, sc, showingStatus, title, synopsis, directorList, castList, "R21", indexStr);
            else
                System.out.println("Please enter a valid input");
        }
    }

    private void setDuration(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis, String[] directorList, String[] castList, String ageRequirement, String indexStr){
        int duration;
        int input;
        while(true){
            duration = navigation.getChoice("Enter the duration (0 to go back): ");
            if (duration < 0 )
                System.out.println("Please enter a valid input");
            else if (duration == 0)
                setAgeRequirement(navigation,sc,showingStatus,title,synopsis,directorList,castList, indexStr);
            else{
                Movie toBeCreated = new Movie(0,showingStatus,title,synopsis,directorList,castList,0,ageRequirement,0,StaffController.getChosenCineplex().getCineplexId(),indexStr,duration);
                ArrayList < Movie > movieList = StaffController.getChosenCineplex().getMovieList();
                movieList.add(toBeCreated);
                System.out.println("Creating Movie...");
                System.out.println("Movie Created Successfully!");
                nextScreen(navigation);
                break;
            }
        }
    }

    private void nextScreen(Navigation navigation){
        while(true){
            int input = navigation.getChoice("\n(0) Return to Main Menu\n(1) Create a new movie\n ");
            if (input ==  0)
                navigation.goBack();
            else if (input == 1)
                display(navigation);
        }
    }
}
