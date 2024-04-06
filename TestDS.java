

import DataStructuresJava.*;

public class TestDS {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.display();
        list.addLast(3);
        list.addLast(10);
        list.display();
        list.insert(26,2);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.delete(1);
        list.display();
        list.clearList();
        list.display();
    }
        
}