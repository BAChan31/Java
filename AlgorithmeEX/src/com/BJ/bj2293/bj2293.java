package com.BJ.bj2293;
import java.util.*;

public class bj2293 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int coinCount = in.nextInt();
		int quest = in.nextInt();
		int [] arr = new int [coinCount+1];
		int [] dp = new int[quest+1];
		
		for(int i=1; i<=coinCount; i++)
			arr[i] = in.nextInt();
		
		dp[0] = 1;
		for(int i=1; i<=coinCount; i++)          
		{
			for(int j=arr[i]; j<=quest; j++)
			{
				dp[j] += dp[j-arr[i]]; 
			}
		}
		
		System.out.println(dp[quest]);
		
	}
}
