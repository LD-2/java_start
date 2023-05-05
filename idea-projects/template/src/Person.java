public abstract class Person {
    //模板方法
    //添加了final之后 这个方法无法被覆盖 核心算法得以保护
    //模板方法定义核心的算法骨架 具体的实现步骤去子类中实现
    public final void day(){
        qiChuang();
        chiFan();
        doSome();
        shuiJiao();
    }
    public void qiChuang(){
        System.out.println("起床");
    }
    public void chiFan(){
        System.out.println("吃饭");
    }
    public abstract void doSome();
    public void shuiJiao(){
        System.out.println("睡觉");
    }
}
