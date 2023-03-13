package com.won.controller;

import com.apps.util.Prompter;
import com.won.model.ActivityFactory;
import com.won.model.Location;
import com.won.model.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;


import com.apps.util.Prompter;
import com.won.model.ActivityFactory;
import com.won.model.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

class ItemPlanClient {
    Prompter prompter = new Prompter(new Scanner(System.in));
    User user = new User();

    private String getName() {
        // Prompt the user for the name
        while (true) {
            String name = prompter.prompt("Please enter your name:");
            // Test if name is a valid input
            if (name != null && !name.trim().isEmpty()) {
                return name;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private User gameLoop(String name) {
        String location = prompter.prompt("What city would you like to visit?");
        requestLocation(location);
        requestSpendLimit();
        requestEnvironment();
        requestRestaurant();
        return user;
    }

    private void requestLocation(String location) {
        ActivityFactory activityFactory = new ActivityFactory();
        try {
            activityFactory.loadJSON(location);
            user.setCity(Location.getInstance());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void requestSpendLimit() {
        double money = Double.parseDouble(prompter.prompt("How much money per person are you willing to spend?"));
        user.setMoney(money);
    }

    private void requestEnvironment() {
        while (true) {
            String environment = prompter.prompt("Would you like to be [I]nside or [O]utside?");
            if (environment.equalsIgnoreCase("I")) {
                user.setEnvironment(true);
            } else if (environment.equalsIgnoreCase("O")) {
                user.setEnvironment(false);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void requestRestaurant() {
        while (true) {
            String restaurant = prompter.prompt("Are you planning to visit a restaurant? (Y/N)");
            if (restaurant.equalsIgnoreCase("Y")) {
                user.setRestaurant(true);
                return;
            } else if (restaurant.equalsIgnoreCase("N")) {
                user.setRestaurant(false);
                return;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    void displayResult() {
        //Take itenerary given by logic class and loop through to display neatly.
    }

    //TODO: requestFinalize() {
    //   ---- possibly to ask the user if he likes it, and then change it (tier 2 goal)}
}
