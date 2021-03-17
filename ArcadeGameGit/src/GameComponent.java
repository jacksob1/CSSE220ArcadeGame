import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper.Range;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author jacksob1 and zlatann
 *
 */
public class GameComponent extends JComponent {

	private Level level;
	private Player player;
	private int count;
	private int points;
	private ArrayList<Bullet> bullets;
	private JFrame screen;
	private int pointsTo3;

	/**
	 * constructs the game component
	 * 
	 * @param level
	 * @param player
	 * @param screen
	 */
	public GameComponent(Level level, Player player, JFrame screen) {
		this.level = level;
		this.player = player;
		this.count = 0;
		this.points = 0;
		bullets = new ArrayList<Bullet>();
		this.screen = screen;
		this.pointsTo3 = 0;
	}

	/**
	 * paints enemies levels and player
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(0, 0, 750, 775);
		g2.setColor(Color.WHITE);
		g2.drawString("Points: " + this.points, 1, 10);
		g2.drawString("Lives: " + player.getLives(), 300, 10);
		g2.drawString("Press 'M' to open manual", 450, 10);
		level.drawOn(g2);
		player.drawOn(g2);
		for (Enemy enemy : level.getEnemies()) {
			enemy.drawOn(g2);
		}
		for (Bullet bullet : bullets) {
			bullet.drawOn(g2);
		}
	}

	/**
	 * updates the state of all of the components
	 */
	public void updateState() {
		updatePlayer();
		updateEnemy();
		updateBullet();
		if (level.getEggs().size() > 0) {
			updateEgg();
		}
	}

	/**
	 * updates enemy in which makes it: check if enemy hit a platform the sword
	 * enemy and bullets follow the enemy
	 */
	private void updateEnemy() {
		for (Enemy enemy : level.getEnemies()) {
			enemy.move();
			enemy.increaseCounter();
			for (Rectangle platform : this.level.getBoxes()) {
				if (enemy.getY() > platform.getY() && enemy.insideBox(platform)) {
					enemy.setY(platform.y + platform.height + enemy.getvY() + (int) platform.getHeight() / 2);
				} else if (enemy.insideBox(platform) && enemy.getY() < platform.getY() + platform.getHeight()) {
					enemy.setY(platform.y - enemy.getHeight());
				}

			}
			if (enemy.getDifficulty() == 1) {
				int velocityX = 2;
				int velocityY = 2;
				if (player.getX() < enemy.getX()) {
					velocityX *= -1;
				}
				if (player.getY() < enemy.getY()) {
					velocityY *= -1;
				}
				enemy.setvY(velocityY);
				enemy.setvX(velocityX);
				enemy.move();
			}
			if (enemy.getDifficulty() == 2 && enemy.getCount() == 90) {
				int velocityX = 4;
				int velocityY = 6;
				if (player.getX() < enemy.getX()) {
					velocityX *= -1;
				}
				if (player.getY() < enemy.getY()) {
					velocityY *= -1;
				}
				bullets.add(new Bullet(enemy, velocityX, velocityY));
				enemy.setCount(0);
				enemy.setvY(0);
				enemy.setvX(velocityX);
				enemy.move();
			}
			if (enemy.getX() < -25) {
				enemy.setX(750);
			}
			if (enemy.getX() > 775) {
				enemy.setX(-25);
			}
			if (enemy.getY() < 0) {
				enemy.setY(0);
			}

			if (enemy.getY() > 775) {
				enemy.setY(enemy.getOriginalY());
			}
		}

	}

	/**
	 * updates state of the bullet
	 */
	private void updateBullet() {
		for (Bullet bullet : bullets) {
			bullet.move();
		}
	}

	/**
	 * makes the egg fall and if fell on platform then it makes it stop
	 */
	private void updateEgg() {
		for (Egg egg : this.level.getEggs()) {
			egg.increaseCount();
			for (Rectangle platform : this.level.getBoxes()) {
				boolean topOfPlatform = egg.fall((int) (platform.getY() - egg.getHeight()));
				if (topOfPlatform && egg.insideBox(platform)) {
					egg.setY(platform.y - egg.getHeight());
				}
			}
		}
	}

	/**
	 * checks if player hit platform if player hit enemy and removes
	 * enemies/eggs/bullets that it hit
	 */
	private void updatePlayer() {
		ArrayList<Enemy> enemiesToRemove = new ArrayList<Enemy>();
		ArrayList<Egg> eggsToRemove = new ArrayList<Egg>();
		if (this.pointsTo3 == 3) {
			player.increaseLives();
			pointsTo3 = 0;
		}

		for (Rectangle platform : this.level.getBoxes()) {
			boolean topOfPlatform = player.fall(platform.y - 25);
			if (player.getY() > platform.getY() && player.insideBox(platform)) {
				player.setY(platform.y + platform.height + player.getvY() + (int) platform.getHeight() / 2);
			} else if (topOfPlatform && player.insideBox(platform) && player.getY() < platform.getY()) {
				player.setY(platform.y - player.getHeight());
			}
		}
		for (Enemy e : this.level.getEnemies()) {
			if (player.hitEnemy(e) && player.getY() < e.getY()) {
				enemiesToRemove.add(e);
			} else if (player.hitEnemy(e) && player.getY() > e.getY()) {
				this.player.setY(player.getOriginalY());
				this.player.setX(player.getOriginalY());
				this.player.decreaseLives();
			}
		}
		for (Bullet b : this.bullets) {
			if (player.hitBullet(b)) {
				this.player.setY(player.getOriginalY());
				this.player.setX(player.getOriginalX());
				this.player.decreaseLives();
			}
		}

		for (Egg egg : this.level.getEggs()) {
			if (player.gotEgg(egg)) {
				eggsToRemove.add(egg);
				this.points++;
				this.pointsTo3++;
			}
			if (egg.getY() > 780) {
				eggsToRemove.add(egg);
			}
		}

		for (Enemy e : enemiesToRemove) {
			this.level.getEnemies().remove(e);
			Egg egg = new Egg(e.getX(), e.getY(), e);
			this.level.addEgg(egg);
		}

		for (Egg e : this.level.getEggs()) {
			if (e.getCount() >= 170) {
				this.level.addEnemy(e.getEnemy());
				eggsToRemove.add(e);

			}
		}

		for (Egg e : eggsToRemove) {
			this.level.getEggs().remove(e);
		}

		if (player.getX() < -25) {
			this.player.setX(750);
		}
		if (player.getX() > 775) {
			this.player.setX(-25);
		}
		if (player.getY() < 0) {
			this.player.setY(0);
		}

		if (player.getY() > 775) {
			this.player.setY(player.getOriginalY());
			player.decreaseLives();
		}

		if (level.getEnemies().size() == 0 && level.getEggs().size() == 0) {
			if (level.getFileChoice() < 3) {
				level.setFileChoice(level.getFileChoice() + 1);
				level.setEnemy();
			} else {
				System.exit(1);
			}
		}

		if (player.getLives() == 0) {
			screen.dispose();
			System.exit(1);
		}
	}

	/**
	 * redraws on screen
	 */
	public void drawScreen() {
		this.repaint();
	}

	/**
	 * return player
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return this.player;
	}
}
