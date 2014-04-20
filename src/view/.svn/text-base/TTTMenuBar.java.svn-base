package view;

import javax.swing.*;
import controller.TTTMenuListener;

/**
 * This class creates a menu bar for the TTTFrame windows. It utilizes a TTTMenuListener
 * to handle ActionEvents from each JMenuItem in the JMenuBar (TTTMenuBar).
 * @author Theo Davis and Sacha Best
 */
@SuppressWarnings("serial")
public class TTTMenuBar extends JMenuBar
{
	/**
	 * The TTTMenuListener handles ActionEvents fired by each JMenuItem. It seemed logical
	 * to have the TTTMenuBar report to its own listener instead of packing the code into the
	 * TTTController class, even though it does violate the model-view-controller theory on
	 * a small scale.
	 */
	private TTTMenuListener menuListener;
	
	/**
	 * Creates a TTTMenuBar instance, adding three menus into it, and initializing the 
	 * TTTMenuListener object.
	 */
	public TTTMenuBar(TTTMenuListener menuListener)
	{
		this.menuListener = menuListener;
		this.add(createFileMenu());
		this.add(createAppearanceMenu());
		this.add(createGameMenu());
	}
	/**
	 * This method creates a "File" menu with the options of "New Game", "About", and "Close".
	 * It also points each JMenuItem to the TTTMenuListener instance variable menuListener
	 * and sets ActionCommands for each JMenuItem for use in the listener.
	 * @return a JMenu representing the "File" menu.
	 */
	private JMenu createFileMenu()
	{
		JMenu fileMenu = new JMenu("File");
		JMenuItem newGameAction = new JMenuItem("New Game");
		JMenuItem aboutAction = new JMenuItem("About");
		JMenuItem closeAction = new JMenuItem("Close");
		newGameAction.setActionCommand("New Game");
		aboutAction.setActionCommand("About");
		closeAction.setActionCommand("Close");
		newGameAction.addActionListener(menuListener);
		aboutAction.addActionListener(menuListener);
		closeAction.addActionListener(menuListener);
		fileMenu.add(newGameAction);
		fileMenu.addSeparator();
		fileMenu.add(aboutAction);
		fileMenu.addSeparator();
		fileMenu.add(closeAction);
		return fileMenu;
	}
	/**
	 * This method creates an "Appearance" menu with the options of "Skin 1", "Skin 2", and "Skin 3".
	 * It also points each JMenuItem to the TTTMenuListener instance variable menuListener
	 * and sets ActionCommands for each JMenuItem for use in the listener.
	 * @return a JMenu representing the "Appearance" menu.
	 */
	private JMenu createAppearanceMenu()
	{
		JMenu appearanceMenu = new JMenu("Appearance");
		JMenuItem skin1 = new JMenuItem("Blue-White");
		JMenuItem skin2 = new JMenuItem("Purple-White");
		JMenuItem skin3 = new JMenuItem("Green-White");
		JMenuItem skin4 = new JMenuItem("Gold-Black");
		JMenuItem skin5 = new JMenuItem("Purple-Black");
		JMenuItem skin6 = new JMenuItem("Green-Black");
		skin1.setActionCommand("Skin 1");
		skin2.setActionCommand("Skin 2");
		skin3.setActionCommand("Skin 3");
		skin4.setActionCommand("Skin 4");
		skin5.setActionCommand("Skin 5");
		skin6.setActionCommand("Skin 6");
		skin1.addActionListener(menuListener);
		skin2.addActionListener(menuListener);
		skin3.addActionListener(menuListener);
		skin4.addActionListener(menuListener);
		skin5.addActionListener(menuListener);
		skin6.addActionListener(menuListener);
		appearanceMenu.add(skin1);
		appearanceMenu.add(skin2);
		appearanceMenu.add(skin3);
		appearanceMenu.add(skin4);
		appearanceMenu.add(skin5);
		appearanceMenu.add(skin6);
		return appearanceMenu;
	}
	/**
	 * This method creates a "Game" menu with the options of "Set Dimensions...", "Human vs. Human", 
	 * "Human vs. Computer", and "Computer vs. Computer".
	 * It also points each JMenuItem to the TTTMenuListener instance variable menuListener
	 * and sets ActionCommands for each JMenuItem for use in the listener.
	 * @return a JMenu representing the "Game" menu.
	 */
	private JMenu createGameMenu()
	{
		JMenu gameMenu = new JMenu("Game");
		JMenuItem setBoardAction = new JMenuItem("Set Dimensions...");
		JMenuItem resetAction = new JMenuItem("Reset Board");
		JMenuItem game1 = new JMenuItem("Human vs. Human");
		JMenuItem game2 = new JMenuItem("Human vs. Computer");
		setBoardAction.setActionCommand("Set Dimensions");
		resetAction.setActionCommand("Reset");
		game1.setActionCommand("Human vs. Human");
		game2.setActionCommand("Human vs. Computer");
		setBoardAction.addActionListener(menuListener);
		resetAction.addActionListener(menuListener);
		game1.addActionListener(menuListener);
		game2.addActionListener(menuListener);
		gameMenu.add(setBoardAction);
		gameMenu.add(resetAction);
		gameMenu.addSeparator();
		gameMenu.add(game1);
		gameMenu.add(game2);
		return gameMenu;
	}
}
