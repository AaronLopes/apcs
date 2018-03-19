package essentials;

public class Example {
	
	
	public static void main(String [] args)
	{
		
		int [] array1 = {1, 2, 3, 4};
		int [] array2 = {1, 2, 3, 4};
		System.out.println(areP(array1, array2));
		
		
	}
	
	public static boolean areP(int [] arr1, int [] arr2 )
	{
		int num = 0;
		for(int i = 0; i < arr1.length; i++)
		{
			for(int j = 0; j < arr2.length; j++)
			{
				if(arr1[i] == arr2[j])
					num++;
			}
		}
		
		if(num == arr1.length)
			return true;
		return false;
	}

}
