package com.won.controller;

import com.apps.util.Prompter;
import com.won.model.activity.Activity;
import com.won.model.db.ActivityFactory;
import com.won.model.Location;
import com.won.model.user.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class UserPrompter {
    Prompter prompter = new Prompter(new Scanner(System.in));
    User user = new User();
    Controller controller = new Controller();


    public void gameLoop() {
        requestName();
        String city = prompter.prompt("Please choose a city from the following list:" +
                "\n1. Seattle\n2. Denver\nEnter your choice (1 or 2):");
        city = city.trim();
        switch (city) {
            case "1":
                requestLocation("Seattle");
                break;
            case "2":
                requestLocation("Denver");
                break;
            default:
                prompter.prompt("Invalid choice. Please choose again (1 or 2)");
        }
        /*
         * FOR TESTING::::
         */
//        requestLocation("Seattle");
//        user.setHours(10.0);
//        user.setMoney(100.0);
//        user.setEnvironment(true);
//        user.setRestaurant(true);
        requestLocation(city);
        requestSpendLimit();
        requestEnvironment();
        requestRestaurant();
        requestPartySize();
        List<? extends Activity> itinerary = controller.buildItinerary(user);
        displayResult(itinerary);
        requestWebsites(itinerary);
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

    private void requestLocation(String city) {
        ActivityFactory activityFactory = new ActivityFactory();
        try {
            activityFactory.loadJSON(city);
            user.setCity(Location.getInstance());
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
            String party = prompter.prompt("How many people(including yourself) will you be paying for?");
            try {
                int partySize = Integer.parseInt(party.trim());
                user.setPartySize(partySize);
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    void displayResult(List<? extends Activity> itinerary) {
        //TODO: Make pretty!!! Table?
        if (itinerary.isEmpty()) {
            System.out.println("Unfortunately, there is currently no available activites based on your critieria");
        }
        itinerary.forEach(System.out::println);
    }

    //TODO: requestFinalize() {
    //   ---- possibly to ask the user if he likes it, and then change it (tier 2 goal)}
    /*
     * TODO:  Will need a launchBrowser(String url) method.
     *    -- Check for OS with System.getProperty("os.name").toLowerCase() into process builder
     *    -- If windows: start "https://wwww.google.com"
     */
    private void requestWebsites(List<? extends Activity> itinerary){
        while(true){
            String goToWeb = prompter.prompt("Would you like to visit the websites? (Y/N)");
            try {
                if (goToWeb.equalsIgnoreCase("Y")) {
                    itinerary.forEach(a -> launchBrowser(a.getWebsite()));
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void launchBrowser(String url){
//        String os = System.getProperty("os.name").toLowerCase();
//        ProcessBuilder process = (os.contains("windows")) ?
//                new ProcessBuilder("start ", url) :
//                new ProcessBuilder("open ", url);
//                process.inheritIO().command("start " + url);

        try {
            Runtime.getRuntime().exec("explorer " + url);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
