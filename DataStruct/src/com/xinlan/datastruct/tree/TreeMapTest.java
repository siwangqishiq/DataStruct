package com.xinlan.datastruct.tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest
{
    public static void main(String[] args)
    {
        Map<String,String> map = new TreeMap<String,String>();
//        Map<String,String> map = new HashMap<String,String>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        
        for(Map.Entry<String, String> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }//end for 
    }
}//end class
