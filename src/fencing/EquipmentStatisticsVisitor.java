
package fencing;

public class EquipmentStatisticsVisitor implements EquipmentVisitor {

    private int maskCount = 0;
    private int weaponCount = 0;
    private int damagedCount = 0;

    @Override
    public void visitMask(FencingMask mask) {
        maskCount++;

        if (mask.isDamaged()) {
            damagedCount++;
        }
    }

    @Override
    public void visitWeapon(FencingWeapon weapon) {
        weaponCount++;

        if (weapon.isDamaged()) {
            damagedCount++;
        }
    }

    public void printStatistics() {
        System.out.println("EQUIPMENT STATISTICS");
        System.out.println("Total masks: " + maskCount);
        System.out.println("Total weapons: " + weaponCount);
        System.out.println("Total equipment: " + (maskCount + weaponCount));
        System.out.println("Damaged equipment: " + damagedCount);
    }
}
