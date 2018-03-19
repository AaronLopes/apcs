package essentials;

//Aaron Lopes
//02.12.2015
//SortMenu.java


import java.util.Scanner;
import java.awt.List;
import java.util.ArrayList;

public class SortMenu
{
	ArrayList <Integer> intList;
	
	public SortMenu ( )
	{
		intList = new ArrayList <Integer> ();
	}

	public static void main (String [] args)
	{
		SortMenu sortit = new SortMenu();
		sortit.run();
	}
	
	public void run ( )
	{
		char choice = '1';
		welcome();
		do
		{
			int size = getSize();
			int max = getMax();
			createList(size, max, intList);
			printList(intList);
			choice = chooseFromMenu("ArrayList of Integer", intList);
			choice = repeatOrEnd(choice);
		} while (choice >= '1' && choice <= '4');
		goodBye();
	}

	//  A welcome message.
	public void welcome ( )
	{
		System.out.println("\n\n\n\n\t\t\tAre you feeling OUT OF SORTS?\n\n");
		System.out.println("Welcome to the SORTING PROGRAM, a program that will take an Integer ArrayList");
		System.out.println("that is initially unordered, and then order the array using one of 3 quadratic");
		System.out.println("sorting algorithms, or an n log n sort.  These include a Bubble Sort, a Selection");
		System.out.println("Sort, an Insertion Sort, and a Merge Sort.  HAPPY SORTING!\n\n");
	}

	//  Gets the size of the array, from 5 to 10000.
	public int getSize ( )
	{
		return 400;
	}

	//  Gets the max value of the random values to be generated, from 1 to max.  The max should be from 5 to 10000.
	public int getMax ( )
	{
		return 1000;
	}

	//  Generates an ArrayList of Integer values, with a size of s, and values from 1 to m.
	public void createList (int s, int m, ArrayList <Integer> a)
	{
		for(int i = 0; i < s; i++)
		{
			int value = (int)(Math.random()*m + 1);
			a.add(new Integer(value));
		}
		
	}

	//  Prints the ArrayList of Integer, printing a new line after every 15 values.
	public void printList (ArrayList <Integer> a)
	{
		System.out.println("\n");
		for(int i = 0; i < a.size(); i++)
		{
			if(i % 15 == 0)
				System.out.println("\n");
			System.out.printf("%-7d", a.get(i).intValue());
		}
		System.out.println("\n");
	}

	//  Calls menuOfSorts, getSortType, one of the sorts, then printList and printSteps.
	public char chooseFromMenu (String arraytype, ArrayList <Integer> list)
	{
		menuOfSorts(arraytype);
		//This will need more work
		int s = Sorts.bubbleSort(intList);
		printList(intList);	
		printSteps(s);
		
		return '1';
	}

	//  Prints the list of sort options.
	public void menuOfSorts (String title)
	{
		System.out.println("\n\n1. " + title + " Bubble Sort");
		System.out.println("2. " + title + " Selection Sort");
		System.out.println("3. " + title + " Insertion Sort");
		System.out.println("4. " + title + " Merge Sort\n");
	}

	//  Prompts the user to enter a character value from '1' to '4', indicating the sort
	//  to be run.
	public char getSortType ( )
	{
		return '1';
	}

	//  Prints the number of steps taken by the sort.
	public void printSteps (int s)
	{
		System.out.println("\n\n" + s + " steps taken in this sort");
	}

	//  Prompts the user to enter a 'c' or 'C' to continue, any other character to exit.
	public char repeatOrEnd (char c)
	{
		return '5';
	}

	//  A goodbye message.
	public void goodBye ( )
	{
		System.out.println("\n\n\n\t\tThanks for working with the SORTING PROGRAM.");
		System.out.println("Hopefully, you were able to put your affairs in order(!).  Please run the program again");
		System.out.println("if you're interested in seeing quadratic sorting algorithms at work.\n\n\n\n");
	}
}
