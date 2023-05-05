package com.ld;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public void reOrderArray(int[] array) {
        List<Integer> list=new LinkedList<Integer>();
        for(int x:array){
            if(x%2!=0)list.add(x);
        }
        for(int x:array) {
            if (x % 2 == 0) list.add(x);
        }
        int idx=0;
        for(Integer integer:list){
            array[idx++]=integer;
        }
    }
}
