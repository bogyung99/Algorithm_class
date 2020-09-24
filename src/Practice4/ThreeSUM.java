package Practice4;

import java.util.Arrays;

public class ThreeSUM {
    public static void main(String[] args) {
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};

        System.out.println("\n결과값은: " + count(arr));
    }

    public static int count(int[] a) {
        Arrays.sort(a);

        System.out.println("정렬된 배열: ");

        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        BinarySearch obj = new BinarySearch();

        int N = a.length;
        int cnt = 0;

        for(int i = 0; i< N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (obj.binarySearch(a, -(a[i] + a[j])) > j)
                    cnt++;
            }
        }
        return cnt;
    }

}
