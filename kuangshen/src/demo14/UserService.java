package demo14;

//接口都需要实现类的
public interface UserService {
    //接口中所有的定义其实都是抽象的 public
    //也就是说接口中的方法不写public abstract这俩 也是默认有的
    public abstract void run();
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);

    //接口中定义的属性都是常量  也是省略没写
    public static final int a=2;
    int b=3;
}
