package ss.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	ArrayList<Object> keys = new ArrayList<Object>(map.keySet());
    	ArrayList<Object> temp = new ArrayList<Object>();
    	for (int i=0; i < keys.size(); i++) {
    		if (temp.contains((map.get(keys.get(i))))) {
    			return false;
    		}
    		temp.add(map.get(keys.get(i)));
    	}
        return true;
    }
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	ArrayList<Object> keys = new ArrayList<Object>(map.keySet());
    	for (int i=0; i < keys.size(); i++) {
    		range.remove(map.get(keys.get(i)));
    	}
        return range.isEmpty();
    }
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	ArrayList<K> k = new ArrayList<K>(map.keySet());
    	ArrayList<V> v = new ArrayList<V>();
    	HashMap<V, Set<K>> result = new HashMap<V, Set<K>>();
    	for (int i=0; i < k.size(); i++) {
    		v.add(map.get(k.get(i)));
    	}
    	for (int i=0; i<k.size(); i++) {
    		for (int j=0; j<k.size(); j++) {
    			if (map.get(k.get(i)) == map.get(k.get(j)) && i!=j && !result.containsKey(map.get(k.get(i)))) {
    				result.put(v.get(i), new HashSet<K>(Arrays.asList(k.get(i), k.get(j))));
    				System.out.println(result.toString());
    				break;
    			}
    		}
    		if (!result.containsKey(v.get(i))) {
    			result.put(v.get(i), new HashSet<K>(Arrays.asList(k.get(i))));
    			System.out.println(result.toString());
    		}
    	}
    	return result;
    	
    
    	
    	
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		ArrayList<V> values = new ArrayList<V>(inverse(map).keySet());
		ArrayList<Set<K>> keyset = new ArrayList<Set<K>>(inverse(map).values());
		HashMap<V, K> test = new HashMap<V,K>();
		if (isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(map.values()))) {
			for (int i=0; i<values.size(); i++) {
				ArrayList<K> keys = new ArrayList<K>(keyset.get(i));
				test.put(values.get(i), keys.get(i));
			}			
			return test;
		}
		return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
