package com.won.model;

class Restaurant extends Activity{
    /*
     * ATTRIBUTES AND FIELDS
     */
    private boolean reservationRequired;
    private int minAge;

    /*
     * CONSTRUCTORS
     */
    Restaurant(String city, double hours, double price, boolean reservationRequired){
        super(city, hours, price);
        setReservationRequired(reservationRequired);
    }
    Restaurant(String city, double hours, double price, String website, boolean reservationRequired){
        super(city, hours, price, website);
        setReservationRequired(reservationRequired);
    }
    private Restaurant(String city, double hours, double price, boolean reservationRequired, int minAge){
        super(city, hours, price);
        setReservationRequired(reservationRequired);
        setMinAge(minAge);
    }
    private Restaurant(String city, double hours, double price, String website, boolean reservationRequired, int minAge){
        super(city, hours, price, website);
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