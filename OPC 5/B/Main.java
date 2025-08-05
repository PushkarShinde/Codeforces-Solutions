// package B;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] f=new int[1001];
        f[0] =0; f[1] =1; f[2] =2; f[3] =3; f[4] =4;
        for (int i=5; i<1001; i++) {
            if (i%2==1){ 
                f[i]=f[i-1]+f[i-2]-f[i-3];
            } else{ 
                f[i]=f[i-1]-f[i-2]+f[i-3];
            }
        }
        ArrayList<Integer> tc=new ArrayList<Integer>(t);
        int it=t;
        while (it-- >0){
            tc.add(sc.nextInt());
        }
        for(int i=0;i<t;i++){
            System.out.println(f[tc.get(i)]);
        }
        sc.close();
    }
}
