package Week7;

import java.util.Scanner;
public class practice1 {
    public static int[][] drawSnail(int n){
        int count = 1;
        int[][] tmp = new int[n][n];
        int i, j;

        for(i=0; i<n; i++){
            for(j=0; j<n ; j++){
                tmp[i][j] = 0;
            }
        }
        tmp[0][0] = count++;
        i=0;
        j=0;

        while(count<=25){
            while(j<n-1 && tmp[i][j+1]==0){
                tmp[i][++j] = count++;
            }
            // printArr(tmp);
            while(i<n-1 && tmp[i+1][j]==0){
                tmp[++i][j] = count++;
            }
            while(j>0 && tmp[i][j-1]==0){
                tmp[i][--j] = count++;
            }
            while(i>0 && tmp[i-1][j]==0){
                tmp[--i][j] = count++;
            }
        }
        return tmp;
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n;
        n = keyboard.nextInt();
        int[][] arr;

        arr = drawSnail(n);
        printArr(arr);
    }

    public static void printArr(int[][] arr){
        for(int[] ar : arr) {
            for (int a : ar) {
                System.out.printf("%3d", a);
            }
            System.out.println();
        }
    }
}
