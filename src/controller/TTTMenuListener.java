package controller;

import global.Skin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 * This class handles ActionEvents from the TTTMenuBar class. See
 * below method for more details.
 * @author Theo Davis and Sacha Best
 */
public class TTTMenuListener implements ActionListener
{
	private TTTController controller;
	/**
	 * This constructor initializes the controller instance variable.
	 * @param controller - the TTTController for the instance variable to be initialized as.
	 */
	public TTTMenuListener(TTTController controller)
	{
		this.controller = controller;
	}
	/**
	 * This method handles ActionEvents fired by the TTTMenuBar class.
	 * It interprets the ActionEvent using the getActionCommand() method, 
	 * which returns a string attached to each ActionEvent that differentiates
	 * the class in TTTMenuBar that originally fired it. For example, the
	 * ActionCommand "About" signifies that the "About" JMenuItem in the 
	 * TTTMenuBar class fired the event. From there, the method handles the
	 * respective events.
	 * @param e - the ActionEvent received
	 */
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("New Game"))
			TTTController.main(null);
		else if (command.equalsIgnoreCase("About"))
			JOptionPane.showMessageDialog(controller.getView(), "Tic-Tac-Toe\nBy Theo Davis and Sacha Best\n" +
					"With artwork from Avalon Nuovo and Sacha Best\nAnd some help from Mr. Hazard");
		else if (command.equalsIgnoreCase("Close"))
			System.exit(0);
		else if (command.equalsIgnoreCase("Set Dimensions"))
		{
			String toShow = "WARNING: This will reset the board\nPlease enter dimensions:";
			String result = JOptionPane.showInputDialog(controller.getView(), toShow, "Dimensions", JOptionPane.INFORMATION_MESSAGE);
			int newDimensions = 0;
			try
			{
				newDimensions = Integer.parseInt(result);
			}
			catch (NumberFormatException ex)
			{
				toShow = "You did not enter a number.";
				result = JOptionPane.showInputDialog(controller.getView(), toShow, "Dimensions", JOptionPane.WARNING_MESSAGE);
			}
			newDimensions = Integer.parseInt(result);
			controller.reset(newDimensions);
		}
		else if (command.equalsIgnoreCase("Reset"))
		{
			String toShow = "WARNING: This will reset the board!\nAre you sure you want to continue?";
			int answer = JOptionPane.showConfirmDialog(controller.getView(), toShow, "Warning", JOptionPane.WARNING_MESSAGE);
			if (answer == JOptionPane.YES_OPTION)
				controller.reset(0);
		}
		else if (command.equals("Skin 1"))
			controller.changeSkin(new Skin("1"));
		else if (command.equals("Skin 2"))
			controller.changeSkin(new Skin("2"));
		else if (command.equals("Skin 3"))
			controller.changeSkin(new Skin("3"));
		else if (command.equals("Skin 4"))
			controller.changeSkin(new Skin("4"));
		else if (command.equals("Skin 5"))
			controller.changeSkin(new Skin("5"));
		else if (command.equals("Skin 6"))
			controller.changeSkin(new Skin("6"));
		else if (command.equals("Human vs. Human"))
		{
			String toShow = "WARNING: This will reset the board!\nAre you sure you want to continue?";
			int answer = JOptionPane.showConfirmDialog(controller.getView(), toShow, "Warning", JOptionPane.WARNING_MESSAGE);
			if (answer == JOptionPane.YES_OPTION)
				controller.changeGameType(TTTController.HUMAN_HUMAN);
		}
		else if (command.equals("Human vs. Computer"))
		{
			String toShow = "WARNING: This will reset the board!\nAre you sure you want to continue?";
			int answer = JOptionPane.showConfirmDialog(controller.getView(), toShow, "Warning", JOptionPane.WARNING_MESSAGE);
			if (answer == JOptionPane.YES_OPTION)
				controller.changeGameType(TTTController.HUMAN_COMP);
		}

	}
}
