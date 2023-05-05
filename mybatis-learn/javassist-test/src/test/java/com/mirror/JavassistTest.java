package com.mirror;

import com.mirror.bank.dao.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JavassistTest {
    @Test
    public void testGenerateAccountDaoImpl() throws CannotCompileException, InstantiationException, IllegalAccessException,Exception {
        //获取类池
        ClassPool classPool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = classPool.makeClass("com.mirror.bank.dao.impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = classPool.makeInterface("com.mirror.bank.dao.AccountDao");
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中的所有方法
//        System.out.println(AccountDao.class.getDeclaredMethods().length);
//        for (Method declaredMethod : AccountDao.class.getDeclaredMethods()) {
//
//        }
        Method[] methods = AccountDao.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method->{
           //method是抽象方法现在要实现了
            try {
                StringBuilder methodCode=new StringBuilder();
                methodCode.append("public ");//追加修饰符列表
                methodCode.append(method.getReturnType().getName());//添加返回值类型
                methodCode.append(" ");
                methodCode.append(method.getName());//追加方法名
                methodCode.append("(");
                //拼接参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    //拼接形参名字
                    methodCode.append("arg"+i);
                    if(i!=parameterTypes.length-1){
                        methodCode.append(",");
                    }
                }
                methodCode.append("){System.out.println(内容);");
                //动态添加return语句
                String returnSimpleName = method.getReturnType().getSimpleName();
                if("void".equals(returnSimpleName)){

                }else if("int".equals(returnSimpleName)){
                    methodCode.append("return 1;");
                }else if("String".equals(returnSimpleName)){
                    methodCode.append("return \"hello\";");
                }
                methodCode.append("}");
                System.out.println(methodCode);
//                System.out.println(method.getName());
//                System.out.println(method.getReturnType().getName());
//                System.out.println(method.getReturnType().getSimpleName());
                System.out.println(methodCode.toString());
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        });
        //加载类
        Class<?> aClass = ctClass.toClass();
        //创建对象
        AccountDao accountDao = (AccountDao)aClass.newInstance();
        accountDao.insert("aa");
//        accountDao.update("aa",30.0);
//        accountDao.selectByActno("aa");
        accountDao.delete();
    }

    @Test
    public void testGenerateTmpl() throws CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取类池
        ClassPool classPool=ClassPool.getDefault();
        //制造类
        CtClass ctClass = classPool.makeClass("com.mirror.bank.dao.impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = classPool.makeInterface("com.mirror.bank.dao.AccountDao");
        //添加接口到类中
        ctClass.addInterface(ctInterface);
        //制造方法
        CtMethod ctMethod=CtMethod.make("public void delete(){System.out.println(\"hello delete.\");}",ctClass);
        //把方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class文件
        //加载class
        Class<?> aClass = ctClass.toClass();
        //创建对象
        AccountDao accountDao = (AccountDao) aClass.newInstance();
        //获取这个实现类的方法
//        Method delete = aClass.getDeclaredMethod("delete");
        //调用方法
//        delete.invoke(o);
        accountDao.delete();
    }


    @Test
    public void testGenerateFirstClass() throws CannotCompileException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取类池
        ClassPool pool=ClassPool.getDefault();
        //制造类 需要告诉javassist 类名是什么
        CtClass ctClass = pool.makeClass("com.mirror.bank.dao.impl.AccountDaoImpl");
        //制造方法
        String method = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod=CtMethod.make(method,ctClass);
        //把方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        ctClass.toClass();
        //类加载到jvm中  返回这个类的字节码
        Class<?> aClass = Class.forName("com.mirror.bank.dao.impl.AccountDaoImpl");
        //创建对象
        Object obj = aClass.newInstance();
        //获取这个实现类的方法
        Method insert = aClass.getDeclaredMethod("insert");
        //调用方法 调用obj的insert方法
        insert.invoke(obj);

    }
}
