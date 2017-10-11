package com.BFSDFS.bj2667;
import java.util.Scanner;


public class BJ2667 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[][] graph = new int[n][n];
		int[][] visitGraph = new int [n][n];
		int[] result;
		int count = 0;
		
		for(int i=0; i<graph.length; i++)
		{
			String question = in.next();
			for(int j=0; j<graph[i].length; j++)
			{
				graph[i][j] = Integer.parseInt(question.charAt(j) + "");
			}
		}
		
		for(int i=0; i<graph.length; i++)
		{
			for(int j=0; j<graph.length; j++)
			{
				if(graph[i][j] == 1 && visitGraph[i][j] == 0)
				{
					++count;
					visitGraph[i][j] = count;
					dfs(graph, visitGraph, i, j, count);
				}				
			}
		}
		
		result = new int[count];
		System.out.println(count);
		
		for(int k=1; k<=result.length; k++)
		{
			for(int i=0; i<visitGraph.length; i++)
			{
				for(int j=0; j<visitGraph[i].length; j++)
				{
					if(k == visitGraph[i][j])
						result[k-1]++;
				}
			}
		}
				
		sortingResult(result);
	}
	
	public static void dfs(int[][] adj, int[][] visit, int startX, int startY, int number) {
		
		int[] moveX = {1,-1,0,0};
		int[] moveY = {0,0,1,-1};
		
		for(int i=0; i<4; i++)
		{
			int nextX = startX + moveX[i];
			int nextY = startY + moveY[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= adj.length || nextY >= adj[startX].length)
				continue;
			if(adj[nextX][nextY] == 1 && visit[nextX][nextY] == 0)
			{
				visit[nextX][nextY] = number;
				dfs(adj, visit, nextX, nextY, number);
			}
		}
	}
	
	public static void sortingResult(int[] sortingArr) {
		
		int temp;
		
		for(int i=0; i<sortingArr.length-1; i++)
		{
			for(int j=0; j<sortingArr.length-1-i; j++ )
			if(sortingArr[j]>sortingArr[j+1])
			{
				temp = sortingArr[j+1];
				sortingArr[j+1] = sortingArr[j];
				sortingArr[j] = temp;
			}
		}
		
		for(int i=0; i<sortingArr.length; i++)
		{
			System.out.println(sortingArr[i]);
		}
	}
}
