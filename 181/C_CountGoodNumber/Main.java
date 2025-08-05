package C_CountGoodNumber;

import java.util.*;
import java.io.*;

public class Main {
    /*
    KEY OBSERVATION:
    A number is not good if it is divisible by 2, 3, 5, or 7.
    So a number is good if it's not divisible by any of them.
    That means we just need to count the numbers in range [l, r] that are not divisible by 2, 3, 5, or 7.
    This leads us to an inclusion-exclusion principle solution.

    Step-by-Step Approach:
    We want to count numbers in L,R that are not divisible by any of {2, 3, 5, 7}.
    This is: good(R)−good(L−1)
    Where good(n) = count of integers from 1 to n that are not divisible by 2, 3, 5, or 7.

    We can compute it using inclusion-exclusion.
    */
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    
    // Fast I/O template
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        long[] output=new long[t];
        int j=0;
        while (t-- > 0) {
            long l=in.nextLong();
            long r=in.nextLong(); 
            output[j++]=solve(r)-solve(l-1);
        }
        for(long i:output){
            out.println(i);
        }
        out.flush(); // Don't forget to flush output!
    }

    static long solve(long n) {
        long[] primes={2,3,5,7};
        long bad=0;
        int subsets=1<<4;
        for(int mask=1;mask<subsets;mask++){
            long lcm=1;
            int bits=0;

            for(int i=0;i<4;i++){
                if((mask & (1<<i))!=0){
                    lcm=lcm(lcm,primes[i]);
                    bits++;
                }
            }

            long cnt=n/lcm;
            if(bits%2==1){
                bad+=cnt;//include
            }else{
                bad-=cnt;//exclude
            }
        }
        return n-bad;
        //wow
    }

    
    // Sieve of Eratosthenes.....TC- O(n log log n)
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
    
    // GCD
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    // LCM
    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }
    
    // Binary Search Template
    static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}
