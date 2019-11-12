package moblima.view;

import moblima.controller.DBController;
import moblima.controller.StaffController;
import moblima.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddMovie {

    private String indexStr;
    public AddMovie() {

    }

    public void display(Navigation navigation) {
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
        setShowingStatus(navigation);
    }

    private void setShowingStatus(Navigation navigation){
        Scanner sc = new Scanner(System.in);
        String showingStatus;
        System.out.println("Enter the showing status [Now Showing, Preview, Coming Soon](0 to go back): ");
        showingStatus = sc.next();
        if (showingStatus.contentEquals("0"))
            navigation.goBack();
        String buffer = sc.nextLine();
        setTitle(navigation, sc, showingStatus);
    }

    private void setTitle(Navigation navigation, Scanner sc, String showingStatus){
        String title;
        System.out.println("Enter the title (0 to go back): ");
        title = sc.next();
        if (title.contentEquals("0"))
            setShowingStatus(navigation);
        String buffer = sc.nextLine();
        setSynopsis(navigation, sc, showingStatus, title);
    }

    private void setSynopsis(Navigation navigation, Scanner sc, String showingStatus, String title){
        String synopsis;
        System.out.println("Enter the synopsis (0 to go back): ");
        synopsis = sc.next();
        if (synopsis.contentEquals("0"))
            setTitle(navigation, sc, showingStatus);
        setDirector(navigation, sc, showingStatus, title, synopsis);
        String buffer = sc.nextLine();
    }

    private void setDirector(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis){
        int number;
        String director;
        String[] directorList;
        int input;
        while(true){
            input = navigation.getChoice("Enter the number of directors (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setSynopsis(navigation, sc, showingStatus, title);
            else if (input > 0)
                break;
        }
        String temp = sc.nextLine();
        directorList = new String[input];
        for (int i = 0; i < input; i++){
            System.out.printf("Enter the name of director number %d (0 to go back): ", i+1);
            director = sc.next();
            if (director.contentEquals("0"))
                setSynopsis(navigation, sc, showingStatus, title);
            directorList[i] = director;
        }
        String buffer = sc.nextLine();
        setCast(navigation, showingStatus, title, synopsis, directorList);
    }

    private void setCast(Navigation navigation, String showingStatus, String title, String synopsis, String[] directorList) {
        Scanner sc = new Scanner(System.in);
        int input;
        String cast;
        String[] castList;
        while (true) {
            input = navigation.getChoice("Enter the number of actors/actresses (0 to go back): ");
            if (input < 0)
                System.out.println("Please enter a valid input");
            else if (input == 0)
                setDirector(navigation, sc, showingStatus, title, synopsis);
            else
                break;
        }
        castList = new String[input];
        String temp = sc.nextLine();
        for (int i = 0; i < input; i++) {
            System.out.printf("Enter the name of actor/actress number %d (0 to go back): \n", i+1);
            cast = sc.next();
            if (cast.contentEquals("0"))
                setDirector(navigation, sc, showingStatus, title, synopsis);
            castList[i] = cast;
        }
        setAgeRequirement(navigation,sc,showingStatus,title,synopsis,directorList,castList);
    }

    private void setAgeRequirement(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis, String[] directorList, String[] castList){
        String ageRequirement;
        System.out.println("Enter the age requirement [PG13, NC16, M18, R21] (0 to go back): ");
        ageRequirement = sc.next();
        if (ageRequirement.contentEquals("0"))
            setCast(navigation,showingStatus,title,synopsis,directorList);
        setDuration(navigation,sc,showingStatus,title,synopsis,directorList,castList,ageRequirement);
        String buffer = sc.nextLine();
    }

    private void setDuration(Navigation navigation, Scanner sc, String showingStatus, String title, String synopsis, String[] directorList, String[] castList, String ageRequirement){
        int duration;
        int input;
        while(true){
            duration = navigation.getChoice("Enter the duration (0 to go back): ");
            if (duration < 0 )
                System.out.println("Please enter a valid input");
            else if (duration == 0)
                setAgeRequirement(navigation,sc,showingStatus,title,synopsis,directorList,castList);
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
            else if (input == 2)
                display(navigation);
        }
    }
}
