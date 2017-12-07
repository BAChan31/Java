package com.BJ.bj1012DFS;
import java.util.*;

public class BJ1012 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]) {

		int testCase = in.nextInt();
		int[] resultCount = new int [testCase];
		
		while(testCase > 0)
		{
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[][] adj = new int[n][m];
			makeGraph(adj, k);
			boolean[][] visited = new boolean[n][m];
			
			for(int i=0; i<adj.length; i++)
			{
				for(int j=0; j<adj[i].length; j++)
				{
					if(adj[i][j] == 1 && visited[i][j] == false)
					{
						visited[i][j] = true;
						dfs(adj, visited, i,j);
						resultCount[testCase-1]++;
					}
						
				}
			}
			
			testCase--;
		}
		
		for(int i = resultCount.length; i>0; i--)
			System.out.println(resultCount[i-1]);
		
	}
	
	public static void dfs(int[][] adjMatrix, boolean[][] visitMatrix, int pointX, int pointY) {
		
		int currentX = pointX;
		int currentY = pointY;
		
		
		int[] moveX = {1, -1, 0, 0};
		int[] moveY = {0, 0, 1, -1};
		
		for(int i=0; i<4; i++)
		{
			int nextX = currentX + moveX[i];
			int nextY = currentY + moveY[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= adjMatrix.length || nextY >= adjMatrix[currentX].length)
				continue;
			if(adjMatrix[nextX][nextY] == 1 && visitMatrix[nextX][nextY] == false)
			{
				visitMatrix[nextX][nextY] = true;
				dfs(adjMatrix, visitMatrix, nextX, nextY);
			}
		}
		
	}
	
	public static void makeGraph(int[][] adjMatrix, int caseSize) {
		for(int i=0; i<caseSize; i++)
		{
			int pointY = in.nextInt();
			int pointX = in.nextInt();
			adjMatrix[pointX][pointY] = 1;
		}
	}
	
}
