import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Binary Search Tree JUnits
 * @author Lucian Tash
 * @version 1.0
 */
public class LucianTests {

    private static final int TIMEOUT = 200;
    private BST<Integer> tree;

    @Before
    public void setup() {
        tree = new BST<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        // Empty list
        List<Integer> data = new ArrayList<>();
        tree = new BST<>(data);
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());

        // Just root
        data.add(13);
        tree = new BST<>(data);
        assertEquals(1, tree.size());
        assertEquals((Integer) 13, tree.getRoot().getData());

        // Normal tree
        data.add(2);
        data.add(1);
        data.add(6);
        data.add(8);
        data.add(7);
        data.add(14);
        data.add(18);
        data.add(15);
        tree = new BST<>(data);
        assertEquals(9, tree.size());

        // Duplicate data should not be added and size not incremented
        data.add(1);
        data.add(6);
        tree = new BST<>(data);
        assertEquals(9, tree.size());

        // Check structure of tree
        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getLeft().getData());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorNullList() {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(null);
        tree = new BST<>(data);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorListWithNull() {
        List<Integer> data = null;
        tree = new BST<>(data);
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        tree = new BST<>();
        tree.add(13);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        assertEquals(9, tree.size());

        // Duplicate data should not be added and size not incremented
        tree.add(18);
        tree.add(7);
        assertEquals(9, tree.size());

        // Check structure of tree
        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getLeft().getData());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNull() {
        tree = new BST<>();
        tree.add(null);
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        // Make tree
        tree = new BST<>();
        Integer[] data = {13, 2, 1, 6, 8, 7, 14, 18, 15};
        for (Integer i : data) { tree.add(i); }
        assertEquals(9, tree.size());
        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 15, tree.getRoot().getRight().getRight().getLeft().getData());

        // Remove leaf
        assertSame(data[8], tree.remove(15));
        assertEquals(8, tree.size());
        assertEquals((Integer) 13, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 14, tree.getRoot().getRight().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getRight().getData());
        assertNull(tree.getRoot().getRight().getRight().getLeft());

        // Remove root
        assertSame(data[0], tree.remove(13));
        assertEquals(7, tree.size());
        assertEquals((Integer) 14, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getRight().getRight());

        // Remove node with one child
        assertSame(data[3], tree.remove(6));
        assertEquals(6, tree.size());
        assertEquals((Integer) 14, tree.getRoot().getData());
        assertEquals((Integer) 2, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getLeft().getRight().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getRight().getLeft().getLeft());

        // Remove node with two children
        assertSame(data[1], tree.remove(2));
        assertEquals(5, tree.size());
        assertEquals((Integer) 14, tree.getRoot().getData());
        assertEquals((Integer) 7, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 8, tree.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 18, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getLeft().getRight().getRight());
        assertNull(tree.getRoot().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft().getRight());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft());

        // More tests (creates degenerate tree)
        Integer[] data2 = {19, 24, 20, 21, 23, 22};
        for (Integer i : data2) { tree.add(i); }
        assertEquals(11, tree.size());
        assertSame(data[6], tree.remove(14));
        assertSame(data[5], tree.remove(7));
        assertSame(data[2], tree.remove(1));
        assertSame(data[4], tree.remove(8));
        assertEquals(7, tree.size());
        assertNull(tree.getRoot().getLeft());

        // Remove degenerate tree root
        assertEquals((Integer) 18, tree.remove(data[7]));

        // Remove from middle of degenerate tree
        assertEquals((Integer) 21, tree.remove(data2[3]));

        // Remove from end of degenerate tree
        assertEquals((Integer) 22, tree.remove(data2[5]));

        // Check remaining tree
        assertEquals((Integer) 19, tree.getRoot().getData());
        assertEquals((Integer) 24, tree.getRoot().getRight().getData());
        assertEquals((Integer) 20, tree.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 23, tree.getRoot().getRight().getLeft().getRight().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
        assertNull(tree.getRoot().getRight().getLeft().getLeft());
        assertNull(tree.getRoot().getRight().getLeft().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getLeft().getRight().getRight());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromEmptyTree() {
        tree = new BST<>();
        tree.remove(0);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveDoesNotExist() {
        tree = new BST<>();
        tree.add(1);
        tree.remove(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        tree = new BST<>();
        tree.add(1);
        tree.remove(null);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        Integer temp200 = 200;
        Integer temp185 = 185;
        Integer temp190 = 190;
        Integer temp195 = 195;
        Integer temp215 = 215;
        Integer temp205 = 205;
        Integer temp210 = 210;
        tree.add(temp200);
        tree.add(temp185);
        tree.add(temp190);
        tree.add(temp195);
        tree.add(temp215);
        tree.add(temp205);
        tree.add(temp210);
        assertEquals(7, tree.size());
        assertSame(temp185, tree.get(185));
        assertSame(temp190, tree.get(190));
        assertSame(temp195, tree.get(195));
        assertSame(temp200, tree.get(200));
        assertSame(temp205, tree.get(205));
        assertSame(temp210, tree.get(210));
        assertSame(temp215, tree.get(215));
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetFromEmptyList() {
        tree = new BST<>();
        tree.get(1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetNullTarget() {
        tree = new BST<>();
        tree.add(1);
        tree.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testTargetDataNotInTree() {
        tree = new BST<>();
        tree.add(1);
        tree.get(2);
    }


    @Test(timeout = TIMEOUT)
    public void testContains() {
        // Empty tree
        tree = new BST<>();
        assertTrue(!tree.contains(1));

        // Root
        tree.add(13);
        assertTrue(tree.contains(13));

        // Exists in tree
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        assertTrue(tree.contains(13));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(14));
        assertTrue(tree.contains(18));
        assertTrue(tree.contains(15));

        // Does not exist in tree
        assertTrue(!tree.contains(0));
        assertTrue(!tree.contains(10));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsNull() {
        tree = new BST<>();
        tree.add(1);
        tree.contains(null);
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {
        // Empty tree
        tree = new BST<>();
        List<Integer> preorder = new ArrayList<>();
        assertEquals(preorder, tree.preorder());

        // Root
        tree.add(13);
        preorder.add(13);
        assertEquals(preorder, tree.preorder());

        // Check sequence
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        preorder.add(2);
        preorder.add(1);
        preorder.add(6);
        preorder.add(8);
        preorder.add(7);
        preorder.add(14);
        preorder.add(18);
        preorder.add(15);

        // Should be [13, 2, 1, 6, 8, 7, 14, 18, 15]
        assertEquals(preorder, tree.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        // Empty tree
        tree = new BST<>();
        List<Integer> inorder = new ArrayList<>();
        assertEquals(inorder, tree.inorder());

        // Root
        tree.add(13);
        inorder.add(13);
        assertEquals(inorder, tree.inorder());

        // Check sequence
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        inorder.clear();
        inorder.add(1);
        inorder.add(2);
        inorder.add(6);
        inorder.add(7);
        inorder.add(8);
        inorder.add(13);
        inorder.add(14);
        inorder.add(15);
        inorder.add(18);

        // Should be [1, 2, 6, 7, 8, 13, 14, 15, 18]
        assertEquals(inorder, tree.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        // Empty tree
        tree = new BST<>();
        List<Integer> postorder = new ArrayList<>();
        assertEquals(postorder, tree.postorder());

        // Root
        tree.add(13);
        postorder.add(13);
        assertEquals(postorder, tree.postorder());

        // Check sequence
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        postorder.clear();
        postorder.add(1);
        postorder.add(7);
        postorder.add(8);
        postorder.add(6);
        postorder.add(2);
        postorder.add(15);
        postorder.add(18);
        postorder.add(14);
        postorder.add(13);

        // Should be [1, 7, 8, 6, 2, 15, 18, 14, 13]
        assertEquals(postorder, tree.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        // Empty tree
        tree = new BST<>();
        List<Integer> levelorder = new ArrayList<>();
        assertEquals(levelorder, tree.levelorder());

        // Root
        tree.add(13);
        levelorder.add(13);
        assertEquals(levelorder, tree.levelorder());

        // Check sequence
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        levelorder.add(2);
        levelorder.add(14);
        levelorder.add(1);
        levelorder.add(6);
        levelorder.add(18);
        levelorder.add(8);
        levelorder.add(15);
        levelorder.add(7);

        // Should be [13, 2, 14, 1, 6, 18, 8, 15, 7]
        assertEquals(levelorder, tree.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        // Empty tree (-1)
        tree = new BST<>();
        assertEquals(-1, tree.height());

        // Just root (0)
        tree.add(1);
        assertEquals(0, tree.height());

        // Degenerate tree
        tree = new BST<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        assertEquals(3, tree.height());

        // Larger tree
        tree = new BST<>();
        tree.add(13);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        assertEquals(4, tree.height());

        // Full complete tree
        tree = new BST<>();
        tree.add(4);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        assertEquals(2, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        // Empty tree (does nothing)
        tree = new BST<>();
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());
        tree.clear();
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());

        // Tree with data
        tree.add(13);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);
        assertEquals(9, tree.size());
        assertEquals((Integer) 13, tree.getRoot().getData());
        tree.clear();
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testKLargest() {
        // Empty tree (should be [])
        tree = new BST<>();
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, tree.kLargest(0));

        tree.add(13);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(7);
        tree.add(14);
        tree.add(18);
        tree.add(15);

        // k = 0 (should be [])
        assertEquals(expected, tree.kLargest(0));

        // k = 1 through size
        expected.clear();
        expected.add(18);
        assertEquals(expected, tree.kLargest(1)); // [18]
        expected.add(0, 15);
        assertEquals(expected, tree.kLargest(2)); // [18, 15]
        expected.add(0, 14);
        assertEquals(expected, tree.kLargest(3)); // [18, 15, 14]
        expected.add(0, 13);
        assertEquals(expected, tree.kLargest(4)); // [18, 15, 14, 13]
        expected.add(0, 8);
        assertEquals(expected, tree.kLargest(5)); // [18, 15, 14, 13, 8]
        expected.add(0, 7);
        assertEquals(expected, tree.kLargest(6)); // [18, 15, 14, 13, 8, 7]
        expected.add(0, 6);
        assertEquals(expected, tree.kLargest(7)); // [18, 15, 14, 13, 8, 7, 6]
        expected.add(0, 2);
        assertEquals(expected, tree.kLargest(8)); // [18, 15, 14, 13, 8, 7, 6, 2]
        expected.add(0, 1);
        assertEquals(expected, tree.kLargest(9)); // [18, 15, 14, 13, 8, 7, 6, 2, 1]
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testKLargestNegativeInput() {
        tree = new BST<>();
        tree.add(1);
        tree.kLargest(-1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testKLargestOOBInput() {
        tree = new BST<>();
        tree.add(1);
        tree.kLargest(2);
    }
}