package moblima.view;

import moblima.model.Holiday;
import moblima.model.MainModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddHoliday {

    public AddHoliday() {
    }

    public void display(Navigation navigation) {
        System.out.println(
                "=====================================\n"
                        + "-----------Add Holiday Date----------\n"
                        + "=====================================\n");

        System.out.println("All Holiday Dates:");
        for (int i = 0; i < MainModel.getHolidayList().size(); i++) {
            System.out.println(MainModel.getHolidayList().get(i).getHolidayDate());
        }
        System.out.println("(0) Back\n");

        try {
            getHolidayDate(navigation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getHolidayDate(Navigation navigation) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input holiday date in this format: dd/mm/yyyy: ");
        String date = sc.next();
        sc.nextLine();
        if (date.contentEquals("0")) {
            navigation.goBack();
        }
        else if (isThisDateValid(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            Date holidayDate = sdf.parse(date);
            if (holidayDateExist(date)) {
                System.out.println("Holiday date is already in database. Please enter a new date");
                getHolidayDate(navigation);
            }
            else if (holidayDate.after(todayDate)) {
                Holiday holiday = new Holiday(date);
                MainModel.addHoliday(holiday);
                System.out.println("Holiday date " + date + " successfully added");
                navigation.goBack();
            }
            else {
                System.out.println("Please enter future dates");
                getHolidayDate(navigation);
            }
        }
        else {
            System.out.println("Invalid date format. Please try again");
            getHolidayDate(navigation);
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
