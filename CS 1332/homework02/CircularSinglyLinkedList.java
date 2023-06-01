import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularSinglyLinkedList without a tail pointer.
 *
 * @author Isaac Song
 * @version 1.0
 * @userid isong41
 * @GTID 903808112
 *
 * Collaborators: None
 * 
 * Resources: QZheng's JUnits, MasonH's JUnits IBorak's JUnits
 */
public class CircularSinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private CircularSinglyLinkedListNode<T> head;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index at which to add the new data
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than zero");
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("index cannot be greater than size");
        }

        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        if (size == 0) {
            head = new CircularSinglyLinkedListNode<T>(data);
            head.setNext(head);
            size += 1;
            return;
        }

        if (index == 0) {
            T oldVal = head.getData();
            head.setData(data);
            head.setNext(new CircularSinglyLinkedListNode<T>(oldVal, head.getNext()));
            size += 1;
            return;
        }

        CircularSinglyLinkedListNode node = head;

        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }

        node.setNext(new CircularSinglyLinkedListNode<T>(data, node.getNext()));
        size += 1;
    }

    /**
     * Adds the data to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        addAtIndex(0, data);
    }

    /**
     * Adds the data to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        addAtIndex(size, data);
    }

    /**
     * Removes and returns the data at the specified index.
     *
     * Must be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than zero");
        }

        if (index  >= size) {
            throw new IndexOutOfBoundsException("index cannot be equal or larger to size");
        }

        if (index == 0) {
            T val = head.getData();
            size -= 1;
            
            if (size == 0) {
                head = null;
                return val;
            }

            head.setData(head.getNext().getData());
            head.setNext(head.getNext().getNext());
            return val;
        }

        CircularSinglyLinkedListNode node = head;

        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }

        T val = (T) node.getNext().getData();
        node.setNext(node.getNext().getNext());
        size -= 1;

        return val;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (head == null) {
            throw new java.util.NoSuchElementException("list is empty");
        }

        return removeAtIndex(0);
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Must be O(n).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (head == null) {
            throw new java.util.NoSuchElementException("list is empty");
        }
        
        return removeAtIndex(size - 1);
    }

    /**
     * Returns the data at the specified index.
     *
     * Should be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than zero");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("index cannot be equal or larger to size");
        }


        CircularSinglyLinkedListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return (T) node.getData();
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
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Removes and returns the last copy of the given data from the list.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the list.
     *
     * Must be O(n).
     *
     * @param data the data to be removed from the list
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if data is not found
     */
    public T removeLastOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("index cannot be less than zero");
        }

        if (head == null) {
            throw new NoSuchElementException("data cannot be found in empty list");
        }

        T result = null;
        CircularSinglyLinkedListNode beforeNode = null;
        CircularSinglyLinkedListNode node = head;

        for (int i = 0; i < size - 1; i++) {
            if (node.getNext().getData() == data) {
                beforeNode = node;
                result = (T) node.getNext().getData();
            }

            node = node.getNext();
        }
        
        if (head.getData() == data && beforeNode == null) {
            return removeFromFront();  
        }

        if (beforeNode == null) {
            throw new NoSuchElementException("Specified element not found");
        }

        beforeNode.setNext(beforeNode.getNext().getNext());
        size -= 1;
        return result;
    }

    /**
     * Returns an array representation of the linked list.
     *
     * Must be O(n) for all cases.
     *
     * @return the array of length size holding all of the data (not the
     * nodes) in the list in the same order
     */
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];

        
        CircularSinglyLinkedListNode node = head;
        for (int i = 0; i < size; i++) {
            arr[i] = (T) node.getData();
            node = node.getNext();
        }

        return arr;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public CircularSinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
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
        // DO NOT MODIFY!
        return size;
    }
}
