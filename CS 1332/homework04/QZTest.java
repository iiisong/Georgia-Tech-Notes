import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QZTest<T extends Comparable<? super T>> {
    private static final int TIMEOUT = 200;
    private BST<String> tree;

    // Just a helper method :)
    private static boolean isValidBST(BSTNode<String> root) {
        return isValidBST(root, "0", "9999");
    }

    private static boolean isValidBST(BSTNode<String> root, String minVal, String maxVal) {
        if (root == null){
            return true;
        }

        if (root.getData().compareTo(maxVal) >= 0 || root.getData().compareTo(minVal) <= 0){
            System.err.println("You're not constructing a valid BST.");
            return false;
        }

        return isValidBST(root.getLeft(), minVal, root.getData())
                && isValidBST(root.getRight(), root.getData(), maxVal);
    }
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
    public void testAdd01() {
        tree = new BST<>(Arrays.asList("0000", "0001", "0002", "0003"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0000", "0001", "0002", "0003"), tree.preorder());
        assertEquals(4, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd02() {
        tree = new BST<>(Arrays.asList("0002", "0001", "0000", "0003"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0002", "0001", "0000", "0003"), tree.preorder());
        assertEquals(4, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd03() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060","0081","0014","0004"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0004", "0020", "0014",
                "0060", "0081"), tree.preorder());
        assertEquals(7, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd04() {
        tree = new BST<>();
        tree.add("0000");
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0000"), tree.preorder());
        assertEquals(1, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060","0014","0002","0016","0015","0018"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0002", "0020", "0014","0016","0015", "0018",
                "0060"), tree.preorder());
        assertEquals(9, tree.size());

        assertEquals("0002", tree.remove(new String("0002")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0020", "0014","0016","0015", "0018",
                "0060"), tree.preorder());
        assertEquals(8, tree.size());

        assertEquals("0060", tree.remove(new String("0060")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0020", "0014","0016","0015", "0018"), tree.preorder());
        assertEquals(7, tree.size());

        assertEquals("0008", tree.remove(new String("0008")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0014", "0003", "0020","0016","0015", "0018"), tree.preorder());
        assertEquals(6, tree.size());

        assertEquals("0016", tree.remove(new String("0016")));
        // System.out.println(tree.preorder());
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0014", "0003", "0020","0018", "0015"), tree.preorder());
        assertEquals(5, tree.size());

        assertEquals("0020", tree.remove(new String("0020")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0014", "0003", "0018", "0015"), tree.preorder());
        assertEquals(4, tree.size());

        assertEquals("0003", tree.remove(new String("0003")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0014", "0018", "0015"), tree.preorder());
        assertEquals(3, tree.size());

        assertEquals("0014", tree.remove(new String("0014")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0018", "0015"), tree.preorder());

        assertEquals("0015", tree.remove(new String("0015")));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0018"), tree.preorder());

        assertEquals("0018", tree.remove(new String("0018")));
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060","0014","0002","0016","0015","0018"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0002", "0020", "0014","0016","0015", "0018",
                "0060"), tree.preorder());
        assertEquals(9, tree.size());
        String target = new String("0015");
        String res = tree.get(target);
        assertTrue(res.equals(target));
        assertFalse(res == target);
        target = new String("0060");
        res = tree.get(target);
        assertTrue(res.equals(target));
        assertFalse(res == target);
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060","0014","0002","0016","0015","0018"));
        assertTrue(isValidBST(tree.getRoot()));
        assertEquals(Arrays.asList("0008", "0003", "0002", "0020", "0014","0016","0015", "0018",
                "0060"), tree.preorder());
        assertEquals(9, tree.size());
        String target = new String("0015");
        assertTrue(tree.contains(target));
        target = new String("0060");
        assertTrue(tree.contains(target));
        target = new String("0000");
        assertFalse(tree.contains(target));
        tree = new BST<>(Arrays.asList("0002", "0001", "0000", "0003"));
        target = new String("0000");
        assertTrue(tree.contains(target));
        target = new String("001");
        assertFalse(tree.contains(target));
        tree.clear();
        target = new String("0000");
        assertFalse(tree.contains(target));
        target = new String("001");
        assertFalse(tree.contains(target));
    }

    @Test(timeout = TIMEOUT)
    public void testTraversals() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060","0014","0002","0016","0015","0018"));
        assertEquals(Arrays.asList("0008", "0003", "0002", "0020", "0014","0016","0015", "0018",
                "0060"), tree.preorder());
        assertEquals(Arrays.asList("0002","0003","0008","0014","0015","0016","0018","0020","0060"),
                tree.inorder());
        assertEquals(Arrays.asList("0002","0003","0015","0018","0016","0014","0060","0020","0008"),
                tree.postorder());
        assertEquals(Arrays.asList("0008","0003","0020","0002","0014","0060","0016","0015","0018"),
                tree.levelorder());
        tree = new BST<>(Arrays.asList("0000","0001","0002","0003"));
        assertEquals(Arrays.asList("0000","0001","0002","0003"), tree.preorder());
        assertEquals(Arrays.asList("0000","0001","0002","0003"),
                tree.inorder());
        assertEquals(Arrays.asList("0003","0002","0001","0000"),
                tree.postorder());
        assertEquals(Arrays.asList("0000","0001","0002","0003"),
                tree.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        tree = new BST<>(Arrays.asList("0001", "0002"));
        assertEquals(1, tree.height());
        tree = new BST<>(Arrays.asList("0005", "0001", "0004", "0002", "0003"));
        assertEquals(4, tree.height());
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        assertEquals(5, tree.height());
        tree.clear();
        assertEquals(-1, tree.height());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        tree.clear();
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
        tree.clear();
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testKLargest() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        assertEquals(Arrays.asList("0020","0060"), tree.kLargest(2));
        assertEquals(Arrays.asList("0019","0020","0060"), tree.kLargest(3));
        assertEquals(Arrays.asList("0015","0016","0018","0019","0020","0060"), tree.kLargest(6));
        assertEquals(Arrays.asList("0008","0014","0015","0016","0018",
                "0019","0020","0060"), tree.kLargest(8));
        assertEquals(tree.inorder(), tree.kLargest(tree.size()));
    }

    @Test(timeout = TIMEOUT)
    public void testConstructException() {
        assertThrows(IllegalArgumentException.class, () -> {new BST<>(Arrays.asList("1000", null));});
    }

    @Test(timeout = TIMEOUT)
    public void testAddException() {
        assertThrows(IllegalArgumentException.class, () -> {tree.add(null);});
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveException() {
        assertThrows(IllegalArgumentException.class, () -> {tree.remove(null);});
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        assertThrows(NoSuchElementException.class, () -> {tree.remove("008");});
        assertThrows(NoSuchElementException.class, () -> {tree.remove("null");});
        assertThrows(NoSuchElementException.class, () -> {tree.remove("0000");});
    }

    @Test(timeout = TIMEOUT)
    public void testGetException() {
        assertThrows(IllegalArgumentException.class, () -> {tree.get(null);});
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        assertThrows(NoSuchElementException.class, () -> {tree.get("008");});
        assertThrows(NoSuchElementException.class, () -> {tree.get("null");});
        assertThrows(NoSuchElementException.class, () -> {tree.get("0000");});
    }

    @Test(timeout = TIMEOUT)
    public void testContainsException() {
        assertThrows(IllegalArgumentException.class, () -> {tree.contains(null);});
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestException() {
        tree = new BST<>(Arrays.asList("0008", "0003", "0020", "0060",
                "0014","0002","0016","0015","0018","0019"));
        assertThrows(IllegalArgumentException.class, () -> {tree.kLargest(-1);});
        assertThrows(IllegalArgumentException.class, () -> {tree.kLargest(20);});
    }
}