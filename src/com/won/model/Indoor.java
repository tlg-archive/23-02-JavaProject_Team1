package com.won.model;

public class Indoor extends Activity{
 /*
  * INDOOR SPECIFIC ATTRIBUTES
  */
    private int minAge;
    private int capacity;

    /*
     * CONSTRUCTORS
     */
    Indoor(String city, double hours, double price){
        super(city, hours, price);
    }
    Indoor(String city, double hours, double price, String website){
        super(city, hours, price, website);
    }
    private Indoor(String city, double hours, double price, int minAge){
        super(city, hours, price);
        setMinAge(minAge);
    }
    private Indoor(String city, double hours, double price, String website, int minAge){
        super(city, hours, price, website);
        setMinAge(minAge);
    }
    private Indoor(String city, double hours, double price, int minAge, int capacity){
        super(city, hours, price);
        setMinAge(minAge);
        setCapacity(capacity);
    }
    private Indoor(String city, double hours, double price, String website,int minAge, int capacity){
        super(city, hours, price, website);
        setMinAge(minAge);
        setCapacity(capacity);
    }







    /*
     * GETTERS AND SETTERS
     */
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getMinAge() {
        return minAge;
    }
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
