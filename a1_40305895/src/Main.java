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

        System.out.print("Would you like to go through the regular menu(0) or the predefined scenario(1)?: ");
        int choice = input.nextInt();
        if(choice == 0){
            int menuChoice = -1;
            while(menuChoice != 14){
            System.out.println("What would you like to do? \n1.Add a Vehicle\n2.Delete a vehicle\n3.Update vehicle information\n4.List all vehicles by category\n5.Add a client\n6.Edit a client\n7.Delete a client\n8.Lease a vehicle to a client\n9.Return a vehicle from a client\n10.Show all vehicles leased by client\n11.Show all vehicles leased by all clients\n12.Display the truck with the largest capacity\n13.Create a copy of the electric trucks array\n14.Exit");
            menuChoice = input.nextInt();
            switch(menuChoice){
                case 1:
                    
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