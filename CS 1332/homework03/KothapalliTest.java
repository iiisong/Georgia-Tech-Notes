import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class KothapalliTest {
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
    public void testArrayStackPush() {
        assertEquals(0, arrayStack.size());
        arrayStack.push("1a");
        assertEquals(1, arrayStack.size());
        arrayStack.push("2b");
        assertEquals(2, arrayStack.size());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPush() {
        assertEquals(0, linkedStack.size());
        linkedStack.push("1a");
        assertEquals(1, linkedStack.size());
        linkedStack.push("2b");
        assertEquals(2, linkedStack.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackPeek() {
        arrayStack.push("1a");
        arrayStack.push("2b");
        arrayStack.push("3c");
        arrayStack.push("4d");
        arrayStack.push("5e");
        assertEquals("5e", arrayStack.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPeek() {
        linkedStack.push("1a");
        linkedStack.push("2b");
        linkedStack.push("3c");
        linkedStack.push("4d");
        linkedStack.push("5e");
        assertEquals("5e", linkedStack.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackPop() {
        arrayStack.push("1a");
        arrayStack.push("2b");
        arrayStack.push("3c");
        arrayStack.push("4d");
        arrayStack.push("5e");
        assertEquals("5e", arrayStack.pop());
        assertEquals("4d", arrayStack.pop());
        assertEquals("3c", arrayStack.pop());
        assertEquals("2b", arrayStack.pop());
        assertEquals("1a", arrayStack.pop());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPop() {
        linkedStack.push("1a");
        linkedStack.push("2b");
        linkedStack.push("3c");
        linkedStack.push("4d");
        linkedStack.push("5e");
        assertEquals("5e", linkedStack.pop());
        assertEquals("4d", linkedStack.pop());
        assertEquals("3c", linkedStack.pop());
        assertEquals("2b", linkedStack.pop());
        assertEquals("1a", linkedStack.pop());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackComprehensive() {
        arrayStack.push("1a");
        assertEquals("1a", arrayStack.pop());
        arrayStack.push("2b");
        arrayStack.push("3c");
        arrayStack.push("4d");
        arrayStack.push("5e");
        assertEquals("5e", arrayStack.pop());
        assertEquals("4d", arrayStack.peek());
        assertEquals(3 , arrayStack.size());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackComprehensive() {
        linkedStack.push("1a");
        assertEquals("1a", linkedStack.pop());
        linkedStack.push("2b");
        linkedStack.push("3c");
        linkedStack.push("4d");
        linkedStack.push("5e");
        assertEquals("5e", linkedStack.pop());
        assertEquals("4d", linkedStack.peek());
        assertEquals(3 , linkedStack.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackPeekError() {
        arrayStack.push("1a");
        arrayStack.push("2b");
        arrayStack.push("3c");
        arrayStack.push("4d");
        arrayStack.push("5e");
        assertEquals("5e", arrayStack.pop());
        assertEquals("4d", arrayStack.pop());
        assertEquals("3c", arrayStack.pop());
        assertEquals("2b", arrayStack.pop());
        assertEquals("1a", arrayStack.pop());
        assertThrows(NoSuchElementException.class, () -> arrayStack.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPeekError() {
        linkedStack.push("1a");
        linkedStack.push("2b");
        linkedStack.push("3c");
        linkedStack.push("4d");
        linkedStack.push("5e");
        assertEquals("5e", linkedStack.pop());
        assertEquals("4d", linkedStack.pop());
        assertEquals("3c", linkedStack.pop());
        assertEquals("2b", linkedStack.pop());
        assertEquals("1a", linkedStack.pop());
        assertThrows(NoSuchElementException.class, () -> linkedStack.peek());
    }
    @Test(timeout = TIMEOUT)
    public void testArrayStackPopError() {
        arrayStack.push("1a");
        arrayStack.push("2b");
        arrayStack.push("3c");
        arrayStack.push("4d");
        arrayStack.push("5e");
        assertEquals("5e", arrayStack.pop());
        assertEquals("4d", arrayStack.pop());
        assertEquals("3c", arrayStack.pop());
        assertEquals("2b", arrayStack.pop());
        assertEquals("1a", arrayStack.pop());
        assertThrows(NoSuchElementException.class, () -> arrayStack.pop());

    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPopError() {
        linkedStack.push("1a");
        linkedStack.push("2b");
        linkedStack.push("3c");
        linkedStack.push("4d");
        linkedStack.push("5e");
        assertEquals("5e", linkedStack.pop());
        assertEquals("4d", linkedStack.pop());
        assertEquals("3c", linkedStack.pop());
        assertEquals("2b", linkedStack.pop());
        assertEquals("1a", linkedStack.pop());
        assertThrows(NoSuchElementException.class, () -> linkedStack.pop());
    }
    @Test(timeout = TIMEOUT)
    public void testArrayStackPushError() {
        assertThrows(IllegalArgumentException.class, () -> arrayStack.push(null));

    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackPushError() {
        assertThrows(IllegalArgumentException.class, () -> linkedStack.push(null));

    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueEnqueue() {
        assertEquals(0, linkedQueue.size());
        linkedQueue.enqueue("1a");
        assertEquals(1, linkedQueue.size());
        linkedQueue.enqueue("2a");
        assertEquals(2, linkedQueue.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueEnqueue() {
        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue("1a");
        assertEquals(1, arrayQueue.size());
        arrayQueue.enqueue("2b");
        assertEquals(2, arrayQueue.size());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueuePeek() {
        linkedQueue.enqueue("1a");
        assertEquals("1a", linkedQueue.peek());
    }
    @Test(timeout = TIMEOUT)
    public void testLinkedQueueDequeueSize1() {
        linkedQueue.enqueue("1a");
        assertEquals("1a", linkedQueue.dequeue());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueDequeueSize5() {
        linkedQueue.enqueue("1a");
        linkedQueue.enqueue("2b");
        linkedQueue.enqueue("3c");
        linkedQueue.enqueue("4d");
        linkedQueue.enqueue("5e");
        assertEquals("1a", linkedQueue.dequeue());
        assertEquals("2b", linkedQueue.dequeue());
        assertEquals("3c", linkedQueue.dequeue());
        assertEquals("4d", linkedQueue.dequeue());
        assertEquals("5e", linkedQueue.dequeue());
    }
    @Test(timeout = TIMEOUT)
    public void testLinkedQueueComprehensiveTest() {
        linkedQueue.enqueue("1a");
        assertEquals("1a", linkedQueue.dequeue());
        linkedQueue.enqueue("2b");
        linkedQueue.enqueue("3c");
        linkedQueue.enqueue("4d");
        linkedQueue.enqueue("5e");
        assertEquals("2b", linkedQueue.peek());
        linkedQueue.enqueue("the test");
        assertEquals("2b", linkedQueue.dequeue());
        assertEquals("3c", linkedQueue.dequeue());
        assertEquals("4d", linkedQueue.dequeue());
        assertEquals("5e", linkedQueue.dequeue());
        assertEquals("the test", linkedQueue.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueuePeek() {
        arrayQueue.enqueue("1a");
        assertEquals("1a", arrayQueue.peek());
    }
    @Test(timeout = TIMEOUT)
    public void testArrayQueueDequeueSize1() {
        arrayQueue.enqueue("1a");
        assertEquals("1a", arrayQueue.dequeue());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueDequeueSize5() {
        arrayQueue.enqueue("1a");
        arrayQueue.enqueue("2b");
        arrayQueue.enqueue("3c");
        arrayQueue.enqueue("4d");
        arrayQueue.enqueue("5e");
        assertEquals("1a", arrayQueue.dequeue());
        assertEquals("2b", arrayQueue.dequeue());
        assertEquals("3c", arrayQueue.dequeue());
        assertEquals("4d", arrayQueue.dequeue());
        assertEquals("5e", arrayQueue.dequeue());
    }
    @Test(timeout = TIMEOUT)
    public void testArrayQueueComprehensiveTest() {
        arrayQueue.enqueue("1a");
        assertEquals("1a", arrayQueue.dequeue());
        arrayQueue.enqueue("2b");
        arrayQueue.enqueue("3c");
        arrayQueue.enqueue("4d");
        arrayQueue.enqueue("5e");
        assertEquals("2b", arrayQueue.peek());
        arrayQueue.enqueue("the test");
        assertEquals("2b", arrayQueue.dequeue());
        assertEquals("3c", arrayQueue.dequeue());
        assertEquals("4d", arrayQueue.dequeue());
        assertEquals("5e", arrayQueue.dequeue());
        assertEquals("the test", arrayQueue.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueuePeekError() {
        arrayQueue.enqueue("1a");
        arrayQueue.enqueue("2b");
        arrayQueue.enqueue("3c");
        arrayQueue.enqueue("4d");
        arrayQueue.enqueue("5e");
        assertEquals("1a", arrayQueue.dequeue());
        assertEquals("2b", arrayQueue.dequeue());
        assertEquals("3c", arrayQueue.dequeue());
        assertEquals("4d", arrayQueue.dequeue());
        assertEquals("5e", arrayQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> arrayQueue.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueuePeekError() {
        linkedQueue.enqueue("1a");
        linkedQueue.enqueue("2b");
        linkedQueue.enqueue("3c");
        linkedQueue.enqueue("4d");
        linkedQueue.enqueue("5e");
        assertEquals("1a", linkedQueue.dequeue());
        assertEquals("2b", linkedQueue.dequeue());
        assertEquals("3c", linkedQueue.dequeue());
        assertEquals("4d", linkedQueue.dequeue());
        assertEquals("5e", linkedQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueDequeueError() {
        arrayQueue.enqueue("1a");
        arrayQueue.enqueue("2b");
        arrayQueue.enqueue("3c");
        arrayQueue.enqueue("4d");
        arrayQueue.enqueue("5e");
        assertEquals("1a", arrayQueue.dequeue());
        assertEquals("2b", arrayQueue.dequeue());
        assertEquals("3c", arrayQueue.dequeue());
        assertEquals("4d", arrayQueue.dequeue());
        assertEquals("5e", arrayQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> arrayQueue.dequeue());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueDequeueError() {
        linkedQueue.enqueue("1a");
        linkedQueue.enqueue("2b");
        linkedQueue.enqueue("3c");
        linkedQueue.enqueue("4d");
        linkedQueue.enqueue("5e");
        assertEquals("1a", linkedQueue.dequeue());
        assertEquals("2b", linkedQueue.dequeue());
        assertEquals("3c", linkedQueue.dequeue());
        assertEquals("4d", linkedQueue.dequeue());
        assertEquals("5e", linkedQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> linkedQueue.dequeue());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueEnqueueError() {
        assertThrows(IllegalArgumentException.class, () -> linkedQueue.enqueue(null));
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueEnqueueError() {
        assertThrows(IllegalArgumentException.class, () -> linkedQueue.enqueue(null));
    }
}