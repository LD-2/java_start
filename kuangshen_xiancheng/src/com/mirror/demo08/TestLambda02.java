package com.mirror.demo08;

public class TestLambda02 {
    public static void main(String[] args) {
//        ILove Love=(String name)->{
//                System.out.println("I love "+name);
//        };
        //还可以简化 参数 括号 大括号
        ILove Love=name-> System.out.println("I love "+name);
        Love.love("mirror");
        Love.love("666");
    }//谨记lambda表达式的前提
    //无论是参数 还是代码 多个的时候就要添加 括号了
}
interface ILove{
    void love(String name);
}

