/**
* Creates Museums Attraction.
*
* @author iiisong
* @version 1
*/
public class Museum extends Attraction {
    private final int maxCapacity;
    private int occupancy = 0;

    /**
     * Main Constructor.
     *
     * @param name name of museum
     * @param admissionFee admission cost of museum
     * @param maxCapacity maximum people allowed
     */
    public Museum(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        this.maxCapacity = maxCapacity;
    }

    /**
     * Constructor chain.
     *
     * @param name name of musuem
     */
    public Museum(String name) {
        this(name, 5.25, 25);
    }

    @Override
    public void admit(String[] names) {
        if (occupancy + names.length > maxCapacity) {
            System.out.println("Museum has reached maximum capacity. Please visit another time!");
            return;
        }

        occupancy += names.length;
        super.admit(names);
    }

    @Override
    public void rateAndExit(int groupIndex, int rating) {
        occupancy -= getVisitors()[groupIndex].size();
        super.rateAndExit(groupIndex, rating);
    }


    /**
     * find percentage occupied.
     *
     * @return double percent occupied
     */
    public double percentOccupancy() {
        return Math.round((double) occupancy / maxCapacity * 100) / 100;
    }

    @Override
    public String toString() {
        return "Museum: " + super.toString() + String.format("/%.2f%%", percentOccupancy());
    }
}
