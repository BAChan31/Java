package com.BJ.bj2644;
import java.util.*;

public class bj2644 {
	static int result=0;
	static int [][] arr;
	static boolean [][] visited;
	public static void main(String args[]) {
		arr = new int [101][101];
		visited = new boolean [101][101];
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();
		int startPeople = in.nextInt();
		int endPeople = in.nextInt();
		int edge = in.nextInt();
		int countResult = -1;
		
		for(int i=0; i<edge; i++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(startPeople, endPeople, countResult);
		
		System.out.println(result!=0 ? result : -1);
	}
	
	static void dfs(int start, int end, int count) {
		if(start==end)
		{
			count++;
			result=count;
			return;
		}
		for(int i=1; i<arr.length; i++)
		{
			if(arr[start][i]==1 && visited[start][i] == false)
			{
				visited[start][i] = true;
				dfs(i,end,count+1);
			}
		}
	}
}
