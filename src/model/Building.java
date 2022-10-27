package model;

public class Building{

    private String buildingId;
    private Apartment[] apartments;
    private String address; 

    public Building(String buildingId, int numApartments, String address){
        this.buildingId = buildingId;
        apartments = new Apartment[numApartments];
        this.address = address;
    }

    /** addApartment: It is the method in charge of adding apartments to the system.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    * @param numRooms: int => This is the number of rooms in the apartment.
    * @param numBathrooms: int => This is the number of bathrooms in the apartment.
    * @param hasBalcony: boolean => It is the option that defines if the apartment will have a balcony or not.
    * @param rentalValue: double => It is the rental fee that the apartment will have.
    */
    public void addApartment(String aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){
        boolean isFound = false;
        for(int i=0; i<apartments.length && !isFound; i++){
            if(apartments[i] == null){
                apartments[i] = new Apartment(aptIdentifier, numRooms, numBathrooms, hasBalcony, rentalValue);
                isFound = true;
            }
        }
    }

    /** searchApartment: It is the method to search for apartments, to know if they are occupied or not, or if they have already been created.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    * @return apartmentisFound: Apartment => It is the validation of the apartment found.
    */
    public Apartment searchApartment(String aptIdentifier){
        Apartment aparmentisFound = null;
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                aparmentisFound = apartments[i];
            }
        }
        return aparmentisFound;
    }

    /** addPersonToApt: It is responsible for adding the owner object to the apartment.
    * @param person: aptOwner => It is the object owner's person.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    */
    public void addPersonToApt(AptOwner person, String aptIdentifier){
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                apartments[i].setAptOwner(person);
            }
        }
    }

    /** addPersonToApt: It is responsible for adding the renter object to the apartment.
    * @param person: aptRenter => It is the object renter person.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    */
    public void addPersonToApt(AptRenter person, String aptIdentifier){
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                apartments[i].setAptRenter(person);
            }
        }
    }

    /** listApartments: It is responsible for listing the available apartments in a building.
    * @return msgApartments: String => It is in charge of returning the found buildings.
    */
    public String listApartments(){
        String msgApartments = "\nLos apartamentos encontrados fueron: ";
        int countedApt = 0;
        for(int i=0; i<apartments.length; i++){
            if(apartments[i]!=null && apartments[i].getRenter()==null){
                countedApt++;
            }
        }
        msgApartments += countedApt;
        return msgApartments;
    }

    /** searchSpecificApartment: It is in charge of validating a specific apartment and validates if it is free or not.
    * @param aptIdentifier: String => It is the ID with which an apartment is identified.
    * @return free: boolean => =Returns the validation of whether the apartment is free or not.
    */
    public boolean searchSpecificApartment(String aptIdentifier){
        boolean free = false;
        boolean isFound = false;
        for(int i=0; i<apartments.length && !isFound; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                if(apartments[i].getRenter()==null){
                    free = true;
                }
                isFound = true;
            }
        }
        return free;
    }

    /** calculateRentalValue: It is responsible for calculating the rent of a building.
    * @return rentalValue: double => It is the value of the sum of the rents of all the apartments.
    */
    public double calculateRentalValue(){
        double rentalValue = 0;
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] !=null && apartments[i].getRenter()==null){
                rentalValue += apartments[i].getRentalValue();
            }
        }
        return rentalValue;
    }

    public String getBuildingid(){
        return buildingId;
    }

    public String getAddress(){
        return address;
    }

    
    
}
