public class LinkedList {

    private Node head; // index 0 item

    public long getSize() {
        return size;
    }

    private long size = 0;

    public void setHead(Node head)
    {
        this.head = head;
    }


    public Node get(long index)
    {
        var currentNode = head;

        for(int i = 0; i < index; i++)
            currentNode = currentNode.getNext();

        return currentNode;
    }

    public void addToFront(Node newNode)
    {
        if (size == 0) // empty list
            setHead(newNode);
        else
        {
            var currentNode = head;
            for(int i = 0; i < (size - 1); i++)
            {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }

        size++;
    }

}
