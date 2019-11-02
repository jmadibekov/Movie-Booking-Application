package moblima.controller;

import moblima.model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Top5Controller {

    private static Cineplex chosenCineplex;

    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    public static void setChosenCineplex(Cineplex chosenCineplex) {
        Top5Controller.chosenCineplex = chosenCineplex;
    }

    public static void getTop5Movies() {
        chosenCineplex.getMovieList().sort(Comparator.comparingInt(Movie::getTicketSales).reversed());
        for (int i = 0;i<chosenCineplex.getMovieList().size();i++) {
            System.out.println(chosenCineplex.getMovieList().get(i).getTitle() + ", TicketSales: " +
                    chosenCineplex.getMovieList().get(i).getTicketSales());
            if (i == 5) {
                break;
            }
        }

    }

}
