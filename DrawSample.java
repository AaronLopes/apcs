package essentials;

import java.awt.*;

public class DrawSample
{
	public static void main(String [] args)
	{
		double [] x = {0, 0.5, 1};
		double [] y = {0.1, 0.1 + Math.sqrt(3)/2, 0.1};
		StdDraw.polygon(x, y);

	}
}
