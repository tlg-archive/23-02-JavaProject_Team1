package com.won.controller;

import com.won.model.Activity;
import com.won.model.Restaurant;
import com.won.model.User;

import java.util.ArrayList;
import java.util.Collection;

class LogicController {
    private Location city;
    private User user;
    private Activity randomAct;
    private Restaurant randomRest;

    /*
     * The logic controller will utilize the user inputs to pull activity and restaurant from the "database"
     */

    /*
     * Activity must be in the location that the user selected and will utilize the budget input from
     * the user to determine whether to pull the activity from the database. Then updateUser.
     *
     */
    public void pullActivity() {
        Collection<Activity> randomAct = new ArrayList<>();

        for (Activity randomAct : user.getActivity()) {
            // activity has to match location and fit in budget
            if (randomAct.getActvity().equals(getLocation().equals(getPrice()))) {

                result.add(randomAct);
            }
            else{
               // don't think I need to do anything else
            }
        }
    }

    /*
     * Restaurant must be in the location that the user selected and will utilize the budget input minus
     * the expenses from the activity to determine whether to pull the activity from the database.
     * Will not run if the user does not select "Get food suggestions"
     */
    public void pullRestaurant() {
        for (Restaurant randomRest : database) {
            // restaurant must fit in budget and be in location
            if (randomRest.getRestaurant().equals(getLocation().equals(getPrice()))) {

                result.add(randomRest);
            }
        }
    }

    public void updateUser (double hours, double money) {
        user.updateMoney(randomAct.price + randomAct.hours )
    }
}