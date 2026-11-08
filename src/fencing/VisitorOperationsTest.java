
package fencing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VisitorOperationsTest {

    public static void main(String[] args) {

        EquipmentCollection collection = new EquipmentCollection();

        collection.addEquipment(new FencingMask("Test Mask", 2, false));
        collection.addEquipment(new FencingWeapon("Epee", 90, true));

        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            collection.acceptVisitor(new SafetyInspectionVisitor());

            String safetyResult = output.toString();

            check(safetyResult.contains("PASSED - Mask is safe"),
                    "Safety inspection: mask");

            check(safetyResult.contains("FAILED - Weapon is damaged"),
                    "Safety inspection: weapon");

            output.reset();

            collection.acceptVisitor(new EquipmentReportVisitor());

            String reportResult = output.toString();

            check(reportResult.contains("Model: Test Mask"),
                    "Equipment report: mask");

            check(reportResult.contains("Type: Epee"),
                    "Equipment report: weapon");

            output.reset();

            EquipmentStatisticsVisitor statistics =
                    new EquipmentStatisticsVisitor();

            collection.acceptVisitor(statistics);
            statistics.printStatistics();

            String statisticsResult = output.toString();

            check(statisticsResult.contains("Total equipment: 2"),
                    "Statistics: total equipment");

            check(statisticsResult.contains("Damaged equipment: 1"),
                    "Statistics: damaged equipment");

        } finally {
            System.setOut(originalOutput);
        }

        System.out.println("ALL VISITOR TESTS PASSED!");
    }

    private static void check(boolean condition, String testName) {
        if (!condition) {
            throw new AssertionError("FAILED: " + testName);
        }
    }
}
