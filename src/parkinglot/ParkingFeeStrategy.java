package parkinglot;

interface ParkingFeeStrategy{
    double calculateFee(VehicleType type, int duration);
}
