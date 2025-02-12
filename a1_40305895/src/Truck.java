public class Truck extends Vehicle {
    private int maxCapacity;

    //Default constructor
    public Truck(){
        super();
        maxCapacity = 0;
        //**TO DO** Add license plate
    }

    //Parametrized constructor
    public Truck(String make, String model, int year, int maxCapacity) {
        super(make, model, year);
        this.maxCapacity = maxCapacity;
        //**TO DO** Add license plate
    }

    //Copy constructor
    public Truck(Truck other){
        super(other);
        this.maxCapacity = other.maxCapacity;
        //**TO DO** Add license plate
    }

    //Setters
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    //Getters
    public int getMaxCapacity() {
        return maxCapacity;
    }


    //toString method
    @Override
    public String toString(){
        return super.toString() + "\nMax Capacity: " + maxCapacity;
    }

    //equals method
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck other = (Truck) o;
        return super.equals(o) && maxCapacity == other.maxCapacity;
    }

}
