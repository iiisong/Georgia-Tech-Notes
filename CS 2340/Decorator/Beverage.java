package Decorator;

public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription() { return description; }
    @Override
    public String toString() {
        return getDescription() + " $" + cost();
    }
    public abstract double cost();
}
