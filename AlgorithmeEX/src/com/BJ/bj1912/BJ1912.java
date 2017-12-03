package com.BJ.bj1912;
import java.util.*;

public class BJ1912 {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int testCase = in.nextInt();
		int[] arr = new int[testCase];
		int[] dp = new int[testCase];
		
		for(int i=0; i<testCase; i++)
		{
			arr[i] = in.nextInt();
		}

		int temp = 0;
		
		while(temp < testCase)
		{
			if(temp == 0)
				dp[0] = arr[0];
			else
			{
				if(dp[temp-1] + arr[temp] > arr[temp])
					dp[temp] = dp[temp-1] + arr[temp];
				else
					dp[temp] = arr[temp];
			}
			temp++;
		}
		
		int findMax = dp[0];
		for(int i=0; i<testCase; i++)
			findMax = Math.max(findMax, dp[i]);
				
		System.out.println(findMax);
	
	}

}
