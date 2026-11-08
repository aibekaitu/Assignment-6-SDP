
package fencing;

public class EquipmentReportVisitor implements EquipmentVisitor {

    @Override
    public void visitMask(FencingMask mask) {
        System.out.println("MASK REPORT");
        System.out.println("Model: " + mask.getModel());
        System.out.println("Protection Level: " + mask.getProtectionLevel());
        System.out.println("Damaged: " + mask.isDamaged());
        System.out.println();
    }

    @Override
    public void visitWeapon(FencingWeapon weapon) {
        System.out.println("WEAPON REPORT");
        System.out.println("Type: " + weapon.getType());
        System.out.println("Blade Length: " + weapon.getBladeLength() + " cm");
        System.out.println("Damaged: " + weapon.isDamaged());
        System.out.println();
    }
}
