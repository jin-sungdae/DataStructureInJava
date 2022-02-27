package set;

import java.util.*;


public class TreeSetDataStructure{
   
    
    public static void main(String []args){
        Set<String> tSet = new TreeSet<String>();
        Set<String> tSet2 = new TreeSet<>();
        Set<String> tSet3 = new TreeSet<String>(Arrays.asList("a", "b"));
        
        tSet.add("e");
        tSet.add("c");
        tSet.add("g");
        tSet.add("f");
        tSet.add("d");
        tSet.addAll(tSet3);
        
        System.out.println("-Contain Test");
        System.out.println("a contain : " + tSet.contains("a"));
        System.out.println("tSet3 value Contain : " + tSet.containsAll(tSet3));
        System.out.println();
        
        System.out.println("-OutPut Test");
        System.out.println("output 1 : iterator use");
        Iterator<String> iter = tSet.iterator();
        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
        System.out.println("output 2 : in forEach use");
        tSet.forEach(System.out::print);
        System.out.println("\n");
        
        System.out.println("output 3 : out forEach use");
        for (String s : tSet){
            System.out.println(s + " ");
        }
        System.out.println();
    }
}