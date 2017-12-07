package com.BJ.bj1012;
import java.util.*;

public class BJ1012 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		int [][][] adj = new int [testCase][][];
		boolean [][][] visited = new boolean [testCase][][];
		int [] result = new int [testCase];
		for(int i=0; i<testCase; i++)
		{
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			adj[i] = new int [n][m]; 
			visited[i] = new boolean [n][m];
			for(int j=0; j<k; j++)
			{
				int trueY = in.nextInt();
				int trueX = in.nextInt();
				adj[i][trueX][trueY] = 1;
			}
		}
		
		bfs(adj, visited, result);
		

	}
	
	static void bfs(int [][][] adjMatrix, boolean [][][] visitMatrix, int[] resultCount) {
		
		int[] moveX = {1,-1,0,0};
		int[] moveY = {0,0,1,-1};
		Queue<Point> queue = new LinkedList<>();
		
		for(int firstCount=0; firstCount < adjMatrix.length; firstCount++)
		{
			for(int secondCount=0; secondCount < adjMatrix[firstCount].length; secondCount++)
			{
				for(int thirdCount=0; thirdCount < adjMatrix[firstCount][secondCount].length; thirdCount++)
				{
					if(adjMatrix[firstCount][secondCount][thirdCount] == 1 && visitMatrix[firstCount][secondCount][thirdCount]==false)
					{
						queue.offer(new Point(secondCount,thirdCount));
						while(!queue.isEmpty())
						{
							Point current = queue.poll();
							int currentX = current.x;
							int currentY = current.y;
							for(int i=0; i<4; i++)
							{
								int nextX = current.x + moveX[i];
								int nextY = current.y + moveY[i];
								
								if(nextX < 0 || nextY < 0 || nextX >= adjMatrix[firstCount].length || nextY >= adjMatrix[firstCount][secondCount].length)
									continue;
								if(adjMatrix[firstCount][nextX][nextY] == 1 && visitMatrix[firstCount][nextX][nextY]==false)
								{
									visitMatrix[firstCount][nextX][nextY]=true;
									queue.offer(new Point(nextX,nextY));
								}								
							}
						}
						
						resultCount[firstCount]++;
						
					}
					
				}
			}
		}
		
		for(int i=0; i<resultCount.length; i++)
			System.out.println(resultCount[i]);
	}
	
	
    static class Point{
    	int x, y;
		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
