package com.won.controller;

import com.won.model.Activity;
import com.won.model.Restaurant;
import com.won.model.User;
import java.util.Random;

import java.util.ArrayList;
import java.util.Collection;

class LogicController {
    private Location city;  // <--- optional.  The user will be holding onto the city as well.
    private User user;
    private Activity randomAct = null;
    private Restaurant randomRest;
    Collection<Activity> activities = new ArrayList<>();
    Collection<Activity> restaurants = new ArrayList<>();

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
        double moneyRemain = user.getMoney();
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
            while (restaurants.size() > 0) {

                Restaurant restaurant = (Restaurant) getRandomActivity(restaurants);
                if (restaurant.getHours() <= userTime
                        && restaurant.getPrice() <= userMoney) {
                    itinerary.add(restaurant);
                    updateUser(restaurant.getHours(), restaurant.getPrice());
                    break;
                }
                else activities.remove(restaurant);
            }
        }
    }

    public void updateUser (double hours, double money) {
        user.updateMoney((randomAct.price + randomAct.hours) );
    }

    private Activity getRandomActivity(Collection<Activity> activities) {
        Random random = new Random();
        int index = random.nextInt(activites.size());
        return activities.get(index);
    }
}