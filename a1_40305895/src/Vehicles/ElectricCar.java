package Vehicles;

public class ElectricCar extends Car {
    private int autonomy;

    //Default constructor
    public ElectricCar(){
        super();
        this.setPlateNumber("EC");
        this.autonomy = 0;
        //**TO DO** Add license plate
    }

    //Parametrized constructor
    public ElectricCar(String make, String model, int year, int maxNumberOfPassengers, int autonomy){
        super(make, model, year, maxNumberOfPassengers);
        this.autonomy = autonomy;
        //**TO DO** Add license plate
    }

    //Copy constructor
    public ElectricCar(ElectricCar other){
        super(other);
        this.autonomy = other.autonomy;
        //**TO DO** Add license plate
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
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectricCar other = (ElectricCar) o;
        return super.equals(other) && this.autonomy == other.autonomy;
    }
}

