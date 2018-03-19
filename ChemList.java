package essentials;

/**
 * ChemList.java
 * ChemList is a program that takes an ArrayList of
 * all the 118 identified elements and sorts them in any
 * particular way the user decides. It also contains a 
 * function in which the user can search for a specific 
 * element, which will then return all the information
 * for that given element.
 * @author AaronLopes
 * @version 1.0
 * @since 1/15/16
 */

import java.util.*;
import java.io.*;

public class ChemList
{
	private ArrayList<Element> elementList;
	private int steps;
	
	public ChemList()
	{
		elementList = new ArrayList<Element>();
	}
	
	public static void main(String [] args)
	{
		ChemList cList = new ChemList();
		cList.run();
	}	
	
	public void run()
	{
		
		int choice = 1;
		loadFile(elementList);
		do
		{
		
			choice = chooseFromMenu("Display Elements", elementList);
			
		}while( choice >= 1 && choice <= 4);
		System.out.println("\nThanks for checking through the Elements!\n\n");
	}


	public void loadFile(ArrayList <Element> a)
	{
		Scanner read = OpenFile.openToRead("/Users/AaronLopes/Elements.txt");
		
		while(read.hasNext())
		{
			a.add(new Element(read.nextInt(), read.next(), read.next(), read.nextDouble()));
		}
		
	} 
	
	public int getSortType ( )
	{	
		
		int c = Prompt.getInt("\nEnter a choice from the menu above", 1, 5);
		return c;
	}
	
	public int chooseFromMenu (String arraytype, ArrayList <Element> list )
	{
		menuOfSorts(arraytype);
		int choice = getSortType();
		String sortedList = "";
		switch(choice)
		{
			case 1:
				sortedList = bubbleSort(list);
				printList();
				break;
			case 2:
				sortedList = selectionSort(list);
				printList();
				break;
			case 3:
				sortedList = mergeSort(list, 0, list.size()-1);
				printList();
				break;
			case 4:
				insertionSort(list);
				elementSearch();
				break;
			case 5:
				choice = 5;
				break;
			default :
				System.out.println("\n\nInvalid input, entry was not between 1 and 5\n\n");
				break;
		}
			
		return choice;
	}
	
	public void printList()
	{
		System.out.println("\n+ - - - - - - - - - +");
		System.out.println("| List of Elements  |");
		System.out.println("+ - - - - - - - - - + - - - - - - - - - - - - - - - - - - - - +");
		System.out.printf("%-5s %-9s %7s %18s %15s %4s \n","|","#","Element", "Symbol", "Atomic Mass", "|");		
		for(int i = 0; i < elementList.size(); i++)
		{
			if( i % 5 == 0)
				System.out.printf("%-14s %48s \n","|","|");
			
			System.out.print(elementList.get(i).toStringFormat());
			
		}
		System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +");
	}
	
	public void menuOfSorts (String title)
	{
		System.out.println("\n\n1. " + title + " sorted by name");
		System.out.println("2. " + title + " sorted by number");
		System.out.println("3. " + title + " sorted by atomic mass");
		System.out.println("4. Search for an Element");
		System.out.println("5. Exit");
	}
	
	public void swap(int a, int b)
	{
		Element temp = elementList.get(a);
		elementList.set(a,elementList.get(b));
		elementList.set(b, temp);
	}
	
	public String bubbleSort (ArrayList <Element> list)
	{
		for (int outer = 0; outer < list.size() - 1; outer++)
		{
			for (int inner = 0; inner < list.size()-outer-1; inner++)
			{
				if (list.get(inner).compareToName(list.get(inner + 1)) > -1)
				{
					swap(inner, inner + 1);
				}
			}
		}
		return list.toString();
	}

	public String selectionSort(ArrayList <Element> list)
	{
		int min; 
		Element temp;
		for (int outer = 0; outer < list.size() - 1; outer++)
		{
			min = outer;
			for (int inner = outer + 1; inner < list.size(); inner++)
			{ 
				if (list.get(inner).compareToNum(list.get(min)) < 1)
				{
					min = inner; // a new smallest item is found
				}
			}
			//swap array[outer] & array[min]
			swap(outer, min);
	
		}		
		return list.toString();
	}
	
	public String insertionSort (ArrayList <Element> list)
	{
		for (int outer = 1; outer < list.size(); outer++)
		{
			int position = outer;
			Element key = list.get(position);
			while (position > 0 && list.get(position - 1).compareToSymbol(key) > 0)
			{
				list.set(position, list.get(position - 1));
				position--;
			}
			list.set(position, key);
		}
		return list.toString();
	}
	
	public String mergeSort (ArrayList<Element> a, int from, int to)
	{	
		if (to - from < 2)
		{
			if (to > from && a.get(to).compareToMass(a.get(from)) < 1)
			{
				swap(to, from);
			}
		}
		else
		{
			int middle = (from + to) / 2;
		}	
		return a.toString();
	}

	public void merge (ArrayList<Element> a, int from, int middle, int to)
	{
		int i = from, j = middle + 1, k = from;
		ArrayList <Element> temp = new ArrayList<Element>();
	
		while (i <= middle && j <= to)
		{
			if (a.get(i).compareToMass(a.get(j)) > 1)
			{
				temp.set(k, a.get(i));
				i++;
			}
			else
			{
				temp.set(k, a.get(j));
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			temp.set(k, a.get(i));
			i++;
			k++;
		}
		while (j <= to)
		{
			temp.set(k,a.get(j));
			j++;
			k++;
		}
		for (k = from; k <= to; k++)
		{	
			a.set(k,temp.get(k));
		}
	} 
	
	public void elementSearch()
	{
		System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		String eSymbol = Prompt.getString("Please enter an atomic symbol to search for (-1 to exit): ");
		int eIndex = binarySearch(eSymbol);
		
		if(eSymbol.equals("-1"))
		{
			return;
		}
		else if(eIndex == -1)
		{
			System.out.println("\nThe binary search took " + steps + " steps to determine that this element does not exist.\n");
			elementSearch();
		}
		else
		{	
			System.out.println("\nThe binary search took " + steps + " steps to find this element.");
			System.out.println("\n" + elementList.get(eIndex).toString());
			elementSearch();
		}
	}
		
	public int binarySearch(String x)
	{		
		int low = 0;
        int high = elementList.size() - 1;
        int mid;
		steps = 0;
        while( low <= high )
        {
            mid  = ( low + high ) / 2;
			steps++;
            if( elementList.get(mid).compareToSymbol( x ) < 0 )
                low = mid + 1;
            else if( elementList.get(mid).compareToSymbol( x ) > 0 )
                high = mid - 1;
            else
                return mid; 
        }

        return -1;     // NOT_FOUND = -1
	}

	
}
