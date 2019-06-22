package com.chl.rpc.common;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello"+name;
	}

	@Override
	public Person getPersion(String name) {
		Person p = new Person();
		p.setName(name);
		p.setAge(130);
		return p;
	}

}
