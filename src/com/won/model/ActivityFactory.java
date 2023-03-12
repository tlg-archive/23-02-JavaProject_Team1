package com.won.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class ActivityFactory {



    private void loadJSON() throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader(String.valueOf(Path.of("resources/activities.json"))));
        JSONObject j = (JSONObject) o;

        Activity activity = downCast(j);
        setOptionals(activity, j);
        collectActivity(activity);
    }

    private Activity downCast(JSONObject j){
        String actType = (String) j.get("Activity");
        String city = (String) j.get("City");
        double hours = Double.parseDouble((String) j.get("Hours"));
        double price = Double.parseDouble((String) j.get("Price"));
        String website = (String) j.get("website");

        switch (actType) {
            case "Indoor":
                return (website != null) ? new Indoor(city, hours, price, website) : new Indoor(city, hours, price);
            case "Outdoor":
                return (website != null) ? new Outdoor(city, hours, price, website) : new Outdoor(city, hours, price);
            case "Restaurant":
                boolean reservationRequired = (Boolean) j.get("Reservation Required");
                return (website != null) ? new Restaurant(city, hours, price, website, reservationRequired)
                        : new Restaurant(city, hours, price, reservationRequired);
            default:
                System.out.println("Failed activity given from JSON: " + actType);
                return new Activity();
        }
    }
    private void setOptionals(Activity a, JSONObject j){
        if (a instanceof Indoor){
            Integer minAge = Integer.parseInt((String) j.get("Min Age"));
            Integer capacity = Integer.parseInt((String) j.get("Capacity"));
            if (minAge != null && minAge != 0){
                ((Indoor) a).setMinAge(minAge);
            }
            if (capacity != null && capacity != 0){
                ((Indoor) a).setCapacity(capacity);
            }
        } else if (a instanceof Outdoor){
            List<String> equipment = (List<String>) j.get("Equipment");
            if (equipment.size() != 0) ((Outdoor) a).setEquipmentRequired(equipment);
        } else if (a instanceof Restaurant){
            Integer minAge = Integer.parseInt((String) j.get("Min Age"));
            if (minAge != null && minAge != 0){
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