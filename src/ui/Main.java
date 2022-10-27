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

    /** calculateNaturalLogarithm: It is in charge of calculating the remaining operations of the natural logarithm using the calculatePotentiation method.
    * @param valueX: double => This is the value entered by the user to calculate the natural logarithm.
    * @param limitInf: int => It is the limit constant for the natural logarithm in order to make more accurate calculations.
    * @return finalResultlog: double => It is the result of performing the natural logarithm which is displayed to the user.
    */
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

                if(controller.isAvailableBuilding().equals("\nLo sentimos, no hay edificios registrados.")){

                }else{
                    System.out.println("\nHa iniciado, registrar apartamento.");
                    System.out.print("\nIngresa el ID del edificio donde estara el apartamento: ");
                    String buildingId = reader.next();

                    if(controller.searchBuilding(buildingId)==null){
                        System.out.println("\nLo sentimos, ese edificio no se encuentra registrado.");
                    }else{
                        System.out.print("\nIngresa el ID para el registro del apartamento: ");
                        String aptIdentifier = reader.next();

                        if(controller.searchApartment(buildingId, aptIdentifier)!=null){
                            System.out.println("\nLo sentimos, ya existe un apartamento con ese ID.");
                        }else{
                            System.out.print("\nIngresa cuantos cuartos tendra este apartamento: ");
                            int numRooms = reader.nextInt();

                            System.out.print("\nIngresa cuantos baños tendra el apartamento: ");
                            int numBathrooms = reader.nextInt();

                            System.out.print("\nEl apartamento tendra balcon? (S/N): ");
                            String hasBalcony = reader.next();

                            boolean balcony = true;
                            while(!hasBalcony.equalsIgnoreCase("S")&& !hasBalcony.equalsIgnoreCase("N")){
                                if(hasBalcony.equalsIgnoreCase("S")){
                                    balcony = true;
                                }else if(hasBalcony.equalsIgnoreCase("N")){
                                    balcony = false;
                                }else{
                                    System.out.print("\nLo sentimos, esta opcion para balcon no es valida intenta nuevamente.");
                                    hasBalcony = reader.next();
                                }
                            }
                            
                            System.out.print("\nIngresa el valor del arrendamiento para el apartamento a registrar: ");
                            double rentalValue = reader.nextDouble();

                            System.out.println(controller.AddApartment(buildingId, aptIdentifier, numRooms, numBathrooms, balcony, rentalValue));
                        }
                    }

                }
                
                break;

            case 3: 

                System.out.println("\nHa iniciado, registrar propietario.");

                System.out.print("\nIngresa el edificio donde esta el apartamento del que eres propietario: ");
                String buildingId = reader.next();

                if(controller.searchBuilding(buildingId)==null){
                    System.out.println("\nLo sentimos, ese edificio no se encuentra registrado.");
                }else{

                    System.out.print("\nIngresa el apartamento del que eres propietario: ");
                    String aptIdentifier = reader.next();

                    if(controller.searchApartment(buildingId, aptIdentifier)==null){
                        System.out.println("\nLo sentimos, este apartamento no existe en el edificio.");
                    }else{

                        System.out.print("\nIngresa que tipo de documento tienes?: ");
                        String id = reader.next();

                        System.out.print("\nIngresa tu numero de documento: ");
                        String numId = reader.next();

                        if(controller.searchPerson(numId)!=null){
                            System.out.println("\nLo sentimos, ya hay una persona con ese numero de documento registrado.");
                        }else{
                            System.out.print("\nIngresa tu nombre completo: ");
                            String name = reader.next();
    
                            System.out.print("\nIngresa tu numero de contacto: ");
                            String phoneNumber = reader.next();

                            System.out.print(
                                "\nIngresa solo una opcion, que tipo de telefono es?: \n"+	
                                "1. Telefono de Casa.\n"+
                                "2. Telefono de Oficina.\n"+
                                "3. Telefono Movil.\n"+
                                "4. Telefono Familiar.\n"+
                                "5. Otro tipo.\n"+
                                "Opcion: ");  
                                int typePhone = reader.nextInt();
    
                            System.out.print("\nCual es el numero de tu cuenta bancaria: "); 
                            String account = reader.next();

                            System.out.print("\nIngresa el banco asignado a la cuenta bancaria: ");
                            String bank = reader.next();

                            System.out.println(controller.addPerson(buildingId, aptIdentifier, id, numId, name, phoneNumber, typePhone, account, bank));
        
                        }

                    }
    
                }

                break;

            case 4:
            
                System.out.println("\nHa iniciado, registrar arrendatario.");

                System.out.print("\nIngresa el edificio donde esta el apartamento que vas a arrendar: ");
                buildingId = reader.next();

                if(controller.searchBuilding(buildingId)==null){
                    System.out.println("\nLo sentimos, ese edificio no se encuentra registrado.");
                }else{

                System.out.print("\nIngresa el apartamento que vas a arrendar: ");
                String aptIdentifier = reader.next();

                if(controller.searchApartment(buildingId, aptIdentifier)==null){
                    System.out.println("\nLo sentimos, este apartamento no existe en el edificio.");
                }else{

                    System.out.print("\nIngresa que tipo de documento tienes?: ");
                    String id = reader.next();

                    System.out.print("\nIngresa tu numero de documento: ");
                    String numId = reader.next();

                    if(controller.searchPerson(numId)!=null){
                        System.out.println("\nLo sentimos, ya hay una persona con ese numero de documento registrado.");
                    }else{
                        System.out.print("\nIngresa tu nombre completo: ");
                        String name = reader.next();

                        System.out.print("\nIngresa tu numero de contacto: ");
                        String phoneNumber = reader.next();

                        System.out.print(
                            "\nIngresa solo una opcion, que tipo de telefono es?: \n"+	
                            "1. Telefono de Casa.\n"+
                            "2. Telefono de Oficina.\n"+
                            "3. Telefono Movil.\n"+
                            "4. Telefono Familiar.\n"+
                            "5. Otro tipo.\n"+
                            "Opcion: ");  
                            int typePhone = reader.nextInt();

                        System.out.println(controller.addPerson(buildingId, aptIdentifier, id, numId, name, phoneNumber, typePhone));
    
                    }

                }

            }

                break;

            case 5:

                if(controller.isAvailableBuilding().equals("\nLo sentimos, no hay edificios registrados.")){
                    System.out.println(controller.isAvailableBuilding());
                }else{
                    System.out.print("\nIngresa el ID del edificio que deseas consultar: ");
                    buildingId = reader.next();

                    System.out.println(controller.listApartments(buildingId));
                }
               
                break;

            case 6:

                if(controller.isAvailableBuilding().equals("\nLo sentimos, no hay edificios registrados.")){
                    System.out.println(controller.isAvailableBuilding());
                }else{
                    System.out.print("\nIngresa el ID del edificio que deseas consultar: ");
                    buildingId = reader.next();

                    System.out.println(controller.calculateRentalValue(buildingId));

                }

                break;

            case 7: 

                if(controller.isAvailableBuilding().equals("\nLo sentimos, no hay edificios registrados.")){
                    System.out.println(controller.isAvailableBuilding());
                }else{
                    System.out.print("\nIngresa el ID del edificio que deseas consultar: ");
                    buildingId = reader.next();

                    System.out.print("\nIngresa el ID del apartamento deseas consultar: ");
                    String aptIdentifier = reader.next();

                    System.out.println(controller.searchSpecificApartment(buildingId, aptIdentifier));
                }

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


