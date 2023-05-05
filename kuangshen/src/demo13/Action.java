package demo13;

//abstract抽象类  extends: 类单继承  (接口可以多继承)  插座~
public abstract class Action {
    //约束~让别人实现  只有方法名字没有方法的实现 没有函数体
    public abstract void doSomething();
    //抽象类:  不能new  只能靠子类去实现  约束
    public void Hello(){}
    //抽象类中可以写抽象方法 抽象方法只能在抽象类中
    //抽象的抽象: 约束
}
