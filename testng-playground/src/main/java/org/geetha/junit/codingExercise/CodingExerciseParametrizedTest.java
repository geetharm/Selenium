package org.geetha.junit.codingExercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class CodingExerciseParametrizedTest {

	private CodingExercise coding = new CodingExercise();
	private int array1[];
	private int array2[];
	private HashMap<Integer, Integer> expected;

	public CodingExerciseParametrizedTest(int a[], int b[], HashMap<Integer, Integer> expected) {
		this.array1 = a;
		this.array2 = b;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		int arr1[] = { 1, 1 };
		int arr2[] = { 1, 4 };
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1, 3);
		map1.put(4, 1);
		return Arrays.asList(new Object[][]{ { arr1, arr2, map1 } });
	}

	@Test
	public void testWithParam() {
		Assert.assertEquals(coding.mergeCounter(this.array1, this.array2), this.expected);
	}
}