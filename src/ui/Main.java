package ui;
import model.*;
import java.util.Scanner;

public class Main{

	public static Scanner reader;
    private RealStateController controller;

    public Main(){
        reader = new Scanner(System.in);
        controller = new RealStateController();
    }

	public static void main(String[] args){ //Start of main method.
        Main main = new Main (); 

        int option = -1; 
        do{ //Start of the cycle
            option = main.getOptionShowMenu(); 
            main.executeOption(option);

        }while(option != 0); //End of the cycle.

    } //End of main method.

	/** getOptionShowMenu: It is responsible for obtaining the menu of options for interaction with the user.
    * @return Option: int => This is the option with which you interact with the program.
    */
    public int getOptionShowMenu(){
        int option = 0; 
        printMenu();

        option = validateReader(); 

        return option; 
    }

	/** printMenu: It is in charge of showing the user the game options ribbon.
     */ 
    public void printMenu(){
        System.out.print(
            "\nBienvenido, administrador de la inmobiliaria, que desea hacer hoy: \n"+	
            "1. Registrar edificios.\n"+
            "2. Registrar apartamentos a un edificio.\n"+
            "3. Registrar a un propietario con su apartamento.\n"+
            "4. Registrar a un arrendatario y asignar su apartamento.\n"+
            "5. Consultar cuantos apartamentos disponibles hay en un edificio.\n"+
            "6. Consultar el valor mensual total a recibir por edificio.\n"+
            "7. Consultar si un apartamento en especifico esta disponible.\n"+
            "8. Consultar cuantos apartamentos tiene arrendados una persona.\n"+ 
            "9. Consultar el valor total por arrendamiento que recibira el propietario.\n"+
            "0. Salir del programa. \n"+
            "Opcion: ");  
    }

	/** validateReader: It is responsible for validating that the user has entered a numerical entry in the options.
    * @return option: int => The option selected by the user.
    */
    public int validateReader(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

	public void executeOption(int option){

        switch(option){
            case 1:

                if(controller.isFoundBuilding()){

                    System.out.println("\nHa iniciado, registrar un edificio.");

                    System.out.print("\nIngresa un id para el nuevo edificio: ");
                    String buildingId = reader.next();

                    if(controller.searchBuilding(buildingId)==null){

                    System.out.print("\nIngresa el numero de apartamentos que tendra este edificio: ");
                    int numApartments = reader.nextInt();

                    System.out.print("\nIngresa la direccion donde estara este nuevo edificio: ");
                    String address = reader.next();

                    System.out.println(controller.addBuilding(buildingId, numApartments, address)); 

                    }else{
                        System.out.println("\nLo sentimos, ya hay un edificio con ese ID.");
                    }

                }else{
                    System.out.println("\nLo sentimos, no hay espacio para mas edificios.");
                }

                break;

            case 2:

                
                break;

            case 3: 

    

                break;

            case 4:

    
                break;

            case 5:
               

                break;

            case 6:
                

                break;

            case 7: 


                break;

            case 8: 
        
                break;

            case 9: 

                

                break;

            case 10:    

                

                break;

            case 11: 

                

                break;

            case 12:

                

                break;

            case 0: 
                System.out.println("\nHasta luego administrador.\n");    
                break;

            default:
                System.out.println("\nOpcion no valida, intenta nuevamente."); 
                break;   
        }
    }

}


