package com.won.model.db;

import com.won.model.activity.Activity;
import com.won.model.activity.Indoor;
import com.won.model.activity.Outdoor;
import com.won.model.activity.Restaurant;

import java.util.*;

public class ActivityDB {
    private Collection<Activity> allActivities = new ArrayList<>();

    /*
     * CONSTRUCTORS ---- MAKING SINGLETON
     */
    private static ActivityDB activityDB = null;
    private ActivityDB() {
    }
    public static synchronized ActivityDB getInstance()
    {
        if(activityDB == null) activityDB = new ActivityDB();
        return activityDB;
    }

    /**
     * Business method to Randomize Activities
     */
    public void shuffleActivities(){
        Collections.shuffle((List<?>) allActivities);
    }

    /**
     * Business method to pull the first random Activity that meets the criteria of Environment vs Restaurant
     * What happens when it's empty
     */
    public Optional<Activity> randomActivityByType(String activityType){
        switch (activityType){
            case "Indoor":
                Optional<Activity> resultIn = getAllActivities().stream().filter(a -> a instanceof Indoor).findFirst();
                resultIn.ifPresent(this::removeRandomActivity);
                return resultIn;
            case "Outdoor":
                Optional<Activity> resultOut = getAllActivities().stream().filter(a -> a instanceof Outdoor).findFirst();
                resultOut.ifPresent(this::removeRandomActivity);
                return resultOut;
            default:
                Optional<Activity> resultRest = getAllActivities().stream().filter(a -> a instanceof Restaurant).findFirst();
                resultRest.ifPresent(this::removeRandomActivity);
                return resultRest;
        }
    }

    /*
     * Pop element off the Collection once it's used.
     */
    private void removeRandomActivity(Activity random){
        getAllActivities().remove(random);
    }

    /*
     * Methods to add to the activities
     */
    public void addActivity(Activity activity){
        allActivities.add(activity);
    }

    /*
     * GETTER ONLY
     */
    public Collection<Activity> getAllActivities(){
        return allActivities;
    }

}