package com.won.model;

public class Activity {
    /*
     * COMMON ATTRIBUTES BETWEEN ALL ACTIVITIES
     */
    private String city;
    private double hours;
    private double price;
    private String website;

    /*
     * CONSTRUCTORS TO ASSIST CHILD CLASSES
     */
    Activity(){}
    Activity(String city, double hours, double price){
        setCity(city);
        setHours(hours);
        setPrice(price);
    }
    Activity(String city, double hours, double price, String website){
        this(city, hours, price);
        setWebsite(website);
    }



    /*
     * GETTERS AND SETTERS
     */

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public double getHours() {
        return hours;
    }
    public void setHours(double hours) {
        this.hours = hours;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String toString(){
        return String.format("City: %s\n" +
                "Hours: %s\n" +
                "Price Per Person: %s\n" +
                "Website: %s",
                getCity(), getHours(), getPrice(), getWebsite());
    }
}