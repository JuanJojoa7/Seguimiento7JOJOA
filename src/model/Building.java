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

    public void addApartment(String aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){
        boolean isFound = false;
        for(int i=0; i<apartments.length && !isFound; i++){
            if(apartments[i] == null){
                apartments[i] = new Apartment(aptIdentifier, numRooms, numBathrooms, hasBalcony, rentalValue);
                isFound = true;
            }
        }
    }

    public Apartment searchApartment(String aptIdentifier){
        Apartment aparment = null;
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                aparment = apartments[i];
            }
        }
        return aparment;
    }

    public void addPersonToApt(AptOwner person, String aptIdentifier){
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                apartments[i].setAptOwner(person);
            }
        }
    }

    public void addPersonToApt(AptRenter person, String aptIdentifier){
        for(int i=0; i<apartments.length; i++){
            if(apartments[i] != null && apartments[i].getAptIdentifier().equalsIgnoreCase(aptIdentifier)){
                apartments[i].setAptRenter(person);
            }
        }
    }

    public String listApartments(){
        String msj = "\nLos apartamentos son: ";
        int countedApt = 0;
        for(int i=0; i<apartments.length; i++){
            if(apartments[i]!=null && apartments[i].getRenter()==null){
                countedApt++;
            }
        }
        msj += countedApt;
        return msj;
    }

    public String getBuildingid(){
        return buildingId;
    }

    public String getAddress(){
        return address;
    }

    
    
}
