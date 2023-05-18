import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    String[] nodeValues = { "Ashe", "Pyke", "Yasuo", "Warwick", "Master Yi" };

    private LinkedList linkedList = new LinkedList();

    @Test
    // Add and remove test
    public void shouldAddAndRemove() {
        populateList(true);

        linkedList.removeTail();
        linkedList.removeFromFront();

        // Compare LinkedList and nodeValues size.
        assertEquals(nodeValues.length - 2, linkedList.getSize());

        String[] addChampions = { "Trundle", "Jinx", "Teemo", "Soraka" };

        for(String champion : addChampions)
        {
            linkedList.addToTail(new Node(champion));

            // Compare last item.
            assertEquals(champion, linkedList.getTail().getValue());
        }
    }

    @Test
    public void shouldRemoveFromTail()
    {
        populateList(true);

        linkedList.removeTail();

        var lastElement = linkedList.getTail();

        // Compare LinkedList last element to nodeValues' second to the last element.
        assertEquals(nodeValues[nodeValues.length - 2], lastElement.getValue());

        // Check size, LinkedList size should be one less than nodeValues.
        assertEquals(nodeValues.length - 1, linkedList.getSize());
    }

    @Test
    public void shouldRemoveFromTailEmpty()
    {
        linkedList.removeTail();

        var lastElement = linkedList.get(linkedList.getSize() - 1);

        // Compare LinkedList last element to nodeValues' second to the last element.
        assertEquals(null, lastElement);

        // Check size, LinkedList size should be one less than nodeValues.
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void shouldRemoveFromFront() {
        populateList(true);

        linkedList.removeFromFront();

        var firstElement = linkedList.get(0);

        // Compare LinkedList first element to nodeValues second element.
        assertEquals(nodeValues[1], firstElement.getValue());

        // Check size, LinkedList size should be one less than nodeValues.
        assertEquals(nodeValues.length - 1, linkedList.getSize());
    }

    @Test
    public void shouldRemoveFromFrontEmpty() {
        linkedList.removeFromFront();

        var firstElement = linkedList.get(0);

        // Compare LinkedList first element to nodeValues second element.
        assertEquals(null, firstElement);

        // Check size, LinkedList size should be one less than nodeValues.
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void shouldAddNodeToTail() {
        populateList(true);

        // Add to front adds to index 0.
        // Reverse for loop.
        for (int i = 0; i < nodeValues.length; i++) {

            // Compare each value in LinkedList and String[]
            assertEquals(nodeValues[i], linkedList.get(i).getValue());
        }

        // Now check size.
        assertEquals(nodeValues.length, linkedList.getSize());
    }

    @Test
    public void shouldAddNodeToHead() {
        populateList(false);

        // Add to front adds to index 0.
        // Reverse for loop.
        for (int i = nodeValues.length - 1; i >= 0; i--) {
            var incrementing = Math.abs(i - (nodeValues.length - 1));

            // Compare each value in LinkedList and String[]
            assertEquals(nodeValues[i], linkedList.get(incrementing).getValue());
        }

        // Now check size.
        assertEquals(nodeValues.length, linkedList.getSize());
    }

    public void populateList(boolean addLocation) {
        long expectedSize = 0;

        for (String y : nodeValues) {
            if (addLocation)
                linkedList.addToTail(new Node(y));
            else
                linkedList.addToFront(new Node(y));

            expectedSize++;

            // Compare size.
            assertEquals(expectedSize, linkedList.getSize());
        }
    }
}