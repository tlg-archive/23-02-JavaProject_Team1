package com.won.model.db;

import com.won.model.activity.Activity;
import com.won.model.activity.Indoor;
import com.won.model.activity.Outdoor;
import com.won.model.activity.Restaurant;

import java.util.*;

public class ActivityDB {
    /*
     * ATTRIBUTES AND FIELDS
     */
//    private List<Indoor> indoorActivities = new ArrayList<>();
//    private List<Outdoor> outdoorActivities = new ArrayList<>();
//    private List<Activity> restaurantActivities = new ArrayList<Activity>();
    private Collection<Activity> allActivities = new ArrayList<>();





    //TODO: Rename as city, and simplify the indoor vs outdoor.  Flesh out further and think of it LIKE the DB.

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



    /*
     * Business method to Randomize Activities
     */
    public void shuffleActivities(){
        System.out.println(getAllActivities());
        Collections.shuffle((List<?>) allActivities);
        System.out.println(getAllActivities());
    }

    /*
     * Business method to pull the first random Activity that meets the criteria of Environment vs Restaurant
     * What happens when it's empty
     */


    // Sorry, Jay.  The enum was rude
    public Activity randomActivityByType(String activityType){
        for (var activity : getAllActivities()){
            // 3 cases: activityType
            System.out.println(activity);
            switch (activityType){
                case "Indoor":
                    if (activity instanceof Indoor){
                        removeRandomActivity(activity);
                        return activity;
                    }
                case "Outdoor":
                    if(activity instanceof Outdoor){
                        removeRandomActivity(activity);
                        return activity;
                    }
                case "Restaurant":
                    if(activity instanceof Restaurant){
                        removeRandomActivity(activity);
                        return activity;
                    }
            }
        }
        System.out.println("O SHIT I'M NULL");
        return null;
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

//    public void addIndoor(Indoor a){
//        indoorActivities.add(a);
//    }
//    public void addOutdoor(Outdoor a){
//        outdoorActivities.add(a);
//    }
//    public void addRestaurantActivities(Restaurant a){
//        restaurantActivities.add(a);
//    }



    /*
     * GETTER ONLY
     * TODO: Cycle through and ask instanceof
     *  TODO: Implement the randomizer inside here.
     *   string Activity randActivity(String type --- enum?){ --- pull the activity and pop off original list }
     *      -- COLLECTIONS.SHUFFLE CRIES INSIDE.
     */

    public Collection<Activity> getAllActivities(){
        return allActivities;
    }





//    public List<Indoor> getIndoorActivities() {
//        return indoorActivities;
//    }
//    public List<Outdoor> getOutdoorActivities() {
//        return outdoorActivities;
//    }
//    public List<Activity> getRestaurantActivities() {
//        return restaurantActivities;
//    }

}