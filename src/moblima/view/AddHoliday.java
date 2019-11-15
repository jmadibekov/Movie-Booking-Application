package moblima.view;

import moblima.controller.Navigation;
import moblima.model.Holiday;
import moblima.model.MainModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class AddHoliday extends View{

    public AddHoliday(int userType, View nextView) {
        super("addHoliday", userType, nextView);
    }

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

    private boolean holidayDateExist(String date) {
        for (int i = 0; i < MainModel.getHolidayList().size(); i++) {
            if (date.contentEquals(MainModel.getHolidayList().get(i).getHolidayDate()))
                return true;
        }
        return false;
    }
}
