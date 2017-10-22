package com.SW.test1206;
import java.util.*;

public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCase=1;
		
		while(testCase <= 10)
		{
			int totalCount = 0;
			int widthSize = in.nextInt();
			int[] apartment = new int[widthSize];

			for(int i=0; i<widthSize; i++)
			{
				apartment[i] = in.nextInt();
			}
			
			for(int i=2; i<widthSize-2; i++)
			{
				int leftSide = Math.max(apartment[i-2], apartment[i-1]);
				int rightSide = Math.max(apartment[i+1], apartment[i+2]);
				int maxTop = Math.max(leftSide, rightSide);
				
				if(apartment[i] > maxTop)
				{
					totalCount += (apartment[i] - maxTop);
				}
			}
			System.out.println("#" + testCase + " " + totalCount );
			testCase++;
		}
	}
}
