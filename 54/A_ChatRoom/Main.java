import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        String str=in.next();
        int[] l=new int[26];
        l['h'-'a']++;
        l['e'-'a']++;
        l['l'-'a']+=2;
        l['o'-'a']++;
        for(char c: str.toCharArray()){
            if(c=='h' && l[c-'a']>0) {
                l[c-'a']--;
            }
            if(l['h'-'a']==0 && c=='e' && l[c-'a']>0) l[c-'a']--;
            if(l['h'-'a']==0 && l['e'-'a']==0 && c=='l' && l[c-'a']>0) l[c-'a']--;
            if(l['h'-'a']==0 && l['e'-'a']==0 && l['l'-'a']==0 && c=='o' && l[c-'a']>0) l[c-'a']--;
        }
        if(l['h'-'a']==0 && l['e'-'a']==0 && l['l'-'a']==0 && l['o'-'a']==0){
            out.println("YES");
        }else{
            out.println("NO");
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