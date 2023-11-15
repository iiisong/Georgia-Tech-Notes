import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QZTest {
    private static final int TIMEOUT = 200;
    private ArrayStack<String> arraySt;
    private LinkedStack<String> linkedSt;
    private ArrayQueue<String> arrayQ;
    private LinkedQueue<String> linkedQ;

    @Before
    public void setup() {
        arraySt = new ArrayStack<>();
        linkedSt = new LinkedStack<>();
        arrayQ = new ArrayQueue<>();
        linkedQ = new LinkedQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, arraySt.size());
        assertArrayEquals(new Object[ArrayStack.INITIAL_CAPACITY],
                arraySt.getBackingArray());
        assertEquals(0, arrayQ.size());
        assertArrayEquals(new Object[ArrayStack.INITIAL_CAPACITY],
                arrayQ.getBackingArray());
        assertEquals(0, linkedSt.size());
        assertNull(linkedSt.getHead());
        assertEquals(0, linkedQ.size());
        assertNull(linkedQ.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayQ.enqueue(null);
        });
        assertThrows(NoSuchElementException.class, () -> {
            arrayQ.dequeue();
        });
        assertThrows(NoSuchElementException.class, () -> {
            arrayQ.peek();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueue() {
        arrayQ.enqueue("00");
        arrayQ.enqueue("01");
        arrayQ.enqueue("02");
        arrayQ.enqueue("03");
        arrayQ.enqueue("04");
        assertArrayEquals(arrayQ.getBackingArray(),
                new String[]{"00","01","02","03","04",null,null,null,null});
        assertEquals(5,arrayQ.size());
        assertEquals("00",arrayQ.peek());
        assertEquals("00",arrayQ.dequeue());
        assertEquals("01",arrayQ.dequeue());
        assertEquals(3,arrayQ.size());
        assertEquals(arrayQ.getFront(), 2);
        assertArrayEquals(arrayQ.getBackingArray(),
                new String[]{null,null,"02","03","04",null,null,null,null});
        assertEquals("02",arrayQ.peek());
        arrayQ.enqueue("05");
        arrayQ.enqueue("06");
        arrayQ.enqueue("07");
        arrayQ.enqueue("08");
        arrayQ.enqueue("09");
        arrayQ.enqueue("10");
        assertArrayEquals(arrayQ.getBackingArray(),
                new String[]{"09","10","02","03","04","05","06","07","08"});
        assertEquals("02",arrayQ.peek());
        assertEquals(9,arrayQ.size());
        assertEquals(arrayQ.getFront(), 2);
        arrayQ.enqueue("11");
        assertArrayEquals(arrayQ.getBackingArray(),
                new String[]{"02","03","04","05","06","07","08","09","10","11",null,null,null
                ,null,null,null,null,null});
        assertEquals("02",arrayQ.peek());
        assertEquals(10,arrayQ.size());
        assertEquals(arrayQ.getFront(), 0);
        assertEquals("02",arrayQ.dequeue());
        assertEquals("03",arrayQ.dequeue());
        assertArrayEquals(arrayQ.getBackingArray(),
                new String[]{null,null,"04","05","06","07","08","09","10","11",null,null,null
                        ,null,null,null,null,null});
        assertEquals(arrayQ.getFront(), 2);
        assertEquals(8,arrayQ.size());
        assertEquals("04",arrayQ.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            linkedQ.enqueue(null);
        });
        assertThrows(NoSuchElementException.class, () -> {
            linkedQ.dequeue();
        });
        assertThrows(NoSuchElementException.class, () -> {
            linkedQ.peek();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueue() {
        linkedQ.enqueue("00");
        linkedQ.enqueue("01");
        linkedQ.enqueue("02");
        linkedQ.enqueue("03");
        linkedQ.enqueue("04");
        assertEquals(5,linkedQ.size());
        assertEquals("00",linkedQ.peek());
        assertEquals("00",linkedQ.dequeue());
        assertEquals("01",linkedQ.dequeue());
        assertEquals(3,linkedQ.size());
        assertEquals(linkedQ.getHead().getData(), "02");
        assertEquals(linkedQ.getTail().getData(), "04");
        assertEquals("02",linkedQ.peek());
        linkedQ.enqueue("05");
        assertEquals("02",linkedQ.peek());
        assertEquals(4,linkedQ.size());
        assertEquals(linkedQ.getHead().getData(), "02");
        assertEquals(linkedQ.getTail().getData(), "05");
        assertEquals("02",linkedQ.dequeue());
        assertEquals("03",linkedQ.dequeue());
        assertEquals(linkedQ.getHead().getData(), "04");
        assertEquals(linkedQ.getTail().getData(), "05");
        assertEquals(2,linkedQ.size());
        assertEquals("04",linkedQ.peek());
        assertEquals("04",linkedQ.dequeue());
        assertEquals("05",linkedQ.dequeue());
        linkedQ.enqueue("06");
        assertEquals(linkedQ.getHead().getData(), "06");
        assertEquals(linkedQ.getTail().getData(), "06");
        assertEquals(1,linkedQ.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            arraySt.push(null);
        });
        assertThrows(NoSuchElementException.class, () -> {
            arraySt.pop();
        });
        assertThrows(NoSuchElementException.class, () -> {
            arraySt.peek();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStack() {
        arraySt.push("00");
        arraySt.push("01");
        arraySt.push("02");
        arraySt.push("03");
        arraySt.push("04");
        arraySt.push("05");
        assertEquals(arraySt.size(),6);
        assertEquals(arraySt.getBackingArray(),
                new String[]{"00","01","02","03","04","05",null,null,null});
        assertEquals(arraySt.pop(),"05");
        assertEquals(arraySt.pop(),"04");
        assertEquals(arraySt.size(),4);
        arraySt.push("06");
        arraySt.push("07");
        arraySt.push("08");
        arraySt.push("09");
        arraySt.push("10");
        assertArrayEquals(arraySt.getBackingArray(),
                new String[]{"00","01","02","03","06","07","08","09","10"});
        assertEquals(arraySt.size(),9);
        arraySt.push("11");
        assertArrayEquals(arraySt.getBackingArray(),
                new String[]{"00","01","02","03","06","07","08","09","10","11"
                ,null,null,null,null,null,null,null,null});
        assertEquals(arraySt.size(),10);
        assertEquals(arraySt.pop(),"11");
        assertEquals(arraySt.pop(),"10");
        assertEquals(arraySt.size(),8);
        assertArrayEquals(arraySt.getBackingArray(),
                new String[]{"00","01","02","03","06","07","08","09",null,null
                        ,null,null,null,null,null,null,null,null});
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStackExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            linkedSt.push(null);
        });
        assertThrows(NoSuchElementException.class, () -> {
            linkedSt.pop();
        });
        assertThrows(NoSuchElementException.class, () -> {
            linkedSt.peek();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStack() {
        linkedSt.push("00");
        linkedSt.push("01");
        linkedSt.push("02");
        linkedSt.push("03");
        linkedSt.push("04");
        assertEquals(5,linkedSt.size());
        assertEquals("04",linkedSt.peek());
        assertEquals("04",linkedSt.pop());
        assertEquals("03",linkedSt.pop());
        assertEquals(3,linkedSt.size());
        assertEquals(linkedSt.getHead().getData(), "02");
        assertEquals("02",linkedSt.peek());
        linkedSt.push("05");
        assertEquals("05",linkedSt.peek());
        assertEquals(4,linkedSt.size());
        assertEquals(linkedSt.getHead().getData(), "05");
        assertEquals("05",linkedSt.pop());
        assertEquals("02",linkedSt.pop());
        assertEquals(linkedSt.getHead().getData(), "01");
        assertEquals(2,linkedSt.size());
        assertEquals("01",linkedSt.peek());
        assertEquals("01",linkedSt.pop());
        assertEquals("00",linkedSt.pop());
        linkedSt.push("06");
        assertEquals(linkedSt.getHead().getData(), "06");
        assertEquals(1,linkedSt.size());
    }
}