import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author zlatann and jacksob1
 *
 */
public class Manual {

	public Manual() {
		/**
		 * creates a manual where users can read as to how to play the game
		 */
		JFrame manual = new JFrame("Manual");
		JTextArea controls = new JTextArea("Controls:\nUse the Arrow Keys to manuver your player around the map.\n"
				+ "To manually change each level, press the 'U' button on the keyboard to advance to the next"
				+ " level and the 'D' button on the keyboard to go back to the previous level.\n"
				+ "To open this window again press the 'M' button on the keyboard.\n"
				+ "In order to gain points you must hit each enemy and be attacking from above them.\n"
				+ " If you hit them too low you will die and respawn however you only have three lives so when those lives run out you lose.\n"
				+ "For every three points you score, your player regains a life.");
		manual.add(controls);
		manual.pack();
		manual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manual.setVisible(true);
	}

}
