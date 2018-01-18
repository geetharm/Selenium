package org.geetha.testng;

import java.io.IOException;

import org.testng.annotations.Test;

public class testException {

	@Test//(expectedExceptions = ArithmeticException.class)
	public void test() {
		
		try{
			int e = 1/0;			
		} catch (ArithmeticException ae) {
			System.out.println("Exception caught");
		}
	}
	
	@Test(expectedExceptions = {IOException.class, ArithmeticException.class}, expectedExceptionsMessageRegExp = "pass")
	public void test1() throws IOException{
		//int e = 1/0;
		throw new IOException("pass");
	}
	
}

