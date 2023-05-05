package com.mirror.demo11;

//ORM Object relationship Mapping 对象关系映射
//类和表结构对应
//属性和字段对应
//对象和记录对应

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c1=Class.forName("com.mirror.demo11.Student");
        Annotation[] annotation=c1.getAnnotations();
        for(Annotation x:annotation){
            System.out.println(x);
        }

        //获得注解得value值
        TableMirror annotation2=(TableMirror)c1.getAnnotation(TableMirror.class);
        String value=annotation2.value();

        System.out.println(annotation2.getClass());

        //获得类得属性得值
        Field f=c1.getDeclaredField("name");
        FieldMirror annotation3=f.getAnnotation(FieldMirror.class);
        System.out.println(annotation3.columnName());
        System.out.println(annotation3.type());
        System.out.println(annotation3.length());
    }
}

@TableMirror("db_Student")
class Student {
    @FieldMirror(columnName = "name",type = "varchar",length="3")
    private String name;
    @FieldMirror(columnName = "age",type = "int",length="10")
    private int age;
    @FieldMirror(columnName = "id",type = "int",length="10")
    private int id;

    public Student() {
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TableMirror{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldMirror{
    String columnName();
    String type();
    String length();
}