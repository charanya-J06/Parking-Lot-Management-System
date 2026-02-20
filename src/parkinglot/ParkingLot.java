package parkinglot;

import java.util.*;

public class ParkingLot{

    private List<ParkingSpot> spots = new ArrayList<>();
    private Map<String, ParkingSpot> parkedVehicles = new HashMap<>();

    public void createSpots(VehicleType type, int count, int startId) {
        for (int i=0; i<count; i++) {
            if (type == VehicleType.CAR) {
                spots.add(new CarParkingSpot(startId + i));
            } else{
                spots.add(new BikeParkingSpot(startId + i));
            }
        }
    }

    public void parkVehicle(Vehicle vehicle){
        if (parkedVehicles.containsKey(vehicle.getNumberPlate())) {
            System.out.println("Vehicle with "+vehicle.getNumberPlate()+" already parked!");
            return;
        }

        for (ParkingSpot spot : spots){
            if (!spot.isOccupied() && spot.canPark(vehicle)){
                spot.park(vehicle);
                parkedVehicles.put(vehicle.getNumberPlate(), spot);
                System.out.println(vehicle.getNumberPlate()+" Parked at spot " + spot.getSpotId());
                return;
            }
        }
        System.out.println("No available spot for " + vehicle.getType());
    }

    public void vacateVehicle(String numberPlate){
        ParkingSpot spot = parkedVehicles.get(numberPlate);
        if (spot == null) {
            System.out.println("Vehicle not found!");
            return;
        }
        spot.vacate();
        parkedVehicles.remove(numberPlate);
        System.out.println("Vehicle exited successfully");
    }

    public VehicleType getVehicleType(String numberPlate){
        ParkingSpot spot = parkedVehicles.get(numberPlate);
        if (spot == null) {
            return null;
        }
        return spot.getParkedVehicle().getType();
    }

    public void displayStatus(){
        System.out.println("\n--- PARKED VEHICLES ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }
        parkedVehicles.forEach((num, spot) -> {
            System.out.println(
                num + " (" + spot.getParkedVehicle().getType() + ") -> Spot " + spot.getSpotId()
            );
        });
    }
}
