import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList = new LinkedList();

    @Test
    public void shouldAddNode() {
        String[] nodeValues = { "Ashe", "Pyke", "Yasuo"};

        long expectedSize = 0;
        for (String y : nodeValues) {
            linkedList.addToFront(new Node(y));
            expectedSize++;

            // Compare size.
            assertEquals(expectedSize, linkedList.getSize());
        }

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
}