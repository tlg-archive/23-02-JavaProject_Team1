package com.won.controller;

import com.won.viewer.Emailer;

class Client {
    public static void main(String[] args) {
        Emailer email = new Emailer();
        ItemPlanClient itinerary = new ItemPlanClient();
        itinerary.gameLoop();
        //TODO: Shift to separate package.
    }
}