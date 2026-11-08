
package fencing;

public class SafetyInspectionVisitor implements EquipmentVisitor {

    private static final int MIN_PROTECTION_LEVEL = 2;
    private static final int MAX_BLADE_LENGTH_CM = 110;

    @Override
    public void visitMask(FencingMask mask) {
        System.out.println("Inspecting mask: " + mask.getModel());

        if (mask.isDamaged()) {
            System.out.println("Result: FAILED - Mask is damaged.");
        } else if (mask.getProtectionLevel() < MIN_PROTECTION_LEVEL) {
            System.out.println("Result: FAILED - Protection level is too low.");
        } else {
            System.out.println("Result: PASSED - Mask is safe.");
        }
    }

    @Override
    public void visitWeapon(FencingWeapon weapon) {
        System.out.println("Inspecting weapon: " + weapon.getType());

        if (weapon.isDamaged()) {
            System.out.println("Result: FAILED - Weapon is damaged.");
        } else if (weapon.getBladeLength() > MAX_BLADE_LENGTH_CM) {
            System.out.println("Result: FAILED - Blade is too long.");
        } else {
            System.out.println("Result: PASSED - Weapon is safe.");
        }
    }
}
