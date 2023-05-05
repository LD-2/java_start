import com.alibaba.fastjson.JSON;
import com.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(1,"mirror","20","guangdong");

        //将person对象转换成json格式的字符串
        //使用阿里巴巴的fastjson组件中的JSON类即可
        //fastjson中又一个类，叫做JSON。全大写
        //JSON类中的方法都是静态方法，直接调用
        String jsonStr= JSON.toJSONString(person);
        System.out.println(jsonStr);

        //将List集合转为数组
        List<Person> list=new ArrayList<Person>();
        list.add(new Person(1,"mirror","20","guangdong"));
        list.add(new Person(2,"ld","20","guangdong"));
        String jsonList=JSON.toJSONString(list);
        System.out.println(jsonList);
    }
}
