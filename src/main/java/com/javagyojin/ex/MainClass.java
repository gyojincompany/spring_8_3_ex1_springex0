package com.javagyojin.ex;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String config = null;
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		if(str.equals("dev")) {			
			config = "dev";			
		} else if(str.equals("run")) {			
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().addActiveProfile(config);
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		
		 ServerInfo sInfo = ctx.getBean("serverInfo",ServerInfo.class);
		 System.out.println("IP : " + sInfo.getIpNumber());
		 System.out.println("PORT : " + sInfo.getPortNumber());
		 
		 ctx.close();
		
	}

}
