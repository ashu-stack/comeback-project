package LinkedLists;

public class LinkedListMain {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(45);
        list.insertAtFirst(22);

        list.insertAtFirst(4);
        list.insertAtFirst(2);

        list.insertAtFirst(5);
        list.insertAtFirst(12);
        list.insertAtLast(99);
        list.insertAtLast(100);
        list.insert(88,2);

       list.display();
       list.delete(3);
       list.display();
    }
}
