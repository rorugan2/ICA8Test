import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
public class App {
    public static void main(String[] args){
        int i= getUrinals();
        System.out.println(i);
    }
    public static int getUrinals() {
        String s;
        boolean brk = false;
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter the input");
        s=sc.nextLine();
        char[] str= new char[s.length()];
        for(int i=0;i< s.length();i++) {
            str[i]=s.charAt(i);
        }
        for(int i=1;i<str.length;i++) {
            if(str[i-1] == '1' && str[i] == '1') {
                System.out.println("invalid string");
                return -1;
            }
        }
        int cc = 0, ff=0,count =0, idx = 0;
        for(int i=0;i<str.length;i++) {
            if(str[i]=='0') {
                // if(cc==ff) System.out.println("Vaccancy available at: "+i+" position");
                cc++;
            }
            else {
                count = count + (cc-ff)/2;
                ff=1;
                cc=0;
            }
            
        }
        count += cc/2;
        return count;
    }
}
 
