package com.won.main;

import com.won.controller.UserPrompter;

/**
 * Main entry point.
 */
public class Client {
    public static void main(String[] args) {
        UserPrompter itinerary = new UserPrompter();
        itinerary.gameLoop();
    }
}