import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
  private static long mod=(long)1e9+7;
  private static long neg=Long.MIN_VALUE/2;

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
    int n=in.nextInt();
    int k=in.nextInt();
    int[] a=new int[n];
    for(int i=0; i<n; i++) a[i]=in.nextInt();
    List<Integer> fre= new ArrayList<>();
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (a[i] == a[i - 1]) {
        count++;
      } else {
        fre.add(count);
        count = 1;
      }
    }
    fre.add(count);

    Map<Integer, Integer> map=new HashMap<>();
    for (int f : fre) {
      map.put(f, map.getOrDefault(f, 0) + 1);
    }
    
    List<Integer> unique= new ArrayList<>(map.keySet());
    Collections.sort(unique);

    long d=fre.size();
    long s=n;
    long ans=0;

    for(int j=0;j<unique.size();j++){
      int next=unique.get(j);
      
      long req=1-next;//min delta required to not destroy the element with frequency next
      long dif=k-s;

      if(dif%d==0){
        long delta=dif/d;
        if(delta>=req){
          ans++;
        }
      }
      
      long cnt=map.get(next);
      d-=cnt;
      s-=cnt*next;
    }

    res.append(ans).append("\n");
  }

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

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }

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