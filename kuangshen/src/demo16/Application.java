package demo16;

import java.io.IOException;

public class Application {
    //捕获异常快捷键ctrl+alt+t

    //Exception异常 运行时异常 非运行时异常  程序员的逻辑错误   检查性异常 运行时异常
    //Error一般由java虚拟机生成并抛出 大多数与代码编写者所执行的操作无关
    public static void main(String[] args) {
        int a=1,b=0;
        try{//try监控区 在try代码块里面的代码有异常就会捕获
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("算数异常");
            //如果出现了catch里面的异常类型就会执行此代码块的代码
        }finally {
            //无论程序有没有异常都会执行此代码块
            System.out.println("finally");
        }



        //catch可以写多个  捕获多个异常要从小到大
        try{
            new Application().f1();
        }catch (Error e){
            System.out.println("Error");
            //要捕获的异常的类型  要把最大的写下面 因为异常和if else 一样捕获成功就ok了
        }catch (RuntimeException e){
            System.out.println("Exception");
        }catch (Exception e){
            System.out.println("Exception");
        }
        finally{
            System.out.println("finally");
        }


        //捕获异常快捷键ctrl+alt+t
        try {
            int c=a/b;
        } catch (Exception e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();//打印错误的栈信息
        } finally {
            System.out.println("finally3");
        }

        //主动抛出异常  方法抛出异常  抛出异常和捕获异常
        try {
            new Application().f3(1,0);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
    public void f1(){
        f2();
    }
    public void f2(){
        f1();
    }
    public void f3(int a,int b)throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();//主动抛出异常
        }
    }
}
