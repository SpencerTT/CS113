import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project02.java : This program adds two polynomials together.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Project02
{
	/**
	 * Driver for Project02
	 * 
	 * Algorithm:
	 * 1. Instantiate and fill the two polynomial ArrayLists and Iterators
	 * 2. Instantiate the addition polynomial ArrayList and get the first two terms
	 * 3. While at least one term is not equal to t0, (a (0, 0) term):
	 * 	a) Compare t1 and t2 using compareTo
	 * 		If t1 < t2, add t2 to p3 and check if i2.hasNext()
	 * 			If i2.hasNext(), then set t2 to i2.next()
	 * 			Else set t2 to t0
	 * 		If t1 > t2, add t1 to p3 and check if i1.hasNext()
	 * 			If i1.hasNext(), then set t1 to i1.next()
	 * 			Else set t1 to t0
	 * 		If t1 == t2, add a new term with the sum of their coefficients and same exponent to p3
	 * 			Then try to iterate through both i1 and i2 as explained above
	 * 5. Display the results to the user.
	 * 
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		//Instantiate and fill the ArrayLists and Iterators
		ArrayList<Term> p1 = new ArrayList<Term>();
		p1.add(new Term(3, 4));
		p1.add(new Term(2, 2));
		p1.add(new Term(3, 1));
		p1.add(new Term(7, 0));
		Iterator<Term> i1 = p1.iterator();
		
		ArrayList<Term> p2 = new ArrayList<Term>();
		p2.add(new Term(2, 3));
		p2.add(new Term(4, 1));
		p2.add(new Term(5, 0));
		Iterator<Term> i2 = p2.iterator();
		
		//Instantiate the addition polynomial ArrayList and get the first two terms
		ArrayList<Term> p3 = new ArrayList<Term>();
		Term t1 = i1.next();
		Term t2 = i2.next();
		Term t0 = new Term();
		
		while (!t1.equals(t0) && !t2.equals(t0))
		{
			//Term t1 has lower exponent
			if (t1.compareTo(t2) == -1)
			{
				p3.add(t2);
				if (i2.hasNext())
				{
					t2 = i2.next();
				}
				else
				{
					t2 = t0;
				}
			}
			//Term t1 has higher exponent
			else if (t1.compareTo(t2) == 1)
			{
				p3.add(t1);
				if (i1.hasNext())
				{
					t1 = i1.next();
				}
				else
				{
					t1 = t0;
				}
			}
			//Terms have same exponent
			else
			{
				p3.add(new Term(t1.getCoefficient() + t2.getCoefficient(), t1.getExponent()));
				if (i1.hasNext())
				{
					t1 = i1.next();
				}
				else
				{
					t1 = t0;
				}
				if (i2.hasNext())
				{
					t2 = i2.next();
				}
				else
				{
					t2 = t0;
				}
			}
		}
		//Output the results.
		for (Term t:p3)
		{
			System.out.print(t + " + ");
		}
		System.out.print("0"); //Something to close out the extra " + "
	}
}