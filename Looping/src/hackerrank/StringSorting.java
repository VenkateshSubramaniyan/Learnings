package hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class StringSorting {
	
	public static void main(String[] args) {
        Scanner si = new Scanner(System.in);
        String s1= si.next();
        
        StringBuilder sb= new StringBuilder(s1);
        
        String s2= sb.reverse().toString();
        if (s1==sb.reverse().toString().intern()){
        	System.out.print("Yes");
        }
        
	}
        
        

}
