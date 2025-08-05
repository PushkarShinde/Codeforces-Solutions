import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String a="Alice";
        String b="Bob";
        // int[] in=new int[t];
        String[] out=new String[t];
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int ct0=0, ct1=0, ct2=0, ct3=0;
            for(int j=0;j<n;j++){
                if(j%4==1) ct1++;
                else if(j%4==0) ct0++;
                else if(j%4==2) ct2++;
                else if(j%4==3) ct3++;
            }
            int pair03=Math.min(ct0,ct3);
            int pair12=Math.min(ct1,ct2);
            int pairs=pair03+pair12;
            if(pairs*2==n){
                out[i]="Bob";
            }else{
                out[i]="Alice";
            }
        }
        for(String ans: out){
            System.out.println(ans);
        }
    }
}