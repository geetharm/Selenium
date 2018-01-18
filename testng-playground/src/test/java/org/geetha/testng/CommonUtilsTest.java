package org.geetha.testng;

import java.util.List;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonUtilsTest {


	@Test
	public void testToList() {
		
		String string = "a,b,c,d";
		List<String> lString = new ArrayList<>();
		lString.add("a");
		lString.add("b");
		lString.add("c");
		lString.add("d");

		Assert.assertEquals(CommonUtils.toList(string), lString);
	}
	
	@Test
	public void testToListEmptyString() {
		
		List<String> lString = new ArrayList<>();
		Assert.assertEquals(CommonUtils.toList(""), lString);
	}
	
	@Test
	public void testGetAbsNumberGreatest() {
		Assert.assertEquals(CommonUtils.getAbsNumberGreatest("1035%", 2), 2);
	}

	@Test
	public void testGetAbsNumberGreatestWithNum() {
		Assert.assertEquals(CommonUtils.getAbsNumberGreatest("1", 1), 1);
	}

	@Test
	public void testGetAbsNumberGreatestWithPercent() {
		Assert.assertEquals(CommonUtils.getAbsNumberGreatest("15%", 1), 1);
	}

	@Test
	public void testGetAbsNumberGreatestWithoutNum() {
		Assert.assertEquals(CommonUtils.getAbsNumberGreatest("1ef5",-1), -1);
	}
	
	@Test
	public void testisPercentOrNumStrWithoutNum() {
		Assert.assertEquals(CommonUtils.isPercentOrNumStr("4f5"), false);
	}
	
	@Test
	public void testisPercentOrNumStrWithPercent() {
		Assert.assertEquals(CommonUtils.isPercentOrNumStr("45%"), true);
	}

	@Test
	public void testisPercentOrNumStrWithNum() {
		Assert.assertEquals(CommonUtils.isPercentOrNumStr("45"), true);
	}
	
	@Test
	public void testisPercentOrNumStr() {
		Assert.assertEquals(CommonUtils.isPercentOrNumStr("4f5%"), false);
	}

}
