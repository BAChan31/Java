package com.BJ.bj11052;
import java.util.*;

public class bj11052 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = in.nextInt();
		
		int breadCount = N;
		
		dp[0] = 0;
		dp[1] = arr[1];
		for(int i=2; i<=N; i++)
		{
			for(int j=1; j<=i; j++)
			{
				dp[i] = max(dp[i], dp[i-j] + arr[j]);
			}
		}
		
		System.out.println(dp[N]);
		
	}
	
	static int max(int a, int b) {
		return a>b?a:b;
	}
}
