/**
* Creates Accomplice subclass of PersonOfInterest.
*
* @author iiisong
* @version 1.0.0
*/
public class Accomplice extends PersonOfInterest {
    private boolean canCode;

    /**
     * Main Constructor.
     *
     * @param hairColor accomplice hair color
     * @param proximity proximity to crime scene
     * @param rubberDuck their rubber duck
     * @param canCode can hack doorbells
     */
    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }

    @Override
    public String toString() {
        return String.format("Possible Accomplice: %s They %s have the ability to hack doorbells.",
                                super.toString(),
                                canCode ? "do" : "do not");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Accomplice)) {
            return false;
        }

        return super.equals((Accomplice) obj)
                && this.canCode == ((Accomplice) obj).canCode;
    }
}
