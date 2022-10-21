package model;

public class GroundStation{

    public static final int SIZE_SATELLITES = 5;

    private Satellite[] satellites;
 
    private double nominalPower;
    private double maximumGain;
    private String name;
   

    public GroundStation(String aname, double anominalPower, double amaximumGain){


        satellites = new Satellite[SIZE_SATELLITES];

        name = aname;
        nominalPower = anominalPower;
        maximumGain = amaximumGain;

    }


    /** calculatePIRE: It is the method in charge of calculating the EIRP of the ground station.
    * @return result: double => It is the result that is returned after calculating the EIRP of the ground station.
    */
    public double calculatePIRE(){
 
        double result =  10*Math.log10((nominalPower+maximumGain));
        
        return result;
    }

    /** addSatellite: It is the method in charge of adding satellites to the set of satellites associated to the ground station.
    * @param orbit: double => It is the distance of the orbit, which must be entered by the user for each satellite.
    * @return msgConfirmation: double => This is the confirmation message that is returned to the user when a satellite is successfully added.
    */
    public String addSatellite(double orbit){
        String msgConfirmation = "\nLimite de satelites alcanzado.";
        Satellite newsatellites = new Satellite(orbit);
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_SATELLITES && !isEmpty; i++){
			if(satellites[i] == null){
				satellites[i] = newsatellites; 
				isEmpty = true; 
				msgConfirmation = "\nSatelite " + (i+1) + " agregado satisfactoriamente en la orbita " + orbit; 
			}
		}
        return msgConfirmation;
    }

    /** getGroundStation: It is in charge of obtaining the name that was typed by the user for the creation of the ground station.
    * @return name: String => Returns the name obtained.
    */
    public String getGroundStationName(){
        return name;
    }


    /** getSatellites: This method is in charge of bringing the satellites for the processes.
    * @return satellites: Satellite => Returns the obtained satellites.
    */
    public Satellite[] getSatellites(){
        return satellites;
    }

    
}
    
    
