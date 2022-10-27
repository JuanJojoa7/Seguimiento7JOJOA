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

    /** isFoundBuilding: It is in charge of validating the registered information of the buildings, and helps to avoid repeating IDs.
    * @return isFound: boolean => Returns whether or not the building can be registered.
    */
    public boolean isFoundBuilding(){
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] == null){
                isFound = true;
            }
        }

        return isFound;
    }

    /** isAvailableBuilding: It is the validation in charge of telling the user if there are still spaces to register buildings.
    * @return response: String => Returns the confirmation message telling the user whether there is space or not.
    */
    public String isAvailableBuilding(){
        String response = "\nPosicion disponible.";
        if(buildings[0]==null){
            response = "\nLo sentimos, no hay edificios registrados.";
        }else if(buildings[SIZE_OF_BUILDINGS-1] != null){
            response = "\nLo sentimos, has alcanzado el maximo de edificios.";
        }
        return response;
    }

    /** addBuilding: It is responsible for adding a building to the program.
    * @param buildingId: String => This is the ID that the user must enter to create the building.
    * @param numApartments: int => It is the number of apartments the building will have.
    * @param address: String => This is the address where the building will be located.
    * @return String => This is the confirmation message that the user receives.
    */
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

    /** listApartments: It is responsible for listing the available apartments in a building.
    * @param buildingId: String => It is the ID that a building has.
    * @return msgListApartments: String => This is the message with the number of apartments found.
    */
    public String listApartments(String buildingId){
        String msgListApartment = null;
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i]!=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                msgListApartment = buildings[i].listApartments();
            }
        }
        return msgListApartment;
    }

    /** addApartment: It is the method in charge of adding apartments to the system.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    * @param numRooms: int => This is the number of rooms in the apartment.
    * @param numBathrooms: int => This is the number of bathrooms in the apartment.
    * @param hasBalcony: boolean => It is the option that defines if the apartment will have a balcony or not.
    * @param rentalValue: double => It is the rental fee that the apartment will have.
    * @return String => This is the message confirming the creation of the apartment.
    */
    public String AddApartment(String buildingId, String aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){

        for(int i=0; i<SIZE_OF_BUILDINGS; i++){
            if(buildings[i] != null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildings[i].addApartment(aptIdentifier, numRooms, numBathrooms, hasBalcony, rentalValue);
            }
        }
        
        return "\nSe ha registrado el apartamento correctamente.";

    }

    /** searchApartment: It is the method to search for apartments, to know if they are occupied or not, or if they have already been created.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    * @return apartmentFound: Apartment => It is the validation of the apartment found.
    */
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

    /** searchBuilding: It is responsible for finding the buildings registered in the system and validating them.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @return buildingFound: Building => Returns whether the building was found or not, in order to assign apartments.
    */
    public Building searchBuilding(String buildingId){
        Building buildingFound = null;
        for(int i=0; i<SIZE_OF_BUILDINGS; i++){
            if(buildings[i] !=null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                buildingFound = buildings[i];
            }
        }
        return buildingFound;
    }

    /** calculateRentalValue: It is the method used to obtain the monthly rent of a building.
    * @param aptIdentifier: String => This is the ID with which the apartment is identified.
    * @return msgConfirmation: String => It is the confirmation message with the rent charged in a building.
    */
    public String calculateRentalValue(String aptIdentifier){
        String msgConfirmation = "\nEl valor mensual a recibir en este edificio es: ";
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] != null && buildings[i].getBuildingid().equalsIgnoreCase(aptIdentifier)){
                msgConfirmation += buildings[i].calculateRentalValue();
                isFound = true;
            }
        } 
        return msgConfirmation;
    }

    /** searchSpecificApartment: It is in charge of searching for the apartment object, verifies if it is created and obtains its information.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @param aptIdentifier: String => This is the ID with which the apartment is identified.
    * @return msgConfirmation: String => This is the message that the user receives with information about the apartment found.
    */
    public String searchSpecificApartment(String buildingId, String aptIdentfier){
        String msgConfirmation = "\nLo sentimos, este apartamento ya esta ocupado.";
        boolean isFound = false;
        for(int i=0; i<SIZE_OF_BUILDINGS && !isFound; i++){
            if(buildings[i] != null && buildings[i].getBuildingid().equalsIgnoreCase(buildingId)){
                isFound = true;
                if(buildings[i].searchSpecificApartment(aptIdentfier)){
                    msgConfirmation = "\nEl apartamento esta libre actualmente.";
                }
            }
        }
        return msgConfirmation;
    }

    /** searchPerson: It is in charge of searching for a person and verifying that he/she exists as an object.
    * @param numId: String => It is the document number that each person registered in the system.
    * @return personFound: Person => Validates the person found in the system.
    */
    public Person searchPerson(String numId){
        Person personFound = null;
        for(int i=0; i<SIZE_OF_PERSONS; i++){
            if(persons[i]!=null && persons[i].getnumId().equalsIgnoreCase(numId)){
                personFound = persons[i];
            }
        }
        return personFound;
    }

    /** addPerson: It is in charge of adding a person, in this case an owner, to the program.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @param aptIdentifier: String => This is the ID with which the apartment is identified.
    * @param id: String => It is the type of document that the person will enter when registering.
    * @param numId: String => It is the document number that each person registered in the system.
    * @param name: String => It is the name by which people identify themselves.
    * @param phoneNumber: String => This is the telephone number by which people will be contacted.
    * @param typePhone: int => This is the type of phone that the user should choose.
    * @param account: String => It is the account number that is assigned to the owner.
    * @param bank: String => It is the owner's account bank.
    * @return String => This is the confirmation message of the owner registration.
    */
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

    /** addPerson: It is in charge of adding a person, in this case a renter, to the program.
    * @param buildingId: String => It is the ID with which a building is identified.
    * @param aptIdentifier: String => This is the ID with which the apartment is identified.
    * @param id: String => It is the type of document that the person will enter when registering.
    * @param numId: String => It is the document number that each person registered in the system.
    * @param name: String => It is the name by which people identify themselves.
    * @param phoneNumber: String => This is the telephone number by which people will be contacted.
    * @param typePhone: int => This is the type of phone that the user should choose.
    * @return String => This is the confirmation message of the renter registration.
    */
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

}