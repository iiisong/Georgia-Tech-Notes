import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 *
 * Resources: Samuel Paul Taubman's JUnits, 
 */
public class ArrayList<T> {

    /**
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * Java does not allow for regular generic array creation, so you will have
     * to cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        this.backingArray = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Adds the element to the specified index.
     *
     * Remember that this add may require elements to be shifted.
     *
     * Must be amortized O(1) for index size and O(n) for all other cases.
     *
     * @param index the index at which to add the new element
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("cannot add at index less than 0");
        }

        if (index > size || index > backingArray.length) {
            throw new IndexOutOfBoundsException("cannot add at index exceeding size");
        }

        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        // if capacity of backingArray met, double capacity
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[size * 2]; // temp double capacity array

            // add all elements before index to expanded array
            for (int i = 0; i < index; i++) {
                newArray[i] = backingArray[i];
            }

            // all elements after index shifted one right
            for (int i = size; i > index; i--) {
                newArray[i] = backingArray[i - 1];
            }

            newArray[index] = data; // add data to index
            backingArray = newArray; // double backingArray capacity
            size += 1; // increase current size
            return;
        }

        // all elements after index shifted one right
        for (int i = size; i > index; i--) {
            backingArray[i] = backingArray[i - 1];
        }

        backingArray[index] = data; // add data to index
        size += 1; // increase current size
    }

    /**
     * Adds the element to the front of the list.
     *
     * Remember that this add may require elements to be shifted.
     *
     * Must be O(n).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) throws IllegalArgumentException {
        addAtIndex(0, data);
    }

    /**
     * Adds the element to the back of the list.
     *
     * Must be amortized O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        addAtIndex(size, data);
    }

    /**
     * Removes and returns the element at the specified index.
     *
     * Remember that this remove may require elements to be shifted.
     *
     * Must be O(1) for index size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("cannot remove at index less than 0");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("cannot remove at index exceeding or equal size");
        }

        T result = backingArray[index]; // store result

        // all elements after index shifted one left, original index value overridden
        for (int i = index; i < size && i < backingArray.length - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }

        backingArray[backingArray.length - 1] = null;   

        size -= 1; // decrease size by 1

        return result;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * Remember that this remove may require elements to be shifted.
     *
     * Must be O(n).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("cannot remove first element of empty list");
        }

        return removeAtIndex(0);
    }

    /**
     * Removes and returns the last element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("cannot remove first element of empty list");
        }

        return removeAtIndex(size - 1);
    }

    /**
     * Returns the element at the specified index.
     *
     * Must be O(1).
     *
     * @param index the index of the element to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("cannot remove t index less than 0");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("cannot remove at index exceeding or equal size");
        }

        return backingArray[index];
    }

    /**
     * Returns whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the backing array of the list.
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
     * Returns the size of the list.
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
