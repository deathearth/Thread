package com.chl.designpatterns;

/**
 * enum类的构造器和序列化都是由 jvm设定的。安全性高
 * @author chenhailong
 * 直接使用 SingleTonSimpleEnum.INSTANCE.getName(); 便是单例
 * 
 * 
 * https://blog.csdn.net/javazejian/article/details/71333103
 */
public enum  SingleTonSimpleEnum {
    INSTANCE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}