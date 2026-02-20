package parkinglot;

public class DailyFeeStrategy implements ParkingFeeStrategy {

    @Override
    public double calculateFee(VehicleType type, int days) {
        double dailyRate;

        switch (type) {
            case CAR:
                dailyRate = 400;
                break;
            case BIKE:
                dailyRate = 200;
                break;
            default:
                dailyRate = 500;
        }

        return dailyRate * days;
    }
}