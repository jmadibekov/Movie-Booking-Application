package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;
import moblima.model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMovie extends View{

    public AddMovie(int userType, View nextView) {
        super("addMovie", userType, nextView);
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int input;
        outputPageName("Add Movie");
        while (true){
            switch (option) {
                case 0: {
                    System.out.println("\nSelect a showing status (0 to go back): ");
                    System.out.println("(1) Now Showing");
                    System.out.println("(2) Preview");
                    System.out.println("(3) Coming Soon");
                    input = getChoice("Showing Status: ");
                    if (input == 0) {
                        Navigation.goBack();
                    } else if (input == 1) {
                        StaffController.setShowingStatus("Now Showing");
                        option = 1;
                    } else if (input == 2) {
                        StaffController.setShowingStatus("Preview");
                        option = 1;
                    } else if (input == 3) {
                        StaffController.setShowingStatus("Coming Soon");
                        option = 1;
                    } else
                        System.out.println("Please enter a valid input");
                    break;
                }
                case 1: {
                    System.out.printf("\nEnter the title (0 to go back): ");
                    String title = sc.nextLine();
                    if (title.contentEquals("0"))
                        option = 0;
                    else{
                        StaffController.setTitle(title);
                        option = 2;
                    }
                    break;
                }
                case 2:{
                    System.out.printf("\nEnter the synopsis (0 to go back): ");
                    String synopsis = sc.nextLine();
                    if (synopsis.contentEquals("0"))
                        option = 1;
                    else{
                        StaffController.setSynopsis(synopsis);
                        option = 3;
                    }
                    break;
                }
                case 3:{
                    int i;
                    while (true){
                        int num = getChoice("\nEnter the number of director (0 to go back): ");
                        if (num < 0)
                            System.out.println("Please enter a valid input");
                        else if (num == 0){
                            option = 2;
                            break;
                        }
                        else {
                            String[] directorList = new String[num];
                            for (i = 0; i < num; i++) {
                                System.out.printf("Enter the name of director number %d (0 to go back): ", i + 1);
                                String director = sc.nextLine();
                                if (director.contentEquals("0")) {
                                    break;
                                }
                                else{
                                    directorList[i] = director;
                                }
                            }
                            if (i == num){
                                StaffController.setDirector(directorList);
                                option = 4;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4:{
                    int i;
                    while (true){
                        int num = getChoice("\nEnter the number of casts (0 to go back): ");
                        if (num < 0)
                            System.out.println("Please enter a valid input");
                        else if (num == 0){
                            option = 3;
                            break;
                        }
                        else {
                            String[] castList = new String[num];
                            for (i = 0; i < num; i++) {
                                System.out.printf("Enter the name of cast number %d (0 to go back): ", i + 1);
                                String cast = sc.nextLine();
                                if (cast.contentEquals("0"))
                                    break;
                                else
                                    castList[i] = cast;
                            }
                            if (i == num){
                                StaffController.setCast(castList);
                                option = 5;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5:{
                    System.out.println("\nSelect an age rating (0 to go back): ");
                    System.out.println("(1) PG13");
                    System.out.println("(2) NC16");
                    System.out.println("(3) M18");
                    System.out.println("(4) R21");
                    while(true) {
                        int selected = getChoice("Movie Rating: ");
                        if (selected == 0){
                            option = 4;
                            break;
                        }
                        else if (selected == 1){
                            StaffController.setAgeRequirement("PG13");
                            option = 6;
                            break;
                        }
                        else if (selected == 2){
                            StaffController.setAgeRequirement("NC16");
                            option = 6;
                            break;
                        }
                        else if (selected == 3){
                            StaffController.setAgeRequirement("M18");
                            option = 6;
                            break;
                        }
                        else if (selected == 4){
                            StaffController.setAgeRequirement("R21");
                            option = 6;
                            break;
                        }
                        else
                            System.out.println("Please enter a valid input");
                    }
                }
                case 6:{
                    while(true){
                        int duration = getChoice("\nEnter the duration (0 to go back): ");
                        if (duration < 0 )
                            System.out.println("Please enter a valid input");
                        else if (duration == 0){
                            option = 5;
                            break;
                        }
                        else{
                            StaffController.setDuration(duration);
                            StaffController.addMovie();
                            System.out.println("Creating Movie...");
                            System.out.println("Movie Created Successfully!");
                            option = 7;
                            break;
                        }
                    }
                    break;
                }
                case 7:{
                    while(true){
                        int choice = getChoice("\n(0) Return to Main Menu\n(1) Create a new movie\n ");
                        if (choice ==  0)
                            Navigation.goBack();
                        else if (choice == 1){
                            option = 0;
                            break;
                        }
                        else
                            System.out.println("Please enter a valid input");
                    }
                }
            }
        }
    }
}