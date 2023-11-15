/**
* Creates PersonOfInterest.
*
* @author iiisong
* @version 1.0.0
*/
public class PersonOfInterest implements Comparable<PersonOfInterest> {
    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;

    /**
     * Main constructor.
     *
     * @param hairColor color of hair
     * @param proximity proximity to crime scene
     * @param rubberDuck their rubber duck
     */
    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        this.hairColor = hairColor == null ? Color.BLACK : hairColor;
        this.proximity = Math.abs(proximity);
        this.rubberDuck = rubberDuck == null ? new RubberDuck() : rubberDuck;
    }

    /**
     * Chain constructor.
     *
     * @param proximity proximity to crime scene
     * @param rubberDuck their rubber duck
     */
    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck);
    }

    @Override
    public String toString() {
        return String.format(
                            "A POI with %s hair was last seen %d miles away holding %s",
                            hairColor,
                            proximity,
                            rubberDuck);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PersonOfInterest)) {
            return false;
        }

        return this.hairColor == ((PersonOfInterest) obj).hairColor
                && this.proximity == ((PersonOfInterest) obj).proximity
                && this.rubberDuck.equals(((PersonOfInterest) obj).rubberDuck);
    }

    @Override
    public int compareTo(PersonOfInterest poi) {
        if (poi == null) {
            return -1;
        }

        if (this.hairColor == poi.hairColor && this.proximity == poi.proximity) {
            return 0;
        }

        if (this.proximity < poi.proximity) {
            return -1;

        } else if (this.proximity > poi.proximity) {
            return 1;

        } else {
            return this.hairColor.toString().compareTo(poi.hairColor.toString());
        }
    }

    /**
     * HairColor getter.
     *
     * @return hair color
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Proximity getter.
     *
     * @return proximity
     */
    public int getProximity() {
        return proximity;
    }

    /**
     * Rubber Duck getter.
     *
     * @return rubber duck
     */
    public RubberDuck getRubberDuck() {
        return rubberDuck;
    }
}
