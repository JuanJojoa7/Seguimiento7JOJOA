package model;

public class Apartment{

    private String aptIdentifier;
    private int numRooms;
    private int numBathrooms;
    private boolean hasBalcony;
    private double rentalValue;
    private AptOwner aptOwner;
    private AptRenter aptRenter;

    public Apartment(String aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){
        this.aptIdentifier = aptIdentifier;
        this.numRooms = numRooms;
        this.numBathrooms = numBathrooms;
        this.hasBalcony = hasBalcony;
        this.rentalValue = rentalValue;
    }

    public String getAptIdentifier(){
        return aptIdentifier;
    }

    public int getNumRooms(){
        return numRooms;
    }

    public int getNumBathrooms(){
        return numBathrooms;
    }

    public boolean getHasBalcony(){
        return hasBalcony;
    }

    public double getRentalValue(){
        return rentalValue;
    }

    public AptRenter getRenter(){
        return aptRenter;
    }

    public void setAptOwner(AptOwner person){
        this.aptOwner = person;
    }

    public void setAptRenter(AptRenter person){
        this.aptRenter = person;
    }
    
}
