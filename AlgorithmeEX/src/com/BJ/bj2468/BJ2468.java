package com.BJ.bj2468;
import java.util.*;

public class BJ2468 {

	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY = {0,0,1,-1};
	public static int[][] map;
	public static int[][] condition;
	
	public static int SAFE = 0;
	public static int VISITED = 1;
	public static int FLOODING = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j] = in.nextInt();
		
		int height = 1;
		int	maxBuilding = 0;
		while(height<100)
		{
			condition = new int[N][N];
			int tempMax = 0;
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(map[i][j] < height)
						condition[i][j] = FLOODING;
				}
			}
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(condition[i][j]==SAFE)
					{
						dfs(i,j);
						tempMax++;
					}
				}
			}
				
			maxBuilding = Math.max(tempMax, maxBuilding);
			height++;
		}
		
		System.out.println(maxBuilding);

	}

	static void dfs(int startX, int startY) {
		condition[startX][startY] = VISITED;
		for(int i=0; i<4; i++)
		{
			int nextX = startX + moveX[i];
			int nextY = startY + moveY[i];
			
			if(nextX>=0 && nextY>=0 && nextX<condition.length && nextY<condition.length && condition[nextX][nextY] == SAFE)
			{
				dfs(nextX, nextY);
			}
		}
	}
}
