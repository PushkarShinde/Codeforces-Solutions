// package B_JeffAndPeriods;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int n =in.nextInt(); 
        int[] an=new int[n];
        for(int i=0;i<n;i++){
          an[i]=in.nextInt();
        }
        //Store: value -> [lastIndex, diff, validFlag]
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
          int x=an[i];
          int id=i+1;
          int[] info=map.get(x);
          if(info==null){
            map.put(x,new int[]{id,0,1});
          }else{
            int dif=id-info[0];
            if(info[2]==1){
              if(info[1]==0) info[1]=dif;
              else if(info[1]!=dif){
                info[2]=0;
              }
            }
            info[0]=id;
          }
        }
        
        List<int[]> result = new ArrayList<>();
        for (var e : map.entrySet()) {
            int val = e.getKey();
            int[] info = e.getValue();
            if (info[2] == 1) result.add(new int[]{val, info[1]});
        }

        result.sort(Comparator.comparingInt(a -> a[0]));

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (int[] r : result) sb.append(r[0]).append(' ').append(r[1]).append('\n');
        System.out.print(sb);
        out.flush(); // Don't forget to flush output!
    }

    private static int isAP(List<Integer> ap){
      int n=ap.size();
      if(n==1) return 0;
      if(n==2) return ap.get(1)-ap.get(0);
      int diff=-1;
      for(int i=1;i<n-1;i++){
        if(ap.get(i)-ap.get(i-1)!=ap.get(i+1)-ap.get(i)){
          return -1;
        }
        diff=ap.get(i)-ap.get(i-1);
      }
      return diff;
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