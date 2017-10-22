package com.SW.test1953;
import java.util.*;

public class Solution {

	public static int[][][] MAP;
	public static boolean[][] VISIT;
	public static int[] moveX = {-1,0,1,0,-1};
	public static int[] moveY = {0,1,0,-1,0};
	public static int RESULT;
	
	public static int[][] turnelType = { {0,0,0,0},{1,1,1,1},{1,0,1,0},{0,1,0,1},{1,1,0,0},{0,1,1,0},{0,0,1,1},{1,0,0,1}};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		int height, width, pointR, pointC, timeL;
		for(int caseCount=1; caseCount<=testCase; caseCount++)
		{
			RESULT = 0;
			
			height = in.nextInt();
			width = in.nextInt();
			pointR = in.nextInt();
			pointC = in.nextInt();
			timeL = in.nextInt();
		
			MAP = new int[height][width][4];
			VISIT = new boolean[height][width];
			for(int i=0; i<height; i++) 
			{
				for(int j=0; j<width; j++)
				{
					int type = in.nextInt();
					MAP[i][j] = turnelType[type];
				}
			}
			findWay(pointR, pointC, timeL, RESULT);
			System.out.println("#" + caseCount + " " + RESULT);
		}
	}
	
	static void findWay(int startX, int startY, int time, int resultValue) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY, time});
		VISIT[startX][startY]=true;
		resultValue++;
		
		while(!queue.isEmpty())
		{
			int[] nextPoint = queue.poll();
			int nextX = nextPoint[0];
			int nextY = nextPoint[1];
			
			if(nextX<0 || nextY<0 || nextX>= MAP.length || nextY>= MAP[startY].length);
		}
	}
	
}
