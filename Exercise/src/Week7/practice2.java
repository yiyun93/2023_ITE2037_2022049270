package Week7;

import java.util.Scanner;
import java.util.Random;
public class practice2 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int count = 0;

        int[][] numBoard = new int[4][4];
        boolean[][] checkBoard = new boolean[4][4];

        fillBoard(numBoard);
        printArr(numBoard, checkBoard);

        while(count<8){
            System.out.println(" Enter coordinate: ");
            int x1, y1, x2, y2;
            y1 = keyboard.nextInt()-1;
            x1 = keyboard.nextInt()-1;
            y2 = keyboard.nextInt()-1;
            x2 = keyboard.nextInt()-1;

            if(numBoard[y1][x1] == numBoard[y2][x2]){
                if(checkBoard[y1][x1])
                    System.out.println("Enter other coordinate");
                else{
                    checkBoard[y1][x1] = true;
                    checkBoard[y2][x2] = true;
                    count++;

                    System.out.printf("%d == %d\n", numBoard[y1][x1], numBoard[y2][x2]);
                }
            }
            else{
                System.out.printf("%d != %d\n", numBoard[y1][x1], numBoard[y2][x2]);
            }
            printArr(numBoard, checkBoard);
            System.out.println();

//            printAns(numBoard);
//            System.out.println(count);
        }
        System.out.println("Complete!");

    }

    public static void fillBoard(int[][] numBoard){
        Random rnd = new Random();
        int[] checkNums = new int[9];

        int k;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                while(true){
                    k = rnd.nextInt(1,9);
                    if(checkNums[k]<2){
                        checkNums[k]++;
                        numBoard[i][j]=k;
                        break;
                    }
                }
            }
        }
    }

    public static void printArr(int[][] arr, boolean[][] checkArr){
        System.out.printf(" %3d%3d%3d%3d\n",1,2,3,4);
        for(int i=0 ; i<4; i++) {
            System.out.printf("%d", i+1);
            for (int j=0; j<4; j++) {
                if(checkArr[i][j])
                    System.out.printf("%3d", arr[i][j]);
                else
                    System.out.printf("%3c", '*');
            }
            System.out.println();
        }
    }

    public static void printAns(int[][] arr){
        for(int[] ar : arr) {
            for (int a : ar) {
                System.out.printf("%3d", a);
            }
            System.out.println();
        }
    }

}
