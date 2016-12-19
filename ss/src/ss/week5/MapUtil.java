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
	
	//@ ensures \result == \forall int i; i >= 0 & i < map.keyset().size(); \exists ! map.get(i);
	/*@pure*/
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	ArrayList<Object> temp = new ArrayList<Object>();
    	for (K key : map.keySet()) {
    		if (temp.contains((map.get(key)))) {
    			return false;
    		}
    		temp.add(map.get(key));
    	}
        return true;
    }
    
    /*@pure*/
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	for (K key : map.keySet()) {
    		range.remove(map.get(key));
    	}
        return range.isEmpty();
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	HashMap<V, Set<K>> result = new HashMap<V, Set<K>>();
    	for (K key : map.keySet()) {
    		HashSet<K> keys = new HashSet<K>();
    		for (Map.Entry<K,V> entry : map.entrySet()) {
    			if (entry.getValue().equals(map.get(key))) {
    				keys.add(entry.getKey());
    				}
    			}
    		result.put(map.get(key), keys);
    		}
    	return result;
    	}
    	
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		HashMap<V, K> result = new HashMap<V,K>();
		if (isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(map.values()))) {
			for (K key : map.keySet()) {
				result.put(map.get(key), key);
			}			
			return result;
		}
		return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		for (W w : g.values()) {
			if (!f.containsKey(w)) {
				return false;
			}
			HashMap<W, V> v = new ArrayList<V>(g.keySet());
			if (f.get(w) != v.get()) {
				
			}
		}
		return true;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		return null;
	}
}
