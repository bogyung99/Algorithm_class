package Practice9;

import java.util.*;

public class OrderedST<Key extends Comparable<Key>, Value> {
    private int N = 0;
    private Key[] keys;
    private Value[] vals;

    public OrderedST(int c){
        keys = (Key[]) new Comparable[c];
        vals = (Value[]) new Object[c];
    }

    public Value get(Key key){
        int i = rank(key);

        if(isEmpty())
            return null;

        if(i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    public void put(Key key, Value val){
        int i = rank(key);

        if(val == null){
            delete(key);
            return;
        }
        else if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }

        for(int j = N; j > i; j--){
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;

        N++;
    }

    public void delete(Key key){
        int i = rank(key);

        if(i == N || keys[i].compareTo(key) != 0){
            return;
        }

        for(int j = i; j < N - 1; j++){
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        N--;

        keys[N] = null;
        vals[N] = null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public int size(Key lo, Key hi){
        if(lo.compareTo(hi) > 0)
            return 0;

        if(contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private int rank(Key key){
        int lo = 0;
        int hi = N - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if(cmp < 0)
                hi = mid - 1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

//    public static void main(String[] args) {
//        OrderedST<String, Integer> st = new OrderedST<String, Integer>();
//
//        for(int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//    }
}
