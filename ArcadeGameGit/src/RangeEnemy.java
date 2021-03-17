import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

/**
 * @author zlatann and jacksob1
 *
 */
public class RangeEnemy extends Enemy {
	/**
	 * creates range enemy
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public RangeEnemy(int x, int y, int width, int height) {
		super(x, y, width, height, 2);
	}

	/**
	 * draws range enemy
	 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	/**
	 * moves range enemy
	 */
	@Override
	public void move() {
		this.setX(this.getX() + this.getvX());
		this.setY(this.getY() + this.getvY());
	}

}
