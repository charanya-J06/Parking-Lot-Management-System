package parkinglot;

public abstract class ParkingSpot {
    protected int spotId;
    protected boolean occupied;
    protected Vehicle parkedVehicle;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public void vacate() {
        this.parkedVehicle = null;
        this.occupied = false;
    }

    public abstract boolean canPark(Vehicle vehicle);
}
