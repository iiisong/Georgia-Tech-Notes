import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MhoTest {
    private static final int TIMEOUT = 200;
    private CircularSinglyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new CircularSinglyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertNull(list.getHead());
    }

    //This should test each of the methods and ensure that incrementing/decrementing is done properly.
    @Test(timeout = TIMEOUT)
    public void testSize(){
        //Adding
        assertEquals(0,list.size());
        list.addToFront(0);                     // 0
        assertEquals(1,list.size());
        list.addToBack(2);                      // 0,2
        assertEquals(2,list.size());
        list.addAtIndex(1,1);             // 0,1,2
        assertEquals(3,list.size());

        //Removing
        list.removeAtIndex(1);                       // 0,2
        assertEquals(2,list.size());
        list.removeFromFront();                      // 2
        assertEquals(1,list.size());
        list.removeFromBack();                       //
        assertEquals(0, list.size());
    }

    //Test Edge Cases, this assumes that your basic functionality has already been tested and works.
    @Test(timeout = TIMEOUT)
    public void testAddingAtIndex(){
        //Test removing from middle
        list.addAtIndex(0,0);               // 0
        assertEquals(0, (int)list.get(0));
        list.addAtIndex(1,2);               // 0, 2
        assertEquals(2, (int)list.get(1));
        list.addAtIndex(1,1);               // 0, 1, 2
        assertEquals(1, (int)list.get(1));
    }

    @Test(timeout = TIMEOUT)
    public void testAddingAtToFront(){
        list.addToFront(1);                 //1
        assertEquals(1, (int)list.get(0));
        assertEquals(list.getHead().getNext(),list.getHead());
        list.addToFront(0);                 //0,1
        assertEquals(0, (int)list.get(0));
        assertEquals(list.getHead().getNext().getNext(),list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testAddingAtToBack(){
        list.addToBack(0);                 //0
        assertEquals(0, (int)list.get(0));
        assertEquals(list.getHead().getNext(),list.getHead());
        list.addToBack(1);                 //0,1
        assertEquals(1, (int)list.get(1));
        assertEquals(list.getHead().getNext().getNext(),list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testRemovingFromFront(){
        list.addToFront(0);                 //0
        assertEquals(0, (int)list.get(0));
        list.removeFromFront();                  //
        assertNull(list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testRemovingFromBack(){
        list.addToBack(0);                 //0
        assertEquals(0, (int)list.get(0));
        list.removeFromBack();                  //
        assertNull(list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrence(){
        //Test edge case where first element is actually the last occurrence which can lead to
        //the head still pointing to the node, and hence it not actually being deleted.
        list.addToBack(0);                  //0
        assertEquals(0,(int)list.removeLastOccurrence(0));                  //
        assertNull(list.getHead());

        list.addToBack(0);                  //0
        list.addToBack(1);                  //0,1
        assertEquals(1, (int)list.removeLastOccurrence(1));                 //0
        assertEquals(1,list.size());

        list.addToBack(1);                  //0,1
        list.addToBack(2);                  //0,1,2
        assertEquals(1, (int)list.removeLastOccurrence(1));                 //0,2

        list.clear();                   //
        assertNull(list.getHead());

        list.addToBack(1);                  //1
        list.addToBack(1);                  //1,1
        list.addToBack(1);                  //1,1,1
        list.addToBack(1);                  //1,1,1,1
        list.addToBack(0);                  //1,1,1,1,0
        list.addToBack(1);                  //1,1,1,1,0,1
        list.addToBack(0);                  //1,1,1,1,0,1,0

        assertEquals(1, (int)list.removeLastOccurrence(1));                 //1,1,1,1,0,0
        assertArrayEquals(new Integer[]{1,1,1,1,0,0}, list.toArray());



    }

    @Test(timeout = TIMEOUT)
    public void testToArray(){
        assertArrayEquals(new Integer[0],list.toArray());
        list.addToBack(0);
        list.addToBack(1);
        list.addToBack(2);
        assertArrayEquals(new Integer[]{0,1,2},list.toArray());
    }



}