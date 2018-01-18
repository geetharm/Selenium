package org.geetha.junit.codingExercise;

import java.util.HashMap;

import org.openqa.selenium.InvalidArgumentException;

public class CodingExercise {

	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static final int MAXIMUM = 10000;
	public static final int MINIMUM = 1;

	public void addMap(int number) throws InvalidArgumentException {
		if ((number > MAXIMUM) || (number < MINIMUM)) {
			throw new InvalidArgumentException("Found value : " + number + ", Value should be between 1 and 10000");
		}

		if (map.get(number) != null) {
			int count = map.get(number);
			map.put(number, ++count);
		} else {
			map.put(number, 1);
		}
	}

	public HashMap<Integer, Integer> mergeCounter(int[] a, int[] b) throws InvalidArgumentException {
		if (a == null) {
			a = new int[0];
		}
		if (b == null) {
			b = new int[0];
		}

		int maxLength = a.length > b.length ? a.length : b.length;
		if (maxLength > MAXIMUM) {
			throw new InvalidArgumentException("Maximum size of the array is 10000");
		}

		for (int i = 0; i < maxLength; i++) {
			if (i < a.length) {
				addMap(a[i]);
			}

			if (i < b.length) {
				addMap(b[i]);
			}
		}
		return map;
	}
}