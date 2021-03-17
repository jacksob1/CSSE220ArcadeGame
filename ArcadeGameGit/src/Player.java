import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * @author zlatann and jacksob1
 *
 */
public class Player {

	private int originalX;
	private int originalY;
	private int x;
	private int y;
	private int width;
	private int height;
	private double gravity = 1;
	private int lives;
	private int vX;
	private int vY;

	/**
	 * constructs player
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Player(int x, int y, int width, int height) {
		super();
		this.originalX = x;
		this.originalY = y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.lives = 3;
		this.vX = 0;
		this.vY = 0;
	}

	/**
	 * returns velocity in x direction
	 * 
	 * @return vX
	 */
	public int getvX() {
		return vX;
	}

	/**
	 * sets the x velocity
	 * 
	 * @param vX
	 */
	public void setvX(int vX) {
		this.vX = vX;
	}

	/**
	 * returns velocity in y direction
	 * 
	 * @return vY
	 */
	public int getvY() {
		return vY;
	}

	/**
	 * sets the y velocity
	 * 
	 * @param vY
	 */
	public void setvY(int vY) {
		this.vY = vY;
	}

	/**
	 * makes the player move
	 */
	public void move() {
		this.y += vY;
		this.x += vX;
	}

	/**
	 * draws on screen
	 * 
	 * @param g
	 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
		g2.fillRect(x, y, width, height);
	}

	/**
	 * returns the x position
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the x position
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * gets the y position
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets the y position
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * returns the number of lives the player has
	 * 
	 * @return lives
	 */
	public int getLives() {
		return this.lives;
	}

	/**
	 * makes the player fall and check if he hit a platform
	 * 
	 * @param bottom
	 * @return this.y>bottom
	 */
	public boolean fall(int bottom) {
		this.y += this.gravity;
		return this.y > bottom;
	}

	/**
	 * checks the intersection between a platform and player
	 * 
	 * @param b
	 * @return b.intersects(x, y, width, height)
	 */
	public boolean insideBox(Rectangle b) {
		return b.intersects(x, y, width, height);
	}

	/**
	 * checks the intersection between an enemy and player
	 * 
	 * @param e
	 * @return b.intersects(x, y, width, height)
	 */
	public boolean hitEnemy(Enemy e) {
		Rectangle b = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
		return b.intersects(x, y, width, height);
	}

	/**
	 * checks the intersection between bullet and player
	 * 
	 * @param b
	 * @return b.intersects(x, y, width, height)
	 */
	public boolean hitBullet(Bullet b) {
		Rectangle hitBox = new Rectangle(b.getX(), b.getY(), 10, 10);
		return hitBox.intersects(x, y, width, height);
	}

	/**
	 * checks the intersection between a platform and player
	 * 
	 * @param egg
	 * @return hitBox.intersects(x, y, width, height)
	 */
	public boolean gotEgg(Egg egg) {
		Rectangle hitBox = new Rectangle(egg.getX(), egg.getY(), egg.getWidth(), egg.getHeight());
		return hitBox.intersects(x, y, width, height);
	}

	/**
	 * returns the initial x position
	 * 
	 * @return originalX
	 */
	public int getOriginalX() {
		return originalX;
	}

	/**
	 * returns the original y position
	 * 
	 * @return originalY
	 */
	public int getOriginalY() {
		return originalY;
	}

	/**
	 * returns the width of player
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * returns height of player
	 * 
	 * @return height
	 */

	public int getHeight() {
		return height;
	}

	/**
	 * increases the number of lives a player has
	 */
	public void increaseLives() {
		this.lives++;
	}

	/**
	 * decreases the number of lives a player has
	 */
	public void decreaseLives() {
		this.lives--;
	}
}
