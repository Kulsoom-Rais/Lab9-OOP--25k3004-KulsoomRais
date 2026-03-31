package Task7;
interface Service {
    void displayStatus();
}
class InsuranceService implements Service {
    @Override
    public void displayStatus() {
        System.out.println("Insurance: Coverage verified.");
    }

    public void getCoverageDetails() {
        System.out.println("Providing insurance coverage details...");
    }
}
class EmergencyService implements Service {
    @Override
    public void displayStatus() {
        System.out.println("Emergency: Immediate response active!");
    }

    public void respondEmergency() {
        System.out.println("Handling emergency situation...");
    }
}
class MedicalHistory {
    private String historyDetails;

    public MedicalHistory(String historyDetails) {
        this.historyDetails = historyDetails;
    }

    public void showHistory() {
        System.out.println("Medical History: " + historyDetails);
    }
}
abstract class Patient {
    protected String name;
    protected MedicalHistory medicalHistory;

    public Patient(String name, String historyDetails) {
        this.name = name;
        this.medicalHistory = new MedicalHistory(historyDetails); // Composition
    }

    public abstract void getTreatment();

    public void showMedicalHistory() {
        medicalHistory.showHistory();
    }
}
class InPatient extends Patient {

    public InPatient(String name, String historyDetails) {
        super(name, historyDetails);
    }

    @Override
    public void getTreatment() {
        System.out.println(name + " is receiving in-patient treatment.");
    }
}
class OutPatient extends Patient {

    public OutPatient(String name, String historyDetails) {
        super(name, historyDetails);
    }

    @Override
    public void getTreatment() {
        System.out.println(name + " is receiving out-patient treatment.");
    }
}

public class Main7 {
        public static void main(String[] args) {

            Patient p1 = new InPatient("Ali", "Diabetes");
            Patient p2 = new OutPatient("Sara", "Flu");

            p1.getTreatment();
            p1.showMedicalHistory();

            p2.getTreatment();
            p2.showMedicalHistory();

            // Services
            InsuranceService insurance = new InsuranceService();
            EmergencyService emergency = new EmergencyService();

            insurance.displayStatus();
            insurance.getCoverageDetails();

            emergency.displayStatus();
            emergency.respondEmergency();
        }

}
