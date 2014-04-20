package view;

import global.Location;
import global.Skin;
import java.awt.*;
import javax.swing.*;

/**
 * This class is an extension of JFrame specifically tailored to a Tic-Tac-Toe game window.
 * It has a TTTMenuBar instance variable, as well as an array of panels representing the 
 * squares on a game board.
 * @author Theo Davis and Sacha Best
 *
 */
@SuppressWarnings("serial")
public class TTTFrame extends JFrame
{
	/**
	 * The dimensions of the game board.
	 */
	private int dimensions;
	/**
	 * The menu bar in the UI.
	 */
	private TTTMenuBar menuBar;
	/**
	 * The array of panels representing the game board onscreen.
	 */
	private TTTPanel[] panelList;
	
	/**
	 * The skin to be used to paint TTTPanels. 
	 */
	private Skin currentSkin;
	/**
	 * This constructor creates a TTTFrame object, setting the default size to 600 x 600 pixels.
	 * It also sets the default close operation, the title of the window, the Skin 
	 * of the panels, and the GridLayout of the panels on the board. Finally, 
	 * the constructor initializes the instance variables and sets the window visible to the user.
	 * @param dimensions - the dimensions of the game board.
	 * @param menuBar - the TTTMenuBar to be placed in the window.
	 */
	public TTTFrame(int dimensions, TTTMenuBar menuBar)
	{
		super();
		this.setBounds(0, 0, 600, 600);
		this.dimensions = dimensions;
		this.menuBar = menuBar;
		setJMenuBar(menuBar);
		setTitle("TicTacToe by Sacha Best and Theo Davis");
		currentSkin = new Skin("1"); //default skin
		this.panelList = createPanelList(dimensions);
		setLayout(new GridLayout(dimensions, dimensions));
		setVisible(true);
	}
	/**
	 * This method is only called in the constructor to create an array of TTTPanels,
	 * each with accurate Location data for use in the "model" by the TTTController.
	 * Each panel is created, set visible, and returned in an array.
	 * @param newDimensions - the new dimensions for when/if the board is resized.
	 * @return - an array of TTTPanels with appropriate Locations attached to them.
	 */
	private TTTPanel[] createPanelList(int newDimensions)
	{
		TTTPanel[] panelList = new TTTPanel[newDimensions * newDimensions];
		for (int c = 0; c < newDimensions * newDimensions; c++)
		{
			TTTPanel temp = (new TTTPanel((int) (c / newDimensions), c % newDimensions, currentSkin));
			add(temp);
			setVisible(true);
			panelList[c] = temp;					
		}
		return panelList;
	}
	/**
	 * This method changes the skin of every TTTPanel in the frame.
	 * @param changeTo - the Skin to be used. 
	 */
	public void changeSkin(Skin changeTo)
	{
		for (int c = 0; c < panelList.length; c++)
			panelList[c].changeSkin(changeTo);
	}
	/**
	 * This method resets the view to an empty grid.
	 * @param dimensions - the dimensions of the new board.
	 */
	public void reset(int dimensions)
	{
		getContentPane().removeAll();
		this.dimensions = dimensions;
		setLayout(new GridLayout(dimensions, dimensions));
		this.panelList = createPanelList(dimensions);
	}
	/**
	 * @return the TTTMenuBar.
	 */
	public JMenuBar getJMenuBar()
	{
		return menuBar;
	}
	/**
	 * @return the dimensions of the grid.
	 */
	public int getDimensions() 
	{
		return dimensions;
	}
	/**
	 * @return the array of TTTPanels in the UI.
	 */
	public TTTPanel[] getPanelList() 
	{
		return panelList;
	}
	/**
	 * This method returns the TTTPanel with the given Location properties. This is only
	 * used by the Computer when simulating MouseEvents.
	 * @param loc - the Location to be retrieved.
	 * @return the TTTPanel at Location loc, or null if there is not one.
	 */
	public TTTPanel getPanelAt(Location loc)
	{
		for (int count = 0; count < panelList.length; count++)
			if (panelList[count].getGridLocation().equals(loc))
					return panelList[count];
		return null;
	}
}
