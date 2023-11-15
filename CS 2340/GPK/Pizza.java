public abstract class Pizza {
    String desc = "Unknown pizza";

    public String getDescription() { return desc; }

    @Override
    public String toString() { return getDescription() + " - $" + cost(); }

    public abstract double cost();
}