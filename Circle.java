package essentials;

public class Circle {
	
	public static void main(String [] args)
	{
		double x =  1/3;
		double y =  1/3;
		double radius = 1/6;


		StdDraw.filledCircle(x, y, radius);

		int n = 6;
		if(args.length > 0)
		{
			n = Integer.parseInt(args[0]);
		}
		double xcenter = 0.5, ycenter = Math.sqrt(3)/8 + 0.1;
		sierpinski(n, radius, xcenter, ycenter);
		
	}
	
	
	public static void sierpinski(int n, double radius, double xc, double yc)
	{
		if(n==0)
			return;
		
		sierpinski(n-1, radius/2, xc - 0.5, yc + 0.5);
		
	}
	
	public static void drawCircle(double radius, double xc, double yc)
	{
		
		
	}

}
