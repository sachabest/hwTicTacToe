package model;

import java.util.ArrayList;

import global.Location;

/**
 * This class represents the model of the Tic Tac Toe board. It extends
 * the GridGame class using Integers to represent whether player 1 or
 * player 2 is moving.
 * @author Theo Davis and Sacha Best
 */
public class TTTBoard extends GridGame
{
	private int player;
	/**
	 * Constructs a new TTTBoard with the given dimensions.
	 * @param dimensions - the dimensions of the board to be used.
	 */
	public TTTBoard(int dimensions)
	{
		super(dimensions, dimensions);
		player = 0;
	}
	/**
	 * This method adds an Integer representing a player's move into the grid.
	 * It first checks if the Location is occupied, knowing for a fact that the
	 * Location itself is valid in the grid because the Location objects held in
	 * the model and view are mirrored. The method then checks if the grid is full by calling
	 * the superclass add method. Finally, if the move results in a win for either player, 
	 * the method returns "win", or a normal "added" otherwise. 
	 * @param loc - the Location (represented in the view by a JPanel) clicked
	 * @return - a String[] holding the player that moved in the first index and
	 * the result of the move in the second index.
	 */
	public String[] add(Location loc)
	{
		String[] returned = new String[2];
		returned[0] = Integer.toString(player);
		if (isOccupied(loc))
		{
			returned[1] = "Occupied";
			return returned;
		}
		String superResult = super.add(player, loc);
		if (checkWin(player, loc))
			returned[1] = "Win";
		else if (superResult.equalsIgnoreCase("Grid full"))
			returned[1] = superResult;
		else 
			returned[1] = "Added";
		player++;
		player = player % 2;
		return returned;
	}
	/** 
	 * This method checks the four possible ways to win a game of Tic Tac Toe. If
	 * any of them result in a win, the method returns true.
	 * @param playerMove - the Integer representing a player's move (0 or 1)
	 * @param loc - the Location (represented in the view by a JPanel) clicked
	 * @return - true if the move results in a win for the player, false otherwise
	 */
	private boolean checkWin(Integer playerMove, Location loc)
	{
		boolean isWinAcross = true, isWinDown = true, isWinDiag1 = true, isWinDiag2 = true;
		for (int col = 0; col < super.getRows() && isWinAcross; col++) //ends loop after isWinAcross is true
			if (grid[loc.getRow()][col] == null || !grid[loc.getRow()][col].equals(playerMove))
				isWinAcross = false;
		for (int row = 0; row < super.getCols() && isWinDown; row++) //ends loop after isWinDown is true
			if (grid[row][loc.getCol()] == null || !grid[row][loc.getCol()].equals(playerMove))
				isWinDown = false;
		for (int diagonal = 0; diagonal < super.getCols() && isWinDiag1; diagonal++) //ends loop after isWinDiag1 is true
			if (grid[diagonal][diagonal] == null || !grid[diagonal][diagonal].equals(playerMove))
				isWinDiag1 = false;
		for (int diagonal2 = 0; diagonal2 < super.getCols() && isWinDiag2; diagonal2++) //ends loop after isWinDiag2 is true
			if (grid[getCols() - diagonal2 - 1][diagonal2] == null || !grid[getCols() - diagonal2 - 1][diagonal2].equals(playerMove))
				isWinDiag2 = false;
		return isWinAcross || isWinDown || isWinDiag1 || isWinDiag2;
	}
	/**
	 * This method is the Computer's "brain" for making moves. It first finds all
	 * possible move locations (unoccupied, in bounds), then moves to any one that
	 * causes a winning board. If there is no winning option, it moves randomly. 
	 * @return - the Location to be moved to.
	 */
	public Location computerMove()
	{
		ArrayList<Location> possibleLocs = new ArrayList<Location>();
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				Location temp = new Location(row, col);
				if (!isOccupied(temp))
					possibleLocs.add(temp);
			}
		}
		for (int count = 0; count < possibleLocs.size(); count++)
		{
			if (checkWin(1, possibleLocs.get(count)))
				return possibleLocs.get(count);
			else if (checkWin(0, possibleLocs.get(count)))
				return possibleLocs.get(count);
		}
		return possibleLocs.get((int) (Math.random() * possibleLocs.size()));
	}
	/**
	 * This method determines if a space on the grid is occupied. 
	 * @param loc - the space to be checked. 
	 * @return - true if the space is occupied, false otherwise. 
	 */
	private boolean isOccupied(Location loc)
	{
		return grid[loc.getRow()][loc.getCol()] != null;
	}
}
