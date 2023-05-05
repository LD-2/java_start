package com.mirror.stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<String> stack=new Stack<String>();
        stack.push("mirror");
        stack.push("ld");
        stack.push("mirror");
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.clear();
        for(String str:stack){
            System.out.println(str);
        }
//        System.out.println(stack.peek());
        try {
            System.out.println(stack.peek());
        } catch (Exception e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }
    }
}
