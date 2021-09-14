package com.company;
import java.util.*;
import java.io.*;
import java.lang.Math;
public class knapsack {
    static int temp[][]=new int[100][1000];
    public static int tdknapsack(int wt[],int val[],int W, int n)
    {
        for(int i=0;i<n+1;i++)
            for(int j=0;j<W+1;j++)
                if(i==0||j==0)
                    temp[i][j]=0;
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<W+1;j++)
            {
                if(wt[i-1]<=j)
                    temp[i][j]=Integer.max((val[i-1]+temp[i-1][j-wt[i-1]]),temp[i-1][j]);
                else
                    temp[i][j]=temp[i-1][j];
            }
        }
        return temp[n][W];
    }
    public static void main(String args[])throws IOException{

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length");
        int n=sc.nextInt();
        System.out.println("Enter the capacity of sack");
        int W=sc.nextInt();
        int wt[]=new int[n];
        int val[]=new int [n];
        System.out.println("Enter the Weight elements");
        for(int i=0;i<n;i++)
            wt[i]=sc.nextInt();
        System.out.println("Enter the Weight elements");
        for(int i=0;i<n;i++)
            val[i]=sc.nextInt();
        System.out.println("Maximum Profit= "+tdknapsack(wt,val,W,n));
    }
}
