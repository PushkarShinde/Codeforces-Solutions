// package B_StrangeMachine;

import java.util.*;
import java.io.*;

public class MainB {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t=in.nextInt(); // comment this line if there's only one test case
        for(int i=0;i<t;i++){
          int n=in.nextInt();
          int q=in.nextInt();
          String s=in.next();
          int[] countA=new int[n];// Count of 'A's before next 'B'
          int[] nextB=new int[n];//Next 'B' position from each position
          for(int j=0;j<n;j++){
            int k=j;
            int count=0;
            while(s.charAt(k)=='A'){
              count++;
              k=(k+1)%n;
              if(k==j) break;//sare 'A' hi hai sale!!
            }
            countA[j]=count;
            nextB[j]=k;
          }
          long[] res=new long[q];
          // char[] ch=s.toCharArray();
          for(int j=0;j<q;j++){
            long qu=in.nextLong();
            int k=0;
            long count=0;
            while(qu>0){
              char c=s.charAt(k);
              if(c=='A'){
                int counta=countA[k];
                if(qu<=counta) {
                  res[j]=count+qu;
                  break;
                }
                qu-=counta;
                count+=counta;
                k=nextB[k];
              }else{
                qu=qu/2;
                count++;
                k=(k+1)%n;
              }
            }
            if(qu==0) res[j]=count;
          } 
          for(long r: res){
            out.println(r);
          }
        }
        out.flush(); // Don't forget to flush output!
    }

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