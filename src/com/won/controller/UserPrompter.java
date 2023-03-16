package com.won.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.won.model.activity.Activity;
import com.won.model.db.ActivityDB;
import com.won.model.db.ActivityFactory;
import com.won.model.user.User;
import com.won.viewer.Emailer;
import com.won.viewer.ViewPane;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


/**
 *  Main player of project.  Works to start and end all user interactions.
 */
public class UserPrompter {
    Prompter prompter = new Prompter(new Scanner(System.in));
    User user = new User();
    Controller controller = new Controller();


    /**
     * gameloop handles all user input and outsources to outside methods and classes.
     */
    public void gameLoop() {
        // Load Banner1:
        ViewPane.displayBanner1();
        // Get user specifics:
        requestName();
        requestSpendLimit();
        requestEnvironment();
        requestRestaurant();
        requestPartySize();
        requestCity();

        // Build the itinerary and clear the screen
        Collection<Activity> itinerary = controller.buildItinerary(user);
        Console.clear();


        // Display victory banner. Display results.  User interactions.
        ViewPane.displayBanner2();
        displayResult(itinerary);
        requestWebsites(itinerary);
        requestEmail(itinerary, user);
    }


    private void requestName() {
        // Prompt the user for the name
        while (true) {
            String name = prompter.prompt("Please enter your name:");
            // Test if name is a valid input
            if (name != null && !name.trim().isEmpty()) {
                user.setName(name);
                return;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void requestCity(){
        while(true) {
            String city = prompter.prompt("Please choose a city from the following list: " +
                    "\n1. Seattle\n2. Denver\nEnter your choice (1 or 2): ");
            city = city.trim();
            switch (city) {
                case "1":
                    requestLocation("Seattle", user);
                    return;
                case "2":
                    requestLocation("Denver", user);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void requestLocation(String city, User user) {
        ActivityFactory activityFactory = new ActivityFactory();
        try {
            activityFactory.loadJSON(city, user);
            user.setCity(ActivityDB.getInstance());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void requestSpendLimit() {
        double money = Double.parseDouble(prompter.prompt("what is your budget?"));
        user.setMoney(money);
    }

    private void requestEnvironment() {
        while (true) {
            String environment = prompter.prompt("Would you like to be [I]nside or [O]utside?");
            if (environment.trim().equalsIgnoreCase("I")) {
                user.setEnvironment(true);
                return;
            } else if (environment.trim().equalsIgnoreCase("O")) {
                user.setEnvironment(false);
                return;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void requestRestaurant() {
        while (true) {
            String restaurant = prompter.prompt("Are you planning to visit a restaurant? (Y/N)");
            if (restaurant.trim().equalsIgnoreCase("Y")) {
                user.setRestaurant(true);
                return;
            } else if (restaurant.trim().equalsIgnoreCase("N")) {
                user.setRestaurant(false);
                return;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    private void requestPartySize() {
        while (true) {
            String party = prompter.prompt("How many people(including yourself) will you be paying for? ");
            // Will accept 0 as answer because other people can pay for us!  Only hours matter at that point.  (Gift cards!)
            try {
                int partySize = Integer.parseInt(party.trim());
                user.setPartySize(partySize);
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    void displayResult(Collection<Activity> itinerary) {
        ViewPane.displayResult(itinerary);
    }


    private void requestWebsites(Collection<Activity> itinerary){
        while(itinerary.size() > 0){
            String goToWeb = prompter.prompt("Would you like to visit the websites? (Y/N): ");
            try {
                if (goToWeb.equalsIgnoreCase("Y")) {
                    itinerary.forEach(a -> launchBrowser(a.getWebsite()));
                    return;
                }
                else if (goToWeb.equalsIgnoreCase("N")){
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void launchBrowser(String url){
        String os = (System.getProperty("os.name").toLowerCase().contains("windows")) ? "explorer " : "start ";
        try {
            Runtime.getRuntime().exec(os + url);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void requestEmail(Collection<Activity> itinerary, User user){
        String email = prompter.prompt("Would you like to email the itinerary? (Y/N)");
            try {
                if (email.equalsIgnoreCase("Y")) {
                    email = prompter.prompt("Who would you like to email it too? (Enter emails separated by ',') for multiple.");
                    Emailer.email(email, itinerary, user);
                    return;
                }
                if (email.equalsIgnoreCase("N")){
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
    }
}
