package com.won.model.activity;

import com.won.model.activity.Activity;

public class Outdoor extends Activity {
    /*
     * ATTRIBUTES AND FIELDS
     */
    private String equipmentRequired;

    /*
     * CONSTRUCTORS
     */
    public Outdoor(String actName, String city, double hours, double price){
        super(actName, city, hours, price);
    }
    public Outdoor(String actName, String city, double hours, double price, String website){
        super(actName, city, hours, price, website);
    }
    private Outdoor(String actName, String city, double hours, double price, String website, String equipmentRequired){
        super(actName, city, hours, price, website);
        setEquipmentRequired(equipmentRequired);
    }

    public String getEquipmentRequired() {
        return equipmentRequired;
    }
    public void setEquipmentRequired(String equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }
}