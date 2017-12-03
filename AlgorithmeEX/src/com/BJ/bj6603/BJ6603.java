package com.BJ.bj6603;
import java.util.*;

public class BJ6603 {

	static int [] arr;
	static int testCase;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true) {
			testCase = in.nextInt();
			if(testCase==0)
				break;
			arr = new int[testCase];
			
			for(int i=0; i<testCase; i++)
				arr[i] = in.nextInt();
			
			findResults(0, 0, "");
			
			System.out.println();
		}
	}
	
	static void findResults(int index, int count, String answer) {
		if(index == testCase)
		{			
			if(count == 6)
			{
				System.out.println(answer);
			}
			return;
		}
		
		
		
		findResults(index +1, count +1, answer + arr[index] + " ");
		findResults(index +1, count, answer);
	}

}
