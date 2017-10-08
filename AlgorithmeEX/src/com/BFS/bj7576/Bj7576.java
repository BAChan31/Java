package com.BFS.bj7576;
import java.util.*;

public class Bj7576 {

	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] graph = new int [n][m];
		int[][] countGraph= new int [n][m];
		boolean[][] visited = new boolean [n][m];
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				graph[i][j] = in.nextInt();
				if(graph[i][j] == 1)
				{
					queue.offer(new Point(i,j));
					countGraph[i][j] = 0;
					visited[i][j] = true;
				}
					
			}
		}
		
		int[] moveX = {1, -1, 0, 0};
		int[] moveY = {0, 0, 1, -1};
		
		while(!queue.isEmpty())
		{
			Point currentPosition = queue.poll();
			int currentX = currentPosition.x;
			int currentY = currentPosition.y;
			
			for(int i=0; i<4; i++)
			{
				int nextX = currentX + moveX[i];
				int nextY = currentY + moveY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >=n || nextY >=m)
					continue;
				if(visited[nextX][nextY] == true || graph[nextX][nextY] == -1)
					continue;
				
				visited[nextX][nextY] = true;
				countGraph[nextX][nextY] = countGraph[currentX][currentY] + 1;
				graph[nextX][nextY] = 1;
				
				queue.offer(new Point(nextX,nextY));
			}
		}
		
		//검사부분 필요
		
		System.out.println(searchMaxCount(countGraph));
		
	}
	
	public static int searchMaxCount(int[][] question) {
		int max=0;
		
		for(int i=0; i< question.length; i++)
		{
			for(int j=0; j< question[i].length; j++)
			{
				if(question[i][j] == 0)
				{
					return -1;
				}
				if(max < question[i][j])
					max=question[i][j];
			}
		}
		
		return max;
	}
	
	public static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
