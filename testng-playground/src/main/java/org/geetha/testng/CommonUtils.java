package org.geetha.testng;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CommonUtils {

	public static <T> List<List<T>> split(List<T> list, int size)
			throws NullPointerException, IllegalArgumentException {
		if (list == null) {
			throw new NullPointerException("The list parameter is null.");
		}

		if (size <= 0) {
			throw new IllegalArgumentException("The size parameter must be more than 0.");
		}

		List<List<T>> result = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			result.add(new ArrayList<>());
		}

		int index = 0;

		for (T t : list) {
			result.get(index).add(t);
			index = (index + 1) % size;
		}

		return result;
	}

	public static List<String> toList(String commaSeparatedString) {
		if (StringUtils.isEmpty(commaSeparatedString)) {
			return new ArrayList<>();
		}
		return Arrays.stream(commaSeparatedString.split(",")).map(String::trim).collect(Collectors.toList());
	}

	public static int getAbsNumberGreatest(final String percentOrNumStr, final int size) {
		int ret;
		try {
			if (isPercentage(percentOrNumStr)) {
				NumberFormat nf = NumberFormat.getPercentInstance();
				ret = (int) Math.ceil((nf.parse(percentOrNumStr).doubleValue() * size));
			} else {
				ret = Integer.parseInt(percentOrNumStr);
			}
		} catch (ParseException | NumberFormatException e) {
			// unable to parse the threshold value, assume 100% threshold
			ret = size;
		}
		if (ret <= 0) {
			ret = 1;
		}
		return Math.min(ret, size);
	}

	public static boolean isPercentage(final String percentNum) {
		if (percentNum.length() >= 2 && percentNum.endsWith("%")) {
			String numberString = percentNum.substring(0, percentNum.length() - 1);
			return NumberUtils.isNumber(numberString);
		}

		return false;
	}

	public static boolean isPercentOrNumStr(final String percentOrNumStr) {
		return isPercentage(percentOrNumStr) || NumberUtils.isNumber(percentOrNumStr);
	}
}