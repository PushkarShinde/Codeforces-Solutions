package B;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> num=new ArrayList<>(t*4);
        int loop=4*t;
        while(loop-->0){
            int s=sc.nextInt();
            num.add(s);
        }

        for(int i=0;i<4*t;i+=4){
            int n=num.get(i);
            int m=num.get(i+1);
            int l=num.get(i+2);
            int r=num.get(i+3);

            if(l<0){
                if(((-1)*l)<r){
                    if(((-1)*l)<m && r>m){
                        System.out.println(l+" "+(m+l));
                    }else if(((-1)*l)<m && r<m){
                        System.out.println(l+" "+r);
                    }else if(((-1)*l)>m && r>m){
                        System.out.println((-(m/2))+" "+(m-m/2));
                    }
                }else if(((-1)*l)>r){
                    if(((-1)*l)>m && r<m){
                        System.out.println((r-m)+" "+r);
                    }else if(((-1)*l)<m && r<m){
                        System.out.println(l+" "+r);
                    }else if(((-1)*l)>m && r>m){
                        System.out.println((-(m/2))+" "+(m-m/2));
                    }
                }else if(((-1)*l)==r){
                    if(((-1)*l)<m && r<m){
                        System.out.println(l+" "+r);
                    }else if(((-1)*l)>m && r>m){
                        System.out.println((-(m/2))+" "+(m-m/2));
                    }
                }
            }else if(l==0){
                System.out.println(0+" "+m);
            }
        }
    }
}
