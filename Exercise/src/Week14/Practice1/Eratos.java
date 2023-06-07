package Week14.Practice1;

import java.util.ArrayList;

public class Eratos {
     public static ArrayList<Integer> sieve(int n){
         boolean[] list = new boolean[n+1];
         ArrayList<Integer> plist = new ArrayList<>();

         list[1] = true;
         for(int i=2; i<=n; i++){
             if(!list[i]){
                 list[i] = true;
                 plist.add(i);
                 for(int j=i; j<=100; j+=i){
                     list[j]=true;
                 }
             }
         }
         return plist;
     }
}
