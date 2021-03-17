import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author zlatann and jacksob1
 *
 */
public abstract class Enemy {

	private int width;
	private int height;
	private int x;
	private int y;
	private int originalY;
	private int originalX;
	private int difficulty;
	private int counter;
	private int vX;
	private int vY;

	/**
	 * constructs enemy
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param difficulty
	 */
	public Enemy(int x, int y, int width, int height, int difficulty) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		originalX = x;
		originalY = y;
		this.difficulty = difficulty;
		this.counter = 0;
		this.vX = 0;
		this.vY = 0;
	}

	/**
	 * returns the velocity of enemy in x direction
	 * 
	 * @return
	 */
	public int getvX() {
		return vX;
	}

	/**
	 * sets the velocity of enemy in x direction
	 * 
	 * @param vX
	 */
	public void setvX(int vX) {
		this.vX = vX;
	}

	/**
	 * returns the velocity in y directon
	 * 
	 * @return
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
	 * returns the difficult of enemy 1 representing sword enemy 2 representing
	 * range enemy
	 * 
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * returns x position
	 * 
	 * @return x
	 */
	public int getX() {
		return this.x;
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
	 * returns y position
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
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
	 * returns the initial y position
	 * 
	 * @return originalY
	 */
	public int getOriginalY() {
		return originalY;
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
	 * returns the width of enemy
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * returns height of enemy
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * checks the intersection between this and b
	 * 
	 * @param b
	 * @return b.intersects(x, y, width, height
	 */
	public boolean insideBox(Rectangle b) {
		return b.intersects(x, y, width, height);
	}

	/**
	 * increases the counter of when the range enmies need to shoot
	 */
	public void increaseCounter() {
		counter++;
	}

	/**
	 * returns the counter of when range enemies need to shoot
	 * 
	 * @return counter
	 */
	public int getCount() {
		return counter;
	}

	/**
	 * counter for when difficulty 2 enemies need to shoot(range enemies)
	 * 
	 * @param num
	 */
	public void setCount(int num) {
		counter = num;
	}

	/**
	 * draw On draws the enemy
	 * 
	 * @param g
	 */
	public abstract void drawOn(Graphics g);

	/**
	 * makes the enemy move
	 */
	public abstract void move();
}
