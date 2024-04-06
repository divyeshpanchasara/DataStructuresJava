package DataStructuresJava;
/**
 * LinkedListClass
 */
public class LinkedListClass {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListClass(){
        this.size = 0;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        node.nextNode = head;
        if(tail == null){
            tail = head;
        }
        head = node;
        size++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        if(head == null){
            addFirst(data);
            return;
        }
        tail.nextNode = node;
        node.nextNode = null;
        size++;
    }

    public void insert(int data, int index){
        Node temp = new Node(data, null);
        if(index <= 0) addFirst(data);
        else if(index >= size) addLast(data);
        else{
            Node prevNode = getNode(index - 1);
            temp.nextNode = prevNode.nextNode;
            prevNode.nextNode = temp;
            size++;
        }
    }

    public void deleteFirst(){
        if(size == 0) System.out.println("The list is empty");
        else{
            head = head.nextNode;
            size--;
        }
    }

    public void deleteLast(){

        if(size == 0) {
            System.out.println("The List is empty");
            return;
        }
        else if(size == 1) {
            deleteFirst();
            size--;
        }
        else{
            Node prevNode = getNode(size - 2);
            tail = prevNode;
            tail.nextNode = null;
            size--;
        }
    }

    public void delete(int index){
        if(index <= 0) deleteFirst();
        else if(index >= size) deleteLast();
        else{
            Node prevNode = getNode(index - 1);
            prevNode.nextNode = prevNode.nextNode.nextNode;
            size--;
        }
    }

    public Node getNode(int index){
        Node temp = head;
        while (index > 0) {
            temp = temp.nextNode;
            index--;
        }
        return temp;
    }

    public void getNodeInfo(int index){
        if(index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }
        Node node = getNode(index);
        if(index != size - 1) System.out.println(node.data + " --> " + node.nextNode.data);
        else System.out.println(node.data + "END");
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.nextNode;
        }
        System.out.println("END");
    }

    public class  Node {
        private int data;
        private Node nextNode;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }
        
    }
}