package set;

import java.util.*;

class  treaTap{
    public static void  main (String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] a =new int[] {2, 4, 6, 8,10};
        for (int t: a){
            list.add(t);
        }
         list.sort(null);

        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(2));
        System.out.println(list.indexOf(11));
        System.out.println(list.indexOf(0));
        System.out.println(list.indexOf(7));
    }
}
