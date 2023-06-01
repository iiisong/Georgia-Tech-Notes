import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author https://github.com/Ian-Boraks
 * @version 1.0
 */
public class IBorakTest {
    private static final int TIMEOUT = 200;
    private CircularSinglyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new CircularSinglyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackSizeOne() {
        list.addToFront("0a");

        assertEquals("0a", list.removeFromBack());
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFrontSizeOne() {
        list.addToFront("0a");

        assertEquals("0a", list.removeFromFront());
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexSizeOne() {
        list.addToFront("0a");

        assertEquals("0a", list.removeAtIndex(0));
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveMultipleFromFront() {
        list.addToFront("0a");
        list.addToFront("1b");
        list.addToFront("2c");
        list.addToFront("3d");

        assertEquals("3d", list.removeFromFront());
        assertEquals("2c", list.removeFromFront());
        assertEquals("1b", list.removeFromFront());
        assertEquals("0a", list.removeFromFront());
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveMultipleFromBack() {
        list.addToFront("0a");
        list.addToFront("1b");
        list.addToFront("2c");
        list.addToFront("3d");

        assertEquals("0a", list.removeFromBack());
        assertEquals("1b", list.removeFromBack());
        assertEquals("2c", list.removeFromBack());
        assertEquals("3d", list.removeFromBack());
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveMultipleAtIndex() {
        list.addToFront("0a");
        list.addToFront("1b");
        list.addToFront("2c");
        list.addToFront("3d");

        assertEquals("0a", list.removeAtIndex(3));
        assertEquals("1b", list.removeAtIndex(2));
        assertEquals("2c", list.removeAtIndex(1));
        assertEquals("3d", list.removeAtIndex(0));
        assertNull(list.getHead());
        assertEquals(0, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testToArrayWhenEmpty() {
        list.addToFront("0a");

        assertEquals("0a", list.removeFromBack());
        list.toArray();
    }

    @Test(timeout = TIMEOUT)
    public void testAddExceptions() {
        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.addAtIndex(-1, "a0"));

        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.addAtIndex(1, "a0"));

        assertThrows(
                IllegalArgumentException.class,
            () -> list.addAtIndex(0, null));

        assertThrows(
                IllegalArgumentException.class,
            () -> list.addToFront(null));

        assertThrows(
                IllegalArgumentException.class,
            () -> list.addToFront(null));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveExceptions() {
        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.removeAtIndex(-1));

        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.removeAtIndex(0));

        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.removeAtIndex(1));

        assertThrows(
                NoSuchElementException.class,
            () -> list.removeFromBack());

        assertThrows(
                NoSuchElementException.class,
            () -> list.removeFromFront());

        assertThrows(
                IllegalArgumentException.class,
            () -> list.removeLastOccurrence(null));

        for (int i = 0; i < 10; i++) {
            list.addToFront("a" + i);
        }

        assertThrows(
                NoSuchElementException.class,
            () -> list.removeLastOccurrence("b0"));

        list.clear();
    }

    @Test(timeout = TIMEOUT)
    public void testGetExceptions() {
        for (int i = 0; i < 10; i++) {
            list.addToFront("a" + i);
        }

        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.get(12));

        assertThrows(
                IndexOutOfBoundsException.class,
            () -> list.get(-1));
    }
}