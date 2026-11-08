
package fencing;

public class FencingMask implements FencingEquipment {

    private final String model;
    private final int protectionLevel;
    private final boolean damaged;

    public FencingMask(String model, int protectionLevel, boolean damaged) {

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Mask model cannot be empty");
        }

        if (protectionLevel < 0) {
            throw new IllegalArgumentException("Protection level cannot be negative");
        }

        this.model = model;
        this.protectionLevel = protectionLevel;
        this.damaged = damaged;
    }

    public String getModel() {
        return model;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public boolean isDamaged() {
        return damaged;
    }

    @Override
    public void accept(EquipmentVisitor visitor) {
        visitor.visitMask(this);
    }
}
