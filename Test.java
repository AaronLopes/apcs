package essentials;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		String[] fishy = {"one","fish","two","fish","red","fish","blue","fish"};
		for(int i = 0; i < fishy.length;i++)
		{
			test.add(fishy[i + 1]);
		}
		System.out.println("\n\n" + test + "\n\n" );

	}

}
