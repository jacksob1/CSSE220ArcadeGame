import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author jacksob1 and zlatann 
 *
 */
public class Egg {
	private int x;
	private int y;
	private int count;
	private int gravity = 3;
	private int width = 20;
	private int height = 30;
	private Enemy enemy;
	/**
	 * constructs egg
	 * @param x
	 * @param y
	 * @param enemy
	 */
	public Egg(int x, int y, Enemy enemy) {
		this.x = x;
		this.y = y;
		this.enemy = enemy;
	}
/**
 * draws eggs on screen
 * @param g
 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.ORANGE);
		g2.fillOval(this.x, this.y, width, height);
	}
	/**
	 * returns the width of egg
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * returns height of egg
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * makes the egg fall and checks if it hit a platform
	 * @param bottom
	 * @return y>bottom
	 */
	public boolean fall(int bottom) {
		this.y += this.gravity;
		return this.y > bottom;
	}
	/**
	 * returns position of x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * sets a new position for x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * checks if egg is inside box
	 * @param b
	 * @return b.intersects(x, y, width, height)
	 */
	public boolean insideBox(Rectangle b) {
		return b.intersects(x, y, width, height);
	}
	/**
	 * return y position
	 * @return t
	 */
	public int getY() {
		return y;
	}
	/**
	 * sets the position of y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * returns an enemy
	 * @return enemy
	 */
	public Enemy getEnemy() {
		return enemy;
	}
	/**
	 * sets the enemy with a different enemy
	 */
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	/**
	 * increases the counter of eggs existence
	 */
	public void increaseCount() {
		this.count++;
	}
	/**
	 * returns the count of eggs existence
	 * @return
	 */
	public int getCount() {
		return this.count;
	}
	
}
