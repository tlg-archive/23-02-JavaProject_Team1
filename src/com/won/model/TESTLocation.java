package com.won.model;

import org.json.simple.parser.ParseException;

import java.io.IOException;

class TESTLocation {
    public static void main(String[] args) {
        ActivityFactory activityFactory = new ActivityFactory();
        try{
            activityFactory.loadJSON("Seattle");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}