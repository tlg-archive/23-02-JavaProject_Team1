package com.won.main;

import com.won.controller.UserPrompter;
import com.won.viewer.Emailer;

public class Client {
    public static void main(String[] args) {
//        Emailer.sendEmail();
        UserPrompter itinerary = new UserPrompter();
        itinerary.gameLoop();
    }
}