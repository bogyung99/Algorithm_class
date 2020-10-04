package Practice5;

public class MergeSort <T extends Comparable<T>> {

    private void merge(T[] arr, T[] aux, int begin, int mid, int end) {
        assert isSorted(arr, begin, mid);
        assert isSorted(arr, mid + 1, end);

        for (int i = begin; i <= end; i++) {
            aux[i] = arr[i];
        }

        int l = begin;
        int r = mid + 1;

        for (int i = begin; i <= end; i++) {
            if (mid < l) {
                arr[i] = aux[r++];
            } else if (end < r) {
                arr[i] = aux[l++];
            } else if (aux[l].compareTo(aux[r]) == -1) {
                arr[i] = aux[l++];
            } else {
                arr[i] = aux[r++];
            }
        }
        assert isSorted(arr, begin, end);
    }

    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }


    private void exch(Object[] arr, int i, int j) {
        Object temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void sort(T[] arr, T[] aux, int begin, int end){
        // if(end <= begin) return;

        if(end-begin < 7){
            insertionSort(arr, begin, end);
            return;
        }

        int mid = (begin+end)/2;

        sort(arr, aux, begin, mid);
        sort(arr, aux, mid+1, end);

        if(arr[mid].compareTo(arr[mid+1]) != 1){
            return;
        }else{
            merge(arr, aux, begin, mid, end);
        }
    }

    private void insertionSort(T[] arr, int begin, int end){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 10, 3, 25, 20, 19, 1, 8};
        Integer[] aux = new Integer[arr.length];

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(arr, aux, 0, arr.length-1);
        System.out.println("Merge sort : ");
        mergeSort.show(arr);
    }
}