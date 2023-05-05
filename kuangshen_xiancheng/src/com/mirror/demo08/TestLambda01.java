package com.mirror.demo08;
/*
推导lambda表达式

*/
public class TestLambda01 {
    //3、实现一个静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2!!");
        }
    }
    public static void main(String[] args) {
        //为了单独实现一个接口的方法还要定义一个类 有点麻烦 因此这里 使用lambda表达式
        ILike like=new Like();
        like.lambda();
        like=new Like2();
        like.lambda();


        //4、局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3!!");
            }
        }

        like= new Like3();
        like.lambda();


        //5、匿名内部类 没有类的名称 必须借助接口或者父类
        like=new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4!!");
            }
        };
        like.lambda();

        //6、用lambda简化
        like=()->{
            System.out.println("I like lambda5!!");
        };
        like.lambda();
    }
}
//1、定义一个函数式接口
interface ILike{
    void lambda();
}
//2、实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda!!");
    }
}
