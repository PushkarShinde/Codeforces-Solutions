import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
  private static long mod=(long)1e9+7;
  private static long neg=Long.MIN_VALUE/2;

  public static void main(String[] args) throws Exception {
    StringBuilder res=new StringBuilder();
    String s=in.nextLine();
    String w=in.nextLine();
    
    int[] fre=new int[26];
    for(char c:s.toCharArray()){
      fre[c-'a']++;
    }
    
    int[] need=new int[26];
    for(char c:w.toCharArray()){
      need[c-'a']++;
    }

    String[] process=in.nextLine().split(" ");

    int m=process.length;
    int l=0, r=m, ans=0;
    while(l<=r){
      int mid=l+((r-l)>>1);
      if(valid(mid, s,w, process)){
        l=mid+1;
        ans=mid;
      }else{
        r=mid-1;
      }
    }
    res.append(ans).append('\n');
    System.out.println(res);
  }

  private static boolean valid(int moves, String s, String w, String[] pr){
    boolean[] vis=new boolean[s.length()];
    for(int i=0;i<moves;i++){
      int ind=Integer.parseInt(pr[i])-1;
      vis[ind]=true;
    }

    int l=0, r=0;
    while(l<s.length() && r<w.length()){
      if(vis[l]){
        l++;
        continue;
      }
      if(l<s.length() && s.charAt(l)==w.charAt(r)){
        l++; r++;
      }else{
        l++;
      }
    }

    return r==w.length();
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