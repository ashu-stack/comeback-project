package LinkedLists;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(4);
        list.insertLast(4);
        list.insertLast(10);
        list.insertLast(10);


        list.display();

        //delete all key occurrences
       //list.deleteAllKey(88);
       list.removeDuplicates();
       list.display();


    }
}
