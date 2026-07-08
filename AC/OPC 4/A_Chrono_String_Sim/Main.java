import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static char evolveCore(int k) {
        StringBuilder core=new StringBuilder("a");
        while(core.length() < k){
            StringBuilder evolved = new StringBuilder();
            for (int i = 0; i < core.length(); i++) {
                char c = core.charAt(i);
                if (c == 'z') {
                    evolved.append('a');
                } else {
                    evolved.append((char)(c + 1));
                }
            }
            // Append evolved segment to core
            core.append(evolved);
        }
        
        // Return kth character (1-based index, so k-1 for 0-based)
        return core.charAt(k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of test cases
        int t = sc.nextInt();
        
        // Store all test cases in an ArrayList
        ArrayList<Integer> testCases = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            testCases.add(sc.nextInt());
        }
        
        // Process all test cases and store results
        ArrayList<Character> results = new ArrayList<>();
        for (int k : testCases) {
            results.add(evolveCore(k));
        }
        
        // Output all results
        for (char result : results) {
            System.out.println(result);
        }
        
        sc.close();
    }
}