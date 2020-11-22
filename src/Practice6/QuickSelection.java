package Practice6;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import java.util.HashSet;
import java.util.Set;

public class QuickSelection {
    public static void main(String[] args) {
        Integer[] a = new Integer[100];

        for(int i = 0; i < a.length; i++){
            a[i] = i + 1;
        }

        QuickSort<Integer> qs = new QuickSort<Integer>();

        Integer[] aux = qs.shuffle(a); // 기억시키기

        Integer boundaryIndex = 3;

        qs.select(aux, boundaryIndex);

        Integer boundaryValue = a[boundaryIndex];

        Set<Integer> expected = new HashSet<Integer>();
        Collections.addAll(expected, boundaryValue);

        Set<Integer> actual = new HashSet<Integer>();

        for(int i = boundaryIndex; i < aux.length; i++){
            Integer value = aux[i];

            if(boundaryValue >= value){
                actual.add(value);
            }
        }

        Assertions.assertEquals(expected, actual);

        System.out.print("QuickSelection 결과 : ");

        for(int i = 0; i < boundaryIndex; i++){
            System.out.print(qs.select(aux, i) + " ");
        }
    }
}
