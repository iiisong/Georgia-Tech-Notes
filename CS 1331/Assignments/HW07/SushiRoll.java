/**
 * Provided methods for use in HW07.
 * @author CS1331 TAs
 * @version 13.31
 */

public class SushiRoll {
    private String name;
    private String color;

    /**
     * Constructor that assigns proper values to the variables.
     * @param name  name of the roll.
     * @param color color of the roll's plate.
     */
    public SushiRoll(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * 1-arg constructor that defaults color to Green.
     * @param name name of the roll
     */
    public SushiRoll(String name) {
        this(name, "Green");
    }

    /**
     * Getter to access the name of the roll.
     * @return the name of the roll.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter to acces the color of the plate of the roll.
     * @return the color of the plate of the roll.
     */
    public String getColor() {
        return color;
    }

    /**
     * toString method that returns the name and the color.
     */
    @Override
    public String toString() {
        return name + " " + color;
    }
}