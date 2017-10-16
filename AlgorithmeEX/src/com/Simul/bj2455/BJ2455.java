package com.Simul.bj2455;
import java.util.Scanner;
import java.math.*;
public class BJ2455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int[][] people = new int[4][2];
		int[] station = new int[4];
		
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<2; j++)
			{
				people[i][j] = in.nextInt();
			}
		}
		
		for(int i=0; i<4; i++)
		{
			countPeople(people, station, i);
		}
		
		int maxPeople = 0;
		
		for(int i=0; i<4; i++)
		{
			maxPeople = Math.max(maxPeople, station[i]);
		}
		
		System.out.println(maxPeople);
	}
	
	static void countPeople(int[][] customer, int[] stationPoint ,int stationNum) {
		if(stationNum == 0)
		{
			stationPoint[stationNum] = customer[stationNum][1];
		}
		else
		{
			stationPoint[stationNum] = stationPoint[stationNum-1] - customer[stationNum][0] + customer[stationNum][1];
		}
	}

}
