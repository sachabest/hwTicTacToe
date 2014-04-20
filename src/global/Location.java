package global;

/**
 * This class holds two ints (x and y) that represent coordinates in a
 * plane. (0, 0) is the far upper left corner of any GridGame<E> board.
 * @author Theo Davis and Sacha Best
 */
public class Location
{
	/**
	 * The ints representing the row and column of the 
	 * Location object.
	 */
	private int row, col;
	
	/**
	 * Creates a new Location object.
	 * @param row - the row.
	 * @param col - the column.
	 */
	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	/**
	 * @return the row.
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * @return the column.
	 */
	public int getCol()
	{
		return col;
	}
	/**
	 * Determines whether or not two Location objects are equal by comparing
	 * their row and column values
	 * @param other - the other Location
	 */
	public boolean equals(Object other)
	{
		if (!(other instanceof Location))
			return false;
		else
		{
			Location compare = (Location) other;
			return getRow() == compare.getRow() && getCol() == compare.getCol();
		}
	}
}
