import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int n=in.nextInt(); 
        int q=in.nextInt();
        long[] a= new long[n];
        int[] d= new int[n];
        for(int i = 0; i < n; i++) a[i]=in.nextLong();
        for(int i = 0; i < n; i++) d[i]=in.nextInt();

        List<Double> meeting=new ArrayList<>();
        for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
            if((d[i]==1 && d[j]==-1 && a[i]<a[j]) ||
            (d[i]==-1 && d[j]==1 && a[i]>a[j])){
              double t=Math.abs(a[i]-a[j])/2;
              meeting.add(t);
            }
          }
        }
        Collections.sort(meeting);
        StringBuilder res=new StringBuilder();
        for(int i = 0; i < q; i++){
          long start=in.nextLong();
          long end=in.nextLong();
          long interval=end-start+1;
          int left=lowerbound(meeting,start);
          int right=upperbound(meeting,end);
          int count=right-left;
          res.append(count).append(" ");
        }
        out.println(res.toString().trim());
        out.flush();
    }

    static int lowerbound(List<Double> list, long num){
      int left=0, right=list.size();
      while(right>left){
        int mid=left+(right-left)/2;
        if(list.get(mid)<num-(1e-9)){
          left=mid+1;
        }else{
          right=mid;
        }
      }
      return left;
    }
    static int upperbound(List<Double> list, long num){
      int left=0, right=list.size();
      while(right>left){
        int mid=left+(right-left)/2;
        if(list.get(mid)<=num +(1e-9)){
          left=mid+1;
        }else{
          right=mid;
        }
      }
      return left;
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