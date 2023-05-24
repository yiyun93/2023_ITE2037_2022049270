package Week12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
        Scanner inputStream = null;
        try{
            inputStream = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e){
            System.out.println("input.txt was not found");
            System.exit(0);
        }

        int[] target = new int[100];
        int[] arr = new int[100000];
        int i;
        for(i=0; i<100; i++){
            target[i] = inputStream.nextInt();
            inputStream.nextLine();
        }
        for(i=0; i<100000; i++){
            arr[i] = inputStream.nextInt();
            inputStream.nextLine();
        }

        for(i=0; i<100; i++){
            int index = bSearch(arr, 0, 99999, target[i]);
            System.out.printf("target: %7d   index: %5d\n", target[i], index);
        }
    }

    public static int bSearch(int[] arr, int start, int end, int x){
        int middle;
        if(start<=end){
            middle = (start+end)/2;
            if(arr[middle]==x) return middle;
            else if(arr[middle]>x) return bSearch(arr, start, middle-1, x);
            else return bSearch(arr, middle+1, end, x);
        }
        return -1;
    }

}
