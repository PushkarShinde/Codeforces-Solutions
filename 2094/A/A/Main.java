package A;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        ArrayList<String> str=new ArrayList<>();
        while(t-->0){
            String s=sc.nextLine();
            str.add(s);
        }
        for(String i:str){
            String res="";
            res+=i.charAt(0);
            for(int j=0;j<i.length();j++){
                if(i.charAt(j)==' '){
                    res+=i.charAt(j+1);
                }
            }
            System.out.println(res);
        }
    }
}
