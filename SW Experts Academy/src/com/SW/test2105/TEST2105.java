package com.SW.test2105;
import java.util.Scanner;

public class TEST2105 {
	
	public static final int[] moveX = {-1,-1,1,1};
	public static final int[] moveY = {-1, 1,1,-1};
	public static final int STARTPOINT = 2;
	public static final int CANVISIT = 1;
	public static final int CANNOTVISIT = 0;

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
			
			testCase--;
			
		}
	}
	
	static void foundBest(int[][] graph, int caseCount) {
		int temp = 0;
		int [][] visitGraph;

		
		//그래프별로 시작점 설정
		for(int i=0; i<caseCount; i++)
		{
			for(int j=0; j<caseCount; j++)
			{
				boolean[] dessert = new boolean[101];
				visitGraph = new int[caseCount][caseCount];
				Point startPoint = new Point(i,j);
				findWay(graph, visitGraph, dessert, startPoint, i, j, true);
			}
		}
		
		System.out.println("dfdf");
	}
	
	static void findWay(int[][] adj, int[][] checkedGraph, boolean[] visitCafe ,Point current, int direction, int curveCount, boolean start) {
		if(start)
		{
			checkedGraph[current.x][current.y] = STARTPOINT;
			visitCafe[adj[current.x][current.y]] = true;
		}
		
		for(int i=0; i<4; i++)
		{
			Point nextPoint = new Point(current.x,current.y);
			nextPoint.x += moveX[i];
			nextPoint.y += moveY[i];
			if(start)
			{
				direction = i;
				curveCount = 0;
			}
			else if(direction != i)
			{
				direction = i;
				curveCount ++;
			}
			
			//for문 탈출조건
			if(nextPoint.x < 0 || nextPoint.y < 0 || nextPoint.x >= adj.length || nextPoint.y >= adj[current.x].length)
				continue;
			if(curveCount > 3)
				return;
			if(visitCafe[adj[nextPoint.x][nextPoint.y]] == true)
				continue;
			if(checkedGraph[nextPoint.x][nextPoint.y]==STARTPOINT && curveCount == 3)
				return;
			if(checkedGraph[nextPoint.x][nextPoint.y] == CANNOTVISIT && curveCount <= 3)
			{
				visitCafe[adj[nextPoint.x][nextPoint.y]] = true;
				checkedGraph[nextPoint.x][nextPoint.y] = CANVISIT;
				findWay(adj, checkedGraph, visitCafe, nextPoint, direction, curveCount, false);
				visitCafe[adj[nextPoint.x][nextPoint.y]] = true;
				checkedGraph[nextPoint.x][nextPoint.y] = CANNOTVISIT;
			}
			
			
		}
	}
	

	public static class Point {
		int x,y;
		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;			
		}
	}
}
