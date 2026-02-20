package parkinglot;

public class CarParkingSpot extends ParkingSpot{

    public CarParkingSpot(int spotId){
        super(spotId);
    }

    @Override
    public boolean canPark(Vehicle vehicle){
        return vehicle.getType() == VehicleType.CAR;
    }
}
