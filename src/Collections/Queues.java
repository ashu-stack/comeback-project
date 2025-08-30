package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(32);
        queue.offer(45);
        queue.offer(89);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }
}
