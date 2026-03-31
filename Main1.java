package Task1;
interface WiFi {
    default void connect() {
        System.out.println("Connecting via WiFi...");
    }
}

interface Bluetooth {
    default void connect() {
        System.out.println("Connecting via Bluetooth...");
    }
}
class SmartDevice implements WiFi, Bluetooth {
    String deviceName;

    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void connect() {
        System.out.println(deviceName + " is connecting...");


        WiFi.super.connect();
        Bluetooth.super.connect();
    }
}
class FAST {
    String universityName = "FAST University";

    // Inner class
    class Department {
        String deptName;

        Department(String deptName) {
            this.deptName = deptName;
        }

        void display() {
            System.out.println("University: " + universityName);
            System.out.println("Department: " + deptName);
        }
    }
}

public class Main1 {

        public static void main(String[] args) {

            // Create SmartDevice
            SmartDevice device = new SmartDevice("Smart Board");
            device.connect();

            System.out.println();

            // Create FAST and Department
            FAST fast = new FAST();
            FAST.Department dept = fast.new Department("Computer Science");

            dept.display();
        }

}
