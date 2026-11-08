
package fencing;

public interface EquipmentVisitor {

    void visitMask(FencingMask mask);

    void visitWeapon(FencingWeapon weapon);

}
