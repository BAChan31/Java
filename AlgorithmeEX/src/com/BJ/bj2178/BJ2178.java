package com.BJ.bj2178;
import java.util.*;

public class BJ2178 {

	public static void main (String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] graph = new int [n][m];
		int[][] countGraph = new int [n][m]; //각 경로의 최단 거리를 카운트
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
		//좌표 이동을 편리하게 작성하기 위하여 '상,하,좌,우'의 좌표 이동을 다음과 같이 표현한다.
		
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0)); //설정한 Point 클래스를 활용하여 x,y 좌표를 초기화와 동시에 Queue에 집어넣음
		visited[0][0] = true; //방문을 체크하는 배열에도 초기값은 true로 변환
		countGraph[0][0] = 1; //각 좌표별 최소 거리를 표시하는 배열의 초기값도 1을 집어 넣음

		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int x = current.x;
			int y = current.y;
			//현재 좌표의 x,y값을 선언
			
			if(x == n-1 && y == m-1) {
				queue.clear();
				break;
				//목적을 이룬 상태라면 나머지 queue 값을 삭제하고 컴파일 종료
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = x + moveX[i];
				int ny = y + moveY[i];
				//하나의 노드에서 상하좌우 움직임을 검사하는 for문
				if(nx<0 || ny<0 || nx >= n || ny >=m)
					continue; //제시된 행렬의 범위를 벗어나는 경우
				if(visited[nx][ny])
					continue; //이동한 좌표가 이미 방문한 곳일 경우
				if(graph[nx][ny] == 0)
					continue; //이동한 좌표가 막혀있는 경우
				
				visited[nx][ny] = true; //위의 조건문에 안걸렸을 경우 첫 방문임을 뜻함으로 false를 true로 변환하여 방문한것을 표시
				countGraph[nx][ny] = countGraph[x][y] + 1; //이전 레벨에 한단계 더 나갔다는 것을 표시 -> 최소 거리 수 증가
				queue.offer(new Point(nx,ny)); // 이동한 좌표의 값을 queue에 추가
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
