import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Your implementation of a MaxHeap.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 *
 * Resources: QZ JUnits, Vemulapalli JUnits, Lucian JUnits, Kothapalli JUnits
 */
public class MaxHeap<T extends Comparable<? super T>> {

    /*
     * The initial capacity of the MaxHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new MaxHeap.
     *
     * The backing array should have an initial capacity of INITIAL_CAPACITY.
     */
    public MaxHeap() {
        this.backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Creates a properly ordered heap from a set of initial values.
     *
     * You must use the BuildHeap algorithm that was taught in lecture! Simply
     * adding the data one by one using the add method will not get any credit.
     * As a reminder, this is the algorithm that involves building the heap
     * from the bottom up by repeated use of downHeap operations.
     *
     * Before doing the algorithm, first copy over the data from the
     * ArrayList to the backingArray (leaving index 0 of the backingArray
     * empty). The data in the backingArray should be in the same order as it
     * appears in the passed in ArrayList before you start the BuildHeap
     * algorithm.
     *
     * The backingArray should have capacity 2n + 1 where n is the
     * number of data in the passed in ArrayList (not INITIAL_CAPACITY).
     * Index 0 should remain empty, indices 1 to n should contain the data in
     * proper order, and the rest of the indices should be empty.
     *
     * Consider how to most efficiently determine if the list contains null data.
     * 
     * @param data a list of data to initialize the heap with
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public MaxHeap(ArrayList<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        size = data.size();
        backingArray = (T[]) new Comparable[2 * size + 1];

        for (int i = 0; i < size; i++) {
            T d = data.get(i);

            if (d == null) {
                throw new IllegalArgumentException("element cannot be null");
            }

            backingArray[i + 1] = d;
        }

        for (int i = size / 2; i > 0; i--) {
            downHeap(i);
        }
    }

    /**
     * Adds the data to the heap.
     *
     * If sufficient space is not available in the backing array (the backing
     * array is full except for index 0), resize it to double the current
     * length.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        if (size == backingArray.length - 1) {
            T[] newArray = (T[]) new Comparable[backingArray.length * 2];

            for (int i = 1; i <= size; i++) {
                newArray[i] = backingArray[i];
            }

            backingArray = newArray;
        }

        size += 1;
        backingArray[size] = data;

        int curr = size;
        int prevData = curr / 2;

        while (prevData > 0 && backingArray[curr].compareTo(backingArray[prevData]) > 0) {
            T temp = backingArray[curr];
            backingArray[curr] = backingArray[prevData];
            backingArray[prevData] = temp;
            curr = prevData;
            prevData = curr / 2;
        }

    }

    /**
     * Downheap helper method.
     *
     * @param currNode index of current node
     */
    private void downHeap(int currNode) {
        while (true) {
            if (currNode * 2 + 1 <= size
                && backingArray[currNode].compareTo(backingArray[currNode * 2 + 1]) < 0
                && backingArray[currNode * 2].compareTo(backingArray[currNode * 2 + 1]) < 0) {
                T temp = backingArray[currNode];
                backingArray[currNode] = backingArray[currNode * 2 + 1];
                backingArray[currNode * 2 + 1] = temp;
                currNode = currNode * 2 + 1;
                continue;
            }

            if (currNode * 2 <= size
                && backingArray[currNode].compareTo(backingArray[currNode * 2]) < 0) {
                T temp = backingArray[currNode];
                backingArray[currNode] = backingArray[currNode * 2];
                backingArray[currNode * 2] = temp;
                currNode = currNode * 2;
                continue;
            }

            break;
        }
    }

    /**
     * Removes and returns the root of the heap.
     *
     * Do not shrink the backing array.
     *
     * Replace any unused spots in the array with null.
     *
     * @return the data that was removed
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("heap empty");
        }

        T result = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size -= 1;

        downHeap(1);

        return result;
    }

    /**
     * Returns the maximum element in the heap.
     *
     * @return the maximum element
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T getMax() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }

        return backingArray[1];
    }

    /**
     * Returns whether or not the heap is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the heap.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     */
    public void clear() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
