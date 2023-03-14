package com.won.main;

import com.won.controller.UserPrompter;

class Main {
    public static void main(String[] args) {
        UserPrompter itinerary = new UserPrompter();
        itinerary.gameLoop();
        //TODO: Shift to separate package.
    }
}