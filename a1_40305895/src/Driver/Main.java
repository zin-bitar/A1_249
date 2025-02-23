package Driver;
import Client.*;
//-----------------------------
//Assignment 1
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//-----------------------------

import Vehicles.*;

import java.util.Objects;
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
        Lease[] allLeases = new Lease[75];

        vehicles[0] = new Car("Honda", "civic", 2004, 5 );
        vehicles[1] = new Car("Honda", "civic", 2004, 5 );
        vehicles[2] = new Car("Ford", "focus", 2011, 5);

        vehicles[3] = new ElectricCar("Toyota", "prius", 2015, 5, 24);
        vehicles[4] = new ElectricCar("Toyota", "prius", 2015, 5, 24);
        vehicles[5] = new ElectricCar("Ford", "fusion", 2011, 5, 50);

        vehicles[9] = new DieselTruck("Ram", "2500", 2024, 1800, 129);
        vehicles[10] = new DieselTruck("Ram", "2500", 2024, 1800, 129);
        vehicles[11] = new DieselTruck("Ford", "F-350",2024 ,3300, 129);

        vehicles[12] = new ElectricTruck("Chevrolet", "Silverado EV", 2025, 816, 200);
        vehicles[13] = new ElectricTruck("Chevrolet", "Silverado EV", 2025, 816, 200);
        vehicles[14] = new ElectricTruck("Rivian", "R1T", 2025, 800, 215);

        Lease[] johnsLeases = new Lease[10];
        clients[0] = new Client("John", johnsLeases );

        Lease[] jacksLeases = new Lease[10];
        clients[1] = new Client("Jack", jacksLeases);

        Lease[] juliasLeases = new Lease[10];
        clients[2] = new Client("Julia", juliasLeases);


        int index2=-1;



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
                    System.out.print("Do you want to add a\n1. Gasoline Truck?\n2. Diesel Truck?\n3. Electric Truck?\n4. Gasoline car?\n5.Electric car?\nEnter your choice: ");
                    int typeChoice = input.nextInt();
                    input.nextLine();
                    switch (typeChoice) {
                        case 1:
                            System.out.print("Vehicle make: ");
                            String vehMake = input.nextLine();
                            System.out.print("Vehicle model: ");
                            String vehModel = input.nextLine();
                            System.out.print("Vehicle year: ");
                            int vehYear = input.nextInt();
                            System.out.print("Truck's max capacity: ");
                            int maxCap = input.nextInt();
                            vehicles = copyVehicles(vehicles,new Truck(vehMake, vehModel, vehYear, maxCap) );
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
                            vehicles = copyVehicles(vehicles,new DieselTruck(vehMake, vehModel, vehYear, maxCap, fuelCap));
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
                            vehicles = copyVehicles(vehicles, new ElectricTruck(vehMake, vehModel, vehYear, maxCap, vehAuto));
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
                            vehicles = copyVehicles(vehicles,new Car(vehMake, vehModel, vehYear, vehPass));
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


                //Lease vehicle to client

                case 8:
                    //Taking all necessary info
                    System.out.println("Enter the expiry date of the lease:");
                    System.out.println("Year:");
                    String year = input.next();
                    while(!(year.matches("\\d+")) || Integer.parseInt(year) < 2025){
                        System.out.println("Invalid year. Make sure the expiry date is not in the past and contains only digits!");
                        System.out.println("Year:");
                        year = input.next();
                    }
                    System.out.println("Month:");
                    String month = input.next();
                    while(!(month.matches("\\d+")) || Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12){
                    System.out.println("Invalid month. Make sure to enter a number between 1 and 12.");
                        System.out.println("Month:");
                        month = input.next();
                    }
                    System.out.println("Day:");
                    String day = input.next();
                    while(!(day.matches("\\d+")) || Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31){
                        System.out.println("Invalid day. Make sure to enter a number between 1 and 31.");
                        System.out.println("Day:");
                        day = input.next();
                    }
                    System.out.println("Enter the vehicle's license plate:");
                    String licensePlate = input.next();
                    index2=-1;
                    while(index2==-1){
                        for(int i = 0; i < vehicles.length; i++){
                            if(vehicles[i] == null){}
                            else if(vehicles[i].getPlateNumber().equals(licensePlate)){
                                index2 = 1;
                                break;
                            }
                        }
                        if(index2 == 1){
                            break;
                        }
                        else{
                            System.out.println("No vehicle matches the license plate. Please enter a new license plate.");
                            System.out.println("LicensePlate:");
                            licensePlate = input.next();
                        }
                    }



                    if(vehicles[findVehicle(licensePlate, vehicles)].getIsLeased()){
                        System.out.println("Vehicle is already leased!");
                        break;
                    }
                    else {
                        System.out.println("Enter the client's name:");
                        String clientName = input.next();
                        while(findClient(clientName, clients) < 0){
                            System.out.println("Invalid client. Please enter a valid client name.");
                            System.out.println("Client:");
                            clientName = input.next();
                        }

                        //Creating return date
                        String returnDate = day + " " + month + " " + year;

                        //Updating lease array of client
                        if (findClient(clientName, clients) >= 0) {
                            Lease[] leaseArray = clients[findClient(clientName, clients)].getLease();
                            Lease newLease = new Lease(returnDate, vehicles[findVehicle(licensePlate, vehicles)]);

                            index2 = -1;
                            for (int i = 0; i < leaseArray.length; i++) {
                                if (leaseArray[i] == null) {
                                    leaseArray[i] = newLease;
                                    index2 = i;
                                    break;
                                }


                            }

                            for(int i = 0; i < allLeases.length; i++) {
                                if(allLeases[i] == null){
                                    allLeases[i] = newLease;
                                    break;
                                }
                            }

                            if (index2 == -1) {
                                System.out.println("Client reached the maximum amount of leases!");
                                break;
                            }
                            //Adding the new lease
                            else {
                                clients[findClient(clientName, clients)].setLease(leaseArray);
                                vehicles[findVehicle(licensePlate, vehicles)].setIsLeased(true);
                                System.out.println("Lease successfully added!");

                            }
                        }
                        else {
                            System.out.println("Client not found!");
                        }
                    }

                break;


                //Deleting lease from client
                case 9:
                    System.out.println("Enter the vehicle's license plate:");
                    licensePlate = input.next();
                    index2=-1;
                    int index3 =-1;
                    int wrongName = 0;
                    while(index2==-1){
                        for(int i = 0; i < vehicles.length; i++){
                            if(vehicles[i] == null){}
                            else if(vehicles[i].getPlateNumber().equals(licensePlate)){
                                index2 = 1;
                                break;
                            }
                        }
                        if(index2 == 1){
                            break;
                        }
                        else{
                            System.out.println("No vehicle matches the license plate. Please enter a new license plate.");
                            System.out.println("LicensePlate:");
                            licensePlate = input.next();
                        }
                    }

                    if(!vehicles[findVehicle(licensePlate, vehicles)].getIsLeased()){
                        System.out.println("Vehicle is not Leased!");
                        break;
                    }
                    else {
                        System.out.println("Enter the client's name:");
                        while(index3==-1) {

                            String clientName = input.next();
                            if(clientName.equals("exit") && wrongName == 1){
                                break;
                            }
                            while (findClient(clientName, clients) < 0) {
                                System.out.println("Invalid client. Please enter a valid client name.");
                                System.out.println("Client:");
                                clientName = input.next();
                            }

                            Lease[] clientLeases = clients[findClient(clientName, clients)].getLease();
                            index2 = -1;
                            for (int i = 0; i < clientLeases.length; i++) {
                                if (clientLeases[i] == null) {
                                } else if (clientLeases[i].getVehicle().getPlateNumber().equals(licensePlate)) {
                                    index2 = i;
                                    break;
                                }

                            }

                            if (index2 == -1) {
                                System.out.println("Client is not leasing the provided vehicle!");
                                System.out.println("Enter the client's name or enter \"exit\" to exit");
                                wrongName = 1;
                            } else {
                                vehicles[findVehicle(licensePlate, vehicles)].setIsLeased(false);
                                clientLeases[index2] = null;
                                System.out.println("Lease successfully ended!");
                                for (int i = 0; i < allLeases.length; i++) {
                                    if (allLeases[i] == null) {
                                        break;
                                    } else if (allLeases[i].getVehicle().getPlateNumber().equals(licensePlate)) {
                                        allLeases[i] = null;
                                        break;
                                    }
                                }
                                index3=1;

                            }
                        }

                    }
                    break;

                    //Showing a client's leases
                    case 10:
                        index2 = -1;
                        System.out.println("Enter the client's name:");
                        String clientName = input.next();
                        while(findClient(clientName, clients) < 0){
                            System.out.println("Invalid client. Please enter a valid client name.");
                            System.out.println("Client:");
                            clientName = input.next();
                        }
                        Client client = clients[findClient(clientName, clients)];
                        for(int i = 0; i<client.getLease().length; i++){
                            if(client.getLease()[i] == null){
                                continue;
                            }
                            else{
                                System.out.println(client.getLease()[i]);
                                index2 = 1;
                            }
                        }
                        if(index2 == -1){
                            System.out.println("Client does not have any leases!");
                        }
                    break;

                    //Showing all leases
                    case 11:
                        index2=-1;
                        for(int i = 0; i< allLeases.length; i++){
                            if(allLeases[i] == null){
                                continue;
                            }
                            else{
                                System.out.println(allLeases[i]);
                                index2 = 1;
                                break;
                            }
                        }
                        if(index2 == -1){
                            System.out.println("No active leases across all clients!");
                        }
                        break;
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
    public static int findVehicle(String plateToFind, Vehicle[] vehicles) {
        int index=-1;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(plateToFind)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int findClient(String name, Client[] clients) {
        int index = -1;
        for(int i = 0; i<clients.length; i++){
            if(clients[i] == null){}
            else if(clients[i].getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
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