package model;
import model.*;

public class RealStateController{

    private final int SIZE_OF_BUILDINGS = 5;

    private final int SIZE_OF_PERSONS = 20;

    private Building[] buildings;

    private Person[] persons;

    public RealStateController(){

        buildings = new Building[SIZE_OF_BUILDINGS];

        persons = new Person[SIZE_OF_PERSONS];

    }

    public boolean isFoundBuilding(){
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] == null){
                isFound = true;
            }
        }

        return isFound;
    }

    public String addBuilding(String buildingId, int numApartments, String address){
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] == null){
                buildings[i] = new Building(buildingId, numApartments, address);
                isFound = true;
            }
        }

        return "\nSe ha creado el edificio exitosamente.";

    }

    public Building searchBuilding(String buildingId){
        Building buildingFound = null;
        for(int i=0; i<SIZE_OF_BUILDINGS; i++){
            if(buildings[i] !=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildingFound = buildings[i];
            }
        }
        return buildingFound;
    }

    

    


}