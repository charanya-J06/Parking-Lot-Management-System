package parkinglot;

public class VehicleFactory {
    public static Vehicle createVehicle(String numberPlate, VehicleType type) {
        if (type == VehicleType.CAR) {
            return new Car(numberPlate);
        } else if (type == VehicleType.BIKE) {
            return new Bike(numberPlate);
        }
        throw new IllegalArgumentException("Invalid vehicle type");
    }
}
