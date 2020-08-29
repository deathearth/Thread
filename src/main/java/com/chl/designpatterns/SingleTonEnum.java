package com.chl.designpatterns;

/**
 * 枚举单例
 * @author chenhailong
 *
 * 
 */
public class SingleTonEnum {

	private SingleTonEnum() {}
	
	enum SingleTon{
		INSTANCE;
		private SingleTonEnum ste;

		public SingleTonEnum getSte() {
			return ste;
		}

		public void setSte(SingleTonEnum ste) {
			this.ste = new SingleTonEnum();
		}
	}
	
	public static SingleTonEnum getInstance() {
		return SingleTon.INSTANCE.getSte();
	}
	
	
	public static void main(String[] args) {
		System.out.println(SingleTonEnum.getInstance());
	}
}
