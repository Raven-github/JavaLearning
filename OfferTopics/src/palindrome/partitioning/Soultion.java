package palindrome.partitioning;

import java.util.ArrayList;

public class Soultion {
	public static void main(String[] args) {
		String s="aab";
		System.out.println(s.substring(0, 3));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> strs=new ArrayList<>();
		
		
		return strs;
	}
	
	public static boolean isHuiwen(String s){
		return new StringBuilder(s).reverse().equals(new StringBuilder(s));
	}
}
