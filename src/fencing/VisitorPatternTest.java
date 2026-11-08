
package fencing;

public class VisitorPatternTest {

    public static void main(String[] args) {

        testDoubleDispatch();
        testValidation();

        System.out.println("ALL TESTS PASSED!");
    }

    private static void testDoubleDispatch() {

        FencingMask mask = new FencingMask("Test Mask", 2, false);
        FencingWeapon weapon = new FencingWeapon("Epee", 90, false);

        int[] visits = {0, 0};

        EquipmentVisitor visitor = new EquipmentVisitor() {

            @Override
            public void visitMask(FencingMask mask) {
                visits[0]++;
            }

            @Override
            public void visitWeapon(FencingWeapon weapon) {
                visits[1]++;
            }
        };

        EquipmentCollection collection = new EquipmentCollection();
        collection.addEquipment(mask);
        collection.addEquipment(weapon);
        collection.acceptVisitor(visitor);

        if (visits[0] != 1 || visits[1] != 1) {
            throw new AssertionError("Double Dispatch failed");
        }

        System.out.println("PASS: Double Dispatch");
    }

    private static void testValidation() {

        try {
            new FencingMask("", 2, false);
            throw new AssertionError("Mask validation failed");
        } catch (IllegalArgumentException expected) {
            System.out.println("PASS: Mask validation");
        }

        try {
            new FencingWeapon("Epee", -10, false);
            throw new AssertionError("Weapon validation failed");
        } catch (IllegalArgumentException expected) {
            System.out.println("PASS: Weapon validation");
        }
    }
}
