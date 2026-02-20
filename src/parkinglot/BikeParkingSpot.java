package parkinglot;

public class BikeParkingSpot extends ParkingSpot{

    public BikeParkingSpot(int spotId) {
        super(spotId);
    }

    @Override
    public boolean canPark(Vehicle vehicle){
        return vehicle.getType() == VehicleType.BIKE;
    }
}
