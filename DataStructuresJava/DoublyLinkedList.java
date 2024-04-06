package DataStructuresJava;

public class DoublyLinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){
        this.size = 0;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        if(tail == null){
            tail = head;
        }
        head = node;
        size++; 
    }

    public Node getNode(int index){
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public void addLast(int data){
        if(head == null){
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++; 
    }

    public void insert(int data, int index){
        if(index <= 0) addFirst(data);
        else if(index >= size) addLast(data);
        else{
            Node node = new Node(data);
            Node prevNode = getNode(index - 1);
            prevNode.next.prev = node;
            node.next = prevNode.next;
            prevNode.next = node;
            node.prev = prevNode;
            size++;
        }
    }

    public void deleteFirst(){
        if(size == 0){
            System.out.println("List is empty");
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteLast(){
        if(size == 0) System.out.println("List is Empty");
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void delete(int index){
        if(index <= 0) deleteFirst();
        else if(index >= size) deleteLast();
        else{
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.next.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    public void clearList(){
        if(size != 0){
            tail = null;
            head = null;
        }
        System.out.println("The list has been cleared");
    }

    public void display(){
        Node node = head;
        System.out.print("Forward :  ");
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.println("END");

        Node temp = tail;
        System.out.print("Reverse :  ");
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }


    /**
     * Node
     */
    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
