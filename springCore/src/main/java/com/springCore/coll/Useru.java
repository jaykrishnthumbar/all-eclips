package com.springCore.coll;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Useru {

	public static void main(String[] args) {
//		ApplicationContext con = new ClassPathXmlApplicationContext("com/springCore/coll/collConfig.xml");
//		User2 user2 = (User2) con.getBean("user2");
		
		Resource resource=new ClassPathResource("com/springCore/coll/collConfig.xml");  
		BeanFactory factory=new XmlBeanFactory(resource);
		User2 user2 = (User2) factory.getBean("user2");
		
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getEmail());
		System.out.println(user2.getNumber());
	}

}
