package com.won.model;

public class User {

    private String Name;
    private double money;
    private double hours;
    private Location city;
    private boolean environment;
    private boolean restaurant;

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

    public User(String name, double money, double hours, Location city) {
        this(name,money,hours);
        setCity(city);
    }

    public User(String name, double money, double hours, Location city, boolean environment) {
        this(name,money,hours,city);
        setEnvironment(environment);
    }

    public User(String name, double money, double hours, Location city, boolean environment, boolean restaurant) {
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

    public Location getCity() {
        return city;
    }

    public void setCity(Location city) {
        this.city = city;
    }

    public boolean isEnvironment() {
        return environment;
    }

    public void setEnvironment(boolean environment) {
        this.environment = environment;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }
}
