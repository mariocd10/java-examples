import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map.Entry;

public class WordHistogram {

	/**
	 * Create histogram of words read from input
	 */

	public static void main(String[] args) {
		/*
		use a hash table to store (word, frequency) pairs; the optional
		parameters are initial table size and load factor.
		*/

		HashMap<String, Integer> hm = new HashMap<String, Integer>(98000, (float) 0.2);
		Scanner s = new Scanner(System.in);
		s.useDelimiter("[^a-zA-Z]"); 
		//long start = System.currentTimeMillis();
		while (s.hasNext()) {
			String w = s.next();
			if(w.equals(""))
				continue;
			w = w.toLowerCase();
			if (hm.containsKey(w))
				hm.put(w, hm.get(w) + 1);
			else
				hm.put(w, 1);
		}
		//long t = System.currentTimeMillis()-start;
		//System.out.println("Time= "+t);


		/*
		Put entries into height-ballanced binary search tree,
		using a comparator that is based on frequencies.
		*/

		ValueComparator vc = new ValueComparator(hm);
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(vc);
		tm.putAll(hm);
		int count = 0;
		System.out.println("word\tfrequency");
		for(String key: tm.keySet()){
		  System.out.println(key+"\t"+tm.get(key));
		  if(++count > 40) break;
		}
		/*
		for (Entry<String, Integer> e : hm.entrySet()) {
			System.out.println(e.getValue()+" "+e.getKey());
		}
		*/
	}

}
