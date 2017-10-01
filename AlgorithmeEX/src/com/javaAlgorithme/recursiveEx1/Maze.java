package com.javaAlgorithme.recursiveEx1;

public class Maze {
	
	private static int N = 8;
	private static int [][] MAZE = {
			{0,0,0,0,0,0,0,1},
			{0,1,1,0,1,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,0,0,1,1,0,0},
			{0,1,1,1,0,0,1,1},
			{0,1,0,0,0,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,1,1,0,1,0,0}
	};
	
	private static final int PATHWAY_COLOR = 0;
	private static final int WALL_COLOR = 1;
	private static final int BLOCKED_COLOR = 2;
	private static final int PATH_COLOR = 3;
	
	public static boolean findMazePath(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N)
			return false;
		//행렬의 범위를 벗어나는 부분을 false로 설정
		
		else if (MAZE[x][y] != PATHWAY_COLOR)
			return false;
		//통로가 아닌 부분은 그냥 다 false로 처리
		
		else if (x == N-1 && y == N-1) {
			MAZE[x][y] = PATH_COLOR;
			return true;
		//최종 목적지에 도달하면 true로 처리. 이 부분이 BaseCase가 된다.
		}
		else {
			MAZE[x][y] = PATH_COLOR;
			//일단 방문한 지점은 통로로 인식해버린다. 아직 옳은 길인지 잘못된 길인지 알 수 없다.
			if(findMazePath(x-1,y) || findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1)) {
				return true;
				//이부분이 핵심인 셈. 조건문에서 재귀를 걸어버림으로써 x,y 좌표 외의경로를 다 탐색하게 된다. 첫번째 재귀조건부터 파고들게되어 BaseCase까지
				//접근한다. 조건이 or기 때문에 하나라도 true가 된다면 일단은 true를 반환한다. 되돌아온 길의 경우 0이기 때문에 false로 인지하게되어 4면이
				//false가 되면 if문을 탈출하게 된다.
			}
			MAZE[x][y] = BLOCKED_COLOR;
			return false;
			//if문을 탈출하게된 경우 갈수 없는 길로 인지하여 false를 반환하고 윗단계의 재귀로 넘어간다.
		}
	}
	
	private static void printMaze() {
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				System.out.print(MAZE[i][j] + " ");
			}
			System.out.println("");
		}			
	}
	
	public static void main (String args[]) {
		
		printMaze();
		findMazePath(0,0);
		System.out.println("");
		printMaze();
	}

}
