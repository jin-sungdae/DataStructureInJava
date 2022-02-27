package set;

import java.util.*;


public class HashSetDataStructure{
   
    
    public static void main(String []args){
        Set<String> hSet = new HashSet<String>();
        Set<String> hSet2 = new HashSet<>();
        Set<String> hSet3 = new HashSet<String>(Arrays.asList("a", "b"));
        
        HashSet<String> hSet4 = new HashSet<String>();
        HashSet<String> hSet5 = new HashSet<>();
        HashSet<String> hSet6 = new HashSet<String>(Arrays.asList("a", "b"));
        
        hSet.add("e");
        hSet.add("c");
        hSet.add("g");
        hSet.add("f");
        hSet.add("d");
        hSet.addAll(hSet3);
        
        System.out.println("-Contain Test");
        System.out.println("a contain : " + hSet.contains("a"));
        System.out.println("hSet3 value contain : " + hSet.containsAll(hSet3));
        System.out.println();
        
        System.out.println("-OutPut Test");
        System.out.println("iterator use");
        Iterator<String> iter = hSet.iterator();
        while (iter.hasNext()){
            String str1 = iter.next();
            System.out.println(str1);
        }
        System.out.println("\n");
        
        System.out.println("-OutPut 2 : use forEach function");
        hSet.forEach(System.out::print);
        System.out.println("\n");
        
        String str = "abc";
        System.out.println(str.hashCode());
    }
}