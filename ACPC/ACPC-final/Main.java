import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] adj;
    
    // A simple class to hold the result of our BFS
    static class BfsResult {
        int farthestNode;
        int maxDistance;
        
        BfsResult(int farthestNode, int maxDistance) {
            this.farthestNode = farthestNode;
            this.maxDistance = maxDistance;
        }
    }

    // Iterative BFS avoids the StackOverflowError that a recursive DFS would hit
    static BfsResult bfs(int startNode, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        dist[startNode] = 0;
        
        int farthestNode = startNode;
        int maxDist = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (dist[current] > maxDist) {
                maxDist = dist[current];
                farthestNode = current;
            }
            
            for (int neighbor : adj[current]) {
                if (dist[neighbor] == -1) { // If not visited
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return new BfsResult(farthestNode, maxDist);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // Fast I/O Initialization
        FastScanner sc = new FastScanner();
        
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(0);
            return;
        }

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // Pass 1: Start at an arbitrary person (person 1) and find the farthest edge
        BfsResult firstPass = bfs(1, n);
        
        // Pass 2: Start at the edge we just found, and find the opposite edge
        BfsResult secondPass = bfs(firstPass.farthestNode, n);

        // The maximum distance found in the second pass is our diameter
        System.out.println(secondPass.maxDistance);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}