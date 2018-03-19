package essentials;

import java.util.ArrayList;

public class Sorts
{
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps++; //  for int outer = 0
		for (int outer = 0; outer < list.size() - 1; outer++)
		{
			steps++; //  when outer < list.size() -1 is true		
			steps++; //  outer++
			steps++; //  int inner = 0
			for (int inner = 0; inner < list.size()-outer-1; inner++)
			{
				steps++; //  inner < list.size()-outer-1 is true
				steps++; //  inner++
				steps++; //  boolean below 
				if (list.get(inner).intValue() > list.get(inner + 1).intValue())
				{
					//swap array[inner] & array[inner+1]
					Integer temp = list.get(inner);
					list.set(inner,list.get(inner+1));
					list.set(inner + 1, temp);
					steps += 3;
				}
			}
			steps++; //  inner < list.size()-outer-1 is false
		}
		steps++; //  when outer < list.size() -1 is false
		return steps;
	}

	public static int selectionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		int min, temp;
		
		steps++; //  for int outer = 0
		for (int outer = 0; outer < list.size() - 1; outer++)
		{
			steps++; //  when outer < list.size() - 1 is true
			steps++; //  outer++
			min = outer;
			steps++; //  min = outer
			steps++; //  int inner = outer + 1
			for (int inner = outer + 1; inner < list.size(); inner++)
			{
				steps++; //  inner < list.size() is true
				steps++; //  inner++
				steps++; //  boolean below 
				if (list.get(inner).intValue() < list.get(min).intValue())
				{
					min = inner; // a new smallest item is found
					steps++; // when min = inner
				}
			}
			//swap array[outer] & array[min]
			temp = list.get(outer);
			list.set(outer, list.get(min));
			list.set(min, temp);
			steps += 4; // inner is false, all the actions above
		}		
		steps++; // when outer < list.size() - 1 is false
		return steps;
	}

	public static int insertionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps++; // int outer = 1
		for (int outer = 1; outer < list.size(); outer++)
		{
			steps++; //  when outer < list.size() is true
			steps++; //  outer++
			int position = outer;
			int key = list.get(position);
			steps += 2; // 2 initializations above
			// Shift larger values to the right	
			while (position > 0 && list.get(position - 1) > key)
			{
				steps += 2; // boolean above
				list.set(position, list.get(position - 1));
				position--;
				steps += 2; // actions above	
			}
			steps += 2; //  when one of them are false
			list.set(position, key);
			steps++; // list.get(position) = key
		}
		steps++; //  when outer < list.size() is false 
		
		return steps;
	}
	
	public static int mergeSort (ArrayList<Integer> a, int from, int to)
	{
		int steps = 0;
		
		steps++; //  boolean below is true
		if (to - from < 2)
		{
			steps+=2; // boolean below
			if (to > from && a.get(to) < a.get(from))
			{
				int atemp = a.get(to);
				a.set(to, a.get(from));
				a.set(from, atemp);
				steps+=3;
			}
			steps+=2; //  last boolean was false
		}
		else
		{
			steps+=3; //  first boolean was false, boolean above is true, initialization below
			int middle = (from + to) / 2;
			steps += mergeSort(a, from, middle);
			steps += mergeSort(a, middle + 1, to);
			steps += merge(a, from, middle, to);
		}
		
		return steps;
	}

	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		int steps = 0;
		
		int i = from, j = middle + 1, k = from;
		ArrayList <Integer> temp = new ArrayList<Integer>(a.size());
		
		steps += 4; //  everything above

		while (i <= middle && j <= to)
		{
			steps += 2; // compound boolean above
			if (a.get(i) < a.get(j))
			{
				temp.set(k, a.get(i));
				i++;
				steps += 3; //  boolean above, temp.set(k, a.get(i))
			}
			else
			{
				temp.set(k, a.get(j));
				j++;
				steps += 3; // boolean above, temp.set(k, a.get(j)) 
			}
			k++;
			steps++;
		}
		steps += 2; //  compound boolean above is false
	
		while (i <= middle)
		{
			steps++; //  boolean above is true
			temp.set(k, a.get(i));
			i++;
			k++;
			steps += 3;
		}
		steps++; //  i <= middle is false
		while (j <= to)
		{
			steps++;
			temp.set(k,a.get(j));
			j++;
			k++;
			steps += 3;
		}
		steps++; // j <= to is false
		steps++; //  k = from
		for (k = from; k <= to; k++)
		{	
			steps+=2; //  k<= to is true, k++
			a.set(i,temp.get(k));
			steps++; //  statement above
		}
		steps++; // k <= to is false
		return steps;
	}

}


