package org.geetha.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class CalculatorTest {
	private Calculator calc = new Calculator();

	@BeforeTest(groups = {"testMul", "testCoun"})
	public void setUp(){
		
	}
	@Test(dependsOnGroups = "init")
	public void testAdd() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(calc.add(5, 6), 11);
		System.out.println("Soft assert executed");
		Assert.assertEquals(calc.add(5, 6), 11);
		System.out.println("Soft assert all executed");
		sa.assertAll();
	}

	@Test(enabled = false)
	public void testAddLargeNumbers() {
		int c = calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
		System.out.println(c);
		Assert.assertEquals(c, 11);
	}

	@Test(dataProvider = "abc", groups = "init")
	public void testSub(Integer a, Integer b, Integer c) {
		Assert.assertEquals(calc.subtract(a, b), (int) c);
	}

	@Test(dependsOnMethods = { "testSub" }, groups = "testMul", alwaysRun = true, dataProvider = "test")
	public void testMul(Integer a, Integer b, Integer c) {
		Assert.assertEquals(calc.multiply(a, b), (int) c);
	}

	@Test(groups = { "init" })
	public void testdiv() {
		Assert.assertEquals(calc.div(10, 2), 5);
	}

	@DataProvider(name = "abc", parallel = true)
	public Object[][] createInput1(Method m) {
		if (m.getName().equalsIgnoreCase("testSub")) {
			return new Object[][] { { new Integer(8), new Integer(5), new Integer(3) },
					{ new Integer(5), new Integer(2), new Integer(3) },
					{ new Integer(5), new Integer(4), new Integer(1) } };
		} else {
			return new Object[][] { { "Canada" } };
		}
	}

	@Test(dataProvider = "abc")
	public void testCountry(String string) {
		System.out.println(string);
	}

	@Test(groups = "testCoun", enabled = true)
	public void testCoun() {
		System.out.println("testCoun");
	}

	@DataProvider (name = "test")
	public Object[][] createInputforMul(ITestContext c) {

		Object[][] groupArray = null;

//		for (String s : c.getIncludedGroups()) {
//			if (s.equalsIgnoreCase("testMul")) {
				groupArray = new Object[][] { { new Integer(8), new Integer(5), new Integer(40) },
						{ new Integer(5), new Integer(2), new Integer(10) },
						{ new Integer(5), new Integer(4), new Integer(20) } };
//				break;
//			} else {
//				groupArray = new Object[][] { { "Russia" } };
//			}
//		}
		
		return groupArray;
	}

}
