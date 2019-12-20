package eg.edu.alexu.csd.oop.game.sample;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.object.ButtonListener;
import eg.edu.alexu.csd.oop.game.sample.object.continueListener;
import eg.edu.alexu.csd.oop.game.sample.object.redolistner;
import eg.edu.alexu.csd.oop.game.sample.world.workspace;

public class Main {
	public  static int x;

	public void setX(int x) {
		this.x = x;
	}

	public  static void printgame() throws CloneNotSupportedException {
		System.out.println("Uncomment any of the lines in the Main to run a new game, Have Fun :)");

		/* -------------------------------------------------------------------- */
		/* using default background color */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Gold(400, 400));
		
		/* -------------------------------------------------------------------- */
		/* using background color at the game */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Ball(700, 400), Color.YELLOW);
		
		/* -------------------------------------------------------------------- */
		/* controlling the behavior of the close button
		 * alternatively, you can use JFrame.DISPOSE_ON_CLOSE, JFrame.HIDE_ON_CLOSE */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Bubles(600, 600), JFrame.EXIT_ON_CLOSE);

//		/* using menus in the game */
//		JMenuBar  menuBar = new JMenuBar();;
//		JMenu menu = new JMenu("File");
//		JMenuItem  exitMenuItem = new JMenuItem("Exit");
//		exitMenuItem.addActionListener(new ActionListener() {
//			@Override public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
//		menu.add(exitMenuItem);
//		menuBar.add(menu);
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.StarWar(800, 600), menuBar, Color.BLACK);

		/* -------------------------------------------------------------------- */
		/* allow pause, resume, and restart multiple worlds in the same frame */
		JMenuBar  menuBar = new JMenuBar();;
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");

		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);

		String fn = JOptionPane.showInputDialog("Enter the level 1 , 2 or 3");
		while(Integer.parseInt(fn) <=0 || Integer.parseInt(fn) >= 4){
			fn = JOptionPane.showInputDialog("Enter the level 1 , 2 or 3");
		}
	    x = Integer.parseInt(fn);

		World m = new eg.edu.alexu.csd.oop.game.sample.world.workspace(800, 600);

		final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", m, menuBar, Color.BLACK);

		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
			try {
				final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.workspace(800, 600), menuBar, Color.BLACK);
			} catch (CloneNotSupportedException ex) {
				ex.printStackTrace();
			}
		}
		});

		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
	}
	
}
