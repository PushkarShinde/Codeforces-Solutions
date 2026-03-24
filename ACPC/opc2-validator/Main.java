import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        long K = Long.parseLong(br.readLine());
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            // Maintain deque with increasing indices
            // Remove from back if current prefix is smaller or equal
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            
            // Check from front: if prefix[i] - prefix[front] >= K, we found a window
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= K) {
                minLen = Math.min(minLen, i - dq.peekFirst());
                dq.pollFirst();
            }
        }
        
        System.out.println(minLen == Integer.MAX_VALUE ? -1 : minLen);
    }
}