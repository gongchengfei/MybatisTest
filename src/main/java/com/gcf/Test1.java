package com.gcf;

import java.util.HashSet;
import java.util.Set;

public class Test1 {

      private static Set<String> result = new HashSet<String>();

      public static void main(String[] args) {
         char[] a = {'a','b','c'};

            permutation(a, 0, 2);
            System.out.println(result);
         }


        private static void permutation(char[] a, int from, int to) {
                 if(a== null || from>to || from<0) {
                         return;
                     }
                 if(from == to) {
                         result.add(String.valueOf(a));
                     }
                 for(int i = from; i <= to; i++) {
                         swap(a,i,from);
                         permutation(a, from +1,to);
                        swap(a,i,from);
                    }
             }


         private static void swap(char[]a, int left, int right) {
                 char temp = a[left];
                 a[left] = a[right];
                 a[right] = temp;
             }
 }

