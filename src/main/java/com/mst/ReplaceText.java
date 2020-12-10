package com.mst;

import org.apache.commons.lang.StringEscapeUtils;

public class ReplaceText {

	public static void main(String[] args) {

		
		String str = "<math display='block'>\\r\\n <semantics>\\r\\n  <mrow></mrow>\\r\\n  <annotation encoding='MathType-MTEF'>MathType@MTEF@5@5@+=\\r\\n  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn\\r\\n  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr\\r\\n  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr\\r\\n  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs\\r\\n  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai\\r\\n  aabeqaamaabaabauaakaa@3F20@\\r\\n  </annotation>\\r\\n </semantics>\\r\\n</math>\\r\\n\\r\\n";
		
		str = str.replaceAll("<annotation(.*?/annotation>)", "");
		
		System.out.println(str);
		
		str = "<math display='block'> <semantics>  <mrow></mrow>  <annotation encoding='MathType-MTEF'>MathType@MTEF@5@5@+=  feaagKart1ev2aaatCvAUfeBSjuyZL2yd9gzLbvyNv2CaerbuLwBLn  hiov2DGi1BTfMBaeXatLxBI9gBaerbd9wDYLwzYbItLDharqqtubsr  4rNCHbWexLMBbXgBd9gzLbvyNv2CaeHbl7mZLdGeaGqiVu0Je9sqqr  pepC0xbbL8F4rqqrFfpeea0xe9Lq=Jc9vqaqpepm0xbba9pwe9Q8fs  0=yqaqpepae9pg0FirpepeKkFr0xfr=xfr=xb9adbaqaaeGaciGaai  aabeqaamaabaabauaakaa@3F20@  </annotation> </semantics></math>";
		
		str = str.replace("\r\n", "").replaceAll("<annotation(.*?/annotation>)", "");
		
		System.out.println(str);
		
		str = str.replace(" ", "");
		
		
		
		System.out.println(str);
	}

}
