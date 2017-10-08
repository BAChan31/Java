package com.BFS.bj1697;
import java.util.*;

public class BJ1697 {
	
	
	public static void main (String args[]) {


		Scanner in = new Scanner(System.in);
		int subinPoint = in.nextInt();
		int brotherPoint = in.nextInt();
		int [] countMap = new int [100001];
		boolean []visited = new boolean[100001];
		
		int[] moveX = {-1,1,2};
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(subinPoint);
		visited[subinPoint] = true;
		countMap[subinPoint] = 0;
		
		while(!queue.isEmpty()) {
			int currentPoint = queue.poll();
			
			if(currentPoint == brotherPoint) {
				queue.clear();
				break;
			}
			
			for(int i=0; i<3; i++)
			{
				int nextPoint = 0;
				if(i < 2)
					nextPoint = currentPoint + moveX[i];
				else if(i == 2)
					nextPoint = currentPoint * moveX[i];
				
				if(nextPoint >= countMap.length || nextPoint < 0)
					continue;
				if(visited[nextPoint])
					continue;
				
				visited[nextPoint] = true;
				countMap[nextPoint] = countMap[currentPoint] + 1;
				queue.offer(nextPoint);
			}
		}
		System.out.println(countMap[brotherPoint]);
		
		for(int i = 0; i<20; i++)
			System.out.print(countMap[i] + " ");

	}
}
