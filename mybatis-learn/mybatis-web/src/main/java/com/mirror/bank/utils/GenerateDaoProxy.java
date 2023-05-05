package com.mirror.bank.utils;

import com.mirror.bank.dao.AccountDao;
import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 工具类 可以动态生成Dao的实现类 动态生成Dao的代理类
 *  返回Dao接口的实现类对象
 */
public class GenerateDaoProxy {
    public static Object generate(SqlSession sqlSession, Class daoInterface){
        //mybatis内置了javassist
        //类池
        ClassPool classPool = ClassPool.getDefault();
        //创建类
        CtClass ctClass = classPool.makeClass(daoInterface.getName()+"Proxy");
        //制造接口
        CtClass  ctInterface= classPool.makeInterface(daoInterface.getName());
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中的所有方法
        Method[] methods = AccountDao.class.getMethods();
        Arrays.stream(methods).forEach(method->{
            try {
                StringBuilder methodCode=new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                //添加形参
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg"+i);
                    if(i!=parameterTypes.length-1){
                        methodCode.append(",");
                    }
                }
                methodCode.append(")");
                methodCode.append("{");
                //添加内容
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = SqlSessionUtil.openSession();");
                //需要知道什么类型sql语句\
//                这是一个原因  为什么 用javassist的时候 要求mapper.xml文件的 namespace 和 id都是固定的 是dao的全限定类名 id是dao接口中的方法名
                String sqlId = daoInterface.getName()+ "."+method.getName();
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if(sqlCommandType == SqlCommandType.DELETE){

                }
                if(sqlCommandType == SqlCommandType.INSERT){

                }
                if(sqlCommandType == SqlCommandType.SELECT){
                    String returnType = method.getReturnType().getName();
                    methodCode.append("("+returnType+")sqlSession.selectOne(\""+sqlId+"\", arg0);");
                }
                if(sqlCommandType == SqlCommandType.UPDATE){
                    methodCode.append("return sqlSession.update(\""+sqlId+"\", arg0);");
                }
                methodCode.append("}");
                CtMethod ctMethod=CtMethod.make(methodCode.toString(),ctClass);
                ctClass.addMethod(ctMethod);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        });
        //创建对象
        Object obj=null;
        try {
            Class<?> aClass = ctClass.toClass();
            obj=aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
