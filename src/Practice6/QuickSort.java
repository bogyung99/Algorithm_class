package Practice6;

public class QuickSort <T extends Comparable<T>> {

    private int CUTOFF = 7;

    private int partition(T[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;

        T v = a[lo];

        while(true){
            while(less(a[++i], v)){
                if(i == hi){
                    break;
                }
            }
            while(less(v, a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;
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

    public void sort(T[] a, int lo, int hi){

        if(hi <= lo + CUTOFF - 1){
            insertionSort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public void insertionSort(T[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public void shuffle(Object[] a){
        int n = a.length;
        for(int i = 0; i<n; i++){
            int r = StdRandom.uniform(i + 1);

            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public Integer[] shuffle(Integer[] a){
        int n = a.length;

        for(int i = 0; i<n; i++){
            int r = StdRandom.uniform(i + 1);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }

    public T select(T[] a, int k){
        int lo = 0;
        int hi = a.length-1;

        while(hi > lo){
            int j = partition(a, lo, hi);
            if(j<k){
                lo = j+1;
            }else if(j>k){
                hi = j-1;
            }else{
                return a[k];
            }
        }
        return a[k];
    }

    public static void main(String[] args){
        String[] a = {"B", "F", "A", "K", "D", "E", "Z", "P", "O", "N"};

        QuickSort<String> qs = new QuickSort<String>();

        qs.shuffle(a);
        qs.sort(a, 0, a.length-1);

        System.out.print("정렬 결과 : ");

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}
