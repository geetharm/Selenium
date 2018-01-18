package org.geetha.junit.codingExercise;

import java.util.HashMap;
import java.util.Random;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.InvalidArgumentException;

public class CodingExerciseTest {

	private CodingExercise coding = new CodingExercise();

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Test
	public void test() {
		int arrayA[] = { 1, 2, 3, 4, 10, 20, 30 };
		int arrayB[] = { 20, 30, 1, 2, 1, 3, 4, 4, 5 };

		HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>() {
			{
				put(1, 3);
				put(2, 2);
				put(3, 2);
				put(10, 1);
				put(20, 2);
				put(30, 2);
				put(4, 3);
				put(5, 1);
			}
		};

		Assert.assertEquals(coding.mergeCounter(arrayA, arrayB), expected);
	}

	@Test
	public void testArray1Empty() {
		int arrayA[] = {};
		int arrayB[] = { 1, 3, 3, 4, 5 };

		HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>() {
			{
				put(1, 1);
				put(3, 2);
				put(4, 1);
				put(5, 1);
			}
		};

		Assert.assertEquals(coding.mergeCounter(arrayA, arrayB), expected);
	}

	@Test
	public void testArray2Empty() {
		int arrayA[] = { 12, 12, 12, 12, 12, 12, 12 };
		int arrayB[] = {};

		HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>() {
			{
				put(12, 7);
			}
		};

		Assert.assertEquals(coding.mergeCounter(arrayA, arrayB), expected);
	}

	@Test
	public void testBothArraysEmpty() {
		int arrayA[] = {};
		int arrayB[] = {};

		HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();

		m1 = coding.mergeCounter(arrayA, arrayB);
		Assert.assertTrue(m1.isEmpty());
	}

	@Test
	public void testArrayANull() {
		int arrayB[] = { 1, 2 };

		HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>() {
			{
				put(1, 1);
				put(2, 1);
			}
		};

		Assert.assertEquals(coding.mergeCounter(null, arrayB), expected);
	}

	@Test
	public void testArrayBNull() {
		int arrayA[] = { 1, 3, 3 };

		HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>() {
			{
				put(1, 1);
				put(3, 2);
			}
		};

		Assert.assertEquals(coding.mergeCounter(arrayA, null), expected);
	}

	@Test
	public void testBothArraysNull() {
		HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();

		m1 = coding.mergeCounter(null, null);
		Assert.assertTrue(m1.isEmpty());
	}

	@Test
	public void testValueMaximum() {
		int arrayA[] = { 10002, 1 };
		int arrayB[] = { 9999, 19998, 100 };

		e.expect(InvalidArgumentException.class);
		e.expectMessage("Found value : 10002, Value should be between 1 and 10000");
		coding.mergeCounter(arrayA, arrayB);
	}

	@Test
	public void testValueMinimum() {
		int arrayA[] = { -1, 1 };
		int arrayB[] = { 9999, 9998, 100 };

		e.expect(InvalidArgumentException.class);
		e.expectMessage("Found value : -1, Value should be between 1 and 10000");
		coding.mergeCounter(arrayA, arrayB);
	}

	@Test
	public void testArrayMaximum() {
		Random rand = new Random();
		int arrayA[] = new int[CodingExercise.MAXIMUM + 2];
		int arrayB[] = new int[10];

		for (int i = 0; i < CodingExercise.MAXIMUM + 2; ++i) {
			arrayA[i] = rand.nextInt(1000) + 1;
		}

		try {
			coding.mergeCounter(arrayA, arrayB);
			Assert.fail("Exception not thrown");
		} catch (InvalidArgumentException iae) {
			Assert.assertTrue(iae.getMessage().contains("Maximum size of the array is 10000"));
		}
	}
}