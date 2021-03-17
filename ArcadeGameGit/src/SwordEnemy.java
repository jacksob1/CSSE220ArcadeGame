import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JComponent;

/**
 * @author zlatann and jacksob1
 *
 */
public class SwordEnemy extends Enemy {
	/**
	 * constructs the SwordEnemy
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public SwordEnemy(int x, int y, int width, int height) {
		super(x, y, width, height, 1);
	}
	/**
	 * draws the SwordEnemy
	 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	/**
	 * moves the player based on velocities
	 */
	@Override
	public void move() {
		this.setX(this.getX() + this.getvX());
		this.setY(this.getY() + this.getvY());
	}
}
