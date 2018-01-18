package org.geetha.testng;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestExcepSubClass extends testException {

	
//	public static void main(String[] args) throws IOException{
//		TestExcepSubClass c1 = new TestExcepSubClass();
//		c1.test();
//	}
	
	@Test
	public void testMethod(){
		System.out.println("test include method");
	}
	
}
