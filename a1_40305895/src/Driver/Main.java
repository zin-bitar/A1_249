package Driver;
//-----------------------------
//Assignment 1
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//-----------------------------

import Client.Client;
import Client.Lease;
import Vehicles.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner
        Scanner input = new Scanner(System.in);

        //Welcome message
        System.out.println("Welcome to Royal Rentals!");

        Client[] clients = new Client[25];

        Lease[] johnsLeases = new Lease[10];
        clients[0] = new Client("John", johnsLeases );

        Lease[] jacksLeases = new Lease[10];
        clients[1] = new Client("Jack", jacksLeases);

        Lease[] juliasLeases = new Lease[10];
        clients[2] = new Client("Julia", juliasLeases);

        Vehicle[] vehicles = new Vehicle[15];

        vehicles[0] = new Car("Honda", "civic", 2004, 5 );
        vehicles[1] = new Car("Honda", "civic", 2004, 5 );
        vehicles[2] = new Car("Ford", "focus", 2011, 5);

        vehicles[3] = new ElectricCar("Toyota", "prius", 2015, 5, 24);
        vehicles[4] = new ElectricCar("Toyota", "prius", 2015, 5, 24);
        vehicles[5] = new ElectricCar("Ford", "fusion", 2011, 5, 50);

        vehicles[6] = new Truck("Ford", "F-150", 2018, 2000);
        vehicles[7] = new Truck("Ford", "F-150", 2018, 2000);
        vehicles[8] = new Truck("Chevrolet", "Silverado", 2018, 1000);

        vehicles[9] = new DieselTruck("Ram", "2500", 2024, 1800, 129);
        vehicles[10] = new DieselTruck("Ram", "2500", 2024, 1800, 129);
        vehicles[11] = new DieselTruck("Ford", "F-350",2024 ,3300, 129);

        vehicles[12] = new ElectricTruck("Chevrolet", "Silverado EV", 2025, 816, 200);
        vehicles[13] = new ElectricTruck("Chevrolet", "Silverado EV", 2025, 816, 200);
        vehicles[14] = new ElectricTruck("Rivian", "R1T", 2025, 800, 215);

        System.out.print("Would you like to go through the regular menu(0) or the predefined scenario(1)?: ");
        int choice = input.nextInt();
        if (choice == 0) {


            int menuChoice = -1;
            while (menuChoice != 14) {
                System.out.println("What would you like to do? \n1.Add a Vehicles.Vehicle\n2.Delete a vehicle\n3.Update vehicle information\n4.List all vehicles by category\n5.Add a client\n6.Edit a client\n7.Delete a client\n8.Client.Lease a vehicle to a client\n9.Return a vehicle from a client\n10.Show all vehicles leased by client\n11.Show all vehicles leased by all clients\n12.Display the truck with the largest capacity\n13.Create a copy of the electric trucks array\n14.Exit");
                menuChoice = input.nextInt();
                switch (menuChoice) {

                    //Add a vehicle
                    case 1:
                        System.out.print("Do you want to add a\n1. Gasoline Vehicles.Truck?\n2. Diesel Vehicles.Truck?\n3. Electric Vehicles.Truck?\n4. Gasoline car?\n5.Electric car?\nEnter your choice: ");
                        int typeChoice = input.nextInt();
                        input.nextLine();
                        switch (typeChoice) {
                            case 1:
                                System.out.print("Vehicles.Vehicle make: ");
                                String vehMake = input.nextLine();
                                System.out.print("Vehicles.Vehicle model: ");
                                String vehModel = input.nextLine();
                                System.out.print("Vehicles.Vehicle year: ");
                                int vehYear = input.nextInt();
                                System.out.print("Vehicles.Truck's max capacity: ");
                                int maxCap = input.nextInt();
                                vehicles = copyVehicles(vehicles,new Truck(vehMake, vehModel, vehYear, maxCap) );
                                break;
                            case 2:
                                System.out.print("Vehicles.Vehicle make: ");
                                vehMake = input.nextLine();
                                System.out.print("Vehicles.Vehicle model: ");
                                vehModel = input.nextLine();
                                System.out.print("Vehicles.Vehicle year: ");
                                vehYear = input.nextInt();
                                System.out.print("Vehicles.Truck's max capacity: ");
                                maxCap = input.nextInt();
                                System.out.print("Vehicles.Truck's fuel capacity: ");
                                int fuelCap = input.nextInt();
                                vehicles = copyVehicles(vehicles,new DieselTruck(vehMake, vehModel, vehYear, maxCap, fuelCap));
                                break;
                            case 3:
                                System.out.print("Vehicles.Vehicle make: ");
                                vehMake = input.nextLine();
                                System.out.print("Vehicles.Vehicle model: ");
                                vehModel = input.nextLine();
                                System.out.print("Vehicles.Vehicle year: ");
                                vehYear = input.nextInt();
                                System.out.print("Vehicles.Truck's max capacity: ");
                                maxCap = input.nextInt();
                                System.out.print("Vehicles.Truck's autonomy: ");
                                int vehAuto = input.nextInt();
                                vehicles = copyVehicles(vehicles, new ElectricTruck(vehMake, vehModel, vehYear, maxCap, vehAuto));
                                break;
                            case 4:
                                System.out.print("Vehicles.Vehicle make: ");
                                vehMake = input.nextLine();
                                System.out.print("Vehicles.Vehicle model: ");
                                vehModel = input.nextLine();
                                System.out.print("Vehicles.Vehicle year: ");
                                vehYear = input.nextInt();
                                System.out.print("Maximum number of passengers: ");
                                int vehPass = input.nextInt();
                                vehicles = copyVehicles(vehicles,new Car(vehMake, vehModel, vehYear, vehPass));
                                break;
                            case 5:
                                System.out.print("Vehicles.Vehicle make: ");
                                vehMake = input.nextLine();
                                System.out.print("Vehicles.Vehicle model: ");
                                vehModel = input.nextLine();
                                System.out.print("Vehicles.Vehicle year: ");
                                vehYear = input.nextInt();
                                System.out.print("Maximum number of passengers: ");
                                vehPass = input.nextInt();
                                System.out.print("Vehicles.Car's autonomy: ");
                                vehAuto = input.nextInt();
                                vehicles = copyVehicles(vehicles,new ElectricCar(vehMake, vehModel, vehYear, vehPass, vehAuto));
                                break;
                            default:
                                System.out.println("Invalid choice. Enter a number between 1 and 5.");
                        }
                        break;


                    //Delete a vehicle
                    case 2:
                        int index = -1;
                        System.out.println("Enter the plate number of the vehicle you would like to remove: ");
                        String plateToFind = input.next();
                        for (int i = 0; i < vehicles.length; i++) {
                            if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(plateToFind)) {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1)
                            System.out.println("Vehicles.Vehicle not found");
                        else if(vehicles[index].getIsLeased()){
                            System.out.println("This vehicle is leased, it cannot be deleted.");
                            break;
                        }
                        else {
                            Vehicle[] vehicles1 = new Vehicle[vehicles.length-1];
                            for (int i = 0, j = 0; j < vehicles1.length; i++, j++) {
                                if(i == index)
                                    i++;
                                vehicles1[j] = vehicles[i];

                            }
                            vehicles = vehicles1;
                        }
                        break;
                    case 3:



                }
            }
        }


        if (choice == 1) {
        }
    }

    public static DieselTruck getLargestTruck(Vehicle[] vehicles) {
        int counter = -1;
        int maxCapacity = Integer.MIN_VALUE;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof DieselTruck) {
                DieselTruck dies = (DieselTruck) vehicles[i];
                if (dies.getMaxCapacity() > maxCapacity) {
                    counter = i;
                    maxCapacity = dies.getMaxCapacity();
                }
            }
        }
        if (counter == -1) {
            return null;
        } else
            return (DieselTruck) vehicles[counter];
    }

    public static ElectricTruck[] copyVehicles(ElectricTruck[] vehicles) {
        if (vehicles == null) return null;
        ElectricTruck[] copy = new ElectricTruck[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null)
                copy[i] = new ElectricTruck(vehicles[i]);
        }
        return copy;
    }
    public static Vehicle[] copyVehicles(Vehicle[] oldVehicles, Vehicle newVehicle){
        Vehicle[] vehicles1 = new Vehicle[oldVehicles.length + 1];
        for (int i = 0; i < oldVehicles.length; i++) {
            vehicles1[i] = oldVehicles[i];
        }
        vehicles1[vehicles1.length-1] = newVehicle;
        return vehicles1;
    }
}