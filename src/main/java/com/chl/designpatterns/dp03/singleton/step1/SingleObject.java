package com.chl.designpatterns.dp03.singleton.step1;

public class SingleObject {

//	/*1����ʽ�����ײ���������ִ��Ч�ʸߣ��˷��ڴ�*/
//	private static SingleObject instance = new SingleObject();
//	//�ù��캯��Ϊprivate,��������Ͳ��ᱻʵ����
//	private SingleObject(){}
//	//��ȡΨһ���õĶ���
//	public static SingleObject getInstance(){
//		return instance;
//	}
//	public void showMessage(){
//		System.out.println("Hello Word!!!");
//	}
	
//	/*2����ʽ���̲߳���ȫ.��Ҫ���̰߳�ȫ���ڶ��̲߳�����������***/
//	private static SingleObject instance;
//	private SingleObject(){};
//	public static SingleObject getInstance(){
//		if(instance==null){
//			instance = new SingleObject();
//		}
//		return instance ;
//	}
	
//	/*3����ʽ���̰߳�ȫ.����֮��Ӱ��Ч��***/
//	private static SingleObject instance;
//	private SingleObject(){};
//	public synchronized static SingleObject getInstance(){
//		if(instance==null){
//			instance = new SingleObject();
//		}
//		return instance ;
//	}
	
//	/*4˫����/˫��У��,��ȫ���ڶ��߳�������ܱ��ָ�����*/
//	private volatile static SingleObject singleObject;
//	private SingleObject(){};
//	public static SingleObject getSingleObject(){
//		if(singleObject==null){
//			synchronized (singleObject) {
//				if(singleObject ==null){
//					singleObject = new SingleObject();
//				}
//			}
//		}
//		return singleObject;
//	}
	
//	/*�Ǽ�ʽ\��̬�ڲ���*/
//	private static class SingletonHolder {  
//		private static final SingleObject INSTANCE = new SingleObject();  
//  }  
//  private SingleObject (){}  
//  public static final SingleObject getInstance() {  
//  	return SingletonHolder.INSTANCE;  
//  }  
	
	/*ENUM ������߳�ͬ�����⣬���һ��Զ�֧�����л����ƣ���ֹ�����л����´����µĶ��󣬾��Է�ֹ���ʵ������*/
	public enum Singleton{
		INSTANCE;
		public void whateverMethod(){};
	}
	
}
