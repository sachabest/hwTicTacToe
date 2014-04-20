package view;

import global.Location;
import global.Skin;
import java.awt.*;
import javax.swing.*;

/**
 * This class represents one square in a Tic-Tac-Toe game board.
 * It extends JPanel, and also is accessible as a Location object when
 * referred to in the "model" section.
 * @author Theo Davis and Sacha Best
 */
@SuppressWarnings("serial")
public class TTTPanel extends JPanel
{
	/**
	 * The row and column for creation of a Location object corresponding to
	 * each individual TTTPanel in the TTTFrame.
	 */
	@SuppressWarnings("unused")
	private int row, col;
	/**
	 * The Location corresponding to each TTTPanel in reference to the rest of
	 * the panels in the TTTFrame. Created based upon row and col.
	 */
	private Location gridLocation;
	
	/**
	 * The Skin to be used on this TTTPanel. 
	 */
	private Skin skin;
	
	/**
	 * The current Image displayed on the TTTPanel. 
	 */
	private Image currentImage;
	
	/**
	 * An int representing which image of the skin should be displayed on
	 * this TTTPanel, based on whose turn it is. 
	 */
	private int player;

	/**
	 * Creates a new TTTPanel with the given row and column. Sets it visible
	 * on the screen, and sets the initial size to 500 x 500 pixels. The panel
	 * will resize as the window it resides in resizes. This constructor also 
	 * attaches an appropriate Location object to each TTTPanel created. In 
	 * addition, the player variable is initialized to -1 before being marked. 
	 * Finally, the Skin is set, and the color of the border surrounding the 
	 * panel is adapted to fit the Skin's color. 
	 * @param row - the row 
	 * @param col - the column
	 * @param skin - the Skin to be used. 
	 */
	public TTTPanel(int row, int col, Skin skin)
	{
		this.setSize(500, 500);
		this.row = row;
		this.col = col;
		this.gridLocation = new Location(row, col);
		this.player = -1;
		this.skin = skin;
		this.currentImage = skin.getBackground();
		Color borderColor = null;
		if (skin.isDark())
			borderColor = Color.white;
		else
			borderColor = Color.black;
		this.setBorder(BorderFactory.createLineBorder(borderColor));
		setVisible(true);
	}
	/**
	 * @return the relative Location in the grid of TTTPanels in TTTFrame.
	 */
	public Location getGridLocation()
	{
		return gridLocation;
	}
	/**
	 * This method changes the Skin of the TTTPanel and repaints it as necessary.
	 * @param changeTo - the new Skin to be used. 
	 */
	public void changeSkin(Skin changeTo)
	{
		skin = changeTo;
		if (player != -1)
			mark(player);
		else
			currentImage = skin.getBackground();
		Color borderColor = null;
		if (skin.isDark())
			borderColor = Color.white;
		else
			borderColor = Color.black;
		this.setBorder(BorderFactory.createLineBorder(borderColor));
		
	}
	/**
	 * This method marks a player's move on this TTTPanel, changing the
	 * Image it displays from the background color to the image representing
	 * the player that moved. 
	 * @param player - the player that moved. 
	 */
	public void mark(int player)
	{
		this.player = player;
		if (player == 0)
			currentImage = skin.getX();
		else
			currentImage = skin.getO();
		repaint();
	}
	/**
	 * This method overrides the superclass method to paint the currentImage instance
	 * variable on the TTTPanel. 
	 */
	public void paintComponent(Graphics g)
	{
		Dimension d = this.getSize();
		g.drawImage(currentImage, 0, 0, (int) d.getWidth(), (int) d.getHeight(), this);
	}
}

		
