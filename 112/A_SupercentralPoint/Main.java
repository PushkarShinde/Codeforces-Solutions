import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        int[][] points=new int[t][2];
        for(int i=0;i<t;i++){
            points[i][0]=in.nextInt();
            points[i][1]=in.nextInt();
        }
        int count=0;
        for(int i=0;i<t;i++){
            int x=points[i][0];
            int y=points[i][1];
            boolean right=false;
            boolean left=false;
            boolean up=false;
            boolean down=false;
            for(int j=0;j<t;j++){
                int xd=points[j][0];
                int yd=points[j][1];
                if(xd>x && yd==y){
                    right=true;
                }else if(xd<x && yd==y){
                    left=true;
                }else if(xd==x && yd>y){
                    up=true;
                }else if(xd==x && yd<y){
                    down=true;
                }
            }
            if(right && left && up && down) count++;
        }

        out.println(count);

        /*
        TC-O(log(n))

        int t = in.nextInt();

        int[][] points = new int[t][2];
        for (int i = 0; i < t; i++) {
            points[i][0] = in.nextInt();
            points[i][1] = in.nextInt();
        }

        // Maps: y -> sorted x’s, x -> sorted y’s
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        for (int[] p : points) {
            rowMap.computeIfAbsent(p[1], k -> new TreeSet<>()).add(p[0]);
            colMap.computeIfAbsent(p[0], k -> new TreeSet<>()).add(p[1]);
        }

        int count = 0;
        for (int[] p : points) {
            int x = p[0], y = p[1];

            TreeSet<Integer> row = rowMap.get(y);
            TreeSet<Integer> col = colMap.get(x);

            boolean right = row.higher(x) != null; // exists x' > x
            boolean left = row.lower(x) != null;   // exists x' < x
            boolean up = col.higher(y) != null;   // exists y' > y
            boolean down = col.lower(y) != null;  // exists y' < y

            if (right && left && up && down) count++;
        }

        System.out.println(count);
         */

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