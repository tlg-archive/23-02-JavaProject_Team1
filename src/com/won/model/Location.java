package com.won.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Location {
    /*
     * ATTRIBUTES AND FIELDS
     */
    private Collection<Indoor> indoorActivities = new ArrayList<>();
    private Collection<Outdoor> outdoorActivities = new ArrayList<>();
    private Collection<Restaurant> restaurantActivities = new ArrayList<>();

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
        System.out.println(indoorActivities);
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