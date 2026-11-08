# Assignment 6 — Visitor Design Pattern

## Project: Fencing Equipment Inspection System

**Course:** Software Design Patterns  
**Programming Language:** Java 25  
**Design Pattern:** Visitor (Behavioral)

## 1. Project Description

This project demonstrates the Visitor Design Pattern through a fencing equipment inspection system.

The application manages fencing masks and weapons and supports three independent operations:

- Safety Inspection — checks equipment against predefined rules.
- Equipment Report — displays detailed equipment information.
- Equipment Statistics — counts masks, weapons, and damaged equipment.

The safety thresholds are illustrative educational rules, not official fencing safety standards.

## 2. Visitor Pattern Components

| Component | Implementation |
|---|---|
| Element Interface | `FencingEquipment` |
| Concrete Elements | `FencingMask`, `FencingWeapon` |
| Visitor Interface | `EquipmentVisitor` |
| Concrete Visitors | `SafetyInspectionVisitor`, `EquipmentReportVisitor`, `EquipmentStatisticsVisitor` |
| Object Structure | `EquipmentCollection` |
| Client | `Main` |

## 3. Double Dispatch

The application implements double dispatch through the `accept()` method.

- `FencingMask` calls `visitor.visitMask(this)`.
- `FencingWeapon` calls `visitor.visitWeapon(this)`.

This allows Java to execute the appropriate visitor method without using `instanceof` or explicit type checking.

## 4. Clean Code Principles

**1. Meaningful Names**

Classes and methods have descriptive names such as `SafetyInspectionVisitor`, `visitMask()`, and `acceptVisitor()`. Their responsibilities are clear.

**2. Single Responsibility Principle (SRP)**

Each Concrete Visitor implements one operation. Safety inspection, reporting, and statistics are separated into independent classes.

**3. Open/Closed Principle (OCP)**

New operations can be introduced through additional Visitor classes without modifying the existing equipment classes. The third visitor, `EquipmentStatisticsVisitor`, demonstrates this extensibility.

**4. Encapsulation**

Equipment properties are declared `private final`. Visitors access the necessary information through public getter methods instead of modifying internal fields.

**5. Avoiding Type Checking**

Double dispatch eliminates the need for `instanceof` chains. Each element calls the corresponding method of the visitor.

**6. Don't Repeat Yourself (DRY)**

The `EquipmentCollection` class centralizes traversal logic so that each visitor can process the same collection without duplicating iteration code in the client.

**7. Defensive Programming and Fail Fast**

Constructors validate equipment data and reject invalid inputs using `IllegalArgumentException`. The collection also rejects null elements and visitors.

## 5. Project Structure

All Java source files are located inside `src/fencing/`.

The main application is `Main.java`.

The project also includes two test classes:

- `VisitorPatternTest.java`
- `VisitorOperationsTest.java`

## 6. How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure JDK 25.
4. Open `src/fencing/Main.java`.
5. Run the `main()` method.

## 7. Testing

The application includes standalone Java test programs that verify:

- Correct double dispatch.
- Mask and weapon input validation.
- Safety inspection results.
- Equipment information reporting.
- Equipment statistics.

Both test programs completed successfully during development.

## 8. Example Results

| Metric | Result |
|---|---:|
| Total Masks | 2 |
| Total Weapons | 2 |
| Total Equipment | 4 |
| Damaged Equipment | 2 |

## 9. Conclusion

The project demonstrates how the Visitor Pattern separates operations from object structures. New functionality can be introduced through additional visitors while preserving the existing equipment classes.

The implementation emphasizes double dispatch, extensibility, encapsulation, and Clean Code principles.
