package com.won.model.activity;

public class Indoor extends Activity {
 /*
  * INDOOR SPECIFIC ATTRIBUTES
  */
    private int minAge;
    private int capacity;

    /*
     * CONSTRUCTORS
     */
    public Indoor(String actName, String city, double hours, double price){
        super(actName, city, hours, price);
    }
    public Indoor(String actName, String city, double hours, double price, String website){
        super(actName, city, hours, price, website);
    }
    private Indoor(String actName, String city, double hours, double price, int minAge){
        super(actName, city, hours, price);
        setMinAge(minAge);
    }
    private Indoor(String actName, String city, double hours, double price, String website, int minAge){
        super(actName, city, hours, price, website);
        setMinAge(minAge);
    }
    private Indoor(String actName, String city, double hours, double price, int minAge, int capacity){
        super(actName, city, hours, price);
        setMinAge(minAge);
        setCapacity(capacity);
    }
    private Indoor(String actName, String city, double hours, double price, String website,int minAge, int capacity){
        super(actName, city, hours, price, website);
        setMinAge(minAge);
        setCapacity(capacity);
    }

    public Indoor() {

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
