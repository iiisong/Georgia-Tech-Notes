/**
* Creates RubberDuck.
*
* @author iiisong
* @version 1.0.0
*/
public class RubberDuck {
    private final Color color;
    private final boolean hasHat;

    /**
     * Main Constructor.
     *
     * @param color color of rubber duck
     * @param hasHat does rubber duck have hat?
     */
    public RubberDuck(Color color, boolean hasHat) {
        this.color = color == null ? Color.YELLOW : color;
        this.hasHat = hasHat;
    }

    /**
     * Chain constructor.
     */
    public RubberDuck() {
        this(Color.YELLOW, true);
    }

    @Override
    public String toString() {
        return String.format("a %s rubber duck %s a hat.",
                                color,
                                hasHat ? "with" : "without");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && !(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        return this.color == ((RubberDuck) obj).color
                && this.hasHat == ((RubberDuck) obj).hasHat;
    }
}
