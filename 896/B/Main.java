import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  static class City{
    int city;
    long x;
    long y;
    boolean major;
    City(int city, long x, long y, boolean major){
      this.city=city;
      this.x=x;
      this.y=y;
      this.major=major;
    }
  }
  public static void main(String[] args) throws Exception {
    int t=in.nextInt(); 
    StringBuilder res=new StringBuilder();
    while (t-- > 0) {
      solve(res);
    }
    System.out.println(res);
    out.flush();
  }

  static void solve(StringBuilder res){
    int n=in.nextInt();
    int k=in.nextInt();
    int a=in.nextInt();
    int b=in.nextInt();

    City[] cities=new City[n+1];

    for(int i=1;i<=n;i++){
      long x=in.nextLong();
      long y=in.nextLong();
      cities[i]=new City(i, x, y, i<=k);
    }

    City start=cities[a];
    City end=cities[b];

    if(start.major && end.major){
      res.append(0).append('\n');
      return;
    }

    long direct=Math.abs(start.x-end.x)+Math.abs(start.y-end.y);
    long minA=Long.MAX_VALUE;
    long minB=Long.MAX_VALUE;

    for(int i=1;i<=k;i++){
      City major=cities[i];
      long d1 = Math.abs(start.x - major.x) + Math.abs(start.y - major.y);
      long d2 = Math.abs(end.x - major.x) + Math.abs(end.y - major.y);

      minA = Math.min(minA, d1);
      minB = Math.min(minB, d2);
    }

    if(minA==Long.MAX_VALUE || minB==Long.MAX_VALUE){
      res.append(direct).append('\n');
      return;
    }
    
    long viaMajor=minA+minB;
    res.append(Math.min(direct, viaMajor)).append('\n');
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