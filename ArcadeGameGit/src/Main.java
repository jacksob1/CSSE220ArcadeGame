
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start by running
 * main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author zlatann and jacksob1
 *
 */
public class Main {
	private Level level;
	private Player player;
	private GameComponent gameComponent;
	private MyControlListener levelListener;
	private Timer time;
	

	public static void main(String[] args) {
		new Main();
	}

	/**
	 * main creates and initializes time and enemies and players
	 */
	public Main() {
		JFrame levelScreen = new JFrame("Arcade Game");
		levelScreen.setSize(750, 775);
		levelScreen.setResizable(false);

		player = new Player(70, 675, 25, 25);
		level = new Level(player);

		gameComponent = new GameComponent(level, player, levelScreen);

		time = new Timer(16, new GameAdvanceListener(gameComponent));
		time.start();

		levelScreen.add(gameComponent);

		levelListener = new MyControlListener(levelScreen, gameComponent, level, time);
		levelScreen.addKeyListener(levelListener);

		levelScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		levelScreen.setVisible(true);
	}

}
