package org.geetha.testng;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashmapSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "ONE");
		map.put(2, "TWO");
		map.put(3, "THREE");
		Set s = map.entrySet();
		Iterator it = s.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
//			System.out.println(it.next());
		}
	
		HashSet<String> set = new HashSet<String>();
		set.add("FOUR");
		set.add("FOUR");
		set.add("FIVE");
		Iterator<String> it1 = set.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		
		
		
	}

}
