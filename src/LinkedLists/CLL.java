package LinkedLists;

public class CLL {
    private Node head;
    private Node tail;
    private int size;
    public CLL(){
        this.size = 0;
    }
    public class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;

        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
        size++;
        return;
    }

    public void delete(int val){

        Node node = head;
        if(node == null){
            return;
        }
        if(node.val == val){
            head = node.next;
            tail.next =head;
        }

        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }

    public void display(){
        if(head == null){
            System.out.println("CLL doesn't exist. ");
        }
        Node node = head;
        do{
            System.out.print(node.val + "-->");
            node = node.next;
        }while(node.next != head);
        System.out.println("END");
        return;
    }
}
