package com.SW.test2105;
import java.util.Scanner;

public class TEST2105 {
	
	public static final int[] moveX = {-1,-1,1,1};
	public static final int[] moveY = {-1, 1,1,-1};

	public static int testResult;
	public static int [][]graph;
	public static boolean[] dessertCafe;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();

		for(int testCaseNum=1; testCaseNum <= testCase; testCaseNum++)
		{
			int caseNum = in.nextInt();
			graph = new int[caseNum][caseNum];
			
			testResult = -1;
			for(int i=0; i<caseNum; i++)
			{
				for(int j=0; j<caseNum; j++)
				{
					graph[i][j] = in.nextInt();
				}
			}
			
			foundBest(caseNum);
			System.out.println("#" + testCaseNum + " " + testResult);
			
		}
	}
	
	static void foundBest(int caseCount) {

		
		//�׷������� ������ ����
		for(int i=0; i<caseCount; i++)
		{
			for(int j=0; j<caseCount; j++)
			{
				dessertCafe = new boolean[101];
				findWay(i,j,i,j,0, 0, 0,true);
			}
		}
		
	}
	
	static void findWay(int startX, int startY, int currentX, int currentY, int direction, int curveCount, int dessertCount, boolean start) {

		if(curveCount > 3)
			return;
		
		for(int i=0; i<4; i++)
		{
			int nextX = currentX + moveX[i];
			int nextY = currentY + moveY[i];
					
			//������ ������Ű�� ������ ��
			if(nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[currentX].length)
				continue;

			if(dessertCafe[graph[nextX][nextY]])
				continue;
			//��� ������ �����Ͽ��� ��
			if((nextX==startX && nextY==startY) && curveCount >= 2)
			{
				testResult = Math.max(testResult, dessertCount +1);
				return;
			}
			//���� �������� �Ѿ�� �� ����
			
				int nextCurve=curveCount;
				
				if(!start)
				{
					if(direction != i)
					{
						nextCurve=curveCount+1;
					}
				}
				
				dessertCafe[graph[nextX][nextY]] = true;
				findWay(startX, startY, nextX, nextY, i, nextCurve, dessertCount+1,false);
				dessertCafe[graph[nextX][nextY]] = false;			
		}
	}
	
}
