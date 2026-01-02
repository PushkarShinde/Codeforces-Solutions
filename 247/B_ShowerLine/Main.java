import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int[][] g=new int[5][5];
    public static void main(String[] args) throws Exception {
        for(int i=0;i<5;i++){
          for(int j=0;j<5;j++){
            g[i][j]=in.nextInt();
          }
        }
        int[] student={1,2,3,4,5};
        int maxHappiness=0;
        do{
          int happy=calculate(student);
          maxHappiness=Math.max(maxHappiness, happy);
        }while(nextPermutation(student));
        out.println(maxHappiness);
        out.flush(); // Don't forget to flush output!
    }

    static int calculate(int[] a){
      int total=0;
      total+=talk(a[0], a[1]);
      total+=talk(a[2], a[3]);

      total+=talk(a[1], a[2]);
      total+=talk(a[3], a[4]);

      total+=talk(a[2], a[3]);

      total+=talk(a[3], a[4]);
      return total;
    }

    static int talk(int a, int b){
      return g[a-1][b-1]+g[b-1][a-1];
    }

    static boolean nextPermutation(int[] a){
      int i=a.length-2;
      while(i>=0 && a[i]>=a[i+1]){
        i--;
      }
      if(i<0) return false;//no next permutation
      int j=a.length-1;
      while(a[j]<=a[i]){
        j--;
      }
      swap(a, i,j);
      reverse(a, i+1,a.length-1);
      return true;
    }

    static void swap(int[] a, int i, int j){
      int temp=a[i];
      a[i]=a[j];
      a[j]=temp;
    }

    static void reverse(int[] a, int start, int end){
      while(start<end){
        swap(a, start, end);
        start++; end--;
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