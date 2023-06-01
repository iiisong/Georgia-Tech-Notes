import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Custom set of JUnit tests for ArrayList edge cases.
 *
 * @author Sammy Taubman
 * @version 1.0.0
 */
public class ArrayListCustomTest {
    private static final int TIMEOUT = 200;
    private ArrayList<String> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testEmptyRemoveFromBack() { list.removeFromBack(); }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testEmptyRemoveFromFront() { list.removeFromFront(); }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testNegativeRemoveIndex() {
        list.addToFront("1");
        list.removeAtIndex(-1); }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveIndex() {
        list.addToFront("1");
        list.removeAtIndex(1);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromLastIndex() {
        list.addToBack("1");
        list.addToBack("2");
        list.addToBack("3");
        assertEquals("3", list.removeAtIndex(2));
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testNegativeGetIndex() {
        list.addToFront("1");
        list.removeAtIndex(-1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testInvalidGetIndex() {
        list.addToFront("1");
        list.removeAtIndex(1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullAddFront() {
        list.addToFront("1");
        list.addToFront(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullAddBack() {
        list.addToBack("1");
        list.addToBack(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullAddIndex() {
        list.addAtIndex(0, "1");
        list.addAtIndex(0, null);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testNegativeAddIndex() {
        list.addAtIndex(0, "1");
        list.addAtIndex(-1, null);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testInvalidAddIndex() {
        list.addAtIndex(0, "1");
        list.addAtIndex(2, null);
    }

    @Test(timeout=TIMEOUT)
    public void testAddFrontAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addToFront("" + i);
        }
        Object[] backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY, backing.length);

        list.addToFront("a");
        backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY * 2, backing.length);
        assertEquals(10, list.size());
    }

    @Test(timeout=TIMEOUT)
    public void testAddBackAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addToBack("" + i);
        }
        Object[] backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY, backing.length);

        list.addToBack("a");
        backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY * 2, backing.length);
        assertEquals(10, list.size());
    }

    @Test(timeout=TIMEOUT)
    public void testAddIndexMiddleAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addAtIndex(i / 2, "" + i);
        }
        Object[] backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY, backing.length);

        list.addAtIndex(ArrayList.INITIAL_CAPACITY / 2, "a");
        backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY * 2, backing.length);
        assertEquals(10, list.size());
    }

    @Test(timeout=TIMEOUT)
    public void testAddIndexEndAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addAtIndex(i, "" + i);
        }
        Object[] backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY, backing.length);

        list.addAtIndex(ArrayList.INITIAL_CAPACITY, "a");
        backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY * 2, backing.length);
        assertEquals(ArrayList.INITIAL_CAPACITY + 1, list.size());
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveBackAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addToFront("" + i);
        }
        assertEquals(list.removeFromBack(), "0");
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveFrontAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addToBack("" + i);
        }
        assertEquals(list.removeFromFront(), "0");
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveIndexAtFullCapacity() {
        for (int i = 0; i < ArrayList.INITIAL_CAPACITY; i++) {
            list.addToBack("" + i);
        }
        assertEquals(list.removeAtIndex(1), "1");
    }

    @Test(timeout=TIMEOUT)
    public void testIncreaseCapacityTwice() {
        for (int i = 0; i <= ArrayList.INITIAL_CAPACITY * 2; i++) {
            list.addToBack("" + i);
        }
        Object[] backing = list.getBackingArray();
        assertEquals(ArrayList.INITIAL_CAPACITY * 4, backing.length);
        assertEquals(ArrayList.INITIAL_CAPACITY * 2 + 1, list.size());
    }
}