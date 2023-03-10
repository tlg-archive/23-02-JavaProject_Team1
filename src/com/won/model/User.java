package com.won.model;

import java.util.Scanner;

class User {
    private double budget;
    private double hours;
    private String location;

    public User(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you plan to spend?");
        budget = scanner.nextDouble();
        System.out.println("How many hours do you plan to spend?");
        hours = scanner.nextDouble();
        System.out.println("Select a city from a following options:?");
        System.out.println("1. Seattle");
        System.out.println("2. Denver");
        String city = scanner.next().toLowerCase();

        switch (city) {
            case "1":
                city = "Seattle";
                break;
            case "2":
                city = "Denver";
                break;
            default:
                System.out.println("No other choices of city as of now.");
                break;
        }
    }

    public double getMoney() {
        return budget;
    }

    public double getHours() {
        return hours;
    }

    public String getLocation() {
        return location;
    }
}
