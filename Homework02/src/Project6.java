//import java.util.Scanner;

/**
 * Project6.java : Computes the area and perimeter of selected figures, with updates.
 * 
 * @author Spencer Thompson & Koffman and Wolfgang
 * @version 2.0
 *
 */

public class Project6
{
	/**
	 * The main program Algorithm
	 * 1. It asks the user for the type of figure.
	 * 2. It asks the user for the characteristics of that figure.
	 * 3. It computes the perimeter.
	 * 4. It computes the area.
	 * 5. It displays the result
	 * 
	 * @param args command line arguments (unused)
	 */
	/*
	public static void main(String[] args)
	{
		Shape myShape;
		double perimeter;
		double area;
		myShape = getShape(); //Ask for figure type
		myShape.readShapeData(); //Read the shape data
		perimeter = myShape.computePerimeter(); //Compute perimeter
		area = myShape.computeArea();           //Compute area
		displayResult(myShape, perimeter, area);//Display the result
		System.exit(0);							//Edit the program
	}
	*/
	/** Ask the user for the type of figure
	 * @return An instance of the selected shape
	*/
	/*
	public static Shape getShape()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter C for Circle");
		System.out.println("Enter R for Rectangle");
		System.out.println("Enter T for Right Triangle");
		System.out.println("Enter S for Square");
		System.out.println("Enter E for Equilateral Triangle");
		String figType = in.next();
		if (figType.equalsIgnoreCase("c"))
		{
			return new Circle();
		}
		else if (figType.equalsIgnoreCase("r"))
		{
			return new Rectangle();
		}
		else if (figType.equalsIgnoreCase("t"))
		{
			return new RtTriangle();
		}
		else if (figType.equalsIgnoreCase("s"))
		{
			return new Square();
		}
		else if (figType.equalsIgnoreCase("e"))
		{
			return new EqualTriangle();
		}
		else
		{
			return null;
		}
	}
	*/
	
	/**Display the result of the computation
	 @param myShape The selected figure
	 @param perim The perimeter of the figure
	 @param area The area of the figure
	*/
	/*
	private static void displayResult(Shape myShape, double perim, double area)
	{
		System.out.println(myShape);
		System.out.printf("The perimeter is %.2f%nThe area is %.2f%n", perim, area);
	}
	*/
}