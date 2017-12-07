package com.BJ.bj2583;
import java.util.*;

public class BJ2583 {

	public static int[][] ADJ;
	public static boolean[][] COLORED;
	public static int[][] RECTANGLE;
	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY = {0,0,1,-1};
	public static int AREACOUNT = 0;
	public static List<Integer> arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int K = in.nextInt();
		
		arr = new ArrayList<>();
		ADJ = new int[M+1][N+1];
		COLORED = new boolean[M][N];
		RECTANGLE = new int[K][4];
		
		for(int i=0; i<K; i++)
		{
			for(int j=0; j<4; j++)
			{
				RECTANGLE[i][j] = in.nextInt();
			}
		}
		
		makeHuddle(K);
		
		for(int i=0; i<COLORED.length; i++)
		{
			for(int j=0; j<COLORED[i].length; j++)
			{
				if(COLORED[i][j] == false)
				{
					findArea(i, j);
				}
			}
		}
		System.out.println(AREACOUNT);
		Collections.sort(arr);
		for(int ans : arr) {
			System.out.print(ans+" ");
		}
//		for(int i=0; i<arr.size(); i++)
//			System.out.print(arr.get(i)+" ");
	}
	
	static void makeHuddle(int count) {
		int widthNum = count;
		while(count > 0)
		{
			int width = RECTANGLE[widthNum-count][2] - RECTANGLE[widthNum-count][0];
			int height = RECTANGLE[widthNum-count][3] - RECTANGLE[widthNum-count][1];
			
			for(int i=0; i<height; i++)
			{
				for(int j=0; j<width; j++)
				{
					COLORED[RECTANGLE[widthNum-count][1]+i][RECTANGLE[widthNum-count][0]+j] = true;
				}
			}
			count--;
		}
	}
	
	static void findArea(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		int area = 1;
		COLORED[startX][startY] = true;
		while(!queue.isEmpty())
		{
			Point temp = queue.poll();
			int currentX = temp.x;
			int currentY = temp.y;
			
			for(int i=0; i<4; i++)
			{
				int nextX = currentX + moveX[i];
				int nextY = currentY + moveY[i];
				
				if(nextX>=0 && nextY>=0 && nextX<COLORED.length && nextY<COLORED[currentX].length)
				{
					if(COLORED[nextX][nextY]==true)
						continue;
					COLORED[nextX][nextY]=true;
					queue.offer(new Point(nextX, nextY));
					area++;
				}
			}
		}
		arr.add(area);
		AREACOUNT++;
	}
	
	static class Point {
		int x;
		int y;		
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	/*public static class Point implements Comparable<Point>{
	      int x, y;
	      public Point(int x, int y){
	         this.x = x;
	         this.y =y ;
	      }
	      @Override
	      public int compareTo(Point o) {
	         return this.x - o.x; //작으면 -1, 같으면 0, 크면 1을 자동으로 반환시키는 방법
	      }
	   }*/

}
