package moblima.view;

import moblima.controller.*;

/**
 * Represents the screen for staff Menu displaying all his/her options
 */
public class AdminMenu extends View{

    /**
     * Instantiates a new Admin Menu
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public AdminMenu(int userType, View nextView) {
        super("adminMenu", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {
        boolean loop = true;
        outputPageName("Admin Menu");
        System.out.println(
                          "(0) Logout\n"
                        + "(1) Update movie details\n"
                        + "(2) Add movie\n"
                        + "(3) Add showtime listing\n"
                        + "(4) Edit baseTicketPrice\n"
                        + "(5) Add holiday date\n"
                        + "(6) View top 5 movies by ticket sales\n"
                        + "(7) View top 5 movies by overall reviewers ratings\n");
        
        while (loop) {
            int input = getChoice("Please select an option: ");
            switch (input) {
                case 0:
                    Navigation.goBackMainMenu();
                    loop = false;
                    break;

                case 1:
                    View nextView = new UpdateMovie(getUserType(), null);
                    Navigation.goTo(new UpdateMovie(getUserType(), nextView));
                    loop = false;
                    break;

                case 2:
                    Navigation.goTo(new AddMovie(getUserType(), null));
                    loop = false;
                    break;

                case 3:
                    View nextViewAddShowtime = new AddShowtime(getUserType(), null);
                    Navigation.goTo(new ChooseMovie(getUserType(), nextViewAddShowtime));
                    loop = false;
                    break;

                case 4:
                    Navigation.goTo(new EditBaseTicketPrice(getUserType(), null));
                    loop = false;
                    break;

                case 5:
                    Navigation.goTo(new AddHoliday(getUserType(), null));
                    loop = false;
                    break;

                case 6:
                    Navigation.goTo(new Top5Sales(getUserType(), null));
                    loop = false;
                    break;

                case 7:
                    Navigation.goTo(new Top5Rating(getUserType(), null));
                    loop = false;
                    break;

                default:
                    System.out.println("\nPlease enter a valid input!\n");
            }
        }
    }
}

