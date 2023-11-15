/**
 * Provided methods for use in HW07.
 * @author CS1331 TAs
 * @version 13.31
 */
public class MergeHelper {

    /**
     * Merges together two ascending-order arrays.
     * @param arr1 the first array, sorted in ascending order
     * @param arr2 the second array, sorted in ascending order
     * @return the combined array, sorted in ascending order
     */
    public static SushiRoll[] merge(SushiRoll[] arr1, SushiRoll[] arr2) {
        SushiRoll[] result = new SushiRoll[arr1.length + arr2.length];
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i].getName()).compareTo(arr2[j].getName()) <= 0) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}