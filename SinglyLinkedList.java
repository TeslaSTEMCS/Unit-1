public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        
        Node() {
            data = 0;
            next = null;
        }
        
        Node(int value) {
            data = value;
            next = null;
        }
        
        Node(int value, Node nextNode) {
            data = value;
            next = nextNode;
        }
    }
    
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    public SinglyLinkedList(int value) {
        head = new Node(value);
        size = 1;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        String result = "";
        Node curr = head;
        while (curr != null) {
            result += curr.data + " --> ";
            curr = curr.next;
        }
        return result += "null";
    }
    
    public int get(int index) {
        Node curr = head;
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Cannot get from nonexistant index!");
        }
        for (int i = 0; i < index; i++) { // parse to the index Node 
            curr = curr.next;
        }
        return curr.data;

    }
    
    public boolean contains(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    public void add(int value) {
        add(size, value);
    }
    
    public void add(int index, int value) {
        if ((index > size && size != 0) || index < 0) {
            throw new IndexOutOfBoundsException("Cannot add from nonexistant index!");
        }
        if (index == 0) {
            head = new Node(value, head);
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) { // parse curr to the node right before the one of interest
                curr = curr.next;
            }
            if (curr.next == null) { // if its the last value of the list
                curr.next = new Node(value);
            } else {
                Node temp = curr.next;
                curr.next = new Node(value, temp);
            }
        }
        size++;
    }
    
    public int remove() {
        return remove(0);
    }
    
    public int remove(int index) {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from empty LinkedList!");
        }
        else {
            Node curr = head;
            int data;
            if (index > size - 1 || index < 0) {
                throw new IndexOutOfBoundsException("Cannot remove from nonexistant index!");
            }
            for (int i = 0; i < index - 1; i++) { // parse curr to the node right before the one of interest (doesn't work if it's 0)
                curr = curr.next;
            }
            if (curr.next == null) { // if there's only 1 node in the list
                data = head.data;
                head = null;
            } else {
                if (index == 0) { // if index is 0
                    data = head.data;
                    head = head.next;
                } else {
                    data = curr.next.data;
                    if (curr.next.next == null) { // if we are removing the last value
                        curr.next = null;
                    } else {
                        curr.next = curr.next.next;
                    }
                }
            }
            size--;
            return data;
        }
    }
}