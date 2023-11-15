/**
* Creates Brawler object extends SuperheroRecruit. Can have catchphrase.
*
* @author iiisong
* @version 1
*/
public class Brawler extends SuperheroRecruit {
    private Catchphrase catchphrase;

    /**
    * Chain Constructor to super.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    * @param strength superhero's strength
    * @param intelligence superhero's intelligence
    * @param catchphrase superhero's catchphrase
    */
    public Brawler(String name, int speed, double strength, int intelligence, Catchphrase catchphrase) {
        super(name, speed, strength, intelligence);
        this.catchphrase = catchphrase != null && !catchphrase.equals("") ? catchphrase : null;
    }

    /**
    * 2 Param Chain Constructor to super.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    */
    public Brawler(String name, int speed) {
        super(name, speed);
        this.catchphrase = null;
    }

    /**
    * Copy Constructor.
    *
    * @param obj existing object
    */
    public Brawler(Brawler obj) {
        super(obj);
        catchphrase = obj.getCatchphrase();
    }

    /**
    * calculate and return powerscaling.
    *
    * @return powerscale
    */
    public double powerScaling() {
        if (catchphrase == null) {
            return super.powerScaling();
        }

        return super.powerScaling() * (1 + catchphrase.getStatIncrease() / 100);
    }

    /**
    * prints statChange.
    */
    public void statChange() {
        System.out.printf("Catchphrase: %s\n", catchphrase != null ? catchphrase.getCatchphrase() : "null");
        System.out.printf("Original Speed and Strength: %d and %.2f\n", getSpeed(), getStrength());
        System.out.printf("Stat Increase: %.2f%%\n", catchphrase != null ? catchphrase.getStatIncrease() : 0);
        System.out.printf("Final Power Scaling: %.2f\n", powerScaling());
    }

    /**
    * Catchphrase Getter.
    *
    * @return catchphrase
    */
    public Catchphrase getCatchphrase() {
        return catchphrase;
    }
}
