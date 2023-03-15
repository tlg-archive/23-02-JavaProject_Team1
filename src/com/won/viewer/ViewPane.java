package com.won.viewer;

import com.won.model.activity.Activity;

import java.util.Collection;

public class ViewPane {
    public static void displayResult(Collection<Activity> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Unfortunately, there is currently no available activites based on your critieria");
        }
        System.out.println(String.format("%-25s %-20s %-20s %-25s", "Attraction", "Hours", "Price Per Person", "Website"));
        System.out.println("------------------------------------------------------------");
        for (Activity activity : itinerary) {
            String website = activity.getWebsite() != null ? activity.getWebsite().toString() : "N/A";
            String attraction = activity.getActName().length() > 25 ? activity.getActName().substring(0, 22) + "..." : activity.getActName();
            System.out.println(String.format("%-25s %-20.1f $%-19.2f %-25s", attraction,
                    activity.getHours(), activity.getPrice(), website));
        }
    }

}