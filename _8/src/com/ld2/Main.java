package com.ld2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String op=sc.next();
            if(op.equals("push")){
                int x=sc.nextInt();
                queue.add(x);
            }
            else if(op.equals("pop")){
                queue.remove();
            }
            else if(op.equals("empty")){
                System.out.println(queue.isEmpty()?"YES":"NO");
            }
            else {
                System.out.println(queue.peek());
            }
        }

    }
}
