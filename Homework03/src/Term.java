/**
 * Term.java : This class contains a polynomial term's coefficient and exponent and implements comparable.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Term implements Comparable
{
	private int coefficient;
	private int exponent;
	
	/**
	 * Default constructor, the term is 0
	 */
	public Term()
	{
		setCoefficient(0);
		setExponent(0);
	}
	
	/**
	 * 2-arg constructor to make a new term
	 * @param coefficient The term's coefficient
	 * @param exponent The term's exponent
	 */
	public Term(int coefficient, int exponent)
	{
		setCoefficient(coefficient);
		setExponent(exponent);
	}
	
	/**
	 * 1-arg setter for coefficient
	 * @param coefficient The term's coefficient
	 */
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	/**
	 * Getter for coefficient
	 * @return coefficient integer value
	 */
	public int getCoefficient()
	{
		return coefficient;
	}
	
	/**
	 * 1-arg setter for exponent
	 * @param exponent The term's exponent
	 */
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	/**
	 * Getter for exponent
	 * @return exponent integer value
	 */
	public int getExponent()
	{
		return exponent;
	}
	
	/**
	 * Term's data represented as a String
	 * @return term string representation
	 */
	public String toString()
	{
		return coefficient + "x^" + exponent;
	}
	
	/**
	 * Equals checks ALL instance variables are equal
	 * @param other The other term to be tested against
	 * @return whether the two terms are equal
	 */
	public boolean equals(Term other)
	{
		return (coefficient == other.getCoefficient() && exponent == other.getExponent());
	}

	/**
	 * compareTo checks that the exponent variables are equal
	 * @param other The other term to be tested against
	 * @return -1 if less than, 1 if greater than, & 0 if equal
	 */
	public int compareTo(Object other)
	{
		Term o = (Term) other;
		if (exponent < o.getExponent())
		{
			return -1;
		}
		else if (exponent > o.getExponent())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}