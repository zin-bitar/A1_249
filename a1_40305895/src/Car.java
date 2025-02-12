public class Car extends Vehicle {

    private int maxNumberOfPassengers;

    //Default constructor
    public Car(){
        super();
        this.maxNumberOfPassengers = 0;
        this.setPlateNumber("GC");
        //**TO DO** Add license plate
    }

    //Parametrized constructor
    public Car(String make, String model, int year, int maxNumberOfPassengers){
        super(make, model, year);
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        //**TO DO** Add license plate
    }

    //Copy constructor
    public Car(Car other){
        super(other);
        this.maxNumberOfPassengers = other.maxNumberOfPassengers;
        //**TO DO** Add license plate
    }

    //Setters
    public void setMaxNumberOfPassengers(int maxNumberOfPassengers){
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    //Getters
    public int getMaxNumberOfPassengers(){
        return this.maxNumberOfPassengers;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + "\nMaximum number of passengers: " + this.maxNumberOfPassengers;
    }

    //equals method
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return super.equals(car) && this.maxNumberOfPassengers == car.maxNumberOfPassengers;
    }

}
