package Practice1;

import java.util.Scanner;

public class Pract1 {

    static int[] arr = new int[6];
    static int mem[] = new int[100];

    public static int CumulativeSum(int n){

        if(n == 0) {
            return arr[0];
        }
        else if(mem[n] != 0) {
            return mem[n];
        }

        mem[n] = arr[n] + CumulativeSum(n - 1);

        return mem[n];
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("배열을 입력해주세요 : ");

        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }

        System.out.println("갱신된 배열 : ");

        for (int i = 0; i < 6; i++){
            System.out.println(CumulativeSum(i));
        }
    }
}
