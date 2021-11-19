//Anurag Tilwe - Maze Project
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class MazeTester extends JPanel implements KeyListener {
	private JFrame frame;
	private Explorer player;																	//Eplorer player
	private Location endLoc, keyLoc, doorLoc, portalLoc, spawnLoc, trapLoc;						//Location for finish, key, door, portal, portal result, and trap
	private int dir = 1, size = 32, numRows = 12, numCols = 21;									//Direction of explorer, size of grid square in pixels, size of maze
	private boolean debug = true, won = false, dead = false, is3D = false, tookPortal = false;	//Set to true to print debug info, checks for win, dead, is3D, and if teleport occured													// set based on uploaded data
	private char[][] maze = new char[numRows][numCols];

	public MazeTester() {
		setBoard();//Method creates maze by reding file and initializes values

		//Creates window
		frame = new JFrame("Anurag's A-Mazing Program");
		frame.setSize(1500, 800);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}//constructor

	public void paintComponent(Graphics g) {//draws playable maze
		//Make Background Blank
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		if (is3D) {//is3D
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
			g2.drawString("3D Maze!", 100, 30);

			boolean isGreen = false, isKey = false, isDoor = false, isPortal = false, isTrap = false;

			//finds dist based on whats in front
			boolean wallPresent = false;
			int dist = 0, increment = 0;
			if (player.getDir() == 0) {//dir 0
				do {
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == ' ' || maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'S')
						dist++;
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'F') {
						isGreen = true;
						dist++;
					}
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'K') {
						isKey = true;
						dist++;
					}
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'D') {
						isDoor = true;
						dist++;
					}
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'P') {
						isPortal = true;
						dist++;
					}
					if (maze[player.getLoc().getR() - increment][player.getLoc().getC()] == 'X') {
						isTrap = true;
						dist++;
					}
					increment++;
				} while (wallPresent == false && increment < 5 && player.getLoc().getR() - increment >= 0 && !isDoor);
			}
			else if (player.getDir() == 1) {//dir 1
				do {
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == ' ' || maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'S')
						dist++;
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'F') {
						isGreen = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'K') {
						isKey = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'D') {
						isDoor = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'P') {
						isPortal = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() + increment] == 'X') {
						isTrap = true;
						dist++;
					}
					increment++;
				} while (wallPresent == false && increment < 5 && player.getLoc().getC() + increment < maze[0].length && !isDoor);
			}
			else if (player.getDir() == 2) {//dir 2
				do {
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == ' ' || maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'S')
						dist++;
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'F') {
						isGreen = true;
						dist++;
					}
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'K') {
						isKey = true;
						dist++;
					}
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'D') {
						isDoor = true;
						dist++;
					}
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'P') {
						isPortal = true;
						dist++;
					}
					if (maze[player.getLoc().getR() + increment][player.getLoc().getC()] == 'X') {
						isTrap = true;
						dist++;
					}
					increment++;
				} while (wallPresent == false && increment < 5 && player.getLoc().getR() + increment < maze.length && !isDoor);
			}
			else if (player.getDir() == 3) {//dir 3
				do {
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == ' ' || maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'S')
						dist++;
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'F') {
						isGreen = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'K') {
						isKey = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'D') {
						isDoor = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'P') {
						isPortal = true;
						dist++;
					}
					if (maze[player.getLoc().getR()][player.getLoc().getC() - increment] == 'X') {
						isTrap = true;
						dist++;
					}
					increment++;
				} while (wallPresent == false && increment < 5 && player.getLoc().getC() - increment >= 0 && !isDoor);
			}

			if (dist != 5 || isDoor)//draws endWall
			{
				int[] xLocsE = { 150, 650, 650, 150 }, yLocsE = { 150, 150, 650, 650 };
				if (dist == 4) {
					xLocsE = new int[] { 300, 500, 500, 300 };
					yLocsE = new int[] { 300, 300, 500, 500 };
				} else if (dist == 3) {
					xLocsE = new int[] { 250, 550, 550, 250 };
					yLocsE = new int[] { 250, 250, 550, 550 };
				} else if (dist == 2) {
					xLocsE = new int[] { 200, 600, 600, 200 };
					yLocsE = new int[] { 200, 200, 600, 600 };
				} else if (dist == 1) {
					xLocsE = new int[] { 150, 650, 650, 150 };
					yLocsE = new int[] { 150, 150, 650, 650 };
				}
				Polygon endWall = new Polygon(xLocsE, yLocsE, xLocsE.length);
				g2.setColor(Color.WHITE);
				if (isGreen)
					g2.setColor(Color.GREEN);
				if (isKey)
					g2.setColor(new Color(101, 67, 33));
				if (isDoor)
					g2.setColor(Color.BLUE);
				if (isPortal)
					g2.setColor(new Color(106, 13, 173));
				if (isTrap)
					g2.setColor(Color.RED);
				g2.fill(endWall);
				g2.setColor(Color.BLACK);
				g2.draw(endWall);
			}//draws endWall

			for (int i = 0; i < dist; i++) {//draws walls, floor, and ceiling
				//leftWall
				int[] xLocsL = { 100 + (i * 50), 150 + (i * 50), 150 + (i * 50), 100 + (i * 50) };
				int[] yLocsL = { 100 + (i * 50), 150 + (i * 50), 650 - (i * 50), 700 - (i * 50) };
				Polygon leftWall = new Polygon(xLocsL, yLocsL, xLocsL.length);
				g2.setColor(setWallColor(i));
				g2.fill(leftWall);
				g2.setColor(Color.BLACK);
				g2.draw(leftWall);

				//ceiling
				int[] xLocsC = { 100 + (i * 50), 700 - (i * 50), 650 - (i * 50), 150 + (i * 50) };
				int[] yLocsC = { 100 + (i * 50), 100 + (i * 50), 150 + (i * 50), 150 + (i * 50) };
				Polygon ceiling = new Polygon(xLocsC, yLocsC, xLocsC.length);
				g2.setColor(setWallColor(i));
				g2.fill(ceiling);
				g2.setColor(Color.BLACK);
				g2.draw(ceiling);

				//rightWall
				int[] xLocsR = { 700 - (i * 50), 650 - (i * 50), 650 - (i * 50), 700 - (i * 50) };
				int[] yLocsR = { 100 + (i * 50), 150 + (i * 50), 650 - (i * 50), 700 - (i * 50) };
				Polygon rightWall = new Polygon(xLocsR, yLocsR, xLocsR.length);
				g2.setColor(setWallColor(i));
				g2.fill(rightWall);
				g2.setColor(Color.BLACK);
				g2.draw(rightWall);

				//floor
				int[] xLocsF = { 100 + (i * 50), 700 - (i * 50), 650 - (i * 50), 150 + (i * 50) };
				int[] yLocsF = { 700 - (i * 50), 700 - (i * 50), 650 - (i * 50), 650 - (i * 50) };
				Polygon floor = new Polygon(xLocsF, yLocsF, xLocsF.length);
				g2.setColor(setWallColor(i));
				g2.fill(floor);
				g2.setColor(Color.BLACK);
				g2.draw(floor);

				//draws turns
				if (player.getDir() == 0)//dir 0
				{
					if (player.getLoc().getC() - 1 >= 0){//left turn
						if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == ' '
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'K'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'F'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'D'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'P'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'S'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'X')
						{
							int[] xLocsG = { 100 + (i * 50), 150 + (i * 50), 150 + (i * 50), 100 + (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorL(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
					if (player.getLoc().getC() + 1 < maze[0].length){//right turn
						if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == ' '
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'K'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'F'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'D'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'P'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'S'
								|| maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'X')
						{
							int[] xLocsG = { 700 - (i * 50), 650 - (i * 50), 650 - (i * 50), 700 - (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorR(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
				}
				if (player.getDir() == 1)//dir 1
				{
					if (player.getLoc().getR() - 1 >= 0){//left turn
						if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == ' '
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'K'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'F'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'D'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'P'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'S'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'X')
						{
							int[] xLocsG = { 100 + (i * 50), 150 + (i * 50), 150 + (i * 50), 100 + (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorL(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
					if (player.getLoc().getR() + 1 < maze.length){//right turn
						if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == ' '
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'K'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'F'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'D'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'P'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'S'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'X')
						{
							int[] xLocsG = { 700 - (i * 50), 650 - (i * 50), 650 - (i * 50), 700 - (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorR(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
				}
				if (player.getDir() == 2)//dir 2
				{
					if (player.getLoc().getC() + 1 < maze[0].length){//left turn
						if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == ' '
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'K'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'F'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'D'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'P'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'S'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'X')
						{
							int[] xLocsG = { 100 + (i * 50), 150 + (i * 50), 150 + (i * 50), 100 + (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorL(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
					if (player.getLoc().getC() - 1 >= 0){//right turn
						if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == ' '
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'K'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'F'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'D'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'P'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'S'
								|| maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'X')
						{
							int[] xLocsG = { 700 - (i * 50), 650 - (i * 50), 650 - (i * 50), 700 - (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorR(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
				}
				if (player.getDir() == 3)//dir 3
				{
					if (player.getLoc().getR() + 1 < maze.length){//left turn
						if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == ' '
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'K'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'F'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'D'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'P'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'S'
								|| maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'X')
						{
							int[] xLocsG = { 100 + (i * 50), 150 + (i * 50), 150 + (i * 50), 100 + (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorL(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
					if (player.getLoc().getR() - 1 >= 0){//right turn
						if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == ' '
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'K'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'F'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'D'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'P'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'S'
								|| maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'X')
						{
							int[] xLocsG = { 700 - (i * 50), 650 - (i * 50), 650 - (i * 50), 700 - (i * 50) };
							int[] yLocsG = { 150 + (i * 50), 150 + (i * 50), 650 - (i * 50), 650 - (i * 50) };
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(setTurnColorR(i));
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					}
				}
			}//draws walls, floor, and ceiling
		}/*is3D*/ else {//2D
			// DRAW MAZE
			g2.setColor(Color.GRAY);
			for (int c = 0; c < maze[0].length; c++)
				for (int r = 0; r < maze.length; r++) {
					if (player.atLocation(r, c)) {
						if (player != null && player.atLocation(r, c)) {//draws EXPLORER
							g2.fillRect(c * size + size, r * size + size, size, size);
							g2.setColor(player.getColor());
							g2.fill(player.getPoly());
							g2.setColor(Color.GRAY);
						}
					} else if (maze[r][c] == 'F') {//draws FINISH
						g2.setColor(Color.GREEN);
						g2.fillRect(c * size + size, r * size + size, size, size);
						g2.setColor(Color.GRAY);
					} else if (maze[r][c] == 'K') {//draws KEY
						g2.setColor(new Color(101, 67, 33));
						g2.fillRect(c * size + size, r * size + size, size, size);
						g2.setColor(Color.GRAY);
					} else if (maze[r][c] == 'D') {//draws DOOR
						g2.setColor(Color.BLUE);
						g2.fillRect(c * size + size, r * size + size, size, size);
						g2.setColor(Color.GRAY);
					} else if (maze[r][c] == 'P') {//draws PORTAL
						g2.setColor(new Color(106, 13, 173));
						g2.fillRect(c * size + size, r * size + size, size, size);
						g2.setColor(Color.GRAY);
					}else if (maze[r][c] == 'X') {//draws TRAP
						g2.setColor(Color.RED);
						g2.fillRect(c * size + size, r * size + size, size, size);
						g2.setColor(Color.GRAY);
					}else if (maze[r][c] == ' ' || maze[r][c] == 'S') //draws OPEN SQUARE GRAY
						g2.fillRect(c * size + size, r * size + size, size, size);
					else //draws BLOCKED SQUARE GRAY OUTLINE
						g2.drawRect(c * size + size, r * size + size, size, size);
				}
		}//2D
		if (debug) {//prints debug info
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans", Font.PLAIN, 12));
			if (!is3D) {//2D
				//keeps track of moves player has made
				g2.drawString("Debug Messages", 12, numRows * size + 2 * size);
				g2.drawString("dir = " + player.getDir(), 12, numRows * size + 2 * size + 16);
				g2.drawString("steps = " + player.getSteps(), 12, numRows * size + 2 * size + 32);
				g2.drawString("turns = " + player.getTurns(), 12, numRows * size + 2 * size + 48);
				g2.drawString("total moves = " + player.getMoves(), 12, numRows * size + 2 * size + 64);

				//legend to identify meaning of colors
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 24));
				g2.setColor(Color.WHITE);
				g2.drawString("Colors", 12, numRows * size + 2 * size + 96);
				g2.setColor(Color.MAGENTA);
				g2.drawString("Explorer", 12, numRows * size + 2 * size + 120);
				g2.setColor(Color.BLUE);
				g2.drawString("Door", 12, numRows * size + 2 * size + 144);
				g2.setColor(new Color(101, 67, 33));
				g2.drawString("Key", 12, numRows * size + 2 * size + 168);
				g2.setColor(new Color(106, 13, 173));
				g2.drawString("Portal", 12, numRows * size + 2 * size + 192);
				g2.setColor(Color.GREEN);
				g2.drawString("Finish", 12, numRows * size + 2 * size + 216);
				g2.setColor(Color.RED);
				g2.drawString("Trap", 12, numRows * size + 2 * size + 240);

				//displays major event messages
				g2.setColor(Color.WHITE);
				if (maze[doorLoc.getR()][doorLoc.getC()] == ' ')
					g2.drawString("The door has opened!", 1200, 48);
				if (tookPortal)
					g2.drawString("You took the portal!", 1200, 96);
				if (dead)
					g2.drawString("You died to the trap!", 1200, 144);
			} else if (is3D){//3D
				//keeps track of moves player has made
				g2.drawString("Debug Messages", 750, 48);
				g2.drawString("dir = " + player.getDir(), 750, 64);
				g2.drawString("steps = " + player.getSteps(), 750, 80);
				g2.drawString("turns = " + player.getTurns(), 750, 96);
				g2.drawString("total moves = " + player.getMoves(), 750, 112);

				//legend to identify meaning of colors
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 24));
				g2.setColor(Color.WHITE);
				g2.drawString("Colors", 10, numRows * size + 2 * size + 96);
				g2.setColor(Color.MAGENTA);
				g2.drawString("Explorer", 10, numRows * size + 2 * size + 120);
				g2.setColor(Color.BLUE);
				g2.drawString("Door", 10, numRows * size + 2 * size + 144);
				g2.setColor(new Color(101, 67, 33));
				g2.drawString("Key", 10, numRows * size + 2 * size + 168);
				g2.setColor(new Color(106, 13, 173));
				g2.drawString("Portal", 10, numRows * size + 2 * size + 192);
				g2.setColor(Color.GREEN);
				g2.drawString("Finish", 10, numRows * size + 2 * size + 216);
				g2.setColor(Color.RED);
				g2.drawString("Trap", 10, numRows * size + 2 * size + 240);

				//displays major event messages
				g2.setColor(Color.WHITE);
				if (maze[doorLoc.getR()][doorLoc.getC()] == ' ')
					g2.drawString("The door has opened!", numCols * size + 2 * size, 208);
				if (tookPortal)
					g2.drawString("You took the portal!", numCols * size + 2 * size, 256);
				if (dead)
					g2.drawString("You died to the trap!", numCols * size + 2 * size, 304);
			}
			g2.setColor(Color.GRAY);
		}//debug
		if (won) {
			g2.setColor(Color.PINK);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 100));
			g2.drawString("YOU WON!!!", 112, 425);
		}
		if (dead) {
			g2.setColor(Color.RED);
			if (is3D)g2.setColor(Color.WHITE);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 100));
			g2.drawString("YOU DIED", 112, 425);
		}
	}//paintComponent

	public void keyPressed(KeyEvent e) {//moves player based on input
		if (e.getKeyCode() == 32)
				is3D = !is3D;

		if (!dead && !won)//only moves if alive and not won
		{
			player.move(e.getKeyCode(), maze);

			if (maze[player.getLoc().getR()][player.getLoc().getC()] == 'K')
				maze[doorLoc.getR()][doorLoc.getC()] = ' ';
			if (maze[player.getLoc().getR()][player.getLoc().getC()] == 'P'){
				player.setLoc(spawnLoc);
				tookPortal = true;
			}
			if (maze[player.getLoc().getR()][player.getLoc().getC()] == 'X')
				dead = true;
		}

		// check for win
		if (endLoc.equals(player.getLoc()))
			won = true;

		System.out.println("Moved to location " + player.getLoc());
		repaint();
	}//keyPressed

	public void keyReleased(KeyEvent e) {}//Required for interface, leave empty

	public void keyTyped(KeyEvent e) {}// Required for interface, leave open

	public void setBoard() {//Read maze from file and set to maze 2d array and intializes variables
		try {
			BufferedReader input = new BufferedReader(new FileReader("maze3.txt"));
			String text;
			int r = 0;
			while ((text = input.readLine()) != null) {
				for (int c = 0; c < text.toCharArray().length; c++) {
					maze[r][c] = text.charAt(c);
					if (text.charAt(c) == 'E') {
						player = new Explorer(new Location(r, c), dir, size, Color.MAGENTA);
						maze[r][c] = ' ';
					}
					if (text.charAt(c) == 'F')
						endLoc = new Location(r, c);
					if (text.charAt(c) == 'K')
						keyLoc = new Location(r, c);
					if (text.charAt(c) == 'D')
						doorLoc = new Location(r, c);
					if (text.charAt(c) == 'P')
						portalLoc = new Location(r, c);
					if (text.charAt(c) == 'S')
						spawnLoc = new Location(r, c);
					if (text.charAt(c) == 'X')
						trapLoc = new Location(r, c);
				}
				r++;
			}

		} catch (IOException io) {
			System.err.println("File does not exist");
		}
	}//setBoard

	public Color setWallColor(int i) {//sets color for walls based on what is present
		if (player.getDir() == 0) {//dir 0
			if (maze[player.getLoc().getR() - i][player.getLoc().getC()] == 'F')
				return Color.GREEN;
			else if (maze[player.getLoc().getR() - i][player.getLoc().getC()] == 'K')
				return new Color(101, 67, 33);
			else if (maze[player.getLoc().getR() - i][player.getLoc().getC()] == 'D')
				return Color.BLUE;
			else if (maze[player.getLoc().getR() - i][player.getLoc().getC()] == 'P')
				return new Color(106, 13, 173);
			else if (maze[player.getLoc().getR() - i][player.getLoc().getC()] == 'X')
				return Color.RED;
		} else if (player.getDir() == 1) {//dir 1
			if (maze[player.getLoc().getR()][player.getLoc().getC() + i] == 'F')
				return Color.GREEN;
			else if (maze[player.getLoc().getR()][player.getLoc().getC() + i] == 'K')
				return new Color(101, 67, 33);
			else if (maze[player.getLoc().getR()][player.getLoc().getC() + i] == 'D')
				return Color.BLUE;
			else if (maze[player.getLoc().getR()][player.getLoc().getC() + i] == 'P')
				return new Color(106, 13, 173);
			else if (maze[player.getLoc().getR()][player.getLoc().getC() + i] == 'X')
				return Color.RED;
		} else if (player.getDir() == 2) {//dir 2
			if (maze[player.getLoc().getR() + i][player.getLoc().getC()] == 'F')
				return Color.GREEN;
			else if (maze[player.getLoc().getR() + i][player.getLoc().getC()] == 'K')
				return new Color(101, 67, 33);
			else if (maze[player.getLoc().getR() + i][player.getLoc().getC()] == 'D')
				return Color.BLUE;
			else if (maze[player.getLoc().getR() + i][player.getLoc().getC()] == 'P')
				return new Color(106, 13, 173);
			else if (maze[player.getLoc().getR() + i][player.getLoc().getC()] == 'X')
				return Color.RED;
		} else if (player.getDir() == 3) {//dir 3
			if (maze[player.getLoc().getR()][player.getLoc().getC() - i] == 'F')
				return Color.GREEN;
			else if (maze[player.getLoc().getR()][player.getLoc().getC() - i] == 'K')
				return new Color(101, 67, 33);
			else if (maze[player.getLoc().getR()][player.getLoc().getC() - i] == 'D')
				return Color.BLUE;
			else if (maze[player.getLoc().getR()][player.getLoc().getC() - i] == 'P')
				return new Color(106, 13, 173);
			else if (maze[player.getLoc().getR()][player.getLoc().getC() - i] == 'X')
				return Color.RED;
		}
		return Color.WHITE;
	}//setWallColor

	public Color setTurnColorL(int i) {//sets color for left turn based on what is present
		if (player.getDir() == 0) {//dir 0
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() - 1] == 'X')
				return Color.RED;
		} else if (player.getDir() == 1) {//dir 1
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() + i] == 'X')
				return Color.RED;
		} else if (player.getDir() == 2) {//dir 2
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() + 1] == 'X')
				return Color.RED;
		} else if (player.getDir() == 3) {//dir 3
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() - i] == 'X')
				return Color.RED;
		}
		return Color.GRAY;
	}//setTurnColorL

	public Color setTurnColorR(int i) {//sets color for walls based on what is present
		if (player.getDir() == 0) {//dir 0
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() - i][player.getLoc().getC() + 1] == 'X')
				return Color.RED;
		} else if (player.getDir() == 1) {//dir 1
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() + 1][player.getLoc().getC() + i] == 'X')
				return Color.RED;
		} else if (player.getDir() == 2) {//dir 2
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() + i][player.getLoc().getC() - 1] == 'X')
				return Color.RED;
		} else if (player.getDir() == 3) {//dir 3
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'F')
				return Color.GREEN;
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'K')
				return new Color(101, 67, 33);
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'D')
				return Color.BLUE;
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'P')
				return new Color(106, 13, 173);
			if (maze[player.getLoc().getR() - 1][player.getLoc().getC() - i] == 'X')
				return Color.RED;
		}
		return Color.GRAY;
	}//setTurnColorR

	public static void main(String[] args) {
		new MazeTester();
	}//main
}//MazeTester