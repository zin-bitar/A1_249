public class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int year;

    //Default constructor
    public Vehicle() {
        plateNumber = "";
        make = "";
        model = "";
        year = 0;
    }

    //Parametrized constructor
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    //Copy constructor
    public Vehicle(Vehicle vehicle){
        this.make = vehicle.make;
        this.model = vehicle.model;
        this.year = vehicle.year;
    }

    //Setters & Getters
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


    //toString method
    @Override
    public String toString(){
        return "Plate number: " + plateNumber + "\nMake: " + make + "\nModel: " + model + "\nYear: " + year;
    }

    //equals method
    @Override
    public boolean equals(Object vehicle){
        if(this==vehicle)return true;
        if(vehicle == null || (getClass() != vehicle.getClass())) return false;
        Vehicle otherVehicle = (Vehicle)vehicle;
        return this.make.equals(otherVehicle.make) && this.model.equals(otherVehicle.model) && this.year == otherVehicle.year;
    }
}
