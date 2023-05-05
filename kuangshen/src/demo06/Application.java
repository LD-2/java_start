package demo06;

public class Application {
    //封装
    //高内聚，低耦合
    //高内聚：类的内部数据操作细节又自己完成，不允许外部干涉
    //低耦合：仅暴漏少量方法给外部使用
    //封装（数据的隐藏） 应禁止直接访问一个对象中数据的实际表示，而应通过操作接口来访问，称为信息隐藏
    //属性私有 get set
    public static void main(String[] args) {
        Student newS=new Student();
        newS.setName("mirror");
        newS.setAge(19);
        newS.setSex('1');
        System.out.printf("name: %s    age: %d    sex: %s\n",newS.getName(),newS.getAge(),newS.getSex());
        System.out.println();
    }
}
