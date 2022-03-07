package arraylist;

import java.util.Arrays;

public class ArrayListTestMain{
	public static void main(String []args){

		ArrayList al = new ArrayList();
		java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		arrayList.add(50);
		arrayList.set(2, 300);
		arrayList.add(2,3000);
		Integer exam = arrayList.remove(3);
		System.out.println("remove = " + exam);
		for (Integer a : arrayList){
			System.out.println(a);
		}
	}
}
