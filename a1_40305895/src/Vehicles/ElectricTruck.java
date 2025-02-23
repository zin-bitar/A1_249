package Vehicles;

public class ElectricTruck extends Truck {
    private int autonomy;
    private static int plateInt = 1000;

    //Default constructor
    public ElectricTruck(){
        super();
        this.autonomy = 0;
        this.setPlateNumber("ET" + plateInt);
        plateInt++;
    }

    //Parametrized constructor
    public ElectricTruck(String make, String model, int year, int maxCapacity, int autonomy){
        super(make, model, year, maxCapacity);
        this.autonomy = autonomy;
        this.setPlateNumber("ET" + plateInt);
        plateInt++;
    }

    //Copy constructor
    public ElectricTruck(ElectricTruck other){
        super(other);
        this.autonomy = other.autonomy;
        this.setPlateNumber("ET" + plateInt);
        plateInt++;
    }

    //Setters
    public void setAutonomy(int autonomy){
        this.autonomy = autonomy;
    }

    //Getters
    public int getAutonomy(){
        return this.autonomy;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + "\nAutonomy: " + autonomy;
    }

    //equals method
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ElectricTruck other = (ElectricTruck) o;
        return super.equals(other) && this.autonomy == other.autonomy;
    }
}
