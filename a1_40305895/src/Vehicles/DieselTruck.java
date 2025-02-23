package Vehicles;

public class DieselTruck extends Truck {

    private int fuelCapacity;
    private static int plateInt = 1000;

    //Default constructor
    public DieselTruck(){
        super();
        this.fuelCapacity = 0;
        this.setPlateNumber("DT" + plateInt);
        plateInt++;
        //**TO DO** Add license plate
    }

    //Parametrized constructor
    public DieselTruck(String make, String model, int year, int maxCapacity, int fuelCapacity){
        super(make, model, year, maxCapacity);
        this.fuelCapacity = fuelCapacity;
        this.setPlateNumber("DT" + plateInt);
        plateInt++;
    }

    //Copy constructor
    public DieselTruck(DieselTruck other){
        super(other);
        this.fuelCapacity = other.fuelCapacity;
        this.setPlateNumber("DT" + plateInt);
        plateInt++;
    }

    //Setters
    public void setFuelCapacity(int fuelCapacity){
        this.fuelCapacity = fuelCapacity;
    }

    //Getters
    public int getFuelCapacity(){
        return this.fuelCapacity;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + "\nFuel Capacity: " + this.fuelCapacity;
    }

    //equals method
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DieselTruck dieselTruck = (DieselTruck) o;
        return super.equals(o) && this.fuelCapacity == dieselTruck.fuelCapacity;
    }
}
