package com.won.model.activity;

import com.won.model.activity.Activity;

public class Restaurant extends Activity {
    /*
     * ATTRIBUTES AND FIELDS
     */
    private boolean reservationRequired;
    private int minAge;

    /*
     * CONSTRUCTORS
     */
    public Restaurant(String actName, String city, double hours, double price, boolean reservationRequired){
        super(actName, city, hours, price);
        setReservationRequired(reservationRequired);
    }
    public Restaurant(String actName, String city, double hours, double price, String website, boolean reservationRequired){
        super(actName, city, hours, price, website);
        setReservationRequired(reservationRequired);
    }
    private Restaurant(String actName, String city, double hours, double price, boolean reservationRequired, int minAge){
        super(actName, city, hours, price);
        setReservationRequired(reservationRequired);
        setMinAge(minAge);
    }
    private Restaurant(String actName, String city, double hours, double price, String website, boolean reservationRequired, int minAge){
        super(actName, city, hours, price, website);
        setReservationRequired(reservationRequired);
        setMinAge(minAge);
    }



    /*
     * GETTERS AND SETTERS
     */
    public boolean isReservationRequired() {
        return reservationRequired;
    }
    public void setReservationRequired(boolean reservationRequired) {
        this.reservationRequired = reservationRequired;
    }
    public int getMinAge() {
        return minAge;
    }
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}