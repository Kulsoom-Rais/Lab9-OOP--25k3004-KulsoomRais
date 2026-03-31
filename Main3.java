package Task3;
interface FraudChecker {
    void checkFraud();
}

interface Auditor {
    void generateReport();
}
public class Main3 {
    public static void main(String[] args) {

        // Temporary Fraud Checker (anonymous class)
        FraudChecker fraudChecker = new FraudChecker() {
            @Override
            public void checkFraud() {
                System.out.println("Fraud check: No suspicious activity detected.");
            }
        };

        // One-time Auditor (anonymous class)
        Auditor auditor = new Auditor() {
            @Override
            public void generateReport() {
                System.out.println("Auditor report: Financial records are accurate.");
            }
        };

        // Execute
        fraudChecker.checkFraud();
        auditor.generateReport();
    }
}

