package com.SW.test2105;
import java.util.Scanner;

public class TEST2105 {
	
	public static final int[] moveX = {-1,-1,1,1};
	public static final int[] moveY = {-1, 1,-1,1};
	public static final int STARTPOINT = 2;
	public static final int CANVISIT = 1;
	public static final int CANNOTVISIT = 0;
//	public static int[][] GRAPH;
//	public static int[][] CHECKEDGRAPH;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		int[][] graph;
		int[] resultArr = new int[testCase];
		while(testCase>0)
		{
			int caseNum = in.nextInt();
			graph = new int[caseNum][caseNum];
			
			for(int i=0; i<caseNum; i++)
			{
				for(int j=0; j<caseNum; j++)
				{
					graph[i][j] = in.nextInt();
				}
			}
			
			foundBest(graph, caseNum);
			
		}
	}
	
	static void foundBest(int[][] GRAPH, int caseCount) {
		int temp = 0;
		int [][] visitGraph;
		
		for(int i=0; i<caseCount; i++)
		{
			for(int j=0; j<caseCount; j++)
			{
				visitGraph = new int[caseCount][caseCount];
				findWay(GRAPH, visitGraph, i, j, true);
			}
		}
		
		System.out.println("dfdf");
	}
	
	static boolean findWay(int[][] GRAPH, int[][] visit ,int pointX, int pointY, boolean start) {
		if(start)
		{
			visit[pointX][pointY] = 3;
		}
		
		for(int i=0; i<4; i++)
		{
			int nextX = pointX + moveX[i];
			int nextY = pointY + moveY[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= GRAPH.length || nextY >= GRAPH[pointX].length)
				return false;
			else if(visit[nextX][nextY] == 3)
				return true;
			else if(visit[nextX][nextY] == 1)
				return false;
			else
			{
				if(findWay(GRAPH, visit, nextX, nextY, false))
				{
					visit[nextX][nextY] = 2;
				}
			}
		}
		
		return false;				
	}

}
