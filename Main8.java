package Task8;
interface Control {
    void executeCommand();
}
class VoiceControl implements Control {
    @Override
    public void executeCommand() {
        System.out.println("Executing command via voice...");
    }
}
class RemoteControl implements Control {
    @Override
    public void executeCommand() {
        System.out.println("Executing command via remote...");
    }
}
class Settings {
    private String configuration;

    public Settings(String configuration) {
        this.configuration = configuration;
    }

    public void showSettings() {
        System.out.println("Settings: " + configuration);
    }
}
abstract class Appliance {
    protected String name;
    protected Settings settings;

    public Appliance(String name, String config) {
        this.name = name;
        this.settings = new Settings(config); // Composition
    }

    public abstract void turnOn();

    public void showSettings() {
        settings.showSettings();
    }
}
class SmartLight extends Appliance {

    public SmartLight(String name, String config) {
        super(name, config);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " light is now ON.");
    }
}
class SmartFan extends Appliance {

    public SmartFan(String name, String config) {
        super(name, config);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " fan is now spinning.");
    }
}

public class Main8 {
        public static void main(String[] args) {

            Appliance light = new SmartLight("Living Room", "Brightness: High");
            Appliance fan = new SmartFan("Bedroom", "Speed: Medium");

            light.turnOn();
            light.showSettings();

            fan.turnOn();
            fan.showSettings();

            // Controls
            Control voice = new VoiceControl();
            Control remote = new RemoteControl();

            voice.executeCommand();
            remote.executeCommand();
        }

}
