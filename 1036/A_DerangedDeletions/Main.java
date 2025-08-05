package A_DerangedDeletions;

import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        // int t = 1;
        int t = in.nextInt(); // comment this line if there's only one test case
        StringBuilder sb=new StringBuilder();
        while (t-->0) {
            int m=in.nextInt();
            int[] arr=new int[m];
            Map<Integer, Integer> freq=new HashMap<>();
            for(int i=0;i<m;i++) {
                arr[i]=in.nextInt();
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }
            int maxFreq=Collections.max(freq.values());
            if(maxFreq>(m+1)/2){
                sb.append("no\n");
                continue;
            }
            sb.append("yes\n");
            // Derangement construction: sort and rotate
            Integer[] sorted=Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(sorted);
            Integer[] deranged=new Integer[m];
            for (int i=0;i<m;i++) {
                deranged[i]=sorted[(i+(m/2))%m];  // smarter than +1 rotation to ensure mismatches
            }
            for (int i = 0; i <m; i++) {
                sb.append(deranged[i]).append(" ");
            }
            sb.append("\n");
        }

        out.print(sb.toString());
        out.flush(); // Don't forget to flush output!
    }

    static boolean deranged(int m, int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        for(int i=0;i<m;i++){
            if(arr[i]==copy[i]) return false;
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
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
            int m = (l + r) / 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}