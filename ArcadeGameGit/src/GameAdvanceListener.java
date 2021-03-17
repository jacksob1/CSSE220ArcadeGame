import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


/**
 * @author jacksob1 and zlatann
 *
 */
public class GameAdvanceListener implements ActionListener {

	private GameComponent comp;

	/**
	 * constructs GameAdvancedListener
	 */
	public GameAdvanceListener(GameComponent comp) {
		this.comp = comp;
	}

	/**
	 * increases the time by one
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
	}

	/**
	 * redraws the screen in which the states of all the components are updated
	 */
	public void advanceOneTick() {
		this.comp.updateState();
		this.comp.drawScreen();
	}

}
