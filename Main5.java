package Task5;
interface ElectricSystem {
    default void showStatus() {
        System.out.println("Electric System: Battery level is optimal.");
    }

    void showEnergyMode();
}

interface GPSSystem {
    default void showStatus() {
        System.out.println("GPS System: Navigation is active.");
    }

    void showLocation();
}
abstract class Vehicle {
    String model;

    Vehicle(String model) {
        this.model = model;
    }

    abstract void startEngine();
}
class SmartVehicle extends Vehicle implements ElectricSystem, GPSSystem {

    // Inner class Engine (tightly coupled)
    class Engine {
        void runEngine() {
            System.out.println("Engine is running smoothly...");
        }
    }

    SmartVehicle(String model) {
        super(model);
    }

    // Define how vehicle starts
    @Override
    void startEngine() {
        System.out.println(model + " starts with push-button ignition.");

        // Engine works internally
        Engine engine = new Engine();
        engine.runEngine();
    }

    // Electric feature
    @Override
    public void showEnergyMode() {
        System.out.println("Energy Mode: Electric Drive");
    }

    // GPS feature
    @Override
    public void showLocation() {
        System.out.println("Current Location: GPS coordinates displayed.");
    }

    // Resolve conflict between ElectricSystem & GPSSystem
    @Override
    public void showStatus() {
        System.out.println("Smart Vehicle Combined Status:");

        ElectricSystem.super.showStatus();
        GPSSystem.super.showStatus();
    }
}
public class Main5 {
        public static void main(String[] args) {

            SmartVehicle car = new SmartVehicle("Tesla Model S");

            car.startEngine();
            System.out.println();

            car.showEnergyMode();
            car.showLocation();
            System.out.println();

            car.showStatus();
        }

}
