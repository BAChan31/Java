package com.BJ.bj11053;
import java.util.*;

public class BJ11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int [N];
		int[] dp = new int [N];
		for(int i=0; i<N; i++)
			arr[i] = in.nextInt();
		int max=0;
		for(int i=0; i<N; i++)
		{
			int min = 0;
			for(int j=0; j<=i; j++)
			{
				if(arr[j]<arr[i])
					if(min < dp[j])
						min = dp[j];
			}
			dp[i] = min +1;
			if(max<dp[i])
				max=dp[i];
		}
		
		System.out.println(max);
	}

}
