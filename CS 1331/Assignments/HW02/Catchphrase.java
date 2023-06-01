/**
* Creates Catchphrase object.
*
* @author iiisong
* @version 1
*/
public class Catchphrase {
    private final String catchphrase;
    private final double statIncrease;

    /**
     * Create Catchphrase.
     *
     * @param catchphrase catphrase string
     * @param statIncrease percentage to increase stats
    */
    public Catchphrase(String catchphrase, double statIncrease) {
        this.catchphrase = catchphrase != null && !catchphrase.equals("") ? catchphrase : "I can do this all day";
        this.statIncrease = statIncrease > 0 && statIncrease <= 20 ? statIncrease : 15;
    }

    /**
    * Override toString.
    *
    * @return string
    */
    public String toString() {
        return String.format("%s!  Stats are increased by %.2f%%.", catchphrase, statIncrease);
    }

    /**
    * Catchphrase Getter.
    *
    * @return catchphrase
    */
    public String getCatchphrase() {
        return catchphrase;
    }

    /**
    * StatIncrease Getter.
    *
    * @return statIncrease
    */
    public double getStatIncrease() {
        return statIncrease;
    }
}
