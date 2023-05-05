package com.mirror.client;

import com.mirror.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComPonentScan {
    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        String packageName = "com.mirror.bean";
        String packagePath = packageName.replaceAll("\\.","/");
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        System.out.println("packagePath: " + packagePath);
        System.out.println("url: " + url);
        String path = url.getPath();
        System.out.println(path);
        //获取一个绝对路径下的所有文件
        File file = new File(path);
        System.out.println("files: "+file);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            System.out.println(f+"     "+f.getName());
            String className = packageName + "." + f.getName().split("\\.")[0];
            System.out.println(className);
            try {
                Class<?> aClass = Class.forName(className);
                System.out.println(aClass);
                if(aClass.isAnnotationPresent(Component.class)){
                    String id = aClass.getAnnotation(Component.class).value();
                    Object o = aClass.newInstance();
                    map.put(id,o);
//                    System.out.println(map.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(map.toString());
    }
}
