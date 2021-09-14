package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class solution {
    static int temp[][]=new int[100][1000];
    public static int knapsack(int wt[],int val[],int W,int n)
    {
        if (n==0||W==0)
            return 0;
        if (temp[n][W]!=-1)
            return temp[n][W];
        if(wt[n-1]<=W)
            return temp[n][W]=(Integer.max((val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1)),
                    knapsack(wt, val, W, n - 1)));
        else //if(wt[n-1]>W)
            return temp[n][W]=knapsack(wt,val,W,n-1);
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length");
        int n=sc.nextInt();
        System.out.println("Enter the Weight of sack");
        int W=sc.nextInt();
        int wt[]=new int[n];
        int val[]=new int[n];
        System.out.println("Enter Elements in weight array");
        for(int i=0;i<n;i++)
            wt[i]=sc.nextInt();
        System.out.println("Enter Elements in value array");
        for(int i=0;i<n;i++)
        val[i]=sc.nextInt();
        for(int i=0;i<n+1;i++)
            for(int j=0;j<W+1;j++)
                temp[i][j]=-1;
        knapsack(wt,val,W,n);
        System.out.println("Max_profit= "+temp[n][W]);
        sc.close();
    }
}
