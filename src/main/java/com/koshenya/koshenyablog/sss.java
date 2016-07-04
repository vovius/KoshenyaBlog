package com.koshenya.koshenyablog;

/**
 * Created by sony on 7/1/2016.
 */
public class sss {
//    static Newlist getKrR(NewList nl, int k, Integer i) {
//
//        if (nl == null)
//            i = 0;
//        else {
//            getKrR(nl.next, k, i);
//            i++;
//            if (i == k)
//                System.out.println("result= " + nl.data);
//        }
//    }


    static NewList getKNodeFromEnd(NewList list, int k, int i, int max) {
        NewList result = null;
        if (list.next != null)
            result = getKNodeFromEnd(list.next, k, ++i, i);

        if (k == i)
            result = list;
        return result;
    }

    public static void main(String args[]) {
        NewList nl = new NewList(0);
        nl.appendLast(1);
        nl.appendLast(2);
        nl.appendLast(3);
        nl.appendLast(4);
        nl.appendLast(5);
        nl.print();

        NewList node = sss.getKNodeFromEnd(nl, 2, 0, -1);
        System.out.println(node.data);
    }
}
