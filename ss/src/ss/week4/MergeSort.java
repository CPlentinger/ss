package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>>
           void mergesort(List<Elem> list) {
    	
    	List<Elem> left = new ArrayList<Elem>();
    	List<Elem> right = new ArrayList<Elem>();
    	int size = list.size();
    	int mid = size / 2;
    	
    	if (size>1) {
    			for (int i = 0; i < mid; i++) {
                	left.add(i, list.get(i));
            	}
    			for (int i = mid; i < size; i++) {
    			 	right.add(i-mid, list.get(i));
    			 
    			}
    		mergesort(left);
            mergesort(right);
            
            
            list.clear();
            while(!left.isEmpty() && !right.isEmpty())
            {
              if((left.get(0)).compareTo(right.get(0)) <= 0)
                list.add(left.remove(0));

              else
                list.add(right.remove(0));
            }

            while(!left.isEmpty())
              list.add(left.remove(0));

            while(!right.isEmpty())
              list.add(right.remove(0));
    }
    }
}

