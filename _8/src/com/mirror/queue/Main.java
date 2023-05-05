package com.mirror.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(6);
        queue.add(2);
        queue.add(5);
        while (queue.size()>0){
            System.out.println(queue.remove());
        }
        System.out.println();
        Queue<Integer> q1=new PriorityQueue<Integer>();
        q1.add(6);
        q1.add(2);
        q1.add(5);
        while (q1.size()>0){
            System.out.println(q1.remove());
        }
        Queue<Integer> q2=new PriorityQueue<Integer>(Collections.reverseOrder());
        q2.add(6);
        q2.add(2);
        q2.add(5);
        while (q2.size()>0){
            System.out.println(q2.remove());
        }
    }
}
