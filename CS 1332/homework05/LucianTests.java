import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * MaxHeap JUnit Tests - Spring 2023
 *
 * @author Lucian Tash
 * @version 1.0
 */
public class LucianTests {

    private static final int TIMEOUT = 200;
    private MaxHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, heap.size());
        assertEquals(13, ((Comparable[]) heap.getBackingArray()).length);
        assertArrayEquals(new Comparable[MaxHeap.INITIAL_CAPACITY], heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap() {
        // Heap A (size=10)
        // Data input: [52, 23, 13, 8, 17, 7, 12, 0, 1, 2]
        // Backing array: [null, 52, 23, 13, 8, 17, 7, 12, 0, 1, 2]
        ArrayList<Integer> data = new ArrayList<>();
        data.add(52);
        data.add(23);
        data.add(13);
        data.add(8);
        data.add(17);
        data.add(7);
        data.add(12);
        data.add(0);
        data.add(1);
        data.add(2);
        heap = new MaxHeap<>(data);
        assertEquals(10, heap.size());
        Integer[] expected = new Integer[10 * 2 + 1];
        expected[1] = 52;
        expected[2] = 23;
        expected[3] = 13;
        expected[4] = 8;
        expected[5] = 17;
        expected[6] = 7;
        expected[7] = 12;
        expected[8] = 0;
        expected[9] = 1;
        expected[10] = 2;
        assertArrayEquals(expected, heap.getBackingArray());

        // Heap B (size=16)
        // Data input: [12, 6, 5, 17, 13, 18, 16, 4, 11, 19, 2, 20, 3, 15, 7, 30]
        // Backing array: [null, 30, 19, 20, 17, 13, 18, 16, 6, 11, 2, 5, 3, 15, 7, 4]
        data = new ArrayList<>();
        data.add(12);
        data.add(6);
        data.add(5);
        data.add(17);
        data.add(13);
        data.add(18);
        data.add(16);
        data.add(4);
        data.add(11);
        data.add(19);
        data.add(2);
        data.add(20);
        data.add(3);
        data.add(15);
        data.add(7);
        data.add(30);
        heap = new MaxHeap<>(data);
        assertEquals(16, heap.size());
        expected = new Integer[16 * 2 + 1];
        expected[1] = 30;
        expected[2] = 19;
        expected[3] = 20;
        expected[4] = 17;
        expected[5] = 13;
        expected[6] = 18;
        expected[7] = 16;
        expected[8] = 6;
        expected[9] = 11;
        expected[10] = 12;
        expected[11] = 2;
        expected[12] = 5;
        expected[13] = 3;
        expected[14] = 15;
        expected[15] = 7;
        expected[16] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        // Heap C (size=1)
        // Data input: [1]
        // Backing array: [null, 1]
        data = new ArrayList<>();
        data.add(1);
        heap = new MaxHeap<>(data);
        assertEquals(1, heap.size());
        expected = new Integer[1 * 2 + 1];
        expected[1] = 1;
        assertArrayEquals(expected, heap.getBackingArray());

        // Heap D (size=30 for fun!)
        // Data input: [25, 1, 31, 22, 14, 3, 11, 10, 23, 5, 28, 4, 26, 9, 8, 15, 24, 19, 30, 7, 12, 32, 36, 6, 29, 17, 37, 2, 18, 20]
        // Backing array: [null, 37, 36, 31, 30, 32, 29, 20, 24, 23, 12, 28, 25, 26, 18, 11, 15, 10, 19, 22, 7, 5, 14, 1, 6, 4, 17, 3, 2, 9, 8]
        data = new ArrayList<>();
        data.add(25);
        data.add(1);
        data.add(31);
        data.add(22);
        data.add(14);
        data.add(3);
        data.add(11);
        data.add(10);
        data.add(23);
        data.add(5);
        data.add(28);
        data.add(4);
        data.add(26);
        data.add(9);
        data.add(8);
        data.add(15);
        data.add(24);
        data.add(19);
        data.add(30);
        data.add(7);
        data.add(12);
        data.add(32);
        data.add(36);
        data.add(6);
        data.add(29);
        data.add(17);
        data.add(37);
        data.add(2);
        data.add(18);
        data.add(20);
        heap = new MaxHeap<>(data);
        assertEquals(30, heap.size());
        expected = new Integer[30 * 2 + 1];
        expected[1] = 37;
        expected[2] = 36;
        expected[3] = 31;
        expected[4] = 30;
        expected[5] = 32;
        expected[6] = 29;
        expected[7] = 20;
        expected[8] = 24;
        expected[9] = 23;
        expected[10] = 12;
        expected[11] = 28;
        expected[12] = 25;
        expected[13] = 26;
        expected[14] = 18;
        expected[15] = 11;
        expected[16] = 15;
        expected[17] = 10;
        expected[18] = 19;
        expected[19] = 22;
        expected[20] = 7;
        expected[21] = 5;
        expected[22] = 14;
        expected[23] = 1;
        expected[24] = 6;
        expected[25] = 4;
        expected[26] = 17;
        expected[27] = 3;
        expected[28] = 2;
        expected[29] = 9;
        expected[30] = 8;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullDataItem() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(null);
        data.add(3);
        heap = new MaxHeap<>(data);

        data.clear();
        data.add(null);
        data.add(1);
        data.add(2);
        data.add(3);
        heap = new MaxHeap<>(data);

        data.clear();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(null);
        heap = new MaxHeap<>(data);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullDataList() {
        ArrayList<Integer> data = null;
        heap = new MaxHeap<>(data);
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        // Heap B (size=16)
        // Add order: 12, 6, 5, 17, 13, 18, 16, 4, 11, 19, 2, 20, 3, 15, 7, 30
        // Backing array: [null, 30, 20, 19, 18, 13, 17, 16, 11, 6, 12, 2, 5, 3, 15, 7, 4]
        heap = new MaxHeap<>();
        heap.add(12);
        heap.add(6);
        heap.add(5);
        heap.add(17);
        heap.add(13);
        heap.add(18);
        heap.add(16);
        heap.add(4);
        heap.add(11);
        heap.add(19);
        heap.add(2);
        heap.add(20);
        heap.add(3);
        heap.add(15);
        heap.add(7);
        heap.add(30);
        assertEquals(16, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY * 2];
        expected[1] = 30;
        expected[2] = 20;
        expected[3] = 19;
        expected[4] = 18;
        expected[5] = 13;
        expected[6] = 17;
        expected[7] = 16;
        expected[8] = 11;
        expected[9] = 6;
        expected[10] = 12;
        expected[11] = 2;
        expected[12] = 5;
        expected[13] = 3;
        expected[14] = 15;
        expected[15] = 7;
        expected[16] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        // Step by Step
        // Heap E (size=8)
        // Add order: 3, 7, 11, 10, 5, 12, 2, 15
        // Backing array: [null, 15, 12, 11, 10, 5, 7, 2, 3]
        heap = new MaxHeap<>();
        assertEquals(0, heap.size());
        heap.add(3);
        expected = new Integer[]{null, 3, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals(1, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(7);
        expected = new Integer[]{null, 7, 3, null, null, null, null, null, null, null, null, null, null};
        assertEquals(2, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(11);
        expected = new Integer[]{null, 11, 3, 7, null, null, null, null, null, null, null, null, null};
        assertEquals(3, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(10);
        expected = new Integer[]{null, 11, 10, 7, 3, null, null, null, null, null, null, null, null};
        assertEquals(4, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(5);
        expected = new Integer[]{null, 11, 10, 7, 3, 5, null, null, null, null, null, null, null};
        assertEquals(5, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(12);
        expected = new Integer[]{null, 12, 10, 11, 3, 5, 7, null, null, null, null, null, null};
        assertEquals(6, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(2);
        expected = new Integer[]{null, 12, 10, 11, 3, 5, 7, 2, null, null, null, null, null};
        assertEquals(7, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
        heap.add(15);
        expected = new Integer[]{null, 15, 12, 11, 10, 5, 7, 2, 3, null, null, null, null};
        assertEquals(8, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNullData() {
        heap = new MaxHeap<>();
        heap.add(null);
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        // Heap E (size=8)
        // Add order: 3, 7, 11, 10, 5, 12, 2, 15
        // Backing array: [null, 15, 12, 11, 10, 5, 7, 2, 3]
        heap = new MaxHeap<>();
        heap.add(3);
        heap.add(7);
        heap.add(11);
        heap.add(10);
        heap.add(5);
        heap.add(12);
        heap.add(2);
        heap.add(15);
        assertEquals(8, heap.size());

        // Remove 15
        assertEquals((Integer) 15, heap.remove());
        assertEquals(7, heap.size());
        Integer[] expected = new Integer[]{null, 12, 10, 11, 3, 5, 7, 2, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 12
        assertEquals((Integer) 12, heap.remove());
        assertEquals(6, heap.size());
        expected = new Integer[]{null, 11, 10, 7, 3, 5, 2, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 11
        assertEquals((Integer) 11, heap.remove());
        assertEquals(5, heap.size());
        expected = new Integer[]{null, 10, 5, 7, 3, 2, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 10
        assertEquals((Integer) 10, heap.remove());
        assertEquals(4, heap.size());
        expected = new Integer[]{null, 7, 5, 2, 3, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 7
        assertEquals((Integer) 7, heap.remove());
        assertEquals(3, heap.size());
        expected = new Integer[]{null, 5, 3, 2, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 5
        assertEquals((Integer) 5, heap.remove());
        assertEquals(2, heap.size());
        expected = new Integer[]{null, 3, 2, null, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 3
        assertEquals((Integer) 3, heap.remove());
        assertEquals(1, heap.size());
        expected = new Integer[]{null, 2, null, null, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());

        // Remove 2
        assertEquals((Integer) 2, heap.remove());
        assertEquals(0, heap.size());
        expected = new Integer[13];
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromEmpty() {
        heap = new MaxHeap<>();
        heap.remove();
    }

    @Test(timeout = TIMEOUT)
    public void testGetMax() {
        // Heap B (size=16)
        // Add order: 12, 6, 5, 17, 13, 18, 16, 4, 11, 19, 2, 20, 3, 15, 7, 30
        heap = new MaxHeap<>();
        heap.add(12);
        heap.add(6);
        heap.add(5);
        heap.add(17);
        heap.add(13);
        heap.add(18);
        heap.add(16);
        heap.add(4);
        heap.add(11);
        heap.add(19);
        heap.add(2);
        heap.add(20);
        heap.add(3);
        heap.add(15);
        heap.add(7);
        heap.add(30);
        assertEquals(16, heap.size());
        assertSame(30, heap.getMax());
        assertEquals(30, ((Comparable[]) heap.getBackingArray())[1]);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetMaxEmpty() {
        heap = new MaxHeap<>();
        heap.getMax();
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyFalse() {
        // Heap B (size=16)
        // Add order: 12, 6, 5, 17, 13, 18, 16, 4, 11, 19, 2, 20, 3, 15, 7, 30
        heap = new MaxHeap<>();
        heap.add(12);
        heap.add(6);
        heap.add(5);
        heap.add(17);
        heap.add(13);
        heap.add(18);
        heap.add(16);
        heap.add(4);
        heap.add(11);
        heap.add(19);
        heap.add(2);
        heap.add(20);
        heap.add(3);
        heap.add(15);
        heap.add(7);
        heap.add(30);
        assertEquals(16, heap.size());
        assertFalse(heap.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyTrue() {
        heap = new MaxHeap<>();
        assertTrue(heap.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        // Heap B (size=16)
        // Add order: 12, 6, 5, 17, 13, 18, 16, 4, 11, 19, 2, 20, 3, 15, 7, 30
        heap = new MaxHeap<>();
        heap.add(12);
        heap.add(6);
        heap.add(5);
        heap.add(17);
        heap.add(13);
        heap.add(18);
        heap.add(16);
        heap.add(4);
        heap.add(11);
        heap.add(19);
        heap.add(2);
        heap.add(20);
        heap.add(3);
        heap.add(15);
        heap.add(7);
        heap.add(30);
        heap.clear();
        assertEquals(0, heap.size());
        assertArrayEquals(new Comparable[MaxHeap.INITIAL_CAPACITY],
            heap.getBackingArray());
    }
}