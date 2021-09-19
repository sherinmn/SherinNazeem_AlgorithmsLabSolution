package com.gl.currency.main;

import java.util.Scanner;

public class DenominatorDemo {
	public int[] currency;
	int size;
	
	public static void countCurrency(int[] currency, int size, int amount) 
    { 
		if(amount==0)
		{
			System.out.println("Amount must be greater than 0");
			return;
		}
		
        int[] counter = new int[size]; //currency counter array
        
        try
        {
        	//count the denominations
        	for (int i = 0; i < size; i++) { 
        		if (amount >= currency[i]) { 
        			counter[i] = amount / currency[i]; 
        			amount = amount - counter[i] * currency[i]; 
        		} 
        	} 
       
        	// Print minimum number of denominations 
        	if(amount>0) {
        		System.out.println("exact amount cannot be given with the highest denomination");
        	}
        	else {
        		System.out.println("Currency Count ->"); 
        		for (int i = 0; i < size; i++) { 
        			if (counter[i] != 0) { 
        				System.out.println(currency[i] + " : "
        						+ counter[i]); 
        			} 
        		}
        	}
        } 
        catch(ArithmeticException e) {
        	System.out.println(e+" notes of denomination 0 is invalid");
        }
    } 
	
	public void mergeSort(int[] currency,int left, int right) 
	{
		if(left<right)
		{
			int mid=(left+right)/2;
			mergeSort(currency,left,mid);
			mergeSort(currency,mid+1,right);
			
			merge(currency,left,mid,right);
		}
		
	}
	
	public void merge(int[] currency,int left,int mid,int right)
	{
		int len1= mid-left+1;
		int len2=right-mid;
		
		int leftArr[]=new int[len1];
		int rightArr[]=new int[len2];
		
		for(int i=0;i<len1;i++)
			leftArr[i]=currency[left+i];
		for(int j=0;j<len2;j++)
			rightArr[j]=currency[mid+1+j];
		
		int i,j,k;
		i=j=0;
		k=left;
		while(i<len1&&j<len2){
			if(leftArr[i]>rightArr[j])
			{
				currency[k]=leftArr[i];
				i++;
			}
			else
			{
				currency[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<len1)
		{
			currency[k]=leftArr[i];
			i++;
			k++;
		}
		while(j<len2)
		{
			currency[k]=rightArr[j];
			j++;
			k++;
		}
		
	}
	
	static void displayArray(int[] currency)
	{
		int size=currency.length;
		for(int i=0;i<size;i++)
			System.out.println(currency[i]+" ");
		System.out.println();
	}
      
    
    public static void main(String argc[]){ 
    	
    	DenominatorDemo den=new DenominatorDemo();
    	Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the size of currency denominations");
        den.size=sc.nextInt();
        
        den.currency=new int[den.size];
        
        System.out.println("Enter the currency denominations value");
        for(int i=0;i<den.size;i++)
        {
        	den.currency[i]=sc.nextInt();
        }
      
        den.mergeSort(den.currency, 0, den.size-1);
        //System.out.println("\n after sorting");
        //displayArray(den.currency);
        
        System.out.println("Enter the amount");
        int amount=sc.nextInt();
        
        countCurrency(den.currency,den.size,amount); 
    } 
      
    
} 


