/**
* Creates FlyingHero object extends SuperheroRecruit. Have Altitude.
*
* @author iiisong
* @version 1
*/
public class FlyingHero extends SuperheroRecruit {
    private double altitude;

    /**
    * Chain Constructor to super.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    * @param strength superhero's strength
    * @param intelligence superhero's intelligence
    * @param altitude superhero's altitude
    */
    public FlyingHero(String name, int speed, double strength, int intelligence, double altitude) {
        super(name, speed, strength, intelligence);
        this.altitude = altitude >= 10 && altitude <= 100 ? altitude : 50;
    }

    /**
    * 2 Param Chain Constructor to super.
    *
    * @param name superhero's name
    * @param speed superhero's speed
    */
    public FlyingHero(String name, int speed) {
        super(name, speed);
        this.altitude = 50;
    }

    /**
    * 2 Param Chain Constructor to super.
    *
    * @param name superhero's name
    */
    public FlyingHero(String name) {
        super(name, 20);
        this.altitude = 50;
    }

    /**
    * Copy Constructor.
    *
    * @param obj existing object
    */
    public FlyingHero(FlyingHero obj) {
        super(obj);
        this.altitude = obj.getAltitude();
    }

    /**
    * calculate and return powerscaling.
    *
    * @return powerscale
    */
    public double powerScaling() {
        return super.powerScaling() + altitude;
    }

    /**
    * Override toString.
    *
    * @return string
    */
    public String toString() {
        return String.format("%s can fly %.2f feet in the air! %s has %d IQ, runs at %d miles per hour",
            getName(), altitude, getName(), getIntelligence(), getSpeed())
            + String.format(", and can lift %.2f pounds. The Power Scaling is %.2f.", getStrength(), powerScaling());
    }

    /**
    * Altitude Getter.
    *
    * @return altitude
    */
    public double getAltitude() {
        return altitude;
    }
}