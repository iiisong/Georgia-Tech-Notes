/**
* Creates SuperheroRecruit.
*
* @author iiisong
* @version 1
*/
public class SuperheroRecruit {
    protected final String name; // immutable
    private int speed; // mutable
    private final double strength; // immutable
    private int intelligence; // mutable
    private static int totalRecruits = 10; // static to keep track of total recruits

    /**
    * Main Constructor.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    * @param strength superhero's strength
    * @param intelligence superhero's intelligence
    */
    public SuperheroRecruit(String name, int speed, double strength, int intelligence) {
        // set properties with constraints and defaults
        this.name = name != null && !name.equals("") ? name : "Steve Rogers";
        this.speed = speed >= 0 ? speed : 20;
        this.strength = strength >= 0 ? strength : 220;
        this.intelligence = intelligence >= 0 ? intelligence : 100;
    }

    /**
    * 3 Param Chain Constructor.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    * @param strength superhero's strength
    */
    public SuperheroRecruit(String name, int speed, double strength) {
        this(name, speed, strength, 100);
    }

    /**
    * 2 Param Chain Constructor.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    */
    public SuperheroRecruit(String name, int speed) {
        this(name, speed, 220, 100);
    }

    /**
    * Copy Constructor.
    *
    * @param obj existing object
    */
    public SuperheroRecruit(SuperheroRecruit obj) {
        this.name = obj.getName();
        this.speed = obj.getSpeed();
        this.strength = obj.getStrength();
        this.intelligence = obj.getIntelligence();
    }

    /**
    * calculate and return powerscaling.
    *
    * @return powerscale
    */
    public double powerScaling() {
        return (speed + strength + intelligence) / 3;
    }

    /**
    * Override toString.
    *
    * @return string
    */
    public String toString() {
        return String.format("%s has %d IQ, runs at %d miles per hour, and can lift %.2f pounds.",
                            name, intelligence, speed, strength)
            + String.format(" The Power Scaling is %.2f.", powerScaling());
    }

    /**
    * Recruit new superhero, deduct from totalRecruits.
    *
    * @param station station to enlist superhero
    *
    * @return String output
    */
    public String recruit(String station) {
        // no more space
        if (totalRecruits <= 0) {
            return "Cannot recruit anyone, there are no slots left!";
        }

        // too weak
        if (powerScaling() <= 120) {
            return "Rejected. Take a look at our sidekick program!";
        }

        // deduct from recruits
        totalRecruits -= 1;
        return toString() + String.format(" Recruit is enlisted to %s.", station);
    }

    /**
    * Name Getter.
    *
    * @return name
    */
    public String getName() {
        return name;
    }

    /**
    * Speed Getter.
    *
    * @return speed
    */
    public int getSpeed() {
        return speed;
    }

    /**
    * Strength Getter.
    *
    * @return strength
    */
    public double getStrength() {
        return strength;
    }

    /**
    * Intelligence Getter.
    *
    * @return intelligence
    */
    public int getIntelligence() {
        return intelligence;
    }
}