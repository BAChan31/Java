package com.javaAlgorithme.recursiveEx2;

public class Blob {

	private static int BACKGROUND_CELL = 0;
	private static int IMAGE_CELL = 1;
	private static int COUNTED_CELL = 2;
	
	private static int N = 8;
	
	private static int [][] Blob = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1}
	};
	
	public static int countCells(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N)
		{
			return 0;
		}
		else if(Blob[x][y] != IMAGE_CELL)
		{
			return 0;
		}
		else
		{
			Blob[x][y] = COUNTED_CELL;
			return 1 + countCells(x-1, y-1) + countCells(x-1, y) + countCells(x-1, y+1)	
			+ countCells(x,y-1) + countCells(x,y+1) + countCells(x+1, y-1) + countCells(x+1, y) + countCells(x+1, y+1);
		}
	}
	
	public void printResult() {
		for(int i = 0; i<N ; i++)
		{
			for(int j = 0; j<N; j++)
			{
				System.out.print(Blob[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main (String args[]) {
		int result = countCells(3,5);
		
		System.out.println(result);
		
		int [] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(arr[(0 + arr.length)/2]);
		System.out.println(arr.length);
		
		
	}
}
