package org.geetha.testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicates{
	
	public void removeDup () {

		List<String> arrayWithDup = (List<String>) Arrays.asList("aaa", "bbb", "aaa", "bbb", "ccc");

		System.out.println(arrayWithDup);
		
		HashSet<String> setWithDup = new HashSet<String>(arrayWithDup);
		
		List<String> arrayWithoutDup = new ArrayList<String>(setWithDup);
		
		System.out.println(arrayWithoutDup);
	}

	public int reverseNum(int number) {
		
		int revNum = 0;
		int mod = 0;
		
		while(number != 0) {
			mod = number%10;
			number /= 10;
			revNum = (revNum * 10) + mod;
		}
			
		System.out.println(revNum);
		return revNum;
	}

	public void reverseArray(int[] array){
		int swap;

		for(int i = 0; i < array.length/2; ++i){
			swap = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = swap;
		}
		
		for(int item: array){
			System.out.println(item);
		}
	}
	
	public boolean isPrime(int number) {
	
		if(number == 1)
			return false;
		
		for(int i = 2; i < Math.sqrt(number); ++i) {
			if((number%i) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int findOccurrences(String param, char c) {
		int count = 0;
		
		for(int i = 0; i < param.length(); ++i) {
			if(param.charAt(i) == c) {
				++count;
			}
		}
		
		return count;		
	}
	
	//code to filter duplicate elements from an array and print as a list
	public void findDuplicates() {
		
		ArrayList<String> array = new ArrayList<>();
		for(int i = 1; i <= 10; ++i) {
			array.add(String.valueOf(i));
		}
		
		for(int i = 1; i <= 5; ++i) {
			array.add(String.valueOf(i));
		}
		for(int i = 1; i <= 5; ++i) {
			array.add(String.valueOf(i));
		}
	
		Set<String> setDuplicate = new HashSet<>();
		Set<String> setOriginal = new HashSet<>();
		
		for(String data : array) {
			if(setDuplicate.contains(data)) {
				continue;
			} else {
				if(setOriginal.contains(data)) {
					setDuplicate.add(data);
					setOriginal.remove(data);
				} else {
					setOriginal.add(data);
				}
			}
		}

		Iterator it = setOriginal.iterator();
		while(it.hasNext()){
			System.out.println(it.next());			
		}

		/*
		HashMap<String, Integer> mapOriginal = new HashMap<>();
		
		for(String data : array) {
			if(mapOriginal.containsKey(data)){
				mapOriginal.put(data, mapOriginal.get(data)+1);
			} else {
				mapOriginal.put(data, 1);
			}
		}

		Set s = mapOriginal.entrySet();
		Iterator it = s.iterator();

		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			if(entry.getValue().equals(1)) {
				System.out.println(entry.getKey());
			}
		} */
	}
	
	public void findDuplicateChar(String input) {
		Set array = new LinkedHashSet<>();
		int count = 0;
		
		for(int i = 0; i < input.length(); ++i) {
			for(int j = i+1; j < input.length(); ++j) {
				if(input.charAt(i) == input.charAt(j)) {
					if(!array.contains(input.charAt(i))){
						array.add(input.charAt(i));
						break;
					}
				}
			}
		}

		Iterator it = array.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void main (String[] args) {
		
		RemoveDuplicates test = new RemoveDuplicates();
//		test.reverseNum(23567);
//		int[] array = {3,4,5,6,7,9};
//		test.reverseArray(array);
//		System.out.println(test.isPrime(37));
		
//		System.out.println(test.findOccurrences("Geetheea", 'e'));
//		test.findDuplicates();
		test.findDuplicateChar("Geteteteha");
	}
}