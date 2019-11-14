package moblima.model;

public class Holiday {

    /**
     * Holiday date
     */
    private String holidayDate;
    /**
     * Name of the holiday
     */
    private String holidayName;

    public Holiday(String holidayDate) {
        this.holidayDate = holidayDate;
    }
    /**
     * Sets new Name of the holiday.
     *
     * @param holidayName New value of Name of the holiday.
     */
    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    /**
     * Sets new Holiday date.
     *
     * @param holidayDate New value of Holiday date.
     */
    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    /**
     * Gets Name of the holiday.
     *
     * @return Value of Name of the holiday.
     */
    public String getHolidayName() {
        return holidayName;
    }

    /**
     * Gets Holiday date.
     *
     * @return Value of Holiday date.
     */
    public String getHolidayDate() {
        return holidayDate;
    }
}
