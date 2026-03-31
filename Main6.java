package Task6;
interface IoTDevice {

    // Default method
    default void update() {
        System.out.println("Updating IoT device firmware...");
    }

    // Static method
    static void info() {
        System.out.println("IoT devices connect and exchange data over the internet.");
    }
}
class SmartSensor implements IoTDevice {
    // No need to override update() unless customization is required
}


public class Main6 {
        public static void main(String[] args) {

            SmartSensor sensor = new SmartSensor();

            // Call default method using object
            sensor.update();

            // Call static method using interface name
            IoTDevice.info();
        }
}
