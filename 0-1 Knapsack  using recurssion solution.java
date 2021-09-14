package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.lang.Math;
public class solution {
    public static int knapsack(int wt[],int val[],int W,int n)
    {
        if (n==0||W==0)
            return 0;
        if(wt[n-1]<=W)
            return(Integer.max((val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1)),
                    knapsack(wt, val, W, n - 1)));
        else //if(wt[n-1]>W)
            return knapsack(wt,val,W,n-1);
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
        System.out.println("Maximum profit= "+knapsack(wt,val,W,n));
        sc.close();
    }
}
