import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t =in.nextInt(); // comment this line if there's only one test case
        int[] res=new int[t];
        for(int test = 0; test < t; test++) {
            int n = in.nextInt();
            String s = in.next();
            
            res[test]=solve(s.toCharArray());
        }
        for(int i=0;i<t;i++){
            out.println(res[i]);
        }
        out.flush(); // Don't forget to flush output!
    }

    static int solve(char[] s) {
        int op=0;
        int n = s.length;
        while(!isSorted(s)) {
            boolean moved = false;// Look for patterns we can fix efficiently
            for(int i = 0; i < n - 2 && !moved; i++) {
                for(int j = i + 1; j < n - 1 && !moved; j++) {
                    for(int k = j + 1; k < n && !moved; k++) {
                        // Current values at positions i, j, k
                        char a = s[i], b = s[j], c = s[k];
                        
                        // Check if right shift improves sorting
                        if(shouldRightShift(s, i, j, k)) {
                            rightShift(s, i, j, k);
                            op++;
                            moved = true;
                        }
                        // Check if left shift improves sorting  
                        else if(shouldLeftShift(s, i, j, k)) {
                            leftShift(s, i, j, k);
                            op++;
                            moved = true;
                        }
                    }
                }
            }
            if(!moved) break;
        }
        return op;
    }
    static boolean shouldRightShift(char[] s, int i, int j, int k) {
        // Right shift: (a,b,c) -> (c,a,b)
        char a = s[i], b = s[j], c = s[k];
        
        // This operation is beneficial if:
        // 1. It moves a '0' to an earlier position where there's a '1'
        // 2. Or it creates a better sorted configuration
        
        if(a == '1' && c == '0') {
            return true; // Moving 0 to earlier position
        }
        
        if(a == '1' && b == '1' && c == '0') {
            return true; // Pattern 110 -> 011
        }
        
        return false;
    }
    
    static boolean shouldLeftShift(char[] s, int i, int j, int k) {
        // Left shift: (a,b,c) -> (b,c,a)
        char a = s[i], b = s[j], c = s[k];
        
        // This operation is beneficial if:
        // 1. It moves a '0' to an earlier position
        // 2. Or creates better sorted configuration
        
        if(a == '1' && (b == '0' || c == '0')) {
            return true; // Moving 0s forward
        }
        
        if(a == '1' && b == '0' && c == '1') {
            return true; // Pattern 101 -> 011  
        }
        
        return false;
    }
    
    // Right shift: (a,b,c) -> (c,a,b)
    static void rightShift(char[] arr, int i, int j, int k) {
        char temp = arr[k];
        arr[k] = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    
    // Left shift: (a,b,c) -> (b,c,a)
    static void leftShift(char[] arr, int i, int j, int k) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
    
    static boolean isSorted(char[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) return false;
        }
        return true;
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