package Practice1;

public class Fibonacci {

    static long mem[] = new long[100];

    public static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;

        if(mem[N] != 0) return mem[N];
        mem[N] =  F(N - 1) + F(N - 2);

        return mem[N];
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();

        for (int N = 0; N < 90; N++){
            System.out.println(N + " " + F(N));
        }

        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
    }
}
