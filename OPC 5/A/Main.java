package A;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] denominations = {100, 20, 10, 5, 1}; 
        ArrayList<Long> amt=new ArrayList<Long>();
        int it=t;
        while (it-- > 0) {
            amt.add(sc.nextLong());
        }
        for(int i=0;i<t;i++){
            int count = 0;
            long n=amt.get(i);
            for (int bill:denominations) {
                count+=n/bill; // itne bills abtak mil gaye!
                n%=bill; // bacha hue bills
            }
            System.out.println(count);
        }
        sc.close();
    }
}