import java.util.Scanner;

public class PaymoneyTransactions {
	
	int maxTrans;
	int[] tranArray;
	int totTarget;
	int targetValue;
	
	//Method to calculate if the target has been achieved or not
	public int calcTarget(int[] tranArray,int max,int targAmount) {
		int sum=0;
		for(int i=0;i<max;i++)
		{
			sum+=tranArray[i];
			if(sum>=targAmount)
			{
				i=i+1;
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int targetCount=0;
		Scanner sc=new Scanner(System.in);
		PaymoneyTransactions ob=new PaymoneyTransactions();
		
		System.out.println("Enter the size of transaction array ");
		ob.maxTrans=sc.nextInt();
		
		//defining the transaction array with the size
		ob.tranArray=new int[ob.maxTrans];
		
		System.out.println("Enter the values of array");
		for(int i=0;i<ob.maxTrans;i++)
		{
			ob.tranArray[i]=sc.nextInt();
		}
		
		System.out.println("Enter the total number of targets to be achieved");
		ob.totTarget=sc.nextInt();
		
		
		while(targetCount<ob.totTarget)
		{
			System.out.println("Enter the value of target");
			ob.targetValue=sc.nextInt();
			
			if(ob.targetValue>0)
			{
				//if return count>0 after checking transaction against target, then target will be achieved
				//if it is zero then the target will not be achieved
				int n=ob.calcTarget(ob.tranArray, ob.maxTrans, ob.targetValue);
				if(n>0)
				{
					System.out.println("target achieved after "+n+" transaction");
				}
				else
				{
					System.out.println("Given target not achieved");
				}
				targetCount++;
			}
			else
			{
				System.out.println("Target value cannot be 0 or less. Please enter a valid value");
			}
		}

	}

}
