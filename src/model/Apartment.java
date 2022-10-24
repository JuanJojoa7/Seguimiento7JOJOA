package model;

public class Apartment{

    private int aptIdentifier;
    private int numRooms;
    private int numBathrooms;
    private boolean hasBalcony;
    private double rentalValue;

    public Apartment(int aptIdentifier, int numRooms, int numBathrooms, boolean hasBalcony, double rentalValue){
        this.aptIdentifier = aptIdentifier;
        this.numRooms = numRooms;
        this.numBathrooms = numBathrooms;
        this.hasBalcony = hasBalcony;
        this.rentalValue = rentalValue;
    }

    public int getAptIdentifier(){
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
    
}
