package com.won.viewer;

import com.won.model.activity.Activity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

/**
 * @author Brandon Park
 *  UI output of activities to display for program user.
 */
    public class ViewPane {


        public static void displayBanner1() {
            try{
//            String banner = Files.readString(Path.of("resources/banner2.txt"));
            Files.lines(Path.of("resources/banner2.txt"))
                .forEach(System.out::println);
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
        public static void displayBanner2() {
            try{
//            String banner = Files.readString(Path.of("resources/banner1.txt"));
            Files.lines(Path.of("resources/banner1.txt"))
                .forEach(System.out::println);
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }



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