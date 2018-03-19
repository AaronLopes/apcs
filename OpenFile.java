package essentials;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class OpenFile
{
	public static void main (String [] args){}
	
	public static Scanner openToRead(String fileString)
	{
		Scanner fromFile = null;
		File fileName = new File(fileString);
		try
		{
			fromFile = new Scanner(fileName);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\nSorry, but the file could not be found.\n");
			System.exit(1);
		}
		return fromFile;
	}
	
	public static PrintWriter openToWrite(String fileString)
	{
		PrintWriter outFile = null;
		try
		{
			outFile = new PrintWriter(fileString);
		}
		catch(Exception e)
		{
			System.out.println("\nSorry, but the file could not be created.\n");
			System.exit(2);
		}
		return outFile;
	}
}