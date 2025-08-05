package C_Brr_Patapim;

import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = in.nextInt(); // comment this line if there's only one test case
        List<String> ans=new ArrayList<>();

        for(int i=0;i<t;i++) {
            ans.add(solve());
        }
        for(String res: ans){
            out.println(res);
        }

        out.flush(); // Don't forget to flush output!
    }

    static String solve() {
        // Your logic for each test case goes here
        int n = in.nextInt();
        int[][] grid=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++ ){
                grid[i][j]=in.nextInt();
            }
        }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] sumGroups=new ArrayList[2*n+2];
        for(int i=0;i<sumGroups.length;i++){
            sumGroups[i]=new ArrayList<>();
        }// initialised the array of type ArrayList 

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++ ){
                sumGroups[i+j+2].add(grid[i][j]);//shift i+j by 2 since min is 2
            }
        }

        int[] p=new int[2*n+1];
        boolean[] used=new boolean[2*n+1];

        for(int k=2;k<=2*n;k++){
            for(int val: sumGroups[k]){
                if(!used[val]){
                    p[k]=val;
                    used[val]=true;
                    break;
                }
            }
        }
        //find the missing value =p[1]
        for(int num=1;num<=2*n;num++){
            if(!used[num]){
                p[1]=num;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int k=1;k<=2*n;k++){
            sb.append(p[k]).append(" ");
        }

        /**
        Example Input:
        n = 3

        Grid:
        1 6 2
        6 2 4
        2 4 3
        Let’s break it down:

        i	j	i + j	G[i][j] = p[i + j]
        1	1	2	            1
        1	2	3	            6
        1	3	4	            2
        2	1	3	            6
        2	2	4	            2
        2	3	5	            4
        3	1	4	            2
        3	2	5	            4
        3	3	6	            3

        From this, you can gather values of:

        p[2] = 1
        p[3] = 6
        p[4] = 2
        p[5] = 4
        p[6] = 3

        But what about p[1]? 

        Answer:
        Since p is a permutation from 1 to 6, the only number missing is:
        1 2 3 4 5 6 → we already have: 1, 2, 3, 4, 6 → so 5 is missing.

         Therefore, p[1] = 5

        Final permutation:
        p = [5, 1, 6, 2, 4, 3]
        Boom! 
        */


        return sb.toString().trim();
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

    //Pre-written Debugging Tools
    static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

}
