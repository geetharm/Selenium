package mergearray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyCount {
	

	String mergeCounter(int[] a, int[] b) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		int i=0,j=0,k=0;
		int al=a.length;
		int bl=b.length;
		int l=al+bl-1;
		while(i<=l && a.length>0 && b.length>0)
		{
			if(j<a.length)
			{
				if(map.containsKey(a[j]))
					map.put(a[j],map.get(a[j])+1);
					else
						map.put(a[j], 1);
				j++;
			}
			else if(k<b.length)
			{
				if(map.containsKey(b[k]))
					map.put(b[k],map.get(b[k])+1);
					else
						map.put(b[k], 1);
				k++;
			}
			else
			{
				break;
			}
			i++;
		}
		
		String response=mapString(map);
		return response;
		
	}


public String mapString(Map<Integer, Integer> map) {
    Iterator i =   map.entrySet().iterator();
     
    if (! ( i).hasNext())
        return "{}";

    StringBuilder sb = new StringBuilder();
    sb.append('{');
    for (;;) {
      Map.Entry<Integer,Integer>  e = ( Map.Entry<Integer, Integer>) i.next();
        int key = e.getKey();
        int value = e.getValue();
        sb.append(key);
        sb.append(':');
        sb.append(value);
        if (! i.hasNext())
        {
            return sb.append('}').toString();
        }
        sb.append(", ");
    }
}
}

	

