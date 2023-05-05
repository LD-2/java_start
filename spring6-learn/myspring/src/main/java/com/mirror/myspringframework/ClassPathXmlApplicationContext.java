package com.mirror.myspringframework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map<String,Object> beanMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);
    public ClassPathXmlApplicationContext(String resource){
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(ClassLoader.getSystemClassLoader().getResourceAsStream(resource));
            // 获取所有的bean标签
            List<Node> beanNodes = document.selectNodes("//bean");
            System.out.println(beanNodes.size());
            // 遍历集合
            beanNodes.forEach(beanNode ->{
                Element beanElement = (Element) beanNode;
                // 获取id
                String id = beanElement.attributeValue("id");
                // 获取className
                String className = beanElement.attributeValue("class");
//                System.out.println(id);
//                System.out.println(className);
                logger.info("id: "+id);
                logger.info("className: "+className);
                try {
                    // 通过反射机制创建对象
                    Class<?> aClass = Class.forName(className);
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    Object o = declaredConstructor.newInstance();
                    // 存储到Map集合
                    beanMap.put(id,o);
                    System.out.println(beanMap.get(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再重新遍历集合，这次遍历是为了给Bean的所有属性赋值。
            // 思考：为什么不在上面的循环中给Bean的属性赋值，而在这里再重新遍历一次呢？
            // 通过这里你是否能够想到Spring是如何解决循环依赖的：实例化和属性赋值分开
            beanNodes.forEach(beanNode->{
                Element beanElement = (Element) beanNode;
                // 获取所有property标签
                List<Element> propertyNodes = beanElement.elements("property");
//                System.out.println(beanNodes.size());
                String className = beanElement.attributeValue("class");
                System.out.println("要赋值对象的Class信息"+className);
                // 获取bean的id
                String beanId = beanElement.attributeValue("id");
                System.out.println("要赋值赋值对象的beanId"+beanId);
                try {
                    Class<?> aClass = Class.forName(className);
                    propertyNodes.forEach(propertyNode->{
                        // 获取属性名
                        String propertyName = propertyNode.attributeValue("name");
                        System.out.println("被赋值者的属性名"+propertyName);
                        // 获取set方法名
                        String setMethodName = "set"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
                        System.out.println("被赋值者的方法名"+setMethodName);

                        try {
                            Field property = aClass.getDeclaredField(propertyName);
                            System.out.println("被赋值者的方法的参数类型"+property.getType());
                            Method declaredMethod = aClass.getDeclaredMethod(setMethodName, property.getType());
                            // 获取属性的值，值可能是value，也可能是ref。
                            // 获取value
                            String value = propertyNode.attributeValue("value");
                            System.out.println("属性值value"+value);
                            Object propertyVal = null;
                            if(value!=null){
                                switch (property.getType().getSimpleName()){
                                    case "byte": case "Byte":
                                        propertyVal = value.valueOf(value);
                                        break;
                                    case "short": case "Short":
                                        propertyVal = Short.valueOf(value);
                                        break;
                                    case "int": case "Integer":
                                        propertyVal = Integer.valueOf(value);
                                        break;
                                    case "long": case "Long":
                                        propertyVal = Long.valueOf(value);
                                        break;
                                    case "float": case "Float":
                                        propertyVal = Float.valueOf(value);
                                        break;
                                    case "double": case "Double":
                                        propertyVal = Double.valueOf(value);
                                        break;
                                    case "boolean": case "Boolean":
                                        propertyVal = Boolean.valueOf(value);
                                        break;
                                    case "char": case "Character":
                                        propertyVal = value.charAt(0);
                                        break;
                                    case "String":
                                        propertyVal = value;
                                        break;
                                }
                                System.out.println("----");
                                System.out.println("获取要赋值对象的id"+beanId);
                                System.out.println("获取这个id的对象(beanMap.get(beanId)"+beanMap.get(beanId)+beanMap.get(beanId).getClass());
                                declaredMethod.invoke(beanMap.get(beanId),propertyVal);
                                System.out.println("获取这个id的对象(beanMap.get(beanId)"+beanMap.get(beanId)+beanMap.get(beanId).getClass());
                            }
                            String ref = propertyNode.attributeValue("ref");
                            System.out.println("ref"+ref);
                            if(ref!=null){
                                // 该属性不是简单属性
                                System.out.println("----");
                                System.out.println("获取要赋值对象的id"+beanId);
                                System.out.println("获取这个id的对象(beanMap.get(beanId)"+beanMap.get(beanId)+beanMap.get(beanId).getClass());
                                declaredMethod.invoke(beanMap.get(beanId),beanMap.get(ref));
                                System.out.println("ref"+beanMap.get(ref));
                                System.out.println("获取这个id的对象(beanMap.get(beanId)"+beanMap.get(beanId)+beanMap.get(beanId).getClass());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beanMap.get(beanId);
    }
}


