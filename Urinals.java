package org.example;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Urinals {
    public static void main(String[] args){
        // int i= getUrinals(null);
        Scanner sc=new Scanner(System.in);
        System.out.println("for input from file press  0 or for input from console press 1");
        int st = sc.nextInt();
        if(st==1){
            int i= getUrinals(null);
            System.out.println(i);


        }
        else{
            BufferedReader br = null;
            try {
                FileReader file = new FileReader(new File("C:\\Users\\rorugan2\\IdeaProjects\\ICATEST8\\src\\main\\java\\org\\example\\urinal.dat"));
                br = new BufferedReader(file);
                //int j=0, c=0;
                File fout = new File("rule.txt");
                if(!fout.exists()) {
                    fout.createNewFile();

                }

                FileWriter fw = new FileWriter(fout.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(fw);
                while (true) {
                    String temp = br.readLine();
                    if(temp == null) break;
                    int val = getUrinals(temp);
                    //    System.out.println(val);
                    bw.write(Integer.toString(val));
                    bw.newLine();
                }
                br.close();
                bw.close();
            } catch(Exception e) {
                System.out.println(e);
                // i=getUrinals(null);
            }
        }
    }
    public static boolean goodString( String str )
    {  // checks to see if valid string
        boolean good=false;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0'||str.charAt(i)=='1')
            {
                good=true;
            }
            else {
                good=false;
            }
        }
        return good;
    }
    public static int getUrinals(String in) {
        String s = in;
        if(in != null) {
            s = in;
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println(" enter the input");
            s=sc.nextLine();
        }
        char[] str= new char[s.length()];
        for(int i=0;i< s.length();i++) {
            str[i]=s.charAt(i);
        }
        for(int i=1;i<str.length;i++) {
            if(str[i-1] == '1' && str[i] == '1') {
                return -1;
            }
        }
        if(!(s.contains("1"))){
            return (s.length()+1)/2;
        }
        int cc = 0, ff=0,count =0;
        for(int i=0;i<str.length;i++) {
            if(str[i]=='0') {
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

