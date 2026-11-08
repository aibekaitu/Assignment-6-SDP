
package fencing;

public class FencingWeapon implements FencingEquipment {

    private final String type;
    private final int bladeLength;
    private final boolean damaged;

    public FencingWeapon(String type, int bladeLength, boolean damaged) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Weapon type cannot be empty");
        }

        if (bladeLength <= 0) {
            throw new IllegalArgumentException("Blade length must be positive");
        }

        this.type = type;
        this.bladeLength = bladeLength;
        this.damaged = damaged;
    }

    public String getType() {
        return type;
    }

    public int getBladeLength() {
        return bladeLength;
    }

    public boolean isDamaged() {
        return damaged;
    }

    @Override
    public void accept(EquipmentVisitor visitor) {
        visitor.visitWeapon(this);
    }
}
