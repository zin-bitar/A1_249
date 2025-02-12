public class Lease {
    private String date;
    private Vehicle vehicle;

    public Lease() {
        date="";
        vehicle=null;
    }

    public Lease(String date, Vehicle vehicle) {
        this.date = date;
        this.vehicle = vehicle;
    }
    public Lease(Lease other) {
        this.date = other.date;
        this.vehicle = other.vehicle;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return date+" "+vehicle.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(other == null || getClass() != other.getClass()) return false;
        Lease lease = (Lease)other;
        return date.equals(lease.date) && vehicle.equals(lease.vehicle);
    }
}
