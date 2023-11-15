/**
* Creates Attraction which extends admittable and is comparable.
*
* @author iiisong
* @version 1
*/
public class Attraction implements Admittable, Comparable<Attraction> {
    private final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    private final double admissionFee;
    private Group[] visitors = new Group[5];

    /**
     * Main Constructor.
     *
     * @param name name of attraction
     * @param admissionFee cost for attraction
     */
    public Attraction(String name, double admissionFee) {
        this.name = (name == null || name.equals("")) ? "No Name" : name;
        this.admissionFee = (admissionFee < 0) ? 0 : admissionFee;
    }

    /**
     * Chain Constructor to main.
     * @param name name of constructor
     */
    public Attraction(String name) {
        this(name, 5.25);
    }


    /**
     * Admits group into attraction.
     *
     * @param names names of people in group(s)
     */
    @Override
    public void admit(String[] names) {
        // iterate through every completed chunk of 5
            // 5, 10, 15 for
        for (int i = 5; names.length >= i; i += 5) {
            String[] tempArray = new String[5]; // temporary storage array
            arrayCopy(names, i - 5, tempArray, 0, 5); // copy subarray

            addGroup(new Group(tempArray)); // create group and add to visitors
        }

        // early return if no remainders and evenly divisble by 5
        if (names.length % 5 == 0) {
            return;
        }

        String[] remainArray = new String[names.length % 5]; // storage array for remainders
        // iterate through last remaining elements
        for (int i = 0; i < names.length % 5; i++) {
            remainArray[i] = names[(names.length / 5) * 5 + i]; // add to storage array
        }

        addGroup(new Group(remainArray)); // add remainder group
    }


    /**
     * Remove group from attraction and gets rating of attraction.
     *
     * @param groupIndex which group to remove
     * @param rating rating of attraction by removed group
     */
    public void rateAndExit(int groupIndex, int rating) {
        if (groupIndex < 0 || groupIndex >= visitors.length || visitors[groupIndex] == null) {
            System.out.println("Could not update rating. Index invalid.");
            return;
        }

        rating = rating < 1 ? 1 : rating;
        rating = rating > 10 ? 10 : rating;

        sumRatings += rating;
        numRatings += 1;

        // a,b,c,d,e
        // 1 : b
        // 2 : c
        // 5 - 1 - 1 = 3
        //
        arrayCopy(visitors, groupIndex + 1, visitors, groupIndex, visitors.length - groupIndex - 1);
        visitors[visitors.length - 1] = null; // last item has to be nulled
    }


    /**
     * Returns average attraction rating.
     *
     * @return double average rating
     */
    public double averageRating() {
        if (numRatings == 0) {
            return 0;
        }
        return (double) sumRatings / numRatings;
    }

    /**
     * Prints visitors in attraction.
     */
    public void printVisitors() {
        System.out.println(toString());

        for (int i = 0; i < visitors.length; i++) {
            if (visitors[i] == null) {
                continue;
            }

            System.out.printf("Group %d: %s\n", i + 1, visitors[i]);
        }
    }

    @Override
    public String toString() {
        return String.format("%s/%.2f/%.2f", name, averageRating(), admissionFee);
    }

    @Override
    public int compareTo(Attraction obj) {
        if (obj == null) {
            return -1;
        }

        if (obj.averageRating() == this.averageRating()
                && obj.admissionFee == this.admissionFee) {
            return 0;
        }

        return this.averageRating() > obj.averageRating() ? -1 : 1;
    }


    /**
     * group getter function..
     *
     * @return Group[] visitors list
     */
    public Group[] getVisitors() {
        return visitors;
    }


    /**
     * helper function to copy subarrays into other arrays.
     *
     * @param src source array to copy from
     * @param srcPos source array index location
     * @param dest target array to copy from
     * @param destPos target array target index location
     * @param length length to copy
     */
    public static void arrayCopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
        if (srcPos + length > src.length) {
            System.out.println("subarray out of bounds for source array");
            return;
        }

        if (destPos + length > dest.length) {
            System.out.println("subarray out of bounds for destination array");
            return;
        }

        Object[] temp = new Object[length];

        for (int i = 0; i < length; i++) {
            temp[i] = src[srcPos + i];
        }

        for (int i = 0; i < length; i++) {
            dest[destPos + i] = temp[i];
        }
    }


    /**
     * Overloads arrayCopy with String[] instead of Object[].
     *
     * @param src source array to copy from
     * @param srcPos source array index location
     * @param dest target array to copy from
     * @param destPos target array target index location
     * @param length length to copy
     */
    public static void arrayCopy(String[] src, int srcPos, String[] dest, int destPos, int length) {
        arrayCopy((Object[]) src, srcPos, (Object[]) dest, destPos, length);
    }


    /**
     * Overloads arrayCopy with Group[] instead of Object[].
     *
     * @param src source array to copy from
     * @param srcPos source array index location
     * @param dest target array to copy from
     * @param destPos target array target index location
     * @param length length to copy
     */
    public static void arrayCopy(Group[] src, int srcPos, Group[] dest, int destPos, int length) {
        arrayCopy((Object[]) src, srcPos, (Object[]) dest, destPos, length);
    }


    /**
     * Adds group to visitors + any resizing of visitors needed
     *
     * @param group group to add to visitors
     */
    private void addGroup(Group group) {
        // iterate through visitors to find earliest unfilled slot
        for (int i = 0; i < visitors.length; i++) {
            if (visitors[i] == null) {
                visitors[i] = group; // add group when found
                return; // early return
            }
        }

        // when no empty slots
        Group[] oldvisitors = visitors.clone(); // temporary store prev visitors in array
        visitors = new Group[visitors.length * 2]; // new visitors twice the size

        arrayCopy(oldvisitors, 0, visitors, 0, oldvisitors.length); // copy back in
        visitors[oldvisitors.length] = group; // first new slot created
    }

    /**
     * Attraction specific testing driver.
     *
     * @param args console
     */
    public static void main(String[] args) {
        String[] a = {"1", "2", "3", "4", "5"};
        String[] b = {"5", "4", "3", "2", "1"};
        Attraction.arrayCopy(a, 2, b, 0, 2);
        for (String i : b) {
            System.out.print(i);
        }

        // Group[] visitors1 = new Group[10];
        // int removeIndex = 5;

        // for (int i = removeIndex + 1; i < visitors1; i++) {
        //     visitors[i - 1] = visitors[i];
        // }

        // visitors[visitors.length - 1] = null;


        // Group[] temp = new Group[visitors1.length - 1];
        // for (int i = 0; i < visitors1.length - 1; i++) {
        //     if (i < removeIndex) {
        //         temp[i] = visitors[i];
        //         continue;
        //     }

        //     temp[i] = visitors[i + 1];
        // }
    }
}