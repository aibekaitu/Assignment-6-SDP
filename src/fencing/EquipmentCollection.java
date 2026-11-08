
package fencing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentCollection {

    private final List<FencingEquipment> equipment = new ArrayList<>();

    public void addEquipment(FencingEquipment item) {
        Objects.requireNonNull(item, "Equipment cannot be null");
        equipment.add(item);
    }

    public void acceptVisitor(EquipmentVisitor visitor) {
        Objects.requireNonNull(visitor, "Visitor cannot be null");

        for (FencingEquipment item : equipment) {
            item.accept(visitor);
        }
    }
}
