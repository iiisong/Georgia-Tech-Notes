import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Abhinav Vemulapalli
 * @version 1.0
 */
public class VemulapalliTests {
    private static final int TIMEOUT = 200;
    private BST<Integer> tree;

    @Before
    public void setup() {
        tree = new BST<>();
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveOneElementTree() {
        /*

                    1

         */
        tree.add(1);
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());

        tree.remove(1);
        assertNull(tree.getRoot());
        assertEquals(0, tree.size());
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveLeaves() {
        /*

                        1
                       / \
                      0   2

                        ->

                        1
                       /
                      0

                        ->

                        1

         */

        tree.add(1);
        tree.add(0);
        tree.add(2);

        assertEquals(3, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 2, tree.getRoot().getRight().getData());

        tree.remove(2);

        assertEquals(2, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());

        tree.remove(0);

        assertEquals(1, tree.size());
        assertEquals((Integer) 1, tree.getRoot().getData());
    }

    @Test(timeout=TIMEOUT)
    public void testRemove2ChildNodes() {
        /*

                        20
                       /  \
                      /    \
                     /      \
                    15      25
                   /  \
                  11  16

         */

        tree.add(20);
        tree.add(15);
        tree.add(25);
        tree.add(11);
        tree.add(16);

        assertEquals(5, tree.size());
        assertEquals((Integer) 20, tree.getRoot().getData());
        assertEquals((Integer) 15, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 25, tree.getRoot().getRight().getData());
        assertEquals((Integer) 11, tree.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 16, tree.getRoot().getLeft().getRight().getData());

        tree.remove(15);
        assertEquals(4, tree.size());
        assertEquals((Integer) 20, tree.getRoot().getData());
        assertEquals((Integer) 16, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 25, tree.getRoot().getRight().getData());
        assertEquals((Integer) 11, tree.getRoot().getLeft().getLeft().getData());
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveRootOfVariousTypes() {
        Integer root = 20;
        /*

                20


         */
        tree.add(root);
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
        assertEquals((Integer) 20, tree.getRoot().getData());

        assertSame(root, tree.remove(20));
        assertEquals(0, tree.size());
        tree.clear();

        /*

                        20
                       /
                      15

         */
        tree.add(root);
        tree.add(15);
        assertEquals(2, tree.size());
        assertEquals(1, tree.height());

        List<Integer> expected = new ArrayList<>();
        expected.add(15);

        assertSame(root, tree.remove(20));
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
        assertEquals(expected, tree.levelorder());
        tree.clear();

        /*
                        20
                       /  \
                     15   25
         */
        tree.add(root);
        tree.add(15);
        tree.add(25);
        assertEquals(3, tree.size());
        assertEquals(1, tree.height());

        expected = new ArrayList<>();
        expected.add(25);
        expected.add(15);

        assertSame(root, tree.remove(20));
        assertEquals(2, tree.size());
        assertEquals(1, tree.height());
        assertEquals(expected, tree.levelorder());
        tree.clear();

        /*
                        20
                       /
                      15
                     /  \
                    10  16

                        ->

                        15
                       /  \
                      10  16
         */
        tree.add(root);
        tree.add(15);
        tree.add(10);
        tree.add(16);
        assertEquals(4, tree.size());
        assertEquals(2, tree.height());

        expected = new ArrayList<>();
        expected.add(15);
        expected.add(10);
        expected.add(16);

        assertSame(root, tree.remove(20));
        assertEquals(3, tree.size());
        assertEquals(1, tree.height());
        tree.clear();

        tree.add(root);
        tree.add(15);
        tree.add(10);
        tree.add(16);
        tree.add(30);
        tree.add(25);
        tree.add(35);
        tree.add(23);
        tree.add(27);
        assertEquals(9, tree.size());
        assertEquals(3, tree.height());

        expected = new ArrayList<>();
        expected.add(23);
        expected.add(15);
        expected.add(30);
        expected.add(10);
        expected.add(16);
        expected.add(25);
        expected.add(35);
        expected.add(27);

        assertSame(root, tree.remove(20));
        assertEquals(8, tree.size());
        assertEquals(3, tree.height());
        assertEquals(expected, tree.levelorder());
        tree.clear();

        tree.add(root);
        tree.add(15);
        tree.add(30);
        tree.add(10);
        tree.add(16);
        tree.add(25);
        tree.add(35);
        tree.add(28);
        tree.add(26);
        tree.add(29);
        tree.add(27);
        assertEquals(11, tree.size());
        assertEquals(5, tree.height());

        expected = new ArrayList<>();
        expected.add(25);
        expected.add(15);
        expected.add(30);
        expected.add(10);
        expected.add(16);
        expected.add(28);
        expected.add(35);
        expected.add(26);
        expected.add(29);
        expected.add(27);

        assertSame(root, tree.remove(20));
        assertEquals(10, tree.size());
        assertEquals(4, tree.height());
        assertEquals(expected, tree.levelorder());
        assertEquals((Integer) 28, tree.getRoot().getRight().getLeft().getData());
    }

    @Test(timeout=TIMEOUT)
    public void testRemoveVariousTypes() {
        Integer notRoot = 150;
        Integer otherData = 185;
        Integer anotherData = 180;
        Integer lastData = 175;
        tree.add(100);
        tree.add(50);
        tree.add(notRoot);
        tree.add(125);
        tree.add(lastData);
        tree.add(anotherData);
        tree.add(otherData);

        assertEquals(7, tree.size());

        List<Integer> expected = new ArrayList<>();
        expected.add(100);
        expected.add(50);
        expected.add(175);
        expected.add(125);
        expected.add(180);
        expected.add(185);

        assertSame(notRoot, tree.remove(150));
        assertEquals(expected, tree.levelorder());


        expected = new ArrayList<>();
        expected.add(100);
        expected.add(50);
        expected.add(175);
        expected.add(125);
        expected.add(185);

        assertSame(anotherData, tree.remove(180));
        assertEquals(expected, tree.levelorder());

        expected = new ArrayList<>();
        expected.add(100);
        expected.add(50);
        expected.add(175);
        expected.add(125);

        assertSame(otherData, tree.remove(185));
        assertEquals(expected, tree.levelorder());

        expected = new ArrayList<>();
        expected.add(100);
        expected.add(50);
        expected.add(125);

        assertSame(lastData, tree.remove(175));
        assertEquals(expected, tree.levelorder());
    }

    @Test(timeout=TIMEOUT)
    public void testHeight() {
        tree.add(20);
        tree.add(15);
        tree.add(35);
        tree.add(40);
        tree.add(45);
        tree.add(50);

        assertEquals(4, tree.height());

        tree.add(34);
        tree.add(33);
        tree.add(32);
        tree.add(31);
        tree.add(25);
        tree.add(22);
        tree.add(28);

        assertEquals(7, tree.height());

        tree.clear();
        assertEquals(-1, tree.height());

        tree.add(10);
        assertEquals(0, tree.height());
    }


    @Test(timeout=TIMEOUT)
    public void testKLargest() {
       tree.add(100);
       tree.add(50);
       tree.add(150);
       tree.add(25);
       tree.add(130);
       tree.add(30);

       List<Integer> expected = new ArrayList<>();
       expected.add(50);
       expected.add(100);
       expected.add(130);
       expected.add(150);

       assertEquals(expected, tree.kLargest(4));
       tree.clear();

       tree.add(100);
       tree.add(150);
       tree.add(50);
       tree.add(25);
       tree.add(20);

       expected = new ArrayList<>();
       expected.add(25);
       expected.add(50);
       expected.add(100);
       expected.add(150);

       assertEquals(expected, tree.kLargest((4)));
       tree.clear();
    }

    @Test(timeout=TIMEOUT)
    public void testConstructorException(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BST<Integer>(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> test = new ArrayList<>();
            test.add(10);
            test.add(null);
            test.add(20);

            new BST<>(test);
        });
    }

    @Test(timeout=TIMEOUT)
    public void testAddRemoveGetContainsException() {
        assertThrows(IllegalArgumentException.class, () -> { tree.add(null);  });
        assertThrows(IllegalArgumentException.class, () -> { tree.remove(null); });

        tree.add(20);
        assertThrows(NoSuchElementException.class, () -> { tree.remove(15); });

        assertThrows(IllegalArgumentException.class, () -> { tree.get(null); });
        assertThrows(NoSuchElementException.class, () -> { tree.get(15); });

        assertThrows(IllegalArgumentException.class, () -> tree.contains(null));

        assertThrows(IllegalArgumentException.class, () -> tree.kLargest(-1));
        assertThrows(IllegalArgumentException.class, () -> tree.kLargest(2));
    }
}