package model;

import global.Location;

/**
 * This class is a base for creating any type of game that uses a grid
 * (i.e. chess, tic-tac-toe, checkers, etc.)
 * @author Sacha Best
 */
public class GridGame
{
	/**
	 * Instance variables for the rows, columns, number of total available spots,
	 * and number of occupied spots.
	 */
	private int rows, cols, capacity, currentAmount;
	/**
	 * The grid itself (a 2D array of Integers). 
	 */
	protected Integer[][] grid;
	
	/**
	 * Creates a new GridGame object. 
	 * @param rows - the number of rows in the grid
	 * @param cols - the number of columns in the grid
	 */
	public GridGame(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		this.capacity = rows * cols;
		this.currentAmount = 0;
		grid = new Integer[rows][cols];
	}
	/**
	 * @return the number of rows in the grid.
	 */
	public int getRows()
	{
		return rows;
	}
	/**
	 * @return - the number of columns in the grid.
	 */
	public int getCols()
	{
		return cols;
	}
	/**
	 * Checks if the Location loc is within the bounds of the grid.
	 * i.e. 0 =< row < rows and 0 <= col < columns.
	 * @param loc - the Location to be checked
	 * @return - true if loc is in bounds, false otherwise.
	 */
	private boolean inBounds(Location loc)
	{
		return (loc.getRow() >= 0 && loc.getRow() < rows && loc.getCol() >= 0 && loc.getCol() < cols);
	}
	/**
	 * Calls inBounds to check if the Location loc is within the grid.
	 * If it is not, an ArrayIndexOutOfBoundsException is thrown.
	 * Then returns the Integer at the given Location loc.
	 * @param loc - the Location to be checked.
	 * @return the object at the given Location loc.
	 */
	public Integer getObjectAt(Location loc)
	{
		if (!inBounds(loc))
			throw new ArrayIndexOutOfBoundsException("You entered values not in the array");
		return grid[loc.getRow()][loc.getCol()];
	}
	/**
	 * Adds the given Integer to the grid at Location loc.
	 * @param addedObject - the object added to the grid.
	 * @param loc - the Location for the object to be added.
	 * @return a String representing the three possible cases of
	 * adding an object: a full board, a move out of bounds, and
	 * a normal add.
	 */
	public String add(Integer addedObject, Location loc)
	{
		if (!inBounds(loc))
			return "Out of Bounds";
		grid[loc.getRow()][loc.getCol()] = addedObject;
		currentAmount++;
		if (currentAmount >= capacity)
			return "Grid full";
		return "Added";
	}
	/**
	 * This method returns a String representation of the grid.
	 * @return a String representing the grid.
	 */
	public String toString()
	{
		String returned = "";
		for (int i = 0; i < rows; i++)
		{
			for (int i2 = 0; i2 < cols; i2++)
				returned += grid[i][i2] + " ";
			returned += "\n";
		}
		return returned;
	}
}
