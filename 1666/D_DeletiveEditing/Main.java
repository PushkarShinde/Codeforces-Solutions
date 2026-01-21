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
      String s=in.next();
      String t=in.next();
      Map<Character, Integer> fres=new HashMap<>();
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        fres.put(c,fres.getOrDefault(c, 0)+1);
      }
      Map<Character, Integer> fret=new HashMap<>();
      for(int i=0;i<t.length();i++){
        char c=t.charAt(i);
        fret.put(c,fret.getOrDefault(c, 0)+1);
      }
      int a=0, b=0;
      while(a<s.length() && b<t.length()){
        char sc=s.charAt(a);
        char tc=t.charAt(b);
        if(tc==sc && fres.get(sc)==fret.get(sc)){
            fres.put(sc,fres.get(sc)-1);
            fret.put(tc,fret.get(tc)-1);
            b++;
        }else{
            fres.put(sc,fres.get(sc)-1);
        }
        a++;
      }
      if(b==t.length()){
        res.append("YES").append('\n');
      }else{
        res.append("NO").append('\n');
      }
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