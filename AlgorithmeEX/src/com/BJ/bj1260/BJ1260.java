package com.BJ.bj1260;

import java.util.*;

public class BJ1260 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int v = in.nextInt();
		int[][] adj = new int [n][n];
		boolean[] visited = new boolean [n];
		

		int a, b;
		for(int i=0; i<m; i++)
		{
			a = in.nextInt()-1;
			b = in.nextInt()-1;
			adj[a][b] = adj[b][a] = 1;

		}
		
		dfs(adj,visited, v-1);
		
		System.out.println();
		
		for(int i=0; i<visited.length; i++)
			visited[i] = false;
		bfs(adj,visited, v-1);
		
	}
	
	public static void dfs(int [][]adj, boolean[] visited, int v) {
		visited[v] = true;
		System.out.print((v+1) + " ");
		
		for(int i=0; i<adj.length; i++)
		{
			if(adj[v][i] == 1 && visited[i] == false)
				dfs(adj, visited, i);
		}
	}
	
	public static void bfs(int[][]adj, boolean[] visited, int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		System.out.print((v+1) + " ");
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0; i<adj.length; i++)
			{
				if(adj[current][i]==1 && visited[i]==false)
				{
					visited[i] = true;
					queue.offer(i);
					System.out.print((i+1) + " ");
				}
			}
		}
		
	}
}
