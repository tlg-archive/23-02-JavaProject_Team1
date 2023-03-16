package com.won.model.activity;

/**
 * Super class to specific categories of Activity
 * @author Joshua Richardson
 */
public class Activity {
    /*
     * COMMON ATTRIBUTES BETWEEN ALL ACTIVITIES
     */
    private String city;
    private double hours;
    private double price;
    private String website;
    private String actName;

    /*
     * CONSTRUCTORS TO ASSIST CHILD CLASSES
     */
    public Activity(){}
    Activity(String actName, String city, double hours, double price){
        setActName(actName);
        setCity(city);
        setHours(hours);
        setPrice(price);
    }
    Activity(String actName, String city, double hours, double price, String website){
        this(actName, city, hours, price);
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
    public String getActName(){
        return this.actName;
    }
    public void setActName(String actName){
        this.actName = actName;
    }
    public String toString(){
        return String.format("Attraction: %s\n" +
                "Hours: %s\n" +
                "Price Per Person: %s\n" +
                "Website: %s\n\n\n",
                getActName(), getHours(), getPrice(), getWebsite());
    }
}