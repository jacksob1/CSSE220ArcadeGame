import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author zlatann and jacksob1
 *
 */
public class MyControlListener implements KeyListener {

	private Level level;
	private Player player;
	private GameComponent comp;
	private Timer timer;
	private JFrame screen;
	private int vX = 13;
	private int vY = 13;

	/**
	 * constructs myControlListener
	 * 
	 * @param gameScreen
	 * @param comp
	 * @param level
	 * @param timer
	 */
	public MyControlListener(JFrame gameScreen, GameComponent comp, Level level, Timer timer) {
		this.level = level;
		this.player = level.getPlayer();
		this.comp = comp;
		this.timer = timer;
		this.screen = gameScreen;
	}

	/**
	 * different key presses for changing level, movement of player and manual pop
	 * up
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_U) {
			if (level.getFileChoice() < 3) {
				level.setFileChoice(level.getFileChoice() + 1);
			}
			level.setEnemy();
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (level.getFileChoice() > 1) {
				level.setFileChoice(level.getFileChoice() - 1);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setvY(-vY);
			player.move();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setvY(vY);
			player.move();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setvX(vX);
			player.move();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setvX(-vX);
			player.move();
		}

		if (e.getKeyCode() == KeyEvent.VK_M) {
			new Manual();
		}

		comp.repaint();
	}

	/**
	 * when keys are released it sets the velocity to 0
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setvY(0);
			player.move();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setvY(0);
			player.move();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setvX(0);
			player.move();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setvX(0);
			player.move();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
