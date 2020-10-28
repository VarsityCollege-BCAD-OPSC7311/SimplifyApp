package com.cpillay.simplifyapp;

public class LogMealsHelperClass {
    String breakfastCal;
    String LunchCal;

    public String getBreakfastCal() {
        return breakfastCal;
    }

    public void setBreakfastCal(String breakfastCal) {
        this.breakfastCal = breakfastCal;
    }

    public String getLunchCal() {
        return LunchCal;
    }

    public void setLunchCal(String lunchCal) {
        LunchCal = lunchCal;
    }

    public String getSupperCal() {
        return SupperCal;
    }

    public void setSupperCal(String supperCal) {
        SupperCal = supperCal;
    }

    public String getSnacksCal() {
        return snacksCal;
    }

    public void setSnacksCal(String snacksCal) {
        this.snacksCal = snacksCal;
    }

    String SupperCal;

    public LogMealsHelperClass(String breakfastCal, String lunchCal, String supperCal, String snacksCal) {
        this.breakfastCal = breakfastCal;
        LunchCal = lunchCal;
        SupperCal = supperCal;
        this.snacksCal = snacksCal;
    }

    String snacksCal;
}
