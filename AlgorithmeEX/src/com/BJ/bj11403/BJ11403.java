package com.BJ.bj11403;
import java.util.*;

public class BJ11403 {

	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		
		int count = in.nextInt();		
		int[][] adj = new int [count][count];
		int[][] resultMatrix = new int [count][count];
		
		for(int i=0; i<count; i++)
		{
			for(int j=0; j<count; j++)
			{
				adj[i][j] = in.nextInt();
			}
		}
		
		for(int i=0; i<count; i++)
		{
			int[] visited = new int [count];
			dfs(adj, visited, i, true);
			resultMatrix[i] = visited;
		}
		
		printResult(resultMatrix);
		
	}
	
	public static void dfs(int [][] adjMatrix, int[] visited, int start, boolean firstTime) {
		if(!firstTime)
			visited[start] = 1;
		for(int i=0; i<visited.length; i++)
		{
			if(adjMatrix[start][i] == 1 && visited[i] == 0)
				dfs(adjMatrix, visited, i, false);
		}
	}
	
	public static void printResult(int[][] adjMatrix)
	{
		for(int i=0; i<adjMatrix.length; i++)
		{
			for(int j=0; j<adjMatrix[i].length; j++)
			{
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
