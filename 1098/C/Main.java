import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws Exception {
    int t = in.nextInt();
    StringBuilder res = new StringBuilder();
    while (t-- > 0) {
      solve(res);
    }
    System.out.println(res);
    out.flush();
  }

  static void solve(StringBuilder res) {
    long a = in.nextLong();
    int n = in.nextInt();
    long d1 = in.nextLong();
    long d2 = in.nextLong();
    res.append(recur(d1, d2, a)).append('\n');
  }

  private static long recur(long d1, long d2, long a) {
    String s = String.valueOf(a);
    long ans = Long.MAX_VALUE;

    long lower = findLower(s, d1, d2, 0, 0, false);
    long upper = findUpper(s, d1, d2, 0, 0, false);

    if (lower != -1)
      ans = Math.min(ans, Math.abs(a - lower));
    if (upper != -1)
      ans = Math.min(ans, Math.abs(a - upper));

    int len = s.length();

    // smallest valid number with len+1 digits
    long longer = 0;
    long firstDig = (d1 == 0) ? d2 : d1;
    longer = firstDig;
    for (int i = 0; i < len; i++)
      longer = longer * 10 + d1;
    ans = Math.min(ans, Math.abs(a - longer));

    // largest number with len-1 digits
    if (len > 1) {
      long shorter = 0;
      for (int i = 0; i < len - 1; i++)
        shorter = shorter * 10 + d2;
      ans = Math.min(ans, Math.abs(a - shorter));
    }
    return ans;
  }

  static long findLower(String s, long d1, long d2, int idx, long num, boolean isLess) {
    if (idx == s.length())
      return num;

    int limit = isLess ? 9 : (s.charAt(idx) - '0');

    if (d2 <= limit) {
      if (!(idx == 0 && d2 == 0 && s.length() > 1)) {
        long val = findLower(s, d1, d2, idx + 1, num * 10 + d2, isLess || d2 < limit);
        if (val != -1)
          return val;
      }
    }
    if (d1 <= limit) {
      if (!(idx == 0 && d1 == 0 && s.length() > 1)) {
        long val = findLower(s, d1, d2, idx + 1, num * 10 + d1, isLess || d1 < limit);
        if (val != -1)
          return val;
      }
    }
    return -1;
  }

  static long findUpper(String s, long d1, long d2, int idx, long num, boolean isGreater) {
    if (idx == s.length())
      return num;

    // Fixed: limit is 0 when isGreater is true
    int limit = isGreater ? 0 : (s.charAt(idx) - '0');

    if (d1 >= limit) {
      if (!(idx == 0 && d1 == 0 && s.length() > 1)) {
        long val = findUpper(s, d1, d2, idx + 1, num * 10 + d1, isGreater || d1 > limit);
        if (val != -1)
          return val;
      }
    }
    if (d2 >= limit) {
      if (!(idx == 0 && d2 == 0 && s.length() > 1)) {
        long val = findUpper(s, d1, d2, idx + 1, num * 10 + d2, isGreater || d2 > limit);
        if (val != -1)
          return val;
      }
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

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

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
    return a / gcd(a, b) * b;
  }

  // Sieve of Eratosthenes
  static boolean[] sieve(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i)
          isPrime[j] = false;
      }
    }
    return isPrime;
  }

  // Binary Search Template
  static int binarySearch(int[] arr, int target) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (arr[m] == target)
        return m;
      else if (arr[m] < target)
        l = m + 1;
      else
        r = m - 1;
    }
    return -1;
  }

}