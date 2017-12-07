package com.BJ.bj2178;
import java.util.*;

public class BJ2178 {

	public static void main (String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] graph = new int [n][m];
		int[][] countGraph = new int [n][m]; //�� ����� �ִ� �Ÿ��� ī��Ʈ
		boolean[][] visited = new boolean [n][m];
		
		for(int i=0; i<n; i++)
		{
			String quest = in.next();
			for(int j=0; j<m; j++)
			{
				graph[i][j] = Integer.parseInt(quest.charAt(j)+"");
				visited[i][j] = false;
			}
				
		}
		
		int[] moveX = {-1,1,0,0};
		int[] moveY = {0,0,-1,1};
		//��ǥ �̵��� ���ϰ� �ۼ��ϱ� ���Ͽ� '��,��,��,��'�� ��ǥ �̵��� ������ ���� ǥ���Ѵ�.
		
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0)); //������ Point Ŭ������ Ȱ���Ͽ� x,y ��ǥ�� �ʱ�ȭ�� ���ÿ� Queue�� �������
		visited[0][0] = true; //�湮�� üũ�ϴ� �迭���� �ʱⰪ�� true�� ��ȯ
		countGraph[0][0] = 1; //�� ��ǥ�� �ּ� �Ÿ��� ǥ���ϴ� �迭�� �ʱⰪ�� 1�� ���� ����

		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int x = current.x;
			int y = current.y;
			//���� ��ǥ�� x,y���� ����
			
			if(x == n-1 && y == m-1) {
				queue.clear();
				break;
				//������ �̷� ���¶�� ������ queue ���� �����ϰ� ������ ����
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = x + moveX[i];
				int ny = y + moveY[i];
				//�ϳ��� ��忡�� �����¿� �������� �˻��ϴ� for��
				if(nx<0 || ny<0 || nx >= n || ny >=m)
					continue; //���õ� ����� ������ ����� ���
				if(visited[nx][ny])
					continue; //�̵��� ��ǥ�� �̹� �湮�� ���� ���
				if(graph[nx][ny] == 0)
					continue; //�̵��� ��ǥ�� �����ִ� ���
				
				visited[nx][ny] = true; //���� ���ǹ��� �Ȱɷ��� ��� ù �湮���� �������� false�� true�� ��ȯ�Ͽ� �湮�Ѱ��� ǥ��
				countGraph[nx][ny] = countGraph[x][y] + 1; //���� ������ �Ѵܰ� �� �����ٴ� ���� ǥ�� -> �ּ� �Ÿ� �� ����
				queue.offer(new Point(nx,ny)); // �̵��� ��ǥ�� ���� queue�� �߰�
			}
		}
		System.out.println(countGraph[n-1][m-1]);
	}
	
	public static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
