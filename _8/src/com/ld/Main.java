package com.ld;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String op=sc.next();
            if(op.equals("push")){
                int x=sc.nextInt();
                stack.push(x);
            }
            else if(op.equals("pop")){
                stack.pop();
            }
            else if(op.equals("query")){
                System.out.println(stack.peek());
            }
            else{
                System.out.println(stack.empty()?"YES":"NO");
            }
        }
    }
}
//class Stack{
//    private int size;
//
//    public Stack() {
//        this.size=0;
//    }
//    public void push(int x){
//
//    }
//    public void pop(){
//
//    }
//    public int query(){
//
//    }
//    public boolean empty(){
//        return this.size==0;
//    }
//}
