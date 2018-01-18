package org.geetha.testng;

public class Calculator {

	public int add(int a, int b) {
		this.sleep();
		return a + b;
	}

	public int subtract(int a, int b) {
		this.sleep();
		return a - b;
	}

	public int multiply(int a, int b) {
		this.sleep();
		return a * b;
	}

	public int div(int a, int b) {
		this.sleep();
		return a / b;
	}

	private void sleep() {
/*		try{
			Thread.sleep(2000);
		}catch (InterruptedException e){
			
		}*/
	}
}
