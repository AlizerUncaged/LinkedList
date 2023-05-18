public class LinkedList {

    private Node head; // index 0 item

    public long getSize() {
        return size;
    }

    private long size = 0;

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return this.get(this.getSize() - 1);
    }

    public Node get(long index) {

        if (index > size - 1 || isEmpty())
            return null;

        var currentNode = head;

        for (int i = 0; i < index; i++)
            currentNode = currentNode.getNext();

        return currentNode;
    }

    public void addToTail(Node newNode) {
        if (isEmpty()) // empty list
            setHead(newNode);
        else {
            var currentNode = head;

            for (int i = 0; i < (size - 1); i++)
                currentNode = currentNode.getNext();

            currentNode.setNext(newNode);
        }

        size++;
    }

    public void addToFront(Node newNode) {
        if (size == 0) // empty list
            setHead(newNode);
        else {
            var originalHead = head;
            head = newNode;
            newNode.setNext(originalHead);
        }

        size++;
    }

    public void removeFromFront() {

        if (isEmpty())
            return;

        head = head.getNext();
        size--;
    }

    public void removeTail() {

        if (isEmpty())
            return;

        var currentNode = head;

        for (int i = 0; i < size - 2; i++) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(null);

        size--;
    }

    public boolean isEmpty() {
        return head == null || size == 0;
    }
}
