package ui; 

import java.util.Scanner;

import model.GroundStation;

public class Main{

    private Scanner reader;
    private GroundStation groundStation;
	public static final int SIZE_TOTAL_SATELLITES = 5;
	

	public Main(){
		reader = new Scanner(System.in); 

	}

    public Scanner getReader(){
		return reader;
	}

    public GroundStation calculatePIRE(){
		return groundStation; 
	}

    public static void main(String[] args){ // Start of main method.

		// Initialization of variables.
        Main main = new Main();
		int option = 0; 

				do{ // Start of cycle.

					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0); // End of the cycle.

				main.getReader().close();
		
	} // End of main method.


	/** getOptionShowMenu: It is responsible for displaying the menu indefinitely so that the user can interact with the options.
    * @return Option: int => This is the option with which you interact with the program.
    */
    public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("\n<<<<< Bienvenido al programa de comunicaciones por satelite >>>>>");
        System.out.println("Por favor selecciona una opcion:\n ");
		System.out.println(
				"1. Crear estacion terrestre.\n" +
                "2. Inicializar satelites artificiales.\n" +
				"0. Salir del programa.\n");
        System.out.print("Opcion: ");        
		option = reader.nextInt(); 

		return option; 
	}


	/** executeOption: It is responsible for executing each of the program's options and starts them.
	* @param option: int => Returns the option so that the user can continue to interact indefinitely.
    */
    public void executeOption(int option){
		String nString = ""; 
		double nominalPower = 0.0; 
		double maximumGain = 0.0; 
		double orbit = 0.0;
		String msgConfirmation = "";
		String msgCalcAttenuation = "";

		switch(option){
			case 1: 
				
                System.out.print("\nIngresa el nombre de la estacion: "); 
                nString = reader.next(); 

                System.out.print("\nIngresa la potencia nominal: "); 
                nominalPower = reader.nextDouble();

                System.out.print("\nIngresa la ganancia maxima: "); 
                maximumGain = reader.nextDouble(); 

                groundStation = new GroundStation(nString, nominalPower, maximumGain);

				System.out.println("\nLa estacion terrestre " + groundStation.getGroundStationName() + " ha sido creada su PIRE es de: " + groundStation.calculatePIRE());

				break; 

			case 2: 

				for (int i = 0; i < SIZE_TOTAL_SATELLITES; i++){

					System.out.print("\nIngrese la distancia de la orbita para el satelite " + (i+1) + ": ");

					orbit = reader.nextDouble();

					msgConfirmation = groundStation.addSatellite(orbit);

					System.out.println(msgConfirmation);

					msgCalcAttenuation = groundStation.getSatellites()[i].calculateAttenuation();

					System.out.println(msgCalcAttenuation);
				}
				
				break; 

			case 0: 
				System.out.println("\nHasta luego.");
				break; 

			default: 
				System.out.println("\nOpcion invalida, intente nuevamente.");
				break; 
		}
	}
}