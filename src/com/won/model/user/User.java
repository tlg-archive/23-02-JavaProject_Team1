package com.won.model.user;

import com.won.model.db.ActivityDB;


/**
 * @author Brandon Park
 * "Actor" of user that is able to track their own wallet, time remaining, and further user specific information
 */
public class User {

    private String Name;
    private double money;
    private double hours = 10.0;
    private ActivityDB city;
    private boolean environment;
    private boolean restaurant;
    private int partySize;

    public User() {}

    public User(String name) {
        setName(name);
    }

    public User(String name, double money) {
        this(name);
        setMoney(money);
    }

    public User(String name, double money, double hours) {
        this(name,money);
        setHours(hours);
    }

    public User(String name, double money, double hours, ActivityDB city) {
        this(name,money,hours);
        setCity(city);
    }

    public User(String name, double money, double hours, ActivityDB city, boolean environment) {
        this(name,money,hours,city);
        setEnvironment(environment);
    }

    public User(String name, double money, double hours, ActivityDB city, boolean environment, boolean restaurant) {
        this(name,money,hours,city,environment);
        setEnvironment(environment);
        setRestaurant(restaurant);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public ActivityDB getCity() {
        return city;
    }

    public void setCity(ActivityDB city) {
        this.city = city;
    }

    public boolean isEnvironment() {
        return environment;
    }

    public void setEnvironment(boolean environment) {
        this.environment = environment;
    }

    public boolean wantRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public int getPartySize(){
        return partySize;
    }
    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}
