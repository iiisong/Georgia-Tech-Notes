import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class KothapalliTests {
    private static final int TIMEOUT = 200;
    private MaxHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, heap.size());
        assertArrayEquals(new Comparable[MaxHeap.INITIAL_CAPACITY],
                heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        heap.add(20);
        heap.add(17);
        heap.add(8);
        heap.add(1);
        heap.add(18);
        heap.add(13);
        heap.add(30);
        heap.add(4);
        heap.add(16);
        heap.add(14);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 8, 13, 1, 4, 14, null, null},
                heap.getBackingArray()
        );
    }

    @Test(timeout = TIMEOUT)
    public void testAddWithMoreThanIntialCap() {
        heap.add(20);
        heap.add(17);
        heap.add(8);
        heap.add(1);
        heap.add(18);
        heap.add(13);
        heap.add(30);
        heap.add(4);
        heap.add(16);
        heap.add(14);
        heap.add(7);
        heap.add(23);
        heap.add(19);
        heap.add(12);
        heap.add(29);
        assertEquals(15, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 29, 16, 17, 20, 23, 1, 4, 14, 7, 8, 19, 12, 13,
                        null, null, null, null, null, null, null, null, null, null},
                heap.getBackingArray()
        );
    }

    @Test(timeout = TIMEOUT)
    public void testAddThroughBuildHeap() {
        ArrayList<Integer> build = new ArrayList<>();
        build.add(20);
        build.add(17);
        build.add(8);
        build.add(1);
        build.add(18);
        build.add(13);
        build.add(30);
        build.add(4);
        build.add(16);
        build.add(14);
        heap = new MaxHeap<>(build);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 13, 8, 4, 1, 14,
                        null, null, null, null, null, null, null, null, null, null},
                heap.getBackingArray()
        );
    }


    @Test(timeout = TIMEOUT)
    public void testRemove() {
        heap.add(20);
        heap.add(17);
        heap.add(8);
        heap.add(1);
        heap.add(18);
        heap.add(13);
        heap.add(30);
        heap.add(4);
        heap.add(16);
        heap.add(14);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 8, 13, 1, 4, 14, null, null},
                heap.getBackingArray()
        );
        assertEquals((Integer) 30, heap.remove());
        assertEquals((Integer) 20, heap.remove());
        assertEquals((Integer) 18, heap.remove());
        assertArrayEquals(new Comparable[]{null, 17, 16, 14, 1, 4, 8, 13,
                        null, null, null, null, null},
                heap.getBackingArray()
        );
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveBuildHeap() {
        ArrayList<Integer> build = new ArrayList<>();
        build.add(20);
        build.add(17);
        build.add(8);
        build.add(1);
        build.add(18);
        build.add(13);
        build.add(30);
        build.add(4);
        build.add(16);
        build.add(14);
        heap = new MaxHeap<>(build);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 13, 8, 4, 1, 14,
                        null, null, null, null, null, null, null, null, null, null},
                heap.getBackingArray()
        );
        assertEquals((Integer) 30, heap.remove());
        assertEquals((Integer) 20, heap.remove());
        assertEquals((Integer) 18, heap.remove());
        assertArrayEquals(new Comparable[]{null, 17, 16, 14, 4, 1, 13, 8,
                        null, null, null, null, null, null, null, null, null, null, null, null, null},
                heap.getBackingArray()
        );
    }

    @Test(timeout = TIMEOUT)
    public void testExceptionsDuringBuildHeap01() {
        ArrayList<Integer> build = new ArrayList<>();
        build.add(20);
        build.add(17);
        build.add(8);
        build.add(null);
        build.add(18);
        build.add(13);
        build.add(30);
        build.add(4);
        build.add(16);
        build.add(14);
        assertThrows(IllegalArgumentException.class, () -> {
            heap = new MaxHeap<>(build);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testExceptionsDuringBuildHeap02() {
        ArrayList<Integer> build = null;
        assertThrows(IllegalArgumentException.class, () -> {
            heap = new MaxHeap<>(build);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testExceptionsDuringAdd() {
        assertThrows(IllegalArgumentException.class, () -> {
            heap.add(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testExceptionsDuringRemove() {
        heap.add(4);
        assertEquals((Integer) 4, heap.remove());
        assertThrows(NoSuchElementException.class, () -> {
            heap.remove();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testExceptionsDuringGetMax() {
        assertThrows(NoSuchElementException.class, () -> {
            heap.getMax();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testGetMax() {
        heap.add(20);
        heap.add(17);
        heap.add(8);
        heap.add(1);
        heap.add(18);
        heap.add(13);
        heap.add(30);
        heap.add(4);
        heap.add(16);
        heap.add(14);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 8, 13, 1, 4, 14, null, null},
                heap.getBackingArray()
        );
        assertEquals((Integer) 30, heap.getMax());
        assertEquals((Integer) 30, heap.remove());
        assertEquals((Integer) 20, heap.getMax());
        assertEquals((Integer) 20, heap.remove());
        assertEquals((Integer) 18, heap.getMax());
        assertEquals((Integer) 18, heap.remove());
        assertArrayEquals(new Comparable[]{null, 17, 16, 14, 1, 4, 8, 13,
                        null, null, null, null, null},
                heap.getBackingArray()
        );
    }

    @Test(timeout = TIMEOUT)
    public void testClearAndisEmpty() {
        heap.add(20);
        heap.add(17);
        heap.add(8);
        heap.add(1);
        heap.add(18);
        heap.add(13);
        heap.add(30);
        heap.add(4);
        heap.add(16);
        heap.add(14);
        assertEquals(10, heap.size());
        assertArrayEquals(new Comparable[]{null, 30, 18, 20, 16, 17, 8, 13, 1, 4, 14, null, null},
                heap.getBackingArray()
        );
        heap.clear();
        assertEquals(0, heap.size());
        assertEquals(true, heap.isEmpty());
        assertArrayEquals(new Comparable[]{null, null, null, null, null, null, null, null, null, null, null, null, null},
                heap.getBackingArray()
        );
    }
}