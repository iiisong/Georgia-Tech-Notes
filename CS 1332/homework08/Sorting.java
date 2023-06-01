import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 *
 * Resources: Soni JUnits, Lucian JUnits
 */
public class Sorting {

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n^2)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("comparator cannot be null");
        }

        int curr_min;

        for (int i = 0; i < arr.length; i++) {
            curr_min = i;
            for (int j = i + 1; j < arr.length; j++) {
                curr_min = comparator.compare(arr[curr_min], arr[j]) > 0 ?  j : curr_min;
            }

            T temp = arr[i];
            arr[i] = arr[curr_min];
            arr[curr_min] = temp;
        }
    }

    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("comparator cannot be null");
        }

        int start = 0;
        int end = arr.length - 1;
        boolean hasSwapped;
        int lastSwap = -1;

        while (end > start) {
            // cocktail up
            hasSwapped = false;
            for (int i = start + 1; i <= end; i++) {
                if (comparator.compare(arr[i], arr[i - 1]) < 0) {
                    // swap
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    hasSwapped = true;
                    lastSwap = i - 1;
                }
            }

            if (!hasSwapped) {
                break;
            }
            end = lastSwap;
        
            // cocktail down
            hasSwapped = false;
            for (int i = end; i > start; i--) {
                if (comparator.compare(arr[i], arr[i - 1]) < 0) {
                    // swwap
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    hasSwapped = true;
                    lastSwap = i;
                }
            }
            
            if (!hasSwapped) {
                break;
            }
            start = lastSwap;
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("comparator cannot be null");
        }

        arr =  mergeSortHelper(arr, comparator);
    }

    /**
     * Recursive Merge Sort helper.
     *
     * @param <T> Generic
     * @param arr array to sort
     * @param comparator comparator
     * @return array sorted out-of-place
     */
    private static <T> T[] mergeSortHelper(T[] arr, Comparator<T> comparator) {
        if (arr.length == 1) {
            return arr;
        }
        
        T[] left = (T[]) new Object[arr.length / 2];
        T[] right = (T[]) new Object[arr.length - left.length];

        for (int i = 0; i < arr.length; i++) {
            if (i < left.length) {
                left[i] = arr[i];
            } else {
                right[i - left.length] = arr[i];
            }
        }

        left = mergeSortHelper(left, comparator);
        right = mergeSortHelper(right, comparator);
        
        int l_in = 0;
        int r_in = 0;

        for (int i = 0; i < arr.length; i++) {
            if (r_in >= right.length)  {
                arr[i] = left[l_in];
                l_in++;
            }

            else if (l_in >= left.length)  {
                arr[i] = right[r_in];
                r_in++;
                continue;
            }

            // <= for stability
            else if (comparator.compare(left[l_in], right[r_in]) <= 0) {
                arr[i] = left[l_in];
                l_in++;
            } else {
                arr[i] = right[r_in];
                r_in++;
            }
        }

        return arr;
    }

    /**
     * Implement kth select.
     *
     * Use the provided random object to select your pivots. For example if you
     * need a pivot between a (inclusive) and b (exclusive) where b > a, use
     * the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * If your recursion uses an inclusive b instead of an exclusive one,
     * the formula changes by adding 1 to the nextInt() call:
     *
     * int pivotIndex = rand.nextInt(b - a + 1) + a;
     *
     * It should be:
     * in-place
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * @param <T>        data type to sort
     * @param k          the index to retrieve data from + 1 (due to
     *                   0-indexing) if the array was sorted; the 'k' in "kth
     *                   select"; e.g. if k == 1, return the smallest element
     *                   in the array
     * @param arr        the array that should be modified after the method
     *                   is finished executing as needed
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @return the kth smallest element
     * @throws java.lang.IllegalArgumentException if the array or comparator
     *                                            or rand is null or k is not
     *                                            in the range of 1 to arr
     *                                            .length
     */
    public static <T> T kthSelect(int k, T[] arr, Comparator<T> comparator,
                                  Random rand) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("comparator cannot be null");
        }

        if (rand == null) {
            throw new IllegalArgumentException("random cannot be null");
        }

        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k cannot be outside range 1 to array length");
        }

        return kthSelectHelper(k, arr, comparator, rand, 0, arr.length);
    }

    /**
     * kthSelect Helper.
     *
     * @param <T> Generic
     * @param k kth index 
     * @param arr array
     * @param comparator comparator
     * @param rand random object
     * @param left leftmost index inclusive
     * @param right rightmost index exclusive
     * @return kth sorted element of array
     */
    private static <T> T kthSelectHelper(int k, T[] arr, Comparator<T> comparator, Random rand, int left, int right) {
        // exclusive right
        
        // select pivot and swap with leftmost
        int pivot_in = rand.nextInt(right - left) + left;
        T pivot = arr[pivot_in];
        arr[pivot_in] = arr[left];
        arr[left] = pivot;


        // instantiate iterators front and back (excluding swapped left)
        int i = left + 1;
        int j = right - 1;

        // repeat process till iterators pass each other
        while (i <= j) {

            // shift left iterator right until iterated greater than pivot
            while (i <= j && comparator.compare(arr[i], pivot) <= 0) {
                i += 1;
            }

            // shift right iterator left until iterated less than pivot
            while (i <= j && comparator.compare(arr[j], pivot) >= 0) {
                j -= 1;
            }
            
            // swap left right items and shift iterators respectively one more
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i += 1;
                j -= 1;
            }
        }

        // swap pivots
        T temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;

        // sort right side if kth index to right
        if (j < k - 1) {
            return kthSelectHelper(k, arr, comparator, rand, j + 1, right);
        }
        
        // sort right side if kth index to left
        if (j > k - 1) {
            return kthSelectHelper(k, arr, comparator, rand, left, j);
        }
        
        // return kth index
        return arr[j];
    }


    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need. The number of iterations
     * can be determined using the number with the largest magnitude.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }

        LinkedList<Integer>[] buckets = new LinkedList[19];

        // 1 32 425 32 656

        // -85 % 100= -8
        
        
        int maxNum = 1;
        for (int i : arr) {
            maxNum = i > maxNum ? i : maxNum;
        }

        // 542 % 100 = 42
        // 42 / 10 = 4
        // 42 % 10 = 2
        // 2 / 1 = 2

        // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18
        //-9 -8 -7 -6 -5 -4 -3 -2 -1  0  1  2  3  4  5  6  7  8  9  

        // -85 % 10 = 5
        // -85 % 100 / 10
        // System.out.println(-85 % 100 / 10);

        // fill buckets
        for (int mag = 10; mag <= maxNum * 10; mag *= 10) {
            // System.out.println("---------------------------------------");
            for (int n : arr) {
                int bucket = Math.abs(n) >= (mag / 10) ? (n % mag / (mag / 10)) + 9 : 9;
                // System.out.println("n: " + n);
                // System.out.println("mag: " + mag);
                // System.out.println("dig: " + (bucket - 9));
                // System.out.println("buck: " + bucket);
                // System.out.println();

                if (buckets[bucket] == null) {
                    buckets[bucket] = new LinkedList<Integer>();
                }
                buckets[bucket].add(n);
            }

            int fill_in = 0;
            // empty buckets
            for (int i = 0; i < buckets.length; i++) {
                while (buckets[i] != null && buckets[i].size() != 0) {
                    arr[fill_in] = buckets[i].pop();
                    fill_in += 1;
                }
            }
        }
    }

    /**
     * Implement heap sort.
     *
     * It should be:
     * out-of-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * Use java.util.PriorityQueue as the heap. Note that in this
     * PriorityQueue implementation, elements are removed from smallest
     * element to largest element.
     *
     * Initialize the PriorityQueue using its build heap constructor (look at
     * the different constructors of java.util.PriorityQueue).
     *
     * Return an int array with a capacity equal to the size of the list. The
     * returned array should have the elements in the list in sorted order.
     *
     * @param data the data to sort
     * @return the array with length equal to the size of the input list that
     * holds the elements from the list is sorted order
     * @throws java.lang.IllegalArgumentException if the data is null
     */
    public static int[] heapSort(List<Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(data);
        int[] result = new int[data.size()];

        for (int i = 0; i < data.size(); i++) {
            result[i] = pq.remove();
        }

        return result;
    }
}
