package moblima.view;

import moblima.model.StackArg;

import java.util.Scanner;

public class AdminMenu {

    public AdminMenu() { }

    public void display(Navigation navigation) {
        boolean loop = true;
        System.out.println(
                  "=====================================\n"
                          + "--------------Admin Menu-------------\n"
                          + "=====================================\n"
                          + "(0) Back\n"
                          + "(1) Update movie details\n"
                          + "(2) Add movie\n"
                          + "(3) Add showtime listing\n"
                          + "(4) Edit baseTicketPrice\n"
                          + "(5) Add holiday date\n"
                          + "(6) View top 5 movies by ticket sales\n"
                          + "(7) View top 5 movies by overall reviewers ratings\n");


        StackArg curView = navigation.getLastView();
        while (loop) {
            int input = navigation.getChoice("Please select an option: ");
            switch (input) {
                case 0:
                    navigation.goBack();
                    loop = false;
                    break;

                case 1:
                    navigation.goTo(new StackArg("chooseMovie", curView.getUserType(), "updateMovie"));
                    loop = false;
                    break;

                case 2:
                    navigation.goTo(new StackArg("addMovie", curView.getUserType()));
                    loop = false;
                    break;

                case 3:
                    navigation.goTo(new StackArg("chooseMovie", curView.getUserType(), "addShowtime"));
                    loop = false;
                    break;

                case 4:
                    navigation.goTo(new StackArg("editBaseTicketPrice", curView.getUserType()));
                    loop = false;
                    break;

                case 5:
                    navigation.goTo(new StackArg("addHoliday", curView.getUserType()));
                    loop = false;
                    break;

                case 6:
                    navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "top5Sales"));
                    loop = false;
                    break;

                case 7:
                    navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "top5Rating"));
                    loop = false;
                    break;

                default:
                    System.out.println("\nPlease enter a valid input!\n");
            }
        }
    }
}

