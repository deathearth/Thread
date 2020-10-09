package com.chl.tools;

public class ReplaceTest {
	
	public static void main(String[] args) {
		String str = "<img  src=http://filegateway.test.mistong.com/api/filecenter/fileService/file/751551399139360769/>\" "
				+ "data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math»\r\n" + 
				" «semantics»\r\n" + 
				"  «mrow»\r\n" + 
				"   «mn»21«/mn»«/mrow»\r\n" + 
				"  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=\r\n" + 
				"  feaagKart1ev2aqatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn\r\n" + 
				"  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr\r\n" + 
				"  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr\r\n" + 
				"  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs\r\n" + 
				"  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai\r\n" + 
				"  aabeqaamaabaabauaakeaacaaIYaGaaGymaaaa@4099@\r\n" + 
				"  «/annotation»\r\n" + 
				" «/semantics»\r\n" + 
				"«/math»\r\n" + 
				"\r\n" + 
				"«/math»\"/>";
//		System.out.println(str.replaceAll("\\<img.*?»", " ").replaceAll("\\«math».*?\\/>", ""));
//		
//		System.out.println("---");
//		
//		System.out.println(str.replaceAll("\\<img.*?\\/>", " "));
		
		
		str = " «math»«semantics»" + 
				"  «mrow»\r\n" + 
				"   «mn»21«/mn»«/mrow»\r\n" + 
				"  «annotation encoding='MathType-MTEF'»MathType@MTEF@5@5@+=\r\n" + 
				"  feaagKart1ev2aqatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn\r\n" + 
				"  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr\r\n" + 
				"  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr\r\n" + 
				"  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs\r\n" + 
				"  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai\r\n" + 
				"  aabeqaamaabaabauaakeaacaaIYaGaaGymaaaa@4099@\r\n" + 
				"  «/annotation»\r\n" + 
				" «/semantics»\r\n" + 
				"«/math»\r\n" + 
				"\r\n" + 
				"«/math»\"/>";
		
		System.out.println(str.replaceAll("«math».*?«/math»", ""));
		
	}

}
