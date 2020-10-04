package Practice5;

public class InsertionSort2<T extends Comparable<T>> {

    public void sort(T[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
                assert isSorted(a);
            }
            assert  isSorted(a);
        }
    }

    private boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }


    private void exch(Object[] arr, int i, int j){
        Object temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isSorted(T[] a){
        return isSorted(a, 0, a.length - 1);
    }

    private boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Object[] a){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 10, 3, 25, 20, 19, 1, 8};

        InsertionSort2<Integer> insertionSort = new InsertionSort2<Integer>();

        insertionSort.sort(arr);
        System.out.println("Insertion sort : ");
        insertionSort.show(arr);
    }
}
