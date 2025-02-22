public class ElectricTruck extends Truck {
    private int autonomy;

    //Default constructor
    public ElectricTruck(){
        super();
        this.setPlateNumber("ET");
        this.autonomy = 0;
        //**TO DO** Add license plate
    }

    //Parametrized constructor
    public ElectricTruck(String make, String model, int year, int maxCapacity, int autonomy){
        super(make, model, year, maxCapacity);
        this.autonomy = autonomy;
        //**TO DO** Add license plate
    }

    //Copy constructor
    public ElectricTruck(ElectricTruck other){
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ElectricTruck other = (ElectricTruck) o;
        return super.equals(other) && this.autonomy == other.autonomy;
    }
}
