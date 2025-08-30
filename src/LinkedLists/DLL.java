package LinkedLists;

public class DLL {
    private Node head;
    private int size;
    public DLL(){
        this.size = 0;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END.");
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next= head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;

    }
    public Node find(int val){
        Node node = head;
        while(node.next != null){
            if(node.val == val){
                return node;
            }else{
                node = node.next;
            }
        }
        return null;
    }

    public void insert(int nodeVal, int val){
        Node p = find(nodeVal);
        Node node = new Node (val);
        node.next = p.next;
        node.prev = p;
        p.next = node;
        node.next.prev = node;
        size++;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        node.prev = last;
        last.next = node;
        size++;

    }
    private class Node{
        int val;
        Node next;
        Node prev;


        public Node(int val){
            this.val = val;
        }

        public Node (int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

}
