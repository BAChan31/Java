package com.Simul.bj1057;
import java.util.Scanner;

public class BJ1057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int participationCount = in.nextInt();
		int kim = in.nextInt();
		int lim = in.nextInt();
		
		int count = 0;
		
		while(kim!=lim)
		{
			kim = kim/2 + kim%2;
			lim = lim/2 + lim%2;
			
			count++;
		}
		
		System.out.println(count);
	}
}
