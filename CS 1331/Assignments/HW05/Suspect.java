/**
* Creates Suspect subclass of PersonOfInterest.
*
* @author iiisong
* @version 1.0.0
*/
public class Suspect extends PersonOfInterest {
    private int height;

    /**
     * Main constructor.
     *
     * @param hairColor hair color
     * @param proximity proximity to crime scene
     * @param rubberDuck their rubber duck
     * @param height height of suspect
     */
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        this.height = height < 150 ? 150 : height;
    }

    /**
     * Chain Constructor.
     *
     * @param proximity proximity to crime scene
     * @param rubberDuck their rubber duck
     */
    public Suspect(int proximity, RubberDuck rubberDuck) {
        super(proximity, rubberDuck);
        this.height = height < 160 ? 160 : height;
    }

    @Override
    public String toString() {
        return String.format("Possible Suspect: %s They were observed to be %d cm tall.",
                             super.toString(), height);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Suspect)) {
            return false;
        }

        return super.equals((Suspect) obj)
                && this.height == ((Suspect) obj).height;
    }

    /**
     * Height getter.
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }
}
