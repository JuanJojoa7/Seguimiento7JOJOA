package model;
import javax.xml.namespace.QName;

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

    public String isAvailableBuilding(){
        String response = "\nPosicion disponible.";
        if(buildings[0]==null){
            response = "\nLo sentimos, no hay edificios registrados.";
        }else if(buildings[SIZE_OF_BUILDINGS-1] != null){
            response = "\nLo sentimos, has alcanzado el maximo de edificios.";
        }
        return response;
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

    public String listApartments(String buildingId){
        String msj = null;
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i]!=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                msj = buildings[i].listApartments();
            }
        }
        return msj;
    }

    public String AddApartment(String buildingId, String aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){

        for(int i=0; i<SIZE_OF_BUILDINGS; i++){
            if(buildings[i] != null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildings[i].addApartment(aptIdentifier, numRooms, numBathrooms, hasBalcony, rentalValue);
            }
        }
        
        return "\nSe ha registrado el apartamento correctamente.";

    }

    public Apartment searchApartment(String buildingId, String aptIdentifier){

        Apartment apartmentFound = null;
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i]!=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                apartmentFound = buildings[i].searchApartment(aptIdentifier);
            }
        }
        return apartmentFound;

    }

    public String addPerson(String buildingId, String aptIdentifier, String id, String numId, String name, String phoneNumber, int typePhone, String account, String bank){
        boolean getSpace = false;
        AptOwner person = null;
        for(int i=0; i<SIZE_OF_PERSONS && !getSpace; i++){
            if(persons[i] == null){
                persons[i] = new AptOwner(id, numId, name, phoneNumber, typePhone, account, bank);
                getSpace = true;

            }
        }
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] !=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildings[i].addPersonToApt(person,aptIdentifier);
            }
        }
        return "\nPropietario agregado correctamente.";
    }

    public String addPerson(String buildingId, String aptIdentifier, String id, String numId, String name, String phoneNumber, int typePhone){
        boolean getSpace = false;
        AptRenter person = null;
        for(int i=0; i<SIZE_OF_PERSONS && !getSpace; i++){
            if(persons[i] == null){
                persons[i] = new AptRenter(id, numId, name, phoneNumber, typePhone);
                getSpace = true;

            }
        }
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] !=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildings[i].addPersonToApt(person,aptIdentifier);
            }
        }
        return "\nArrendatario agregado correctamente.";
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

    public Person searchPerson(String numId){
        Person personFound = null;
        for(int i=0; i<SIZE_OF_PERSONS; i++){
            if(persons[i]!=null && persons[i].getnumId().equalsIgnoreCase(numId)){
                personFound = persons[i];
            }
        }
        return personFound;
    }

}