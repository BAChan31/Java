package com.DP.bj1149;
import java.util.Scanner;
import java.math.*;

public class BJ1149 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner in = new Scanner(System.in);
      
      int n = in.nextInt();
      int [][] graph = new int [n+1][3];
      int [][] dp = new int [n+1][3];
      
      for(int i=1; i<graph.length; i++)
      {
         for(int j=0; j<3; j++)
         {
            graph[i][j]=in.nextInt();
         }
      }
      
      graph[0][0] = graph[0][1] = graph[0][2] = dp[0][0] = dp[0][1] = dp[0][2] = 0;
      
      for(int i=1; i<graph.length; i++)
      {
         dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + graph[i][0];
         dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + graph[i][1];
         dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][2];
      }
      
      System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
   }

}