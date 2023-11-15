import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Tests included in the file:
 * - Exceptions
 * - Resizing of array backed data structures
 * - One element functionality of linked list backed data structures
 * - Weirdness involving unwrapping and in-between null values for Queues
 * @author Abhinav Vemulapalli
 * @version 1.0
 */
public class VemulapalliTest {
    private static final int TIMEOUT = 200;
    private ArrayStack<String> arrayStack;
    private LinkedStack<String> linkedStack;
    private ArrayQueue<String> arrayQueue;
    private LinkedQueue<String> linkedQueue;

    @Before
    public void setup() {
        arrayStack = new ArrayStack<>();
        linkedStack = new LinkedStack<>();
        arrayQueue = new ArrayQueue<>();
        linkedQueue = new LinkedQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackOneElementFunctionality() {
        linkedStack.push("0a");

        LinkedNode<String> cur = linkedStack.getHead();
        assertEquals(1, linkedStack.size());
        assertEquals("0a", cur.getData());
        assertNull(cur.getNext());

        assertEquals("0a", linkedStack.peek());
        assertEquals("0a", linkedStack.pop());
        cur = linkedStack.getHead();
        assertEquals(0, linkedStack.size());
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackBackingArrayResize() {
        Object[] expectedArray = new Object[ArrayStack.INITIAL_CAPACITY * 2];
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i + "a");
            expectedArray[i] = i + "a";
        }

        Object[] arr = arrayStack.getBackingArray();
        assertEquals(10, arrayStack.size());
        assertEquals(18, arr.length);
        assertArrayEquals(expectedArray, arr);

        expectedArray = new Object[expectedArray.length * 2];
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i + "b");
        }
        expectedArray[0] = "0a";
        expectedArray[1] = "1a";
        expectedArray[2] = "2a";
        expectedArray[3] = "3a";
        expectedArray[4] = "4a";
        expectedArray[5] = "5a";
        expectedArray[6] = "6a";
        expectedArray[7] = "7a";
        expectedArray[8] = "8a";
        expectedArray[9] = "9a";
        expectedArray[10] = "0b";
        expectedArray[11] = "1b";
        expectedArray[12] = "2b";
        expectedArray[13] = "3b";
        expectedArray[14] = "4b";
        expectedArray[15] = "5b";
        expectedArray[16] = "6b";
        expectedArray[17] = "7b";
        expectedArray[18] = "8b";
        expectedArray[19] = "9b";

        arr = arrayStack.getBackingArray();
        assertEquals(20, arrayStack.size());
        assertEquals(36, arr.length);
        assertArrayEquals(expectedArray, arr);

        for (int i = 0; i < 3; i++) {
            assertEquals(9-i + "b", arrayStack.pop());
        }

        arr = arrayStack.getBackingArray();
        assertEquals(17, arrayStack.size());
        assertEquals(36, arr.length);
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueOneElementFunctionality() {
        linkedQueue.enqueue("0a");

        LinkedNode<String> curHead = linkedQueue.getHead();
        LinkedNode<String> curTail = linkedQueue.getTail();

        assertEquals(1, linkedQueue.size());
        assertSame(curHead, curTail);
        assertNotNull(curHead);
        assertEquals("0a", curHead.getData());
        assertNull(curHead.getNext());

        assertEquals("0a", linkedQueue.peek());
        assertEquals("0a", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());

        curHead = linkedQueue.getHead();
        curTail = linkedQueue.getTail();
        assertSame(curHead, curTail);
        assertNull(curHead);
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueHeadAndTail() {
        linkedQueue.enqueue("0a");
        linkedQueue.enqueue("1a");
        linkedQueue.enqueue("2a");

        assertEquals(3, linkedQueue.size());
        assertEquals("0a", linkedQueue.getHead().getData());
        assertEquals("2a", linkedQueue.getTail().getData());

        linkedQueue.dequeue();

        assertEquals(2, linkedQueue.size());
        assertEquals("1a", linkedQueue.getHead().getData());
        assertEquals("2a", linkedQueue.getTail().getData());

        linkedQueue.dequeue();
        assertEquals(1, linkedQueue.size());
        assertSame(linkedQueue.getHead(), linkedQueue.getTail());
        assertEquals("2a", linkedQueue.getTail().getData());
    }

    @Test()
    public void testArrayQueueResize() {
        Object[] expectedArray = new Object[ArrayQueue.INITIAL_CAPACITY * 2];
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i + "a");
            expectedArray[i] = i + "a";
        }

        Object[] arr = arrayQueue.getBackingArray();
        assertEquals(10, arrayQueue.size());
        assertEquals(18, arr.length);
        assertArrayEquals(expectedArray, arr);

        expectedArray = new Object[expectedArray.length * 2];
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i + "b");
        }
        expectedArray[0] = "0a";
        expectedArray[1] = "1a";
        expectedArray[2] = "2a";
        expectedArray[3] = "3a";
        expectedArray[4] = "4a";
        expectedArray[5] = "5a";
        expectedArray[6] = "6a";
        expectedArray[7] = "7a";
        expectedArray[8] = "8a";
        expectedArray[9] = "9a";
        expectedArray[10] = "0b";
        expectedArray[11] = "1b";
        expectedArray[12] = "2b";
        expectedArray[13] = "3b";
        expectedArray[14] = "4b";
        expectedArray[15] = "5b";
        expectedArray[16] = "6b";
        expectedArray[17] = "7b";
        expectedArray[18] = "8b";
        expectedArray[19] = "9b";

        arr = arrayQueue.getBackingArray();
        assertEquals(20, arrayQueue.size());
        assertEquals(36, arr.length);
        assertArrayEquals(expectedArray, arr);

        for (int i = 0; i < 3; i++) {
            assertEquals(i + "a", arrayQueue.dequeue());
        }

        arr = arrayQueue.getBackingArray();
        assertEquals(17, arrayQueue.size());
        assertEquals(36, arr.length);
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueWeirdness() {
        for (int i = 0; i < 9; i++) {
            arrayQueue.enqueue(i + "a");
        }

        Object[] arr = arrayQueue.getBackingArray();
        assertEquals(9, arrayQueue.size());
        assertEquals(9, arr.length);

        for (int i = 0; i < 3; i++) {
            assertEquals(i + "a", arrayQueue.dequeue());
        }
        Object[] expected = new Object[ArrayQueue.INITIAL_CAPACITY];
        expected[3] = "3a";
        expected[4] = "4a";
        expected[5] = "5a";
        expected[6] = "6a";
        expected[7] = "7a";
        expected[8] = "8a";

        assertEquals(6, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());

        arrayQueue.enqueue("0a");

        expected[0] = "0a";
        assertEquals(7, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());
        assertEquals(3, arrayQueue.getFront());

        for (int i = 0; i < 6; i++) {
            assertEquals(i + 3 + "a", arrayQueue.dequeue());
        }

        expected = new Object[ArrayQueue.INITIAL_CAPACITY];
        expected[0] = "0a";
        assertEquals(1, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());
        assertEquals(0, arrayQueue.getFront());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueUnwrapping() {
        for (int i = 0; i < 9; i++) {
            arrayQueue.enqueue(i + "a");
        }
        for (int i = 0; i < 3; i++) {
            arrayQueue.dequeue();
        }

        Object[] expected = new Object[ArrayQueue.INITIAL_CAPACITY];
        expected[3] = "3a";
        expected[4] = "4a";
        expected[5] = "5a";
        expected[6] = "6a";
        expected[7] = "7a";
        expected[8] = "8a";
        assertEquals(6, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());
        assertEquals(3, arrayQueue.getFront());

        for (int i = 0; i < 4; i++) {
            arrayQueue.enqueue(i + "b");
        }

        expected = new Object[ArrayQueue.INITIAL_CAPACITY * 2];
        expected[0] = "3a";
        expected[1] = "4a";
        expected[2] = "5a";
        expected[3] = "6a";
        expected[4] = "7a";
        expected[5] = "8a";
        expected[6] = "0b";
        expected[7] = "1b";
        expected[8] = "2b";
        expected[9] = "3b";

        assertEquals(10, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());
        assertEquals(0, arrayQueue.getFront());

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("0c");
        expected = new Object[ArrayQueue.INITIAL_CAPACITY * 2];
        expected[2] = "5a";
        expected[3] = "6a";
        expected[4] = "7a";
        expected[5] = "8a";
        expected[6] = "0b";
        expected[7] = "1b";
        expected[8] = "2b";
        expected[9] = "3b";
        expected[10] = "0c";

        assertEquals(9, arrayQueue.size());
        assertArrayEquals(expected, arrayQueue.getBackingArray());
        assertEquals(2, arrayQueue.getFront());
    }

    @Test(timeout = TIMEOUT)
    public void testStackExceptions() {
        assertThrows(IllegalArgumentException.class, () -> arrayStack.push(null));
        assertThrows(IllegalArgumentException.class, () -> linkedStack.push(null));

        assertThrows(NoSuchElementException.class, () -> arrayStack.pop());
        assertThrows(NoSuchElementException.class, () -> linkedStack.pop());

        assertThrows(NoSuchElementException.class, () -> arrayStack.peek());
        assertThrows(NoSuchElementException.class, () -> linkedStack.peek());

        arrayStack.push("0a");
        linkedStack.push("0a");
        arrayStack.pop();
        linkedStack.pop();

        assertThrows(NoSuchElementException.class, () -> arrayStack.pop());
        assertThrows(NoSuchElementException.class, () -> linkedStack.pop());

        assertThrows(NoSuchElementException.class, () -> arrayStack.peek());
        assertThrows(NoSuchElementException.class, () -> linkedStack.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testQueueExceptions() {
        assertThrows(IllegalArgumentException.class, () -> arrayQueue.enqueue(null));
        assertThrows(IllegalArgumentException.class, () -> linkedQueue.enqueue(null));

        assertThrows(NoSuchElementException.class, () -> arrayQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.dequeue());

        assertThrows(NoSuchElementException.class, () -> arrayQueue.peek());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.peek());

        arrayQueue.enqueue("0a");
        linkedQueue.enqueue("0a");
        arrayQueue.dequeue();
        linkedQueue.dequeue();

        assertThrows(NoSuchElementException.class, () -> arrayQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.dequeue());

        assertThrows(NoSuchElementException.class, () -> arrayQueue.peek());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.peek());
    }

}