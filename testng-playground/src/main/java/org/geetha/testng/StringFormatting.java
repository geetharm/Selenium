package org.geetha.testng;
class CountCharOccurences {
	public void countChar(){
		String input = "sales";
		int count = input.length() - input.replace("s", "").length();
		System.out.println(count);
	}

	public void removeWhiteSpaces(String str) {
		System.out.println(str.replace(" ", ""));
	}
}


class Convert {
	public String convertInttoString(int number) {
		return Integer.toString(number);
	}

	public int ConvertStringtoInt(String text) {
		//return Integer.valueOf(text);
		return Integer.parseInt(text);
	}
}

class ProveStringImmutable {
	public void prove(){
		System.out.println("Addresses of string concatenation");
		String test = "This ";
		System.out.println(test.hashCode());
		test += " ";
		System.out.println(test.hashCode());
		test += "is a test";
		System.out.println(test.hashCode());
		
		System.out.println("Addresses of stringbuilder concatenation");
		StringBuilder sb = new StringBuilder("That ");
		System.out.println(sb.hashCode());
		sb.append(" ");
		System.out.println(sb.hashCode());
		sb.append("is a sample"); 
		System.out.println(sb.hashCode());
		
		String s1 = "Java";
		System.out.println(s1.hashCode());
		String s2 = "Java";
		System.out.println(s2.hashCode());
		if(s1 == s2) 
			System.out.println("Addresses are equal");
		
		s1 = "HTML";
		System.out.println(s1.hashCode());
		if(s1 == s2)
			System.out.println("Addresses are not equal");
		
	}
}

class Frog {
	private int id;
	private String name;

	public Frog(int id, String name) {
		this.id = id;
		this.name = name;			
	}
	
	public String toString() {
//		return id + ": " + name;
		
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(": ").append(name);
		return sb.toString();
	}
	
	public String addArray(String[] names) {
		StringBuilder text = new StringBuilder();

		for(int i = 0; i < names.length; ++i) {
			text.append(names[i]);
			
			if(i < (names.length - 1))
				text.append(" ");
		}
		return text.toString();
	}
	
}

public class StringFormatting {

	public static void main(String[] args) {
		
		double value = 1567.7889; 
		String str = String.format("%010.2f", value);
		System.out.println(str);
		
		Frog frog1 = new Frog(5, "ABCD");
		System.out.println(frog1);
		
		Frog frog2 = new Frog(6, "EFGH");
		System.out.println(frog2);
		
		String[] input = {"cow", "cat" , "dog"};
		System.out.println(frog1.addArray(input));
		
		CountCharOccurences cc = new CountCharOccurences();
		cc.countChar();
		
		String test = "This is a te st";
		cc.removeWhiteSpaces(test);
		
		Convert c1 = new Convert();
		System.out.println(c1.convertInttoString(5));
		
		Convert c2 = new Convert();
		System.out.println(c2.ConvertStringtoInt("15"));
		
		ProveStringImmutable p1 = new ProveStringImmutable();
		p1.prove();
	}
}
