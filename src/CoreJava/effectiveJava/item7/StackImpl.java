package CoreJava.effectiveJava.item7;


import Heaps.HeapSums;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackImpl {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_CAPACITY=5;

    public StackImpl(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push (Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0) throw new EmptyStackException();
        elements[size] = null;
        return elements[--size];
    }
    public void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2*size+1);
        }
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(new HeapSums.Pair(2,1));
        stack.push(new HeapSums.Pairs(2,3));
        stack.push(new HeapSums.Pair(6,1));
        stack.push(new HeapSums.Pairs(21,3));
        stack.push(new HeapSums.Pair(2,110));
        stack.push(new HeapSums.Pairs(22,33));
        System.out.println(stack.pop().toString());
        System.out.println(stack.size);



    }
}
