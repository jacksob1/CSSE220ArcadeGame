import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;

/**
 * @author zlatann and jacksob1
 *
 */
public class Level {
	private Player player;
	private ArrayList<Enemy> enemies;
	private int fileChoice;
	private ArrayList<Rectangle> boxes;
	private ArrayList<Egg> eggs;
	private ArrayList<Enemy> enemies1 = new ArrayList<Enemy>();
	private ArrayList<Enemy> enemies2 = new ArrayList<Enemy>();
	private ArrayList<Enemy> enemies3 = new ArrayList<Enemy>();

	/**
	 * constructs level
	 * 
	 * @param player
	 */
	public Level(Player player) {
		this.fileChoice = 1;
		this.player = player;
		this.eggs = new ArrayList<Egg>();
		this.boxes = new ArrayList<Rectangle>();
		makeEnemies1();
		makeEnemies2();
		makeEnemies3();
		this.enemies = enemies1;
	}

	/**
	 * draws the platform based on a text fil, as well as the eggs
	 * 
	 * @param g
	 */
	public void drawOn(Graphics2D g) {
		boxes = new ArrayList<Rectangle>();
		Graphics2D g2 = (Graphics2D) g;
		FileReader file = null;

		try {
			file = new FileReader("JoustLevel" + fileChoice + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner s = new Scanner(file);
		int count = 1;
		int boxX = 0;
		int boxY = 0;
		int boxWidth = 0;
		int boxHeight = 0;

		while (s.hasNext()) {
			if (count % 4 == 1) {
				boxX = s.nextInt();
			} else if (count % 4 == 2) {
				boxY = s.nextInt();
			} else if (count % 4 == 3) {
				boxWidth = s.nextInt();
			} else if (count % 4 == 0) {
				boxHeight = s.nextInt();
				Rectangle box = new Rectangle(boxX, boxY, boxWidth, boxHeight);
				boxes.add(box);
			}
			count++;
		}
		Color color = g2.getColor();
		g2.setColor(color.CYAN);
		for (Rectangle box : boxes) {
			g2.fill(box);
		}
		g2.setColor(color);
		for (Egg egg : eggs) {
			egg.drawOn(g2);
		}
	}

	/**
	 * returns an arraylist of enemies
	 * 
	 * @return enemies
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * sets based on the fileChoice number (which is a level)
	 */
	public void setEnemy() {
		if (this.fileChoice == 1) {
			this.enemies = enemies1;
		}
		if (this.fileChoice == 2) {
			this.enemies = enemies2;
		}
		if (this.fileChoice == 3) {
			this.enemies = enemies3;
		}
	}

	/**
	 * return an arraylist of eggs
	 * 
	 * @return eggs
	 */
	public ArrayList<Egg> getEggs() {
		return eggs;
	}

	/**
	 * adds an egg to the eggs
	 * 
	 * @param egg
	 */
	public void addEgg(Egg egg) {
		this.eggs.add(egg);
	}

	/**
	 * returns the fileChoice which is a level
	 * 
	 * @return fileChoice
	 */
	public int getFileChoice() {
		return fileChoice;
	}

	/**
	 * changes the fileChoice which is the level
	 * 
	 * @param fileChoice
	 */
	public void setFileChoice(int fileChoice) {
		this.fileChoice = fileChoice;
	}

	/**
	 * returns the platforms
	 * 
	 * @return boxes
	 */
	public ArrayList<Rectangle> getBoxes() {
		return boxes;
	}

	/**
	 * sets the boxes depending on the fileChoice which is a level
	 * 
	 * @param boxes
	 */
	public void setBoxes(ArrayList<Rectangle> boxes) {
		this.boxes = boxes;
	}

	/**
	 * sets the player depending on input values
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * returns the player
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * adds an enemy to enemies
	 * 
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy) {
		this.enemies.add(enemy);
	}

	/**
	 * makes enemies in the first fileChoice which is a level
	 */
	private void makeEnemies1() {
		enemies1.add(new SwordEnemy(30, 50, 25, 25));
		enemies1.add(new SwordEnemy(320, 100, 25, 25));
		enemies1.add(new RangeEnemy(220, 80, 30, 30));
		enemies1.add(new RangeEnemy(123, 100, 30, 30));
	}

	/**
	 * makes enemies in the second fileChoice which is a level
	 */
	private void makeEnemies2() {
		enemies2.add(new SwordEnemy(30, 50, 25, 25));
		enemies2.add(new SwordEnemy(300, 50, 25, 25));
		enemies2.add(new SwordEnemy(50, 87, 25, 25));
		enemies2.add(new RangeEnemy(123, 100, 30, 30));
	}

	/**
	 * makes enemies in the third fileChoice which is a level
	 */
	private void makeEnemies3() {
		enemies3.add(new SwordEnemy(400, 75, 25, 25));
		enemies3.add(new SwordEnemy(575, 300, 25, 25));
		enemies3.add(new RangeEnemy(450, 205, 30, 30));
		enemies3.add(new RangeEnemy(525, 50, 30, 30));
		enemies3.add(new RangeEnemy(325, 150, 30, 30));
	}
}
