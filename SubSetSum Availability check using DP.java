package com.company;
import java.util.*;
import java.io.*;
public class SubSetSum {
    static boolean temp[][]=new boolean[100][1000];
    static boolean subsetsum(int arr[],int sum,int n)
    {
      for(int i=0;i<n+1;i++)
          for(int j=0;j<sum+1;j++)
          {
              if(i==0)
                  temp[i][j]=false;
              if(j==0)
                  temp[i][j]=true;
          }
      for(int i=1;i<n+1;i++)
          for(int j=1;j<sum+1;j++)
              if(arr[i-1]<=j)
                temp[i][j] = temp[i - 1][j - arr[i - 1]] || temp[i - 1][j];
              else
                  temp[i][j]=temp[i-1][j];
      return temp[n][sum];
    }
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n=sc.nextInt();
        System.out.println("Enter the Sum to be find");
        int sum=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the Array Elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        if(subsetsum(arr,sum,n))
            System.out.println("Subset Present");
        else
            System.out.println("Subset Not present");
        sc.close();
    }
}
