//-----------------------------
//Assignment 1
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//-----------------------------

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner
        Scanner input = new Scanner(System.in);

        //Welcome message
        System.out.println("Welcome to Royal Rentals!");

        Client[] clients = new Client[25];

        Vehicle[] vehicles = new Vehicle[75];
        int vehicleList = 20;

        System.out.print("Would you like to go through the regular menu(0) or the predefined scenario(1)?: ");
        int choice = input.nextInt();
        if(choice == 0){


            int menuChoice = -1;
            while(menuChoice != 14){
            System.out.println("What would you like to do? \n1.Add a Vehicle\n2.Delete a vehicle\n3.Update vehicle information\n4.List all vehicles by category\n5.Add a client\n6.Edit a client\n7.Delete a client\n8.Lease a vehicle to a client\n9.Return a vehicle from a client\n10.Show all vehicles leased by client\n11.Show all vehicles leased by all clients\n12.Display the truck with the largest capacity\n13.Create a copy of the electric trucks array\n14.Exit");
            menuChoice = input.nextInt();
            switch(menuChoice){

                //Add a vehicle
                case 1:
                    vehicleList++;
                    System.out.print("Do you want to add a\n1. Gasoline Truck?\n2. Diesel Truck?\n3. Electric Truck?\n4. Gasoline car?\n5.Electric car?\nEnter your choice: ");
                    int typeChoice = input.nextInt();
                    input.nextLine();
                    switch(typeChoice){
                        case 1:
                            System.out.print("Vehicle make: ");
                            String vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            String vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            int vehYear = input.nextInt();
                            System.out.print("Truck's max capacity: ");
                            int maxCap = input.nextInt();
                            vehicles[vehicleList] = new Truck(vehMake, vehModel, vehYear, maxCap);
                            break;
                        case 2:
                            System.out.print("Vehicle make: ");
                            vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            vehYear = input.nextInt();
                            System.out.print("Truck's max capacity: ");
                            maxCap = input.nextInt();
                            System.out.print("Truck's fuel capacity: ");
                            int fuelCap = input.nextInt();
                            vehicles[vehicleList] = new DieselTruck(vehMake, vehModel, vehYear, maxCap, fuelCap);
                            break;
                        case 3:
                            System.out.print("Vehicle make: ");
                            vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            vehYear = input.nextInt();
                            System.out.print("Truck's max capacity: ");
                            maxCap = input.nextInt();
                            System.out.print("Truck's autonomy: ");
                            int vehAuto = input.nextInt();
                            vehicles[vehicleList] = new ElectricTruck(vehMake, vehModel, vehYear, maxCap, vehAuto);
                            break;
                        case 4:
                            System.out.print("Vehicle make: ");
                            vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            vehYear = input.nextInt();
                            System.out.print("Maximum number of passengers: ");
                            int vehPass = input.nextInt();
                            vehicles[vehicleList] = new Car(vehMake, vehModel, vehYear, vehPass);
                            break;
                        case 5:
                            System.out.print("Vehicle make: ");
                            vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            vehYear = input.nextInt();
                            System.out.print("Maximum number of passengers: ");
                            vehPass = input.nextInt();
                            System.out.print("Car's autonomy: ");
                            vehAuto = input.nextInt();
                            vehicles[vehicleList] = new ElectricCar(vehMake, vehModel, vehYear, vehPass, vehAuto);
                            break;
                        default:
                            System.out.println("Invalid choice. Enter a number between 1 and 5.");
                    }
                    break;


                //Delete a vehicle
                case 2:
                    int index = -1;
                    System.out.println("Enter the plate number of the vehicle you would like to remove: ");
                    String vehToRemove = input.next();
                    for (int i = 0; i < vehicles.length; i++) {
                        if(vehicles[i] != null && vehicles[i].getPlateNumber().equals(vehToRemove)){
                         index = i;
                         break;
                        }
                    }
                    if(index == -1)
                        System.out.println("Vehicle not found");
                    else{

                    }

                    
            }
            }
        }



        if(choice == 1){}
    }

    public static DieselTruck getLargestTruck(Vehicle[] vehicles) {
        int counter = -1;
        int maxCapacity = Integer.MIN_VALUE;
        for (int i = 0; i < vehicles.length; i++) {
            if(vehicles[i] instanceof DieselTruck) {
            DieselTruck dies  = (DieselTruck) vehicles[i];
            if(dies.getMaxCapacity() > maxCapacity) {
                counter = i;
                maxCapacity = dies.getMaxCapacity();
                }
            }
        }
        if(counter == -1) {
            return null;
        }
        else
            return (DieselTruck) vehicles[counter];
    }
    public static ElectricTruck[] copyVehicles(ElectricTruck[] vehicles) {
        if(vehicles == null) return null;
        ElectricTruck[] copy = new ElectricTruck[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            if(vehicles[i] != null)
                copy[i] = new ElectricTruck(vehicles[i]);
        }
        return copy;
    }
}