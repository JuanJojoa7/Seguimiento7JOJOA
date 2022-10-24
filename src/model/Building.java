package model;

public class Building{

    private String buildingId;

    private final int SIZE_OF_APARTMENTS = 10;

    private Apartment[] apartments; 

    private String address; 

    public Building(String buildingId, int numApartments, String address){

        apartments = new Apartment[SIZE_OF_APARTMENTS];

        this.buildingId = buildingId;
        
        this.address = address;
    }

    public String getBuildingid(){
        return buildingId;
    }

    public String getAddress(){
        return address;
    }
    
}
