package com.DP.bj2193;
import java.util.Scanner;
public class BJ2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n+1][];
		int[] dp = new int[n+1];
		int jegob = 1;
		
		for(int i=1; i<arr.length; i++)
		{
			if(i<2^jegob)
			{
				
			}
			int count = i/(2^jegob);
			arr[i] = new int[count+1];
			int divideResult = i;
			for(int j=arr[i].length-1; j>=0; j--)
			{

				int divideLeft = divideResult%2;
				arr[i][j] = divideLeft;
				divideResult = divideResult/2;				
			}
		}
		
		for(int i=1; i<arr.length; i++)
		{
			for(int j=0; j<arr[i].length; j++)
			{
				if(j==0 && i==1)
				{
					dp[i]++;
					break;
				}
				else if(j==0 && i!=1)
					continue;
				if(!(arr[i][j]==1 && arr[i][j-1] == 1))
				{
					dp[i] = dp[i-1] +1;
					break;
				}
				else
				{
					dp[i] = dp[i-1];
				}
			}
		}
		
		System.out.println(dp[n]);
	}

}
