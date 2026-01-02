import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
      int n=in.nextInt();
      int k=in.nextInt(); 
      int[] a= new int[n];
      int[] primes=new int[1001];
      for(int i=2;i<1001;i++){
        int x=i;
        int count=0;
        for(int p=2;p*p<=x;p++){
          while(x%p==0){
            count++;
            x/=p;
          }
        }
        if(x>1) count++;
        primes[i]=count;
      }
      for(int i = 0; i < n; i++) a[i]=in.nextInt();
      int res=Integer.MAX_VALUE;
      for(int i=0;i<n-k;i++){
        int hcf=a[i];
        for(int j=i;j<i+k-1;j++){
          hcf=gcd(hcf,a[j+1]);
        }
        int op=0;
        for(int j=i;j<i+k;j++){
          int val=a[j];
          if(sieve[hcf]) op+=val/hcf;
          op+=resolve(val,hcf);
        }
        res=Math.min(res,op);
      }
      out.println(res);
      out.flush();
    }
    private static int resolve(int val, int hcf){
      int max=0;
      while(true){
        for(int i=0;i<1001;i++){

        }
      }
      return;
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
    static int gcd(int a, int b) {
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