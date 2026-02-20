package parkinglot;

class BasicHourlyRate implements ParkingFeeStrategy{

    @Override
    public double calculateFee(VehicleType type, int hours){
        double rate;

        switch(type){
            case CAR:
                rate = 20;
                break;
            case BIKE:
                rate = 10;
                break;
            default:
                rate = 25;
        }

        return rate*hours;
    }
}
