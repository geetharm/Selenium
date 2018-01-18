package mergearray;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class testcases {
	
	Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
	
	Random rn = new Random();
	FrequencyCount cc=new FrequencyCount();
	int al=rn.nextInt(10000) + 1;
	int bl=rn.nextInt(10000) + 1;
	int a[]=new int[al];
	int b[]=new int[bl];
	
	@Before
	public void init()
	{
		
		int val;
		
		for(int i=0;i<al;i++)
		{
			 val=rn.nextInt(10) + 1;
			if(map.containsKey(val))
				map.put(val,map.get(val)+1);
				else
					map.put(val, 1);
			a[i]=val;
		}
		for(int i=0;i<bl;i++)
		{
			val=rn.nextInt(10) + 1;
			if(map.containsKey(val))
				map.put(val,map.get(val)+1);
				else
					map.put(val, 1);

			b[i]=val;
		}
		
		
	}

	@Test
	public void TestCase001()
	{
	
		String str1=cc.mapString(map);
		String str2=cc.mergeCounter(a,b);
		assertEquals(str1,str2);
	}
	
	@Test
	public void TestCase002()
	{
	
		int b[]={};
		String str1=cc.mapString(map);
		String str2=cc.mergeCounter(a,b);
		assertEquals(str1,str2);
	}

}
