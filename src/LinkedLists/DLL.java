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
    public void deleteAllKey(int key){
        Node temp = head;
        while(temp != null){
            if(temp.val == key){
                if(temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if(temp.next !=null) {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
    }
    public void findPairs(int sum){
        Node left = head;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node right = temp;
        while(left.val < right.val){
            int pairSum = left.val+right.val;
            if(pairSum == sum){
                System.out.println(left.val + " + " + right.val);
                right = right.prev;
                left = left.next;
            }
            else if(pairSum > sum){
                right = right.prev;
            }
            else if (pairSum < sum ){
                left = left.next;
            }

        }
    }

    public void removeDuplicates(){
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{

                temp = temp.next;
            }
        }
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
