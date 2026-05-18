package Part02;

public class MyLinkedList {
    private NodeMove head;

    public void insert(Move move) {
        if (this.head == null) {
            this.head = new NodeMove();
            this.head.moveData = move;
            return;
        }
        
        NodeMove current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        NodeMove newNode = new NodeMove();
        newNode.moveData = move;
        current.next = newNode;
    }

    public NodeMove getHead() {
        return this.head;
    }
}
