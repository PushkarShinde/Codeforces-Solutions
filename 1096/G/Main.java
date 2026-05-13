import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  static int[] bit;

  static void update(int i){
    for(i++;i<bit.length;i+=(i&(-i))) bit[i]++;
  }
  static int queryRange(int l, int r){
    if(l>r) return 0;
    return query(r)-(l>0?query(l-1):0);
  }

  static int query(int i){
    int s=0;
    for(i++;i>0;i-=(i&(-i))) s+=bit[i];
    return s;
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
    long[] a=new long[n+1];
    for(int i=1; i<=n; i++) a[i]=in.nextLong();
    // pref[i] = a[1] - a[2] + a[3] - ... (1-indexed, sign = (-1)^(i-1))
    long[] pref=new long[n+1];
    for(int i=1;i<=n;i++){
      pref[i]=pref[i-1]+(i%2==1?a[i]:-a[i]);
    }

    long[] sorted=Arrays.copyOf(pref, n+1);
    Arrays.sort(sorted);
    int m=0;
    long[] sv=new long[n+1];
    for(long v: sorted){
      if(m==0 || sv[m-1]!=v) sv[m++]=v;
    }

    // rank(v) = compressed index of v in sv[0..m-1]
    // For each r (1-indexed), we look at pref[r] and count valid l-1 values:
    //   l and r same parity (odd length) and l-1 index has opposite parity to r
    //   i.e., (l-1) parity = (r-1) parity, so (l-1) and r have different parity
    //   Actually: l same parity as r → (l-1) opposite parity to r.
    //
    // r odd: need l odd → l-1 even → count even-indexed pref[j] < pref[r], j <= r-2
    // r even: need l even → l-1 odd → count odd-indexed pref[j] > pref[r], j <= r-2
    //
    // We maintain two BITs: one for even-indexed pref values seen so far,
    // one for odd-indexed pref values seen so far.
    // Sweep r = 1..n, before processing r, insert pref[r-2] into the appropriate BIT.
    // (We insert j = r-2 when processing r, so j <= r-2 exactly.)

    int[][] bits=new int[2][m+1];
    bit=bits[0];
    long ans=n;// all length-1 subarrays
    // Insert pref[0] (even index) before we start — but we insert lazily:
    // when processing r, insert pref[r-2] if r-2 >= 0.

    // Reset both BITs
    bits[0]=new int[m+1];
    bits[1]=new int[m+1];
    for(int r=1;r<=n;r++){
      // Insert pref[r-2] into BIT for parity (r-2)%2 = r%2
      int j=r-2;
      if(j>=0){
        int parity=j%2;
        bit=bits[parity];
        int ci=Arrays.binarySearch(sv, 0, m, pref[j]);
        update(ci);
      }

      int pr=(int)(r%2);;
      int cr=Arrays.binarySearch(sv, 0, m, pref[r]);

      if(pr==1){
        bit=bits[0];
        if(cr>0) ans+=query(cr-1);
      } else {
        bit=bits[1];
        if(cr>=0) ans+=queryRange(cr+1, m-1);
      }
    }
    res.append(ans).append("\n");
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