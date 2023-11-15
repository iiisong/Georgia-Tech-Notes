import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import org.junit.Assert;

public class Qzheng75Test {
    private static final int TIMEOUT = 200;
    private CircularSinglyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new CircularSinglyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        Assert.assertEquals(0, list.size());
        Assert.assertNull(list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            list.addAtIndex(0, null);
        });
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addAtIndex(1, 7);
        });
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addAtIndex(-1, 7);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, 3);
        list.addAtIndex(1, 4);
        list.addAtIndex(0, 1);
        list.addAtIndex(3, 5);

        Assert.assertEquals(4, list.size());
        Object[] arr = new Object[] {1, 3, 4, 5};

        Assert.assertArrayEquals(arr, list.toArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            list.addToFront(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront(5);
        list.addToFront(4);
        list.addToFront(3);
        list.addToFront(1);

        Assert.assertEquals(4, list.size());
        Object[] arr = new Object[] {1, 3, 4, 5};

        Assert.assertArrayEquals(arr, list.toArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            list.addToBack(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(5);

        Assert.assertEquals(4, list.size());
        Object[] arr = new Object[] {1, 3, 4, 5};

        Assert.assertArrayEquals(arr, list.toArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFrontException() {
        Assert.assertThrows(NoSuchElementException.class, () -> {
            list.removeFromFront();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveBackException() {
        Assert.assertThrows(NoSuchElementException.class, () -> {
            list.removeFromBack();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexException() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(-1);
        });
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(9);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFront() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(5);
        int i = list.size();
        while (!list.isEmpty()) {
            Assert.assertEquals(list.get(0), list.removeFromFront());
            Assert.assertEquals(list.size(), --i);
        }
        Assert.assertNull(list.getHead());
        Assert.assertEquals(list.size(), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveBack() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(5);
        int i = list.size();
        while (!list.isEmpty()) {
            Assert.assertEquals(list.get(i - 1), list.removeFromBack());
            Assert.assertEquals(list.size(), --i);
        }
        Assert.assertNull(list.getHead());
        Assert.assertEquals(list.size(), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveIndex() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(5);
        int i = list.size();
        while (!list.isEmpty()) {
            int n = (int) (Math.random() * list.size());
            Assert.assertEquals(list.get(n), list.removeAtIndex(n));
            Assert.assertEquals(list.size(), --i);
        }
        Assert.assertNull(list.getHead());
        Assert.assertEquals(list.size(), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(1);
        list.addToBack(4);
        list.addToBack(5);
        list.addToBack(5);
        list.addToBack(7);
        Object[] arr = new Object[]{1, 3, 1, 4, 5, 5, 7};
        for (int i = 0; i < 100; ++i) {
            int n = (int) (Math.random() * list.size());
            Assert.assertEquals(arr[n], list.get(n));
        }
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrence() {
        list.addToBack(1);
        list.addToBack(3);
        list.addToBack(5);
        list.addToBack(4);
        list.addToBack(5);
        list.addToBack(5);
        list.addToBack(7);
        int n = list.size();
        Object[] arr = new Object[]{3, 5, 4, 5, 5, 7};
        Assert.assertEquals((Object) 1, list.removeLastOccurrence(1));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        arr = new Object[]{3, 5, 4, 5, 7};
        Assert.assertEquals((Object) 5, list.removeLastOccurrence(5));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        arr = new Object[]{3, 5, 4, 5};
        Assert.assertEquals((Object) 7, list.removeLastOccurrence(7));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        arr = new Object[]{3, 5, 5};
        Assert.assertEquals((Object) 4, list.removeLastOccurrence(4));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        arr = new Object[]{3, 5};
        Assert.assertEquals((Object) 5, list.removeLastOccurrence(5));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        Assert.assertThrows(NoSuchElementException.class, () -> {
            list.removeLastOccurrence(1);
        });

        arr = new Object[]{3};
        Assert.assertEquals((Object) 5, list.removeLastOccurrence(5));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        Assert.assertThrows(NoSuchElementException.class, () -> {
            list.removeLastOccurrence(1);
        });

        arr = new Object[]{};
        Assert.assertEquals((Object) 3, list.removeLastOccurrence(3));
        Assert.assertEquals(--n, list.size());
        Assert.assertArrayEquals(arr, list.toArray());

        list.clear();
        Assert.assertThrows(NoSuchElementException.class, () -> {
            list.removeLastOccurrence(1);
        });
    }
}