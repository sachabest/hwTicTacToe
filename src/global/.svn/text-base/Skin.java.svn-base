package global;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * The Skin class represents a skin used to represent two players in a game.
 * It is tailored to import files stored in the project filesystem into Java-
 * readable BufferedImage objects. The class is also tailored to set established
 * values for a white and black background. This is helpful in changing the color
 * of a border depending on the color of the object it surrounds.
 * @author Theo Davis and Sacha Best
 */
public class Skin
{
	/**
	 * BufferedImages representing an x, an o, and an empty square.
	 */
	private BufferedImage x, o, background;
	/**
	 * A boolean representing whether or not the skin has a dark background.
	 */
	private boolean dark;
	
	/**
	 * Two Color objects representing a black and a white background. The given standards
	 * in the Color API do not reflect different monitor settings for color,
	 * these two objects do. 
	 */
	public static final Color WHITE_BACK, BLACK_BACK;
	
	/**
	 * This is a very complex way to solve an inherent Java issue. Because the
	 * ImageIO.read() method throws an IOException, it is impossible to create
	 * the two static final Color objects in one line. The static constructor
	 * handles the possible exception and creates two established values for 
	 * black and white backgrounds, respectively.
	 */
	static
	{
		Color temp1 = null, temp2 = null;
		try
		{
			temp1 = new Color(((BufferedImage) ImageIO.read(new File("skins/1/blank.jpg"))).getRGB(0, 0));
			temp2 = new Color(((BufferedImage) ImageIO.read(new File("skins/4/blank.jpg"))).getRGB(0, 0));
		}
		catch (IOException e) {}
		WHITE_BACK = temp1;
		BLACK_BACK = temp2;
	}
	
	/**
	 * This constructor makes a new Skin object by reading three images stored in the 
	 * project filesystem. It takes a String representing the number of the skin to be 
	 * chosen and reads the three files in that folder. The constructor then decides
	 * whether or not the color has a dark background, and stores a boolean representing
	 * that decision. 
	 * @param number - the number of the skin to be created.
	 */
	public Skin(String number)
	{
		try
		{
			this.x = ImageIO.read(new File("skins/" + number + "/X.jpg"));
			this.o = ImageIO.read(new File("skins/" + number + "/O.jpg"));
			this.background = ImageIO.read(new File("skins/" + number + "/blank.jpg"));
		}
		catch (IOException e) {}
		if (new Color(background.getRGB(0, 0)).equals(BLACK_BACK))
			dark = true;
		else
			dark = false;
	}
	
	/**
	 * @return - the image representing the X marking.
	 */
	public Image getX()
	{
		return x;
	}
	/**
	 * @return - the image representing the O marking.
	 */
	public Image getO()
	{
		return o;
	}
	/**
	 * @return - the image representing no marking.
	 */
	public Image getBackground()
	{
		return background;
	}
	/**
	 * @return - a boolean representing whether or not the Skin has a dark background.
	 */
	public boolean isDark()
	{
		return dark;
	}
}
