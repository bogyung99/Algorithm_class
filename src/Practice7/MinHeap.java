package Practice7;

import java.util.Scanner;

import static java.lang.System.exit;

public class MinHeap <T extends Comparable<T>> {
    private T[] arr;

    private int N;

    public MinHeap(){
        this(1);
    }

    public MinHeap(int capacity) {
        arr = (T[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T min() {
        return arr[1];
    }

    public int size() {
        return N;
    }

    private boolean less(int v, int w) {
        return arr[v].compareTo(arr[w]) < 0;
    }

    private void exch(int i, int j) {
        T swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public void insert(T e) {
        if (N == arr.length - 1)
            resize(2 * arr.length);

        arr[++N] = e;
        swim(N);
    }

    private void swim(int pos) {
        while (1 < pos && less(pos / 2, pos)) {
            exch(pos, pos / 2);
            pos = pos / 2;
        }
    }

    public T delMin(){
        T min = arr[1];
        arr[1] = arr[N--];
        sink(1);

        arr[N + 1] = null;

        if ((N > 0) && (N == (arr.length - 1) / 4))
            resize(arr.length  / 2);

        return min;
    }

    private void sink(int pos){
        while (2 * pos <= N){
            int j = 2 * pos;

            if(j < N && less(j, j + 1))
                j++;
            if(!less(pos, j))
                break;

            exch(pos, j);
            pos = j;
        }
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Comparable[capacity];

        for (int i = 1; i <= N; i++)
            copy[i] = arr[i];

        arr = copy;
    }

    public void show(){
        for(int i = 1; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        MinHeap<String> mh = new MinHeap<String>();

        Scanner s = new Scanner(System.in);


        while(true){
            System.out.println("\n수행할 연산을 선택해주세요.");
            System.out.println("1.Insert 2.Delete 3.Show Queue 4.exit");

            int n = s.nextInt();

            switch (n){
                case 1:
                    System.out.println("\nQueue에 넣을 item을 입력하세요: ");
                    String item = s.next();

                    mh.insert(item);

                    break;

                case 2:
                    if(mh.isEmpty())
                        System.out.println("\nQueue가 비었어요!");
                    else
                        mh.delMin();

                    break;

                case 3:
                    if(mh.isEmpty())
                        System.out.println("\nQueue가 비었어요!");
                    else {
                        System.out.println("\n현재 Queue : ");
                        mh.show();
                    }

                    break;

                default:
                    exit(0);
                    break;
            }
        }
    }
}


