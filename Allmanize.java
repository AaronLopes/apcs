package essentials;

/**
* Allmanize.java
* Takes any java or text file given
* by the user and formats it according
* to Allmans style formatting. It then prints
* the formatted file to the terminal window
* and creates a new file dubbed "Test.java"
* @author Aaron Lopes
* @version 1.0
* @since 11/3/15
*/

import java.util.Scanner;
import java.io.*;

public class Allmanize
{
	/** Global Variables */
	private static String myFile = "";
	private int numberOfTabs = 0;
	private Scanner infile;
	private int i;
	private PrintWriter outfile;

	/**
	* Public constructor for Allamize.java
	* @param filename			The file entered by the user
	*/
	public Allmanize(String filename)
	{
		infile = OpenFile.openToRead(filename);
		outfile = OpenFile.openToWrite("Test.java");
		i = 0;
	}

	public static void main(String [] args)
	{
		Allmanize run = new Allmanize(args[0]);
		run.setString();
		run.allmanize();
	}

	/**
	* Removes all spaces and tabs, turning the file into
	* one large String
	*/
	public void setString()
	{
		while(infile.hasNextLine())
		{
			String temp = infile.nextLine();
			myFile += temp;
		}
		for(int i = 0; i < myFile.length(); i++)
		{
			if(myFile.charAt(i) == '\n' || myFile.charAt(i) == '\t')
			{
				myFile = myFile.substring(0,i) + myFile.substring(i+1);
				i--;
			}
		}
	}

	/**
	* Formats the String calling the corresponding methods for
	* the respective markers in the String. Also writes the formatted
	* String to a new java file called "Test.java"
	*/
	public void allmanize()
	{
		do{
			if(myFile.charAt(i) == '{')
			{
				formatFrontBracket();
			}
			else if(myFile.charAt(i) == ';')
			{
				formatSemicolon();
			}
			else if (myFile.charAt(i) == '}')
			{
				formatEndBracket();
			}
			else if(myFile.charAt(i) == '/')
			{
				formatComment();
			}
		i++;
		}while(i < myFile.length());
		System.out.print(myFile + "\n\n\n");
		outfile.print(myFile);
		outfile.flush();
		outfile.close();
	}

	/**
	* When a front bracket is recogized, a new line is added, followed by the
	* appropriate number of tabs, then a new line.
	*/
	public void formatFrontBracket()
	{
		myFile = myFile.substring(0, i) + '\n' + countTab() + '{' + '\n' + addTabs() + myFile.substring(i + 1);
		i += numberOfTabs;
	}

	/**
	* If the semicolon is not within a for loop, as well as not being
	* before ' ' and being before a end bracket, a space is added. If not, then
	* a space is added and tabs are counted.
	*/
	public void formatSemicolon()
	{
		if (!isForLoop(i))
		{
			for (int k = i + 1; k < myFile.length(); k++)
			{
				if (myFile.charAt(k) != ' ' && myFile.charAt(k) == '}')
				{
					myFile = myFile.substring(0, i + 1) + '\n' + myFile.substring(i + 1);
					k = myFile.length();
				}
				else
				{
					myFile = myFile.substring(0, i + 1) + '\n' + countTab() + myFile.substring(i + 1);
					k = myFile.length();
				}
			}
		}
	}

	/**
	* Method for recogizing comments and adding the appropriate number
	*	of tabs and new lines.
	*/
	public void formatComment()
	{
		i+=2;
		while(myFile.charAt(i) != '/' && !myFile.substring(i, i + 6).equals("import") && !myFile.substring(i, i + 6).equals("public"))
		{
			i++;
		}
		i--;
		myFile = myFile.substring(0, i + 1) + '\n' + countTab() + myFile.substring(i + 1);
	}

	/**
	* Method for recogizing end bracket and adding the appropriate number
	* of tabs and new lines.
	*/
	public void formatEndBracket()
	{
		for (int k = i + 1; k < myFile.length(); k++)
		{
			if (myFile.charAt(k) != ' ' && myFile.charAt(k) == '}')
			{
				myFile = myFile.substring(0, i) + deleteTabs() + '}' + '\n' + myFile.substring(i + 1);
				k = myFile.length();
			}
			else
			{
				myFile = myFile.substring(0, i) + deleteTabs() + '}' + '\n' + countTab() + myFile.substring(i + 1);
				k = myFile.length();
			}
		}
		i += numberOfTabs;
	}

	/**
	* Method for adding the specific number of tabs
	* @return 			Reurns the specific amount of tabs
	*/
	public String countTab()
	{
		String tab = "";
		for(int i = 0; i < numberOfTabs; i++)
		{
			tab += "\t";
		}
		return tab;
	}

	/**
	* Method for adding the specific number of tabs
	* AND adding an additional tab
	* @return 		Returns the specific amount of tabs
	*/
	public String addTabs()
	{
		String tab = "";
		numberOfTabs ++;
		for(int i = 0; i < numberOfTabs; i++)
		{
			tab += "\t";
		}
		return tab;
	}

	/**
	* Method for adding the specific number of tabs
	* AND removing an additional tab
	* @return 		Returns the specific amount of tabs
	*/
	public String deleteTabs()
	{
		String tab = "";
		numberOfTabs--;
		for(int i = 0; i < numberOfTabs; i++)
		{
			tab += "\t";
		}

		return tab;
	}

	/**
	* Method that checks if the following statement
	* in the file is a for loop, as there are
	* exceptions for the general rules.
	* @param 			the index of the current loop
	* @return 		true or false if it is a for loop or not
	*/
	public boolean isForLoop(int i)
	{
		for(int k = i-1; k > 0; k--)
		{
			if(myFile.substring(k-3,k).equals("for"))
			{
				return true;
			}
			else if(myFile.charAt(k) == '\n')
			{
				return false;
			}
		}
		return false;
	}


















}
