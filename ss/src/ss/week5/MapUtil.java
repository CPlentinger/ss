package ss.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtil {
	
	//@ ensures \result == (\forAll K x,y; map.containsKey(x) && map.containsKey(y) && x != y; map.get(x) != map.get(y));
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
    
	//@ ensures \result == (\forAll V y; map.containsValue(y); range.containsValue(y); (\exists K x; map.containsKey(x); map.get(x) == y));
	/*@pure*/
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	for (K key : map.keySet()) {
    		range.remove(map.get(key));
    	}
        return range.isEmpty();
    }
    
    //@ ensures \result == (\forAll K x; map.inverse(map) == x);
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
    
    //@ ensures \result == (\forAll K x; map.inverseBijection(map) == x);
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
	
	//@ ensures \result == (\forAll K x; (\exists V y; f.get(x) == y && g.values().contains(y)));
	/*@pure*/
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
			return g.keySet().containsAll(f.values());
	}
	
	//@ ensures \result == (\forAll K x; (\forAll V y; f.get(x) == y; g.values().contains(y)));
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		HashMap<K, W> result = new HashMap<K, W>();
		for (K key : f.keySet()) {
			V val = f.get(key);
			for (Map.Entry<V, W> entry : g.entrySet()){
				if (entry.getKey().equals(val)) {
					result.put(key, entry.getValue());
				}
			}
		}
		return result;
	}
}
