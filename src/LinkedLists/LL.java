package LinkedLists;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;

    }

    public int delete(int ind){
        if(ind == 0){
            return deleteFirst();
        }
        if(ind == size-1){
            return deleteLast();
        }
        Node prev = get(ind-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;

    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        int val = tail.value;
        Node secondLast = get(size-2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;// first element added
        }
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public void insertAtLast(int value){
        Node node = new Node(value);
        if(tail == null){
            insertAtFirst(value);
        }
        else{
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int val, int ind){
        if(ind == 0){
            insertAtFirst(val);
            return;
        }
        if(ind == size){
            insertAtLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }

    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
