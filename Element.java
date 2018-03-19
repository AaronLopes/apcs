package essentials;

/**
 * Element.java
 * This Element class is used as an object for every
 * singular element in the given list of elements (read from 
 * a text file in ChemList.java). every Element has 4 specific 
 * values: name, symbol, atomic number, and atomic mass. These values
 * can later be compared to another Element's values by using the 
 * given methods.
 * @author AaronLopes
 * @version 1.0
 * @since 1.15.16
 */

public class Element
{
	private String name; 
	private String symbol;
	private int	atomN;
	private double atomM;
	
	public Element(int num, String s, String n, double m)
	{
		name = n;
		symbol = s;
		atomN = num;
		atomM = m;		
	}
	
	public int compareToName(Element other)
	{
		return name.compareTo(other.name);	
	}
	
	public int compareToNum(Element other)
	{
		return atomN - other.atomN;
	}
	
	public int compareToSymbol(Element other)
	{
		return symbol.compareTo(other.symbol);
	}
	
	public int compareToSymbol(String other)
	{
		return symbol.toLowerCase().compareTo(other.toLowerCase());
	}
	
	public int compareToMass(Element other)
	{
		return (int)(atomM - other.atomM);
	}
	
	public String toStringFormat()
	{
		return String.format("%-5s %-9d %7s %18s %15.2f %4s \n","|",atomN,symbol, name, atomM, "|");
	}
	
	public String toString()
	{
		return String.format("%-9d %7s %18s %15.2f \n",atomN,symbol, name, atomM);	
	}
}