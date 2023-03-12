package com.won.model;

import java.util.Collection;
import java.util.Collections;

class Location {
    /*
     * ATTRIBUTES AND FIELDS
     */
    private Collection<Indoor> indoorActivities;
    private Collection<Outdoor> outdoorActivities;
    private Collection<Restaurant> restaurantActivities;

    /*
     * CONSTRUCTORS ---- MAKING SINGLETON
     */
    private static Location location = null;
    private Location() {
    }
    public static synchronized Location getInstance()
    {
        if(location == null) location = new Location();
        return location;
    }


    /*
     * Methods to add to the activities
     */
    public void addIndoor(Indoor a){
        indoorActivities.add(a);
    }
    public void addOutdoor(Outdoor a){
        outdoorActivities.add(a);
    }
    public void addRestaurantActivities(Restaurant a){
        restaurantActivities.add(a);
    }



    /*
     * GETTER ONLY
     */
    public Collection<Indoor> getIndoorActivities() {
        return indoorActivities;
    }
    public Collection<Outdoor> getOutdoorActivities() {
        return outdoorActivities;
    }
    public Collection<Restaurant> getRestaurantActivities() {
        return restaurantActivities;
    }

}