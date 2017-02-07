package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
	
	public static String input(String text) throws IOException {
		
		System.out.println(text);
		
		String rl = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		rl = br.readLine().trim();
		
		return rl;
		
	}
}
