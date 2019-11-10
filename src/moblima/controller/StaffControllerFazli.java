package moblima.controller;

import moblima.model.Cineplex;

public class StaffControllerFazli {

    private static Cineplex chosenCineplex;

    public static Cineplex getChosenCineplex() {
        return chosenCineplex;
    }

    public static void setChosenCineplex(Cineplex cineplex) {
        chosenCineplex = cineplex;
    }

}
