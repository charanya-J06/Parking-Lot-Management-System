package parkinglot;

class CardPayment implements PaymentStrategy{
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
