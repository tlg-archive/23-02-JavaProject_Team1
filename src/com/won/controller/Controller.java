package com.won.controller;

import com.won.model.activity.Activity;
import com.won.model.activity.Restaurant;
import com.won.model.db.ActivityDB;
import com.won.model.db.ActivityFactory;
import com.won.model.user.User;

import java.util.List;
import java.util.Random;

import java.util.ArrayList;

class Controller {
    private List<Activity> restaurants = new ArrayList<>();
    private List<? extends Activity> activities = new ArrayList<>();

    /*
     * The logic controller will utilize the user inputs to pull activity and restaurant from the "database"
     */

    /*
     * Activity must be in the location that the user selected and will utilize the budget input from
     * the user to determine whether to pull the activity from the database. Then updateUser.
     */


    public Collection<Activity> buildItinerary(User user) {

        // Helper variables:
        String environment = (user.isEnvironment() == true) ? "Indoor" : "Outdoor";
        ActivityDB db = ActivityDB.getInstance();
        db.shuffleActivities();
        Collection<Activity> itinerary = new ArrayList<>();
        //TODO: Only include ONE restaurant in the list!  (Or we're gonna make our peeps fat)
        while (!db.getAllActivities().isEmpty()) {
            // First find a random Activity:
            Activity activity = db.randomActivityByType(environment);
            // Now test if it meets our criteria (money and time)
            if (activity != null &&  activity.getHours() <= user.getHours()
                && activity.getPrice() * user.getPartySize() <= user.getMoney()) {
                    itinerary.add(activity);
                    updateUser(user, activity.getHours(), activity.getPrice());
            }
            if (user.isRestaurant()) {
                // First find a random Restaurant
                Activity restaurant = db.randomActivityByType("Restaurant");
                // Now test if it meets our criteria (money and time)
                if (activity != null && restaurant.getHours() <= user.getHours()
                    && restaurant.getPrice() * user.getPartySize() <= user.getMoney()) {
                        itinerary.add(restaurant);
                        updateUser(user, restaurant.getHours(), restaurant.getPrice());
                }
            }
        }
        return itinerary;
    }

    public void updateUser(User user, double activityHours, double activityPrice) {
        user.setMoney(user.getMoney() - activityPrice * user.getPartySize());
        user.setHours(user.getHours() - activityHours);
    }
    private Activity getRandomActivity(List<? extends Activity> activities) {
        Random random = new Random();
        int index = random.nextInt(activities.size());
        return activities.get(index);
    }
}