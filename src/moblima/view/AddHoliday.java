package moblima.view;

import moblima.controller.Navigation;
import moblima.model.Holiday;
import moblima.model.MainModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents the screen when staff wants to add a holiday
 */
public class AddHoliday extends View{

    /**
     * Instantiates a new AddHoliday view
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public AddHoliday(int userType, View nextView) {
        super("addHoliday", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {
        outputPageName("Add Holiday Date");

        System.out.println("All Holiday Dates:");
        for (int i = 0; i < MainModel.getHolidayList().size(); i++) {
            System.out.printf("%s, %s\n",
                    MainModel.getHolidayList().get(i).getHolidayName(),
                    MainModel.getHolidayList().get(i).getHolidayDate());
        }
        System.out.println("(0) Back\n");

        try {
            getHolidayDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display the view to get holiday date
     * @throws ParseException exception to thrown if IO interrupt or unable to read.
     */
    private void getHolidayDate() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input holiday date in this format: dd/mm/yyyy: ");
        String date = sc.next();
        sc.nextLine();
        if (date.contentEquals("0")) {
            Navigation.goBack();
        }
        else if (isThisDateValid(date) && date.length() == 10) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            Date holidayDate = sdf.parse(date);
            if (holidayDateExist(date)) {
                System.out.println("Holiday date is already in database. Please enter a new date");
                getHolidayDate();
            }
            else if (holidayDate.after(todayDate)) {
                getHolidayName(date);
            }
            else {
                System.out.println("Please enter future dates");
                getHolidayDate();
            }
        }
        else {
            System.out.println("Invalid date format. Please try again");
            getHolidayDate();
        }
    }

    /**
     * Display the view to get Holiday Name
     *
     * @param date the holiday's date
     * @throws ParseException exception to thrown if IO interrupt or unable to read.
     */
    private void getHolidayName(String date) throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input the holiday name: ");
        String holidayName = sc.nextLine();
        if (holidayName.contentEquals("0")) {
            getHolidayDate();
        }
        else {
            Holiday holiday = new Holiday(holidayName, date);
            MainModel.addHoliday(holiday);
            System.out.println("Holiday: " + holidayName + ", " + date + " was successfully added");
            Navigation.goBack();
        }
    }

    /**
     * A function to test if the date entered by  a user is a valid date in the format dd/MM/yyyy
     *
     * @param dateToValidate Date to be checked.
     * @return boolean based on whether the date is valid
     */
    private boolean isThisDateValid(String dateToValidate){
        if(dateToValidate == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Check whether the date entered by a staff exist in the system. If exist, return true. Otherwise, return false
     *
     * @param date the holiday's date
     * @return boolean based on whether holiday date exist in system
     */
    private boolean holidayDateExist(String date) {
        for (int i = 0; i < MainModel.getHolidayList().size(); i++) {
            if (date.contentEquals(MainModel.getHolidayList().get(i).getHolidayDate()))
                return true;
        }
        return false;
    }
}
