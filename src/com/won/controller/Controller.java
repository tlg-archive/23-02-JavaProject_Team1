package com.won.controller;

import com.won.model.activity.Activity;
import com.won.model.activity.Restaurant;
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

    public List<? extends Activity> pullActivity(User user) {
        if (user.wantRestaurant()) {
            restaurants = user.getCity().getRestaurantActivities();
        }
//        activities = (user.isEnvironment()) ? user.getCity().getIndoorActivities() : user.getCity().getOutdoorActivities();
        return activities = (user.isIndoors()) ? user.getCity().getIndoorActivities() : user.getCity().getOutdoorActivities();
    }

    public List<? extends Activity> buildItinerary(User user) {
        pullActivity(user);
        List<Activity> itinerary = new ArrayList<>();
        //TODO: Combine activities and restaurants into one list and request instanceof
        // Perhaps have the Location class conduct the randomizer.
        while (!activities.isEmpty() && !restaurants.isEmpty()) {
            chooseRandomActivity(user,itinerary);
            chooseRandomRestaurant(user,itinerary);
        }
        return itinerary;
    }

    private void chooseRandomActivity(User user, List<Activity> itinerary){
        while (activities.size() > 0) {
            Activity activity = getRandomActivity(activities);
            if (activity.getHours() <= user.getHours()
                    && activity.getPrice()*user.getPartySize() <= user.getMoney()) {
                itinerary.add(activity);
                updateUser(user, activity.getHours(), activity.getPrice());
                activities.remove(activity);
                return;
            }
            activities.remove(activity);
        }
    }
    private void chooseRandomRestaurant(User user, List<Activity> itinerary){
        while (restaurants.size() > 0) {
            Restaurant restaurant = (Restaurant) getRandomActivity(restaurants);
            if (restaurant.getHours() <= user.getHours()
                    && restaurant.getPrice()*user.getPartySize() <= user.getMoney()) {
                itinerary.add(restaurant);
                updateUser(user, restaurant.getHours(), restaurant.getPrice());
                restaurants.remove(restaurant);
                return;
            }
            restaurants.remove(restaurant);
        }
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