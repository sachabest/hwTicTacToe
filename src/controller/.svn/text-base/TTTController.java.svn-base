package controller;

import global.*;

import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import view.*;
import model.*;

/**
 * The main class that handles all events in any Tic Tac Toe game.
 * TTTController handles events queued by users in the "view", processes
 * them, and transmits their changes into the "model" TTTBoard. TTTController
 * listens to all created TTTPanels in the "view" for clicks by a user, and
 * starts the rest of the process.
 * @author Theo Davis and Sacha Best
 */
public class TTTController implements MouseListener
{
	/**
	 * These static ints represent the two possible game types. 
	 */
	public static final int HUMAN_HUMAN = 0, HUMAN_COMP = 1;
	/**
	 * The instance of TTTBoard used to represent the current game of Tic-Tac-Toe.
	 */
	private TTTBoard model;
	/**
	 * The instance of TTTFrame shown in the UI and based on the TTTBoard model.
	 */
	private TTTFrame view;
	/**
	 * This int represents the current game type as specified by the static final
	 * variables. 
	 */
	private int gameType;
	
	/**
	 * Constructor for a new TTTController which is used to start a new game of Tic-Tac-Toe.
	 * This constructor initializes the above instance variables and adds listeners to each
	 * UI object.
	 * @param dimensions - the dimensions of the board to be created. Defaults to 3.
	 */
	public TTTController(int dimensions)
	{
		gameType = HUMAN_HUMAN; //default
		model = new TTTBoard(dimensions);
		view = new TTTFrame(dimensions, new TTTMenuBar(new TTTMenuListener(this)));
		JOptionPane.showMessageDialog(view, "Welcome to Tic-Tac-Toe by Sacha Best and Theo Davis!\n" +
				"The game starts as a 3x3 grid but can be changed to NxN.\n" +
				"6 Skins are avaliable in the skins menu and sounds play when " +
				"objects are clicked.\nA semi-intelligent computer player is included.\n" +
				"Please refer to the /doc/ folder (javadoc) " +
				"for more information. Enjoy!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		addMouseListeners();
	}
	/**
	 * See workhorse constructor.
	 */
	public TTTController()
	{
		this(3);
	}
	/**
	 * This method adds the TTTController class as a MouseListener for every TTTPanel
	 */
	private void addMouseListeners()
	{
		TTTPanel[] panelList = view.getPanelList();
		for (int c = 0; c < panelList.length; c++)
			panelList[c].addMouseListener(this);
	}
	/**
	 * The main method used to start a game of TicTacToe. Calls newGame() from a static context
	 * so that a main method recognizable by applets can still exist while creating a non-static
	 * TTTController object.
	 * @param args - the default java nomenclature for a main() method. Serves no purpose.
	 */
	public static void main(String[] args)
	{
		newGame(3); //default
	}
	/**
	 * The method called by main() to create a new Tic-Tac-Toe game. This method is used when
	 * the game is initially run and also when the menuBar is used to select new game.
	 * @param dimensions - the dimensions of the board to be created.
	 */
	public static void newGame(int dimensions)
	{
		new TTTController(dimensions);
	}
	/**
	 * This method resets the board. If dimensions = 0, then the game is
	 * created using the current dimensions.
	 * @param dimensions - the dimensions to initialize the board with.
	 */
	public void reset(int dimensions)
	{
		if (dimensions == 0)
		{
			view.reset(view.getDimensions());
			model = new TTTBoard(view.getDimensions());
		}
		else
		{
			view.reset(dimensions);
			model = new TTTBoard(dimensions);
		}
		addMouseListeners();	
	}
	/**
	 * This method changes the Skin of the view.
	 * @param changeTo - the new Skin.
	 */
	public void changeSkin(Skin changeTo)
	{
		view.changeSkin(changeTo);
	}
	/**
	 * This method plays a sound.
	 * @param sound - the sound to be played. 
	 */
	private void playSound(String sound)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sounds/" + sound));
	        clip.open(inputStream);
	        clip.start();
		}
		catch (Exception ex) {}
	}
	/**
	 * This method resets the board and changes the game type to the type specified
	 * based on the static final variables. 
	 * @param changeTo - the int representing the game to change to. 
	 */
	public void changeGameType(int changeTo)
	{
		this.gameType = changeTo;
		reset(0);
	}
	/**
	 * This method represents a Computer's decision. The Computer "plays" by creating
	 * simulated MouseEvents to submit using the mouseClicked() method. This usage conserves
	 * code and reuses already created code to efficiently handle a Computer's moves. We 
	 * create a MouseEvent with only the relevant information (i.e. the TTTPanel clicked).
	 */
	public void computerMove()
	{
		TTTPanel movedTo = view.getPanelAt(model.computerMove());
		MouseEvent e = new MouseEvent(movedTo, 0, 0, 0, 0, 0, 0, false);
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException e1) {}
		mouseClicked(e); 
	}
	/**
	 * This method handles a click on a TTTPanel object. It interprets the
	 * object's relative Location, and sends the information to the TTTBoard
	 * for decoding. The TTTBoard then returns a 2 String String[], with the
	 * first String representing the player that clicked, and the second String
	 * representing the result of the click. There are 4 possible cases: a winning
	 * move, a non-winning move, a click on an already occupied location, and a
	 * "cat's game", or a full grid. The MouseEvent e can also be simulated by a 
	 * Computer if there is a Computer playing. This method also determines which
	 * sound should be played by the playSound() method.
	 * @param e - the MouseEvent fired by the TTTPanel clicked or the computer.
	 */
	public void mouseClicked(MouseEvent e)
	{
		TTTPanel clicked = (TTTPanel) e.getSource();
		Location movedTo = clicked.getGridLocation();
		String[] modelInfo = model.add(movedTo);
		int player = Integer.parseInt(modelInfo[0]);
		if (modelInfo[1].equalsIgnoreCase("Occupied"))
		{
			playSound("error.wav");
			JOptionPane.showMessageDialog(view, "That space is occupied.");
			return;
		}
		clicked.mark(player);
		if (modelInfo[1].equalsIgnoreCase("Grid full"))
		{
			playSound("error.wav");
			int answer = JOptionPane.showConfirmDialog(view, "Cat's game. Would you like to start another?");
			if (answer == JOptionPane.YES_OPTION)
				reset(0);
			else if (answer == JOptionPane.NO_OPTION)
				System.exit(0);
			return;
		}
		else if (modelInfo[1].equalsIgnoreCase("Win"))
		{
			String winner = "";
			if (player == 0)
				winner = "X";
			else
				winner = "O";
			playSound("win.wav");
			int answer = JOptionPane.showConfirmDialog(view, winner + " wins! Would you like to play another game?");
			if (answer == JOptionPane.YES_OPTION)
				reset(0);
			else if (answer == JOptionPane.NO_OPTION)
				System.exit(0);
			return;
		}
		playSound("click.wav");
		if (gameType == HUMAN_COMP && player == 0)
			computerMove();
	}
	/**
	 * This method only exists to fulfill the requirements of the MouseListener interface.
	 */
	public void mouseEntered(MouseEvent e)
	{
		return;
	}
	/**
	 * This method only exists to fulfill the requirements of the MouseListener interface.
	 */
	public void mouseExited(MouseEvent e)
	{
		return;
	}
	/**
	 * This method only exists to fulfill the requirements of the MouseListener interface.
	 */
	public void mousePressed(MouseEvent e)
	{
		return;
	}
	/**
	 * This method only exists to fulfill the requirements of the MouseListener interface.
	 */
	public void mouseReleased(MouseEvent e)
	{
		return;
	}
	/**
	 * This method returns the TTTFrame view.
	 * @return - the TTTFrame representing the view.
	 */
	public TTTFrame getView()
	{
		return view;
	}
	/**
	 * This method returns the TTTBoard model.
	 * @return - the TTTBoard representing the view.
	 */
	public TTTBoard getModel()
	{
		return model;
	}
}
