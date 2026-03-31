package Task4;
interface GPSTracking {
    void trackLocation();
}

interface PaymentSystem {
    void processPayment(double amount);
}
class RideApp {

    // Static Inner Class
    static class CompanyRules {
        static void showRules() {
            System.out.println("Company Rules:");
            System.out.println("- Follow traffic laws");
            System.out.println("- Maintain customer safety");
        }
    }
}
class Ride implements GPSTracking, PaymentSystem {

    String riderName;

    Ride(String riderName) {
        this.riderName = riderName;
    }

    @Override
    public void trackLocation() {
        System.out.println("Tracking location for rider: " + riderName);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " for " + riderName);
    }
}

public class Main4 {

        public static void main(String[] args) {

            Ride ride = new Ride("Ali");

            ride.trackLocation();
            ride.processPayment(250.0);

            System.out.println();

            // Access static inner class
            RideApp.CompanyRules.showRules();
        }
}
