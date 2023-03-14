package com.won.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    /*
     * ATTRIBUTES AND FIELDS
     */
    private List<Indoor> indoorActivities = new ArrayList<>();
    private List<Outdoor> outdoorActivities = new ArrayList<>();
    private List<Activity> restaurantActivities = new ArrayList<Activity>();

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
    public List<Indoor> getIndoorActivities() {
        return indoorActivities;
    }
    public List<Outdoor> getOutdoorActivities() {
        return outdoorActivities;
    }
    public List<Activity> getRestaurantActivities() {
        return restaurantActivities;
    }

}