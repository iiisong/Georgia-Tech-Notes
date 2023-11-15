import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Tests for AddIndex and RemoveIndex
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class ArrayListTests2 {
    private static final int TIMEOUT = 200;
    private ArrayList<String> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertArrayEquals(new Object[ArrayList.INITIAL_CAPACITY], list.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testEmptyAddAtIndex() {
        list.addAtIndex(5, "3");
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullAddAtIndex() {
        list.addAtIndex(0, null);
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexThenAddToFront() {
        for (int i = 0; i < 9; i++) {
            list.addAtIndex(i, "a");
        }

        list.addToFront("b");
        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "b";
        expected[1] = "a";
        expected[2] = "a";
        expected[3] = "a";
        expected[4] = "a";
        expected[5] = "a";
        expected[6] = "a";
        expected[7] = "a";
        expected[8] = "a";
        expected[9] = "a";

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddIndexThenAddToBack() {
        for (int i = 0; i < 9; i++) {
            list.addAtIndex(i, "a");
        }

        list.addToBack("b");
        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "a";
        expected[2] = "a";
        expected[3] = "a";
        expected[4] = "a";
        expected[5] = "a";
        expected[6] = "a";
        expected[7] = "a";
        expected[8] = "a";
        expected[9] = "b";

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddBackThenFront() {
        list.addToBack("a");
        list.addToBack("b");
        list.addToBack("c");
        list.addToBack("d");
        list.addToBack("e");
        list.addToBack("f");
        list.addToBack("g");
        list.addToBack("h");
        list.addToBack("i");
        list.addToFront("14");

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "14";
        expected[1] = "a";
        expected[2] = "b";
        expected[3] = "c";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddBackThenFrontThenIndexFront() {
        list.addToBack("a");
        list.addToBack("b");
        list.addToBack("c");
        list.addToBack("d");
        list.addToBack("e");
        list.addToBack("f");
        list.addToBack("g");
        list.addToBack("h");
        list.addToBack("i");
        list.addToFront("14");
        list.addAtIndex(0, "15");

        assertEquals(11, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "15";
        expected[1] = "14";
        expected[2] = "a";
        expected[3] = "b";
        expected[4] = "c";
        expected[5] = "d";
        expected[6] = "e";
        expected[7] = "f";
        expected[8] = "g";
        expected[9] = "h";
        expected[10] = "i";

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddBackThenFrontThenIndexBack() {
        list.addToBack("a");
        list.addToBack("b");
        list.addToBack("c");
        list.addToBack("d");
        list.addToBack("e");
        list.addToBack("f");
        list.addToBack("g");
        list.addToBack("h");
        list.addToBack("i");
        list.addToFront("14");
        list.addAtIndex(list.size(), "15");

        assertEquals(11, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "14";
        expected[1] = "a";
        expected[2] = "b";
        expected[3] = "c";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";
        expected[10] = "15";

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testToFrontTwiceThenAddToIndexSizeMinusOne() {
        list.addToFront("a");
        list.addToFront("b");
        list.addToFront("c");
        list.addToFront("d");
        list.addToFront("e");
        list.addToFront("f");
        list.addToFront("g");
        list.addToFront("h");
        list.addToFront("i");
        list.addToFront("14");
        list.addAtIndex(list.size() - 1, "15");

        assertEquals(11, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "14";
        expected[1] = "i";
        expected[2] = "h";
        expected[3] = "g";
        expected[4] = "f";
        expected[5] = "e";
        expected[6] = "d";
        expected[7] = "c";
        expected[8] = "b";
        expected[9] = "15";
        expected[10] = "a";
        expected[11] = null;
        expected[12] = null;
        expected[13] = null;

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexFront() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addToFront("14");

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "14";
        expected[1] = "a";
        expected[2] = "b";
        expected[3] = "c";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";

        assertArrayEquals(expected, list.getBackingArray());
    }
    //indexbackfrontordertest
    @Test(timeout = TIMEOUT) 
    public void addIndexFrontBack() {
        list.addAtIndex(0, "a"); //a
        list.addToFront("b"); //b a
        list.addToBack("8"); // b a 8
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "a";
        expected[2] = "8";
        
        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT) 
    public void addIndexBackFront() {
        list.addAtIndex(0, "a");
        list.addToBack("8");  
        list.addToFront("b"); 
       
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "a";
        expected[2] = "8";
        
        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT) 
    public void addFrontBackIndex() {
        list.addToFront("b");
        list.addToBack("8"); 
        list.addAtIndex(0, "a"); 
         
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "8";
        
        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT) 
    public void addBackFrontIndex() {
        list.addToBack("8");
        list.addToFront("b"); 
        list.addAtIndex(0, "a"); 
         
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "8";
        
        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddIndexSizeMinusOneCapTwice() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "j");
        list.addAtIndex(10, "k");
        list.addAtIndex(11, "l");
        list.addAtIndex(12, "m");
        list.addAtIndex(13, "n");
        list.addAtIndex(14, "o");
        list.addAtIndex(15, "p");
        list.addAtIndex(16, "q");
        list.addAtIndex(17, "r");

        assertEquals(18, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "h";
        expected[8] = "i";
        expected[9] = "j";
        expected[10] = "k";
        expected[11] = "l";
        expected[12] = "m";
        expected[13] = "n";
        expected[14] = "o";
        expected[15] = "p";
        expected[16] = "q";
        expected[17] = "r";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexMiddleFullCap() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(4, "j");

        /*for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }*/

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "j";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";

        /*System.out.println();
        for (int i = 0; i < expected.length; i++) {
            System.out.print(expected[i] + " ");
        }*/

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddIndexFrontFullCap() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(0, "j");

        /*for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }*/

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "j";
        expected[1] = "a";
        expected[2] = "b";
        expected[3] = "c";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";

        /*System.out.println();
        for (int i = 0; i < expected.length; i++) {
            System.out.print(expected[i] + " ");
        }*/

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexLastCapTwice() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "j");
        list.addAtIndex(10, "k");
        list.addAtIndex(11, "l");
        list.addAtIndex(12, "m");
        list.addAtIndex(13, "n");
        list.addAtIndex(14, "o");
        list.addAtIndex(15, "p");
        list.addAtIndex(16, "q");
        list.addAtIndex(17, "r");
        list.addAtIndex(18, "s");

        assertEquals(19, list.size());

        Object[] expected = new Object[(ArrayList.INITIAL_CAPACITY * 2) * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "h";
        expected[8] = "i";
        expected[9] = "j";
        expected[10] = "k";
        expected[11] = "l";
        expected[12] = "m";
        expected[13] = "n";
        expected[14] = "o";
        expected[15] = "p";
        expected[16] = "q";
        expected[17] = "r";
        expected[18] = "s";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexOneElement() {
        list.addAtIndex(0, "a");
        list.addAtIndex(0, "b");

        assertEquals(2, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "a";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexRandom() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addToFront("14");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addToBack("16");
        list.addToBack("17");
        list.addAtIndex(3, "18");

        assertEquals(13, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "14";
        expected[1] = "a";
        expected[2] = "c";
        expected[3] = "18";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";
        expected[8] = "h";
        expected[9] = "i";
        expected[10] = "b";
        expected[11] = "16";
        expected[12] = "17";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRandomAdd() {
        list.addAtIndex(0, "a");
        list.addToBack("f");
        list.addToFront("g");
        list.addAtIndex(3, "b");
        list.addToFront("h");
        list.addAtIndex(5, "c");

        assertEquals(6, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "h";
        expected[1] = "g";
        expected[2] = "a";
        expected[3] = "f";
        expected[4] = "b";
        expected[5] = "c";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexLastResize() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "18");

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "h";
        expected[8] = "i";
        expected[9] = "18";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexBack() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addToBack("14");

        assertEquals(10, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "h";
        expected[8] = "i";
        expected[9] = "14";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexBackWithoutResize() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addToBack("14");

        assertEquals(8, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "14";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexFrontWithoutResize() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addToFront("14");

        assertEquals(8, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "14";
        expected[1] = "a";
        expected[2] = "b";
        expected[3] = "c";
        expected[4] = "d";
        expected[5] = "e";
        expected[6] = "f";
        expected[7] = "g";

        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, "2a"); // 2a
        list.addAtIndex(0, "1a"); // 1a, 2a
        list.addAtIndex(2, "4a"); // 1a, 2a, 4a
        list.addAtIndex(2, "3a"); // 1a, 2a, 3a, 4a
        list.addAtIndex(0, "0a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "2a";
        expected[3] = "3a";
        expected[4] = "4a";
        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddIndexEmpty() {

        assertEquals(0, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];

        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveAtIndexFront() {
        String remove = "a";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(0));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "c";
        expected[2] = "d";
        expected[3] = "e";
        expected[4] = "f";
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) 
    public void testRemoveFromFrontEmpty() {
        String remove = "a";
        list.removeFromFront();
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(0));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "c";
        expected[2] = "d";
        expected[3] = "e";
        expected[4] = "f";
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class) 
    public void testRemoveFromVBackEmpty() {
        String remove = "a";
        list.removeFromBack();
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(0));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "c";
        expected[2] = "d";
        expected[3] = "e";
        expected[4] = "f";
        assertArrayEquals(expected, list.getBackingArray());
    
    }
  
    
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class) 
    public void testRemoveAtIndexException() {
        String remove = "a";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        
        list.removeAtIndex(7);
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(0));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "c";
        expected[2] = "d";
        expected[3] = "e";
        expected[4] = "f";
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveRandom() {
        String removeOne = "c";
        String removeTwo = "a";
        String removeThree = "f";
        String removeFour = "d";
        
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        
  
        assertEquals(6, list.size());
        assertSame(removeOne, list.removeAtIndex(2));
        assertSame(removeTwo, list.removeFromFront());
        assertSame(removeThree, list.removeFromBack());
        assertSame(removeFour, list.removeAtIndex(1));

        assertEquals(2, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "b";
        expected[1] = "e";
        expected[2] = null;
        expected[3] = null;
        expected[4] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveAtIndexSizeMinusOne() {
        String remove = "f";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(5));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexBetween() {
        String remove = "f";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "f");
        list.addAtIndex(5, "e");
        assertEquals(6, list.size());
        assertSame(remove, list.removeAtIndex(4));
        assertEquals(5, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveAtIndexSizeCapacity() {
        String remove = "j";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "j");
        assertEquals(10, list.size());
        assertSame(remove, list.removeAtIndex(9));
        assertEquals(9, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "e";
        expected[5] = "f";
        expected[6] = "g";
        expected[7] = "h";
        expected[8] = "i";
        expected[9] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveAtIndexSizeCapacityRandom() {
        String remove = "e";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "j");
        assertEquals(10, list.size());
        assertSame(remove, list.removeAtIndex(4));
        assertEquals(9, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "f";
        expected[5] = "g";
        expected[6] = "h";
        expected[7] = "i";
        expected[8] = "j";
        expected[9] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRemoveNulls() {
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        list.addAtIndex(9, "j");
        assertEquals(10, list.size());
        assertSame("a", list.removeAtIndex(0));
        assertSame("b", list.removeAtIndex(0));
        assertEquals(8, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "c";
        expected[1] = "d";
        expected[2] = "e";
        expected[3] = "f";
        expected[4] = "g";
        expected[5] = "h";
        expected[6] = "i";
        expected[7] = "j";
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class) 
    public void testRemoveAtIndexEmpty() {
        String remove = "e";
        assertSame(remove, list.removeAtIndex(0));
        assertEquals(9, list.size());
        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "a";
        expected[1] = "b";
        expected[2] = "c";
        expected[3] = "d";
        expected[4] = "f";
        expected[5] = "g";
        expected[6] = "h";
        expected[7] = "i";
        expected[8] = "j";
        expected[9] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
    
    @Test(timeout = TIMEOUT) 
    public void testRandomAddRemoves() {
        list.addAtIndex(0, "a"); //a
        list.addToFront("b"); //b a
        list.addToBack("8"); // b a 8
        list.addAtIndex(2, "6"); // b a 6 8
        list.addAtIndex(list.size(), "r"); //b a 6 8 r
        list.addAtIndex(list.size() - 1, "f"); // b a 6 8 f r
        list.addToBack("funny"); // b a 6 8 f r funny
        list.addToFront("silly"); // silly b a 6 8 f r funny
        list.addAtIndex(4, "L"); //silly b a 6 L 8 f r funny
        list.addAtIndex(4, "7"); //silly b a 6 7 L 8 f r funny
        list.addAtIndex(4, "crazy"); //silly b a 6 crazy 7 L 8 f r funny
        assertEquals(11, list.size());
        assertSame("silly", list.removeAtIndex(0)); //b a 6 crazy 7 L 8 f r funny
        assertSame("b", list.removeAtIndex(0)); //a 6 crazy 7 L 8 f r funny
        assertSame("a", list.removeFromFront()); //6 crazy 7 L 8 f r funny
        assertSame("funny", list.removeFromBack()); //6 crazy 7 L 8 f r
        assertSame("8", list.removeAtIndex(4)); //6 crazy 7 L f r
        assertEquals(6, list.size());

        
        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY * 2];
        expected[0] = "6";
        expected[1] = "crazy";
        expected[2] = "7";
        expected[3] = "L";
        expected[4] = "f";
        expected[5] = "r";
        expected[6] = null;
        expected[7] = null;
        assertArrayEquals(expected, list.getBackingArray());
    
    }
 
    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class) 
    public void testRemoveAtIndexSizeFullCapacity() {
        String remove = "f";
        list.addAtIndex(0, "a");
        list.addAtIndex(1, "b");
        list.addAtIndex(2, "c");
        list.addAtIndex(3, "d");
        list.addAtIndex(4, "e");
        list.addAtIndex(5, "f");
        list.addAtIndex(6, "g");
        list.addAtIndex(7, "h");
        list.addAtIndex(8, "i");
        assertEquals(9, list.size());
        assertSame(remove, list.removeAtIndex(9));
            
    }
    
    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        String temp = "2a"; // For equality checking.

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, temp);   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a");   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        // assertSame checks for reference equality whereas assertEquals checks
        // value equality.
        assertSame(temp, list.removeAtIndex(2));    // 0a, 1a, 3a, 4a, 5a

        assertEquals(5, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        assertArrayEquals(expected, list.getBackingArray());
    }
    
    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        String temp = "0a"; // For equality checking.

        list.addAtIndex(0, temp);   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a");   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        // assertSame checks for reference equality whereas assertEquals checks
        // value equality.
        assertSame(temp, list.removeFromFront());   // 1a, 2a, 3a, 4a, 5a

        assertEquals(5, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "1a";
        expected[1] = "2a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        assertArrayEquals(expected, list.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        String temp = "5a"; // For equality checking.

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, temp);   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        // assertSame checks for reference equality whereas assertEquals checks
        // value equality.
        assertSame(temp, list.removeFromBack());    // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "2a";
        expected[3] = "3a";
        expected[4] = "4a";
        assertArrayEquals(expected, list.getBackingArray());
    }
    
}