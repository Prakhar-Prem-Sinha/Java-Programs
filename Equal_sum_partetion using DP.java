package com.company;
import java.util.*;
import java.io.*;
public class Equal_sum_partetion {
    static boolean temp[][]=new boolean[100][1000];
    static boolean partetion(int arr[],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        if (sum%2!=0)
            return false;
        else
            return subsetsum(arr,sum/2,n);
    }
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
        int arr[]=new int[n];
        System.out.println("Enter the Array Elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        if(partetion(arr,n))
            System.out.println("Equal Partetion can be formed");
        else
            System.out.println("Equal partetion cannot be formed");
        sc.close();
    }
}
