package com.won.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ActivityFactory {



    public void loadJSON(String city) throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader(String.valueOf(Path.of("resources/activities.json"))));
        JSONArray jsonArray = (JSONArray) o;
        for (var i : jsonArray){
            // Need to determine if we've seen this city before!!!
            Activity activity = downCast((JSONObject) i);
            if (activity.getCity().equals(city)){
                setOptionals(activity, (JSONObject) i);
                collectActivity(activity);
            }
        }
    }

    private Activity downCast(JSONObject j){
        String actType = (String) j.get("Activity");
        String city = (String) j.get("City");
        double hours = Double.parseDouble((String) j.get("Hours"));
        double price = Double.parseDouble((String) j.get("Price"));
        String website;
        website = (j.containsKey("Website")) ? (String) j.get("website") : null;

        switch (actType) {
            case "Indoor":
                return (website != null) ? new Indoor(city, hours, price, website) : new Indoor(city, hours, price);
            case "Outdoor":
                return (website != null) ? new Outdoor(city, hours, price, website) : new Outdoor(city, hours, price);
            case "Restaurant":
                boolean reservationRequired = Boolean.parseBoolean((String) j.get("Reservations"));
                return (website != null) ? new Restaurant(city, hours, price, website, reservationRequired)
                        : new Restaurant(city, hours, price, reservationRequired);
            default:
                System.out.println("Failed activity given from JSON: " + actType);
                return new Activity();
        }
    }
    private void setOptionals(Activity a, JSONObject j){
        if (a instanceof Indoor){
            Integer minAge;
            Integer capacity;
            minAge = j.containsKey("Min Age") ? Integer.parseInt((String) j.get("Min Age")) : null;
            capacity = j.containsKey("Capacity") ? Integer.parseInt((String) j.get("Capacity")) : null;
            if (minAge != null){
                ((Indoor) a).setMinAge(minAge);
            }
            if (capacity != null){
                ((Indoor) a).setCapacity(capacity);
            }
        } else if (a instanceof Outdoor){
            String equipment;
            equipment = j.containsKey("Equipment") ? (String) j.get("Equipment") : null;
            if (equipment != null) ((Outdoor) a).setEquipmentRequired(equipment);
        } else if (a instanceof Restaurant){
            Integer minAge;
            minAge = j.containsKey("Min Age") ? Integer.parseInt((String) j.get("Min Age")) : null;
            if (minAge != null){
                ((Restaurant) a).setMinAge(minAge);
            }
        }
    }
    private void collectActivity(Activity a){
        if(a instanceof Indoor){
            Location.getInstance().addIndoor((Indoor) a);
        } else if(a instanceof Outdoor){
            Location.getInstance().addOutdoor((Outdoor) a);
        } else {
            Location.getInstance().addRestaurantActivities((Restaurant) a);
        }
    }
}