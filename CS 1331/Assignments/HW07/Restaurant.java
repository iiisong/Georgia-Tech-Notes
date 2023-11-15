/**
* Creates Restaurant Class with recursive powered static methods to work on sushirolls.
*
* @author iiisong
* @version 1
*/
public class Restaurant {
    /**
     * Sort array of rolls lexicographically by name.
     * @param srs array of sushi rolls
     * @return sorted array of rolls
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] srs) {
        return mergeSortRollsRecursive(srs);
    }

    /**
     * Recursive helper for mergeSortRolls.
     * @param srs array of rolls
     * @return sorted array of rolls
     */
    private static SushiRoll[] mergeSortRollsRecursive(SushiRoll[] srs) {
        if (srs.length == 1) {
            return srs;
        }

        int oddOffset = srs.length % 2 == 0 ? 0 : 1;
        return MergeHelper.merge(createSubarray(srs, 0, srs.length / 2 + oddOffset),
                                    createSubarray(srs, srs.length / 2 + oddOffset, srs.length / 2));
    }

    /**
     * Combine array of arrays of rolls to one list.
     *
     * @param orders array of arrays of rolls
     * @return single combined array of rolls
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orders) {
        return mergeOrdersRecursive(orders, new SushiRoll[0], 0);
    }

    /**
     * Recursive helper for mergeOrders.
     *
     * @param orders array of arrays of rolls
     * @param index current index
     * @return single combined array of rolls
     */
    private static SushiRoll[] mergeOrdersRecursive(SushiRoll[][] orders, SushiRoll[] result, int index) {
        if (index >= orders.length) {
            return result;
        }
        result = MergeHelper.merge(result, orders[index]);
        return mergeOrdersRecursive(orders, result, ++index);
    }

    /**
     * Return array of rolls with specified plate color.
     * @param srs array of rolls
     * @param color specified plate color
     * @return array of rolls of plate color
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] srs, String color) {
        SushiRoll[] result = platesOfColorRecursive(srs, color, new SushiRoll[0], 0);
        return result.length == 0 ? null : result;
    }

    /**
     * Recursive helper to platesOfColor.
     *
     * @param srs array of rolls
     * @param color specified color
     * @param result current array of plates of color
     * @param index current index
     * @return array of all plates of specified color
     */
    public static SushiRoll[] platesOfColorRecursive(SushiRoll[] srs, String color, SushiRoll[] result, int index) {
        if (index >= srs.length) {
            return result;
        }

        if (srs[index].getColor().equals(color)) {
            result = MergeHelper.merge(result, new SushiRoll[]{srs[index]});
        }

        return platesOfColorRecursive(srs, color, result, ++index);
    }

    /**
     * Returns cumulative price of array of rolls.
     *
     * @param srs array of rolls
     * @return price
     */
    public static double totalPrice(SushiRoll[] srs) {
        return totalPriceRecursive(srs, 0, 0);
    }

    /**
     * Recursive helper for totalPrice.
     *
     * @param srs array of rolls
     * @param priceSum current sum of prices
     * @param index current index
     * @return total price
     */
    private static double totalPriceRecursive(SushiRoll[] srs, double priceSum, int index) {
        if (index >= srs.length) {
            return priceSum;
        }

        switch (srs[index].getColor()) {
        case "Red":
            priceSum += 7;
            break;
        case "Blue":
            priceSum += 6;
            break;
        default: // defaults to Green
            priceSum += 6.5;
        }

        return totalPriceRecursive(srs, priceSum, ++index);
    }

    /**
     * Flips sorted array of rolls inplace.
     * @param srs array of rolls
     */
    public static void flip(SushiRoll[] srs) {
        flipRecursive(srs, 0);
    }

    /**
     * Recursive helper for flipRecursive.
     *
     * @param srs array of rolls
     * @param index current index
     */
    public static void flipRecursive(SushiRoll[] srs, int index) {
        if (index >= srs.length / 2) {
            return;
        }

        SushiRoll temp = srs[srs.length - index - 1];
        srs[srs.length - index - 1] = srs[index];
        srs[index] = temp;

        flipRecursive(srs, ++index);
    }

    /**
     * Uses custom arrayCopy to create subarray of SushiRoll[].
     *
     * @param src source array to copy from
     * @param srcPos source array index location
     * @param length length to copy
     *
     * @return dest
     */
    public static SushiRoll[] createSubarray(SushiRoll[] src, int srcPos, int length) {
        SushiRoll[] dest = new SushiRoll[length];
        arrayCopy((Object[]) src, srcPos, (Object[]) dest, 0, length);

        return dest;
    }

    /**
     * helper function to return subarrays.
     *
     * @param src source array to copy from
     * @param srcPos source array index location
     * @param dest target array to copy to
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
     * Main driver for testing.
     *
     * @param args console params
     */
    public static void main(String[] args) {
        System.out.println("\nSort Orders:");
        SushiRoll[] srs = {new SushiRoll("Avocado", "Blue"),
                           new SushiRoll("Dragon", "Blue"),
                           new SushiRoll("Maki", "Red"),
                           new SushiRoll("Rainbow", "Green"),
                           new SushiRoll("Unagi", "Red")};

        for (SushiRoll sr : mergeSortRolls(srs)) {
            System.out.println(sr);
        }

        System.out.println("\nSorted Orders:");
        SushiRoll[] srsSorted = {new SushiRoll("Avocado", "Blue"),
                                 new SushiRoll("Dragon", "Blue"),
                                 new SushiRoll("Maki", "Red"),
                                 new SushiRoll("Rainbow", "Green"),
                                 new SushiRoll("Unagi", "Red")};

        for (SushiRoll sr : mergeSortRolls(srsSorted)) {
            System.out.println(sr);
        }

        System.out.println("\nMerge Orders:");
        SushiRoll[][] orders = {{new SushiRoll("Avacado"), new SushiRoll("Dragon")},
                                {new SushiRoll("Tobiko"), new SushiRoll("Unagi")},
                                {new SushiRoll("Maki")}};

        for (SushiRoll sr : mergeOrders(orders)) {
            System.out.println(sr);
        }


        System.out.println("\nPlate Colors:");
        for (SushiRoll sr : platesOfColor(srs, "Blue")) {
            System.out.println(sr);
        }

        System.out.println("\nTotal Price:");
        System.out.println(totalPrice(srs));


        System.out.println("\nFlipped:");
        SushiRoll[] flipped = mergeSortRolls(srs);
        flip(flipped);
        for (SushiRoll sr : flipped) {
            System.out.println(sr);
        }
    }
}
