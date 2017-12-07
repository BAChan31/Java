package com.BJ.bj2579;
import java.util.Scanner;
import java.math.*;

public class BJ2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] stair = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1; i<stair.length; i++)
		{
			stair[i] = in.nextInt();
		}
		
		for(int i=1; i< stair.length; i++)
		{
			if(i==1)
			{
				dp[i] = stair[i];
			}
			else if(i==2)
			{
				dp[i] = Math.max(dp[i-1] + stair[i], stair[i]);
			}
			else
			{
				dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
			}
		}
		
		System.out.println(dp[n]);

	}

}
