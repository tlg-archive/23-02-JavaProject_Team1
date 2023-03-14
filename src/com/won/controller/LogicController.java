package com.won.controller;

import com.won.model.*;

import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.Collection;

class LogicController {
    private List<Activity> restaurants = new ArrayList<>();
    private List<? extends Activity> activities = new ArrayList<>();

    /*
     * The logic controller will utilize the user inputs to pull activity and restaurant from the "database"
     */

    /*
     * Activity must be in the location that the user selected and will utilize the budget input from
     * the user to determine whether to pull the activity from the database. Then updateUser.
     */

    public List<? extends Activity> pullActivity(User user) {
        double timeRemain = user.getHours();
        double moneyRemain = user.getMoney();
        if (user.isRestaurant()) {
            restaurants = user.getCity().getRestaurantActivities();
        }
        activities = (user.isEnvironment()) ? user.getCity().getIndoorActivities() : user.getCity().getOutdoorActivities();
        return (user.isEnvironment()) ? user.getCity().getIndoorActivities() : user.getCity().getOutdoorActivities();
    }

    public List<? extends Activity> buildItinerary(User user) {
        pullActivity(user);
        List<Activity> itinerary = new ArrayList<>();


        while (user.getMoney() > 0
                && user.getHours() >0
                && !activities.isEmpty()
                && !restaurants.isEmpty()) {
            while (activities.size() > 0) {
                Activity activity = getRandomActivity(activities);
                if (activity.getHours() <= user.getHours()
                        && activity.getPrice() <= user.getMoney()) {
                    itinerary.add(activity);
                    updateUser(user, activity.getHours(), activity.getPrice());
                    break;
                }
                activities.remove(activity);

            }
            while (restaurants.size() > 0) {

                Restaurant restaurant = (Restaurant) getRandomActivity(restaurants);
                if (restaurant.getHours() <= user.getHours()
                        && restaurant.getPrice() <= user.getMoney()) {
                    itinerary.add(restaurant);
                    updateUser(user, restaurant.getHours(), restaurant.getPrice());
                    break;
                }
                restaurants.remove(restaurant);
            }
        }
        return itinerary;
    }

    public void updateUser(User user, double activityHours, double activityPrice) {
        user.setMoney(user.getMoney() - activityPrice);
        user.setHours(user.getHours() - activityHours);
    }
    private Activity getRandomActivity(List<? extends Activity> activities) {
        Random random = new Random();
        int index = random.nextInt(activities.size());
        return activities.get(index);
    }
}