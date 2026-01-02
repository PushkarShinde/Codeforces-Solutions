import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        StringBuilder res=new StringBuilder();
        while (t-- > 0) {
            solve(res);
        }
        System.out.println(res);
        out.flush(); // Don't forget to flush output!
    }

    static void solve(StringBuilder res) {
        long a= in.nextLong();
        long b= in.nextLong();
        long xk = in.nextLong();
        long yk = in.nextLong();
        long xq = in.nextLong();
        long yq = in.nextLong();

        Set<String> king=positions(xk,yk,a,b);
        Set<String> queen=positions(xq,yq,a,b);
        king.retainAll(queen);

        res.append(king.size()).append('\n');
    }
    private static Set<String> positions(long x, long y, long a, long b){
      Set<String> pos=new HashSet<>();
      long[][] moves;
      if(a==b){
        moves=new long[][]{
          {a,b}, {a,-b}, {-a,b}, {-a,-b}
        };
      }else{
        moves=new long[][]{
          {a,b}, {a,-b}, {-a,b}, {-a,-b},
          {b,a}, {b,-a}, {-b,a}, {-b,-a}
        };
      }
      for(long[] move:moves){
        long nx=x+move[0];
        long ny=y+move[1];
        pos.add(nx+","+ny);
      }
      return pos;
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