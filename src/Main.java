public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addToFront(new Node("Yasuo"));
        linkedList.addToFront(new Node("Pyke"));

        // Iterate
        for(int i = 0; i < linkedList.getSize(); i++) {
            System.out.println("Index [" + i + "]: " + linkedList.get(i).getValue());
        }

    }
}