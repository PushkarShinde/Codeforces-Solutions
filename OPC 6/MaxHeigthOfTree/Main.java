import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            adj=new ArrayList<>();
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<n-1;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            visit=new boolean[n+1];
            int ht=dfs(1)-1;
            System.out.println(ht);
        }
    }
    static int dfs(int node){
        visit[node]=true;
        int maxHt=0;
        for(int ch:adj.get(node)){
            if(!visit[ch]){
                maxHt=Math.max(maxHt,dfs(ch));
            }
        }
        return maxHt+1;
    }
}
