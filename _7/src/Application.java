import com.mirror.Hero;
import com.mirror.impl.Athena;
import com.mirror.impl.Zeus;

public class Application {
    public static void main(String[] args) {
        //抽象类和接口只不过是不可以自己实例化对象但是其引用类型可以指向 可继承其的子类或者实现其的类 的实例对象
        Hero[] heroes={
          new Zeus(),
          new Athena()
        };
        for(Hero hero:heroes){
            hero.greet();
        }
    }
}
