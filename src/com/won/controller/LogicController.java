package com.won.controller;

import com.won.model.Activity;
import com.won.model.Restaurant;
import com.won.model.User;

import java.util.ArrayList;
import java.util.Collection;

class LogicController {
    private Location city;
    private User user;
    private Activity randomAct = null;
    private Restaurant randomRest;

    private List<Activity> itinerary;

    /*
     * The logic controller will utilize the user inputs to pull activity and restaurant from the "database"
     */

    /*
     * Activity must be in the location that the user selected and will utilize the budget input from
     * the user to determine whether to pull the activity from the database. Then updateUser.
     */
    String environment = user.getEnvironment();
    boolean wantRestaurant = user.getWantRestaurant();
    public void pullActivity(environment, wantRestaurant) {
        double timeRemain = user.getHours();
        double moneyRemain = user.getMoney
        if (environment.equals("indoors")) {
            activities = user.city.getIndoors();
        } else if (environment.equals("outdoors")) {
            activities = user.location.getOudoors();
        }

        if (wantRestaurant) {
            restaurants = user.location.getRestaurants();
        }
    }

    public void buildItinerary() {
        double userTime = user.getHours();
        double userMoney = user.getMoney();
        while (userTime > 0 && userMoney >0) {
            while (activities.size() > 0) {
                Activity activity = getRandomActivity(activities);
                if (activity.getHours() <= userTime
                        && activity.getPrice() <= userMoney) {
                    itinerary.add(activity);
                    updateUser(activity.getHours(), activity.getPrice());
                    break;
                }
                else activities.remove(activity);
            }
        }
    }

    public void updateUser (double hours, double money) {
        user.updateMoney(randomAct.price + randomAct.hours );
    }
}