import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

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
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
        a[i] = in.nextInt();
    }

    int INF = (int)1e9;
    int[] prev = new int[7];
    int[] curr = new int[7];

    // base case
    for(int v = 1; v <= 6; v++){
        prev[v] = (a[0] == v ? 0 : 1);
    }

    for(int i = 1; i < n; i++){
        for(int v = 1; v <= 6; v++){
            curr[v] = INF;
        }

        for(int v = 1; v <= 6; v++){
            int cost = (a[i] == v ? 0 : 1);

            for(int u = 1; u <= 6; u++){
                if(u == v) continue;
                if(u + v == 7) continue;

                curr[v] = Math.min(curr[v], prev[u] + cost);
            }
        }

        int[] temp = prev;
        prev = curr;
        curr = temp;
    }

    int ans = INF;
    for(int v = 1; v <= 6; v++){
        ans = Math.min(ans, prev[v]);
    }

    res.append(ans).append('\n');
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