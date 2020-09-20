package Practice3;

import static java.lang.Math.random;

public class InsertionSort {
    public static void main(String[] args) {
        double [] arr = new double[10000];

        for(int i = 0; i < arr.length; i++){
            arr[i] = random();
        }

        long start = System.currentTimeMillis();

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0 && less(arr[j], arr[j-1]); j--){
                exch(arr, j, j-1);
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("실행 시간 : " + (end - start) / 1000.0 + "초");

    }

    private static boolean less(double current, double min){
        if(current<min){
            return true;
        }else {
            return false;
        }
    }


    private static void exch(double[] arr, int i, int min){
        double temp;
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

}
