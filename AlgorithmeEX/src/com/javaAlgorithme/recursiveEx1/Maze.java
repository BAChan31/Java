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
		//����� ������ ����� �κ��� false�� ����
		
		else if (MAZE[x][y] != PATHWAY_COLOR)
			return false;
		//��ΰ� �ƴ� �κ��� �׳� �� false�� ó��
		
		else if (x == N-1 && y == N-1) {
			MAZE[x][y] = PATH_COLOR;
			return true;
		//���� �������� �����ϸ� true�� ó��. �� �κ��� BaseCase�� �ȴ�.
		}
		else {
			MAZE[x][y] = PATH_COLOR;
			//�ϴ� �湮�� ������ ��η� �ν��ع�����. ���� ���� ������ �߸��� ������ �� �� ����.
			if(findMazePath(x-1,y) || findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1)) {
				return true;
				//�̺κ��� �ٽ��� ��. ���ǹ����� ��͸� �ɾ�������ν� x,y ��ǥ ���ǰ�θ� �� Ž���ϰ� �ȴ�. ù��° ������Ǻ��� �İ��ԵǾ� BaseCase����
				//�����Ѵ�. ������ or�� ������ �ϳ��� true�� �ȴٸ� �ϴ��� true�� ��ȯ�Ѵ�. �ǵ��ƿ� ���� ��� 0�̱� ������ false�� �����ϰԵǾ� 4����
				//false�� �Ǹ� if���� Ż���ϰ� �ȴ�.
			}
			MAZE[x][y] = BLOCKED_COLOR;
			return false;
			//if���� Ż���ϰԵ� ��� ���� ���� ��� �����Ͽ� false�� ��ȯ�ϰ� ���ܰ��� ��ͷ� �Ѿ��.
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
