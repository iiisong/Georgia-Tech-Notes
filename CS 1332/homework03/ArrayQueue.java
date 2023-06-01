import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: QZheng JUnits, Vemulapalli JUnits, Kothapalli JUnits
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        this.backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        front = 0;
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Must be amortized O(1).
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        if (size >= backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = backingArray[(i + front) % backingArray.length];
            }

            backingArray = newArray;
            front = 0;
        } 
        
        if (size + front >= backingArray.length) {
            backingArray[(size + front) % backingArray.length] = data;
        } else {
            backingArray[size + front] = data;
        }

        size += 1;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("queue is empty");
        }
        T result = backingArray[front];
        backingArray[front] = null;
        front = (front + 1) % backingArray.length;
        size -= 1;
        return result;
    }

    /**
     * Returns the data from the front of the queue without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("queue is empty");
        }
        return backingArray[front];
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the front index of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the front index of the queue
     */
    public int getFront() {
        // DO NOT MODIFY THIS METHOD!
        return front;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQ = new ArrayQueue<String>();
        arrayQ.enqueue("00");
        arrayQ.enqueue("01");
        arrayQ.enqueue("02");
        arrayQ.enqueue("03");
        arrayQ.enqueue("04");

        arrayQ.dequeue();
        arrayQ.dequeue();

        arrayQ.enqueue("05");
        arrayQ.enqueue("06");
        arrayQ.enqueue("07");
        arrayQ.enqueue("08");
        arrayQ.enqueue("09");
        arrayQ.enqueue("10");
        // arrayQ.enqueue("11");

        Object[] arr = arrayQ.getBackingArray();
        System.out.println(arr.length);
        for (Object str : arr ) {
            System.out.println(str);
        }
    }
}
