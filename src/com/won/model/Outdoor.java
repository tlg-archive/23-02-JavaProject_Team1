package com.won.model;

import java.util.List;

public class Outdoor extends Activity{
    /*
     * ATTRIBUTES AND FIELDS
     */
    private String equipmentRequired;

    /*
     * CONSTRUCTORS
     */
    Outdoor(String city, double hours, double price){
        super(city, hours, price);
    }
    Outdoor(String city, double hours, double price, String website){
        super(city, hours, price, website);
    }
    private Outdoor(String city, double hours, double price, String website, String equipmentRequired){
        super(city, hours, price, website);
        setEquipmentRequired(equipmentRequired);
    }

    public String getEquipmentRequired() {
        return equipmentRequired;
    }
    public void setEquipmentRequired(String equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }
}