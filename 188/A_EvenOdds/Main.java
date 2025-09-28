import java.util.*;
import java.io.*;

public class Main {

    // static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        long k=in.nextLong();
        long odd=(n+1)/2;
        // long even=n/2;
        if(k<=odd){
            System.out.println(1+(k-1)*2);
            // return;
        }else{
            System.out.println((k-odd)*2);
            // return;
        }
    }
        // out.flush(); // Don't forget to flush output!

    // GCD
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // LCM
    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }

    // Sieve of Eratosthenes
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) isPrime[j] = false;
            }
        }
        return isPrime;
    }

    // Binary Search Template
    static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l+(r-l)/ 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}