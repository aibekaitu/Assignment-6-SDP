
package fencing;

public class Main {

    public static void main(String[] args) {

        EquipmentCollection collection = new EquipmentCollection();

        collection.addEquipment(new FencingMask("Allstar FIE", 2, false));
        collection.addEquipment(new FencingMask("Training Mask", 1, true));

        collection.addEquipment(new FencingWeapon("Epee", 90, false));
        collection.addEquipment(new FencingWeapon("Foil", 115, true));

        EquipmentVisitor safetyVisitor = new SafetyInspectionVisitor();
        EquipmentVisitor reportVisitor = new EquipmentReportVisitor();
        EquipmentStatisticsVisitor statisticsVisitor = new EquipmentStatisticsVisitor();

        System.out.println("SAFETY INSPECTION");
        collection.acceptVisitor(safetyVisitor);

        System.out.println("\nEQUIPMENT INFORMATION");
        collection.acceptVisitor(reportVisitor);

        System.out.println("\nSTATISTICS");
        collection.acceptVisitor(statisticsVisitor);
        statisticsVisitor.printStatistics();
    }
}
