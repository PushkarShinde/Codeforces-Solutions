package B_Bobritto_Bandito;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of test cases
        int t = sc.nextInt();
        
        HashMap<Integer, int[]> map = new HashMap<>();

        // Process each test case
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Calculate segment [l', r'] for day m
            int left = Math.max(l, -m); // Start as far left as possible within [l, r]
            int right = left + m;       // Ensure length is m + 1 (r' - l' = m)

            // Ensure segment includes 0 and is within [l, r]
            if (left > 0 || right < 0 || right > r) {
                right = Math.min(r, m); // Rightmost bound that includes 0 or within [l, r]
                left = right - m;
            }

            map.put(tc, new int[]{left, right});
        }

        // Print all results
        for (int i = 1; i <= t; i++) {
            int[] pair = map.get(i);
            System.out.println(pair[0] + " " + pair[1]);
        }

        sc.close();
    }
}