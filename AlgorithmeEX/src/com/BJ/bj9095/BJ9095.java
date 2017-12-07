package com.BJ.bj9095;
import java.util.*;
public class BJ9095 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int testCase = in.nextInt();
		
		int[] nArray= new int[11];
		nArray[1] = 1;
		nArray[2] = 2;
		nArray[3] = 4;
		
		while(testCase>0)
		{
			int n = in.nextInt();
			for(int i=4; i<=n; i++)
			{
				nArray[i] = nArray[i-1]+nArray[i-2]+nArray[i-3];
			}
			System.out.println(nArray[n]);
			testCase--;
		}			
	}

}
