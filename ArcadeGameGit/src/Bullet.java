import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author jacksob1 and zlatann
 *
 */
public class Bullet {
	private Enemy enemy;
	private int x;
	private int y;
	private int velocityX;
	private int velocityY;

	/**
	 * constructs Bullet
	 * 
	 * @param enemy
	 * @param velocityX
	 * @param velocityY
	 */
	public Bullet(Enemy enemy, int velocityX, int velocityY) {
		this.enemy = enemy;
		this.x = enemy.getX();
		this.y = enemy.getY();
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}

	/**
	 * returns x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the x with parameter x
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * returns y
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets the y with parameter y
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * draws the bullet onto the screen
	 * 
	 * @param g
	 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.MAGENTA);
		g2.fillOval(this.x, this.y, 10, 10);
	}

	/**
	 * moves the bullet based on velocity
	 */
	public void move() {
		this.x += this.velocityX;
		this.y += this.velocityY;
	}

	/**
	 * returns the enemy enemy in order to get its x and y values
	 * 
	 * @return
	 */
	public Enemy getEnemy() {
		return enemy;
	}
}
