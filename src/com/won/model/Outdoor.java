package com.won.model;

import java.util.List;

class Outdoor extends Activity{
    /*
     * ATTRIBUTES AND FIELDS
     */
    private List<String> equipmentRequired;

    /*
     * CONSTRUCTORS
     */
    Outdoor(String city, double hours, double price){
        super(city, hours, price);
    }
    Outdoor(String city, double hours, double price, String website){
        super(city, hours, price, website);
    }
    private Outdoor(String city, double hours, double price, List<String> equipmentRequired){
        super(city, hours, price);
        setEquipmentRequired(equipmentRequired);
    }
    private Outdoor(String city, double hours, double price, String website, List<String> equipmentRequired){
        super(city, hours, price, website);
        setEquipmentRequired(equipmentRequired);
    }

    public List<String> getEquipmentRequired() {
        return equipmentRequired;
    }
    public void setEquipmentRequired(List<String> equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }
}