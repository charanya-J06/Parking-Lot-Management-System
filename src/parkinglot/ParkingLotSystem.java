package parkinglot;

import java.util.Scanner;

public class ParkingLotSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        // Spot creation
        System.out.print("Enter number of CAR spots: ");
        int carSpots = sc.nextInt();

        System.out.print("Enter number of BIKE spots: ");
        int bikeSpots = sc.nextInt();
        sc.nextLine();

        parkingLot.createSpots(VehicleType.CAR, carSpots, 1);
        parkingLot.createSpots(VehicleType.BIKE, bikeSpots, carSpots + 1);

        while (true) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. Exit System");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine();

                    System.out.print("Enter type (CAR/BIKE): ");
                    VehicleType type;
                    try {
                        type = VehicleType.valueOf(sc.nextLine().toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Invalid vehicle type");
                        break;
                    }

                    Vehicle vehicle = VehicleFactory.createVehicle(number, type);
                    parkingLot.parkVehicle(vehicle);
                    break;

                case 2:
                    System.out.print("Enter vehicle number to exit: ");
                    String exitNumber = sc.nextLine();

                    // Check if vehicle exists
                    VehicleType vehicleType = parkingLot.getVehicleType(exitNumber);
                    if (vehicleType == null) {
                        System.out.println("Vehicle not found in parking lot");
                        break;
                    }

                    System.out.println("Parking Duration Type:");
                    System.out.println("1. Hours");
                    System.out.println("2. Days");
                    System.out.print("Choose option: ");
                    int durationChoice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter duration: ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    ParkingFeeStrategy feeStrategy;
                    if (durationChoice == 1) {
                        feeStrategy = new BasicHourlyRate();
                    } else {
                        feeStrategy = new DailyFeeStrategy();
                    }

                    double fee = feeStrategy.calculateFee(vehicleType, duration);

                    System.out.println("Parking Fee: " + fee);
                    System.out.println("Payment Mode: 1. Cash  2. Card");
                    int payChoice = sc.nextInt();
                    sc.nextLine();

                    PaymentStrategy payment = (payChoice == 1) ? new CashPayment() : new CardPayment();
                    payment.pay(fee);
                    parkingLot.vacateVehicle(exitNumber);
                    break;

                case 3:
                    parkingLot.displayStatus();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
