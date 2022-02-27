package hashtable;

import java.util.Hashtable;
import java.util.*;
public class HashTableDemo {
	public static void main(String []args){
		
		Hashtable<Integer, Integer> i = new Hashtable<Integer, Integer>();
		i.put(1, 10);
		i.put(2, 20);
		i.put(3, 30);
		System.out.println("===================================");
		System.out.println(i);
		Hashtable<Integer, Integer> i3 = new Hashtable<>(i);
		System.out.println("===================================");
		System.out.println(i3);
		Hashtable<Integer, Integer> i4 = new Hashtable<>(10);
		System.out.println("===================================");
		i4.put(1, 1);
		i4.put(2, 2);
		i4.put(3, 17);
		i4.put(4, 4);
		i4.put(5, 5);
		i4.put(6, 6);
		i4.put(7, 7);
		i4.put(8, 8);
		i4.put(9, 9);
		i4.put(10, 10);
		i4.put(11, 11);
		

		Hashtable<Integer, String> str = new Hashtable<Integer, String>();
		System.out.println("===================================");
		str.put(1, "hello world1");
		str.put(2, "hello world2");
		str.put(3, "hello world3");
		str.put(4, "hello world4");

		System.out.println(str);
		System.out.println("===================================");
		i4.remove(11);
		System.out.println(i4);
		int test = i4.get(3);
		System.out.println(test);
	}
}
