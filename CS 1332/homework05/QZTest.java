import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
public class QZTest {

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
    public void testBuildHeap01() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(1, 3, 5, 4, 6, 13));
        heap = new MaxHeap<>(data);
        assertEquals(6, heap.size());
        Integer[] expectedArr = new Integer[] {null,13,6,5,4,3,1,null,null,null,null,null,null};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap02() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17, 0, 12, 14));
        heap = new MaxHeap<>(data);
        assertEquals(14, heap.size());
        Integer[] expectedArr = new Integer[] {null,17,15,14,9,6,13,10,4,8,3,1,0,12,5,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap03() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(44, 65, 48, 23, 41, 96, 62, 88, 39, 74, 33, 95, 72, 50, 2,
                71, 66, 21, 27, 35, 69, 97, 36, 84, 9, 59));
        heap = new MaxHeap<>(data);
        assertEquals(26, heap.size());
        Integer[] expectedArr = new Integer[] {null,97, 88, 96, 71, 74, 95, 62, 66, 39, 69, 41, 84, 72, 50, 2, 23, 44,
                21, 27, 35, 65, 33, 36, 48, 9, 59,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap04() {
        ArrayList<Integer> data = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new MaxHeap<>(data);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap05() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(4, 5, null, 7));
        assertThrows(IllegalArgumentException.class, () -> {
            new MaxHeap<>(data);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddToHeap01() {
        int[] toAdd = new int[]{59, 43, 4, 75, 92, 79, 26, 45, 88};
        for (int num : toAdd) {
            heap.add(num);
        }
        assertEquals(9, heap.size());
        Integer[] expectedArr = new Integer[]{null, 92, 88, 79, 75, 59, 4, 26, 43, 45,
                null, null, null};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToHeap02() {
        int[] toAdd = new int[]{76, 27, 32, 81, 64, 71, 5, 89, 22, 61, 83, 17, 96};
        for (int num : toAdd) {
            heap.add(num);
        }
        assertEquals(13, heap.size());
        Integer[] expectedArr = new Integer[]{null, 96, 83, 89, 76, 81, 71, 5, 27, 22, 61, 64, 17, 32,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToHeap03() {
        int[] toAdd = new int[]{16, 73, 91, 89, 4, 59, 93, 2, 34, 83, 98, 44, 48, 76, 12, 32, 97, 42, 13, 14, 18,
                7, 88, 64, 81};
        for (int num : toAdd) {
            heap.add(num);
        }
        assertEquals(25, heap.size());
        Integer[] expectedArr = new Integer[]{null, 98, 97, 91, 93, 89, 81, 76, 34, 42, 18, 88, 64, 48, 73, 12, 2, 32,
                16, 13, 4, 14, 7, 83, 44, 59};
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddToHeap04() {
        assertThrows(IllegalArgumentException.class, () -> {
            heap.add(5);
            heap.add(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromHeap01() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(40, 5, 94, 2, 47, 55, 57, 73, 74));
        heap = new MaxHeap<>(data);
        Integer[] expectedArr = new Integer[] {null, 94, 74, 57, 73, 47, 55, 40, 5, 2, null, null, null, null, null,
            null, null, null, null};
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 74, 73, 57, 5, 47, 55, 40, 2, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 94, heap.remove());
        assertEquals(8, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 73, 47, 57, 5, 2, 55, 40, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 74, heap.remove());
        assertEquals(7, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 57, 47, 55, 5, 2, 40, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 73, heap.remove());
        assertEquals(6, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 55, 47, 40, 5, 2, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 57, heap.remove());
        assertEquals(5, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 47, 5, 40, 2, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 55, heap.remove());
        assertEquals(4, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 40, 5, 2, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 47, heap.remove());
        assertEquals(3, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 5, 2, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 40, heap.remove());
        assertEquals(2, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, 2, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 5, heap.remove());
        assertEquals(1, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());

        expectedArr = new Integer[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null};
        assertEquals((Integer) 2, heap.remove());
        assertEquals(0, heap.size());
        assertArrayEquals(expectedArr, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromHeap02() {
        assertThrows(NoSuchElementException.class, () -> {
            heap.add(1);
            heap.remove();
            heap.remove();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testGetMaxHeap01() {
        int[] toAdd = new int[]{16, 73, 91, 89, 89, 4, 59, 93, 2, 34, 83, 98, 44, 48, 76, 12, 32, 97, 42, 13, 14, 18,
                7, 88, 64, 81, 7};
        int max = Integer.MIN_VALUE;
        for (int num : toAdd) {
            max = Math.max(max, num);
            heap.add(num);
            assertEquals((Integer) max, heap.getMax());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testGetMaxHeap02() {
        assertThrows(NoSuchElementException.class, () -> {
            heap.add(1);
            heap.remove();
            heap.getMax();
        });
    }

    @Test(timeout = TIMEOUT)
    public void testMisc() {
        assertTrue(heap.isEmpty());
        heap.add(5);
        heap.add(8);
        heap.clear();
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
        heap.add(5);
        heap.add(8);
        heap.remove();
        heap.remove();
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
 }