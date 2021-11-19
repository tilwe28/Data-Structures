//Anurag Tilwe
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class MazeProjectTemplate extends JPanel implements KeyListener, ActionListener
{
	private JFrame frame;
	private Explorer player;
	private Location endLoc;									//Finish line location
	private int col=0, row=0, dir = 1; 							//Location and direction of explorer
	private int size = 32;  		  							//size of grid square in pixels
	private boolean debug = true, won = false, is3D = false;   	//Set to true to print debug info
	private int numRows = 8, numCols = 20; 					// set based on uploaded data
	private char[][] maze=new char[numRows][numCols];

	private UpDownBot udb;
	private Timer t;

	public MazeProjectTemplate()
	{
		setBoard();  //write this method to read board from file



		frame=new JFrame("Anurag's A-Mazing Program");
		frame.setSize(1000,800);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		//udb = new UpDownBot("Up Down Bot 1", maze ,new Location (1, 3)); //Put udb in maze
		t = new Timer(2000, this); // Fires an Action Event every 2000 ms (2 seconds)
		t.start();
	}
	public void paintComponent(Graphics g)
	{

		System.out.println("col" + player.getLoc().getC());

		//Make Background Blank
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,frame.getWidth(),frame.getHeight());

		if (is3D)
		{
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
			g2.drawString("3D Maze!", 100, 30);

			boolean isGreen = false;

			//checking space in front
			//checking distance with walls in front
			boolean wallPresent = false;
			int dist = 0, increment = 0;
			if (player.getDir() == 0)
			{
				do
				{
					if (maze[player.getLoc().getR()-increment][player.getLoc().getC()] == ' ')
						dist++;
					if (maze[player.getLoc().getR()-increment][player.getLoc().getC()] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()-increment][player.getLoc().getC()] == 'F'){
						isGreen = true;
						wallPresent = true;
						dist++;
					}
					increment++;
				}while(wallPresent == false && increment<5 && player.getLoc().getR()-increment>=0);
			}
			if (player.getDir() == 1)
			{
				do
				{
					if (maze[player.getLoc().getR()][player.getLoc().getC()+increment] == ' ')
						dist++;
					if (maze[player.getLoc().getR()][player.getLoc().getC()+increment] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()][player.getLoc().getC()+increment] == 'F'){
						isGreen = true;
						wallPresent = true;
						dist++;
					}
					increment++;
				}while(wallPresent == false && increment<5 && player.getLoc().getC()+increment<maze[0].length);
			}
			if (player.getDir() == 2)
			{
				do
				{
					if (maze[player.getLoc().getR()+increment][player.getLoc().getC()] == ' ')
						dist++;
					if (maze[player.getLoc().getR()+increment][player.getLoc().getC()] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()+increment][player.getLoc().getC()] == 'F'){
						isGreen = true;
						wallPresent = true;
						dist++;
					}
					increment++;
				}while(wallPresent == false && increment<5 && player.getLoc().getR()+increment<maze.length);
			}
			if (player.getDir() == 3)
			{
				do
				{
					if (maze[player.getLoc().getR()][player.getLoc().getC()-increment] == ' ')
						dist++;
					if (maze[player.getLoc().getR()][player.getLoc().getC()-increment] == '#')
						wallPresent = true;
					if (maze[player.getLoc().getR()][player.getLoc().getC()-increment] == 'F'){
						isGreen = true;
						wallPresent = true;
						dist++;
					}
					increment++;
				}while(wallPresent == false && increment<5 && player.getLoc().getC()-increment>=0);
			}

			if (dist != 5)//endWall
			{
				int[] xLocsE = {150, 650, 650, 150}, yLocsE = {150, 150, 650, 650};
				if (dist == 4)
				{
					xLocsE = new int[]{300, 500, 500, 300};
					yLocsE = new int[]{300, 300, 500, 500};
				} else if (dist == 3) {
					xLocsE = new int[]{250, 550, 550, 250};
					yLocsE = new int[]{250, 250, 550, 550};
				} else if (dist == 2) {
					xLocsE = new int[]{200, 600, 600, 200};
					yLocsE = new int[]{200, 200, 600, 600};
				} else if (dist == 1) {
					xLocsE = new int[]{150, 650, 650, 150};
					yLocsE = new int[]{150, 150, 650, 650};
				}
				Polygon endWall = new Polygon(xLocsE, yLocsE, xLocsE.length);
				g2.setColor(Color.WHITE);
				if (isGreen) g2.setColor(Color.GREEN);
				g2.fill(endWall);
				g2.setColor(Color.BLACK);
				g2.draw(endWall);
			}

			for (int i=0; i<dist; i++)
			{
				System.out.println("i" + i);
				//leftWall
				int[] xLocsL = {100+(i*50), 150+(i*50), 150+(i*50), 100+(i*50)};
				int[] yLocsL = {100+(i*50), 150+(i*50), 650-(i*50), 700-(i*50)};
				Polygon leftWall = new Polygon(xLocsL, yLocsL, xLocsL.length);
				g2.setColor(Color.WHITE);
				if (player.getDir()==0)
					if (maze[player.getLoc().getR()-i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==1)
					if (maze[player.getLoc().getR()][player.getLoc().getC()+i] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==2)
					if (maze[player.getLoc().getR()+i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==3)
					if (maze[player.getLoc().getR()][player.getLoc().getC()-i] == 'F') g2.setColor(Color.GREEN);
				g2.fill(leftWall);
				g2.setColor(Color.BLACK);
				g2.draw(leftWall);

				//Ceiling
				int[] xLocsC = {100+(i*50), 700-(i*50), 650-(i*50), 150+(i*50)};
				int[] yLocsC = {100+(i*50), 100+(i*50), 150+(i*50), 150+(i*50)};
				Polygon ceiling = new Polygon(xLocsC, yLocsC, xLocsC.length);
				g2.setColor(Color.WHITE);
				if (player.getDir()==0)
					if (maze[player.getLoc().getR()-i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==1)
					if (maze[player.getLoc().getR()][player.getLoc().getC()+i] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==2)
					if (maze[player.getLoc().getR()+i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==3)
					if (maze[player.getLoc().getR()][player.getLoc().getC()-i] == 'F') g2.setColor(Color.GREEN);
				g2.fill(ceiling);
				g2.setColor(Color.BLACK);
				g2.draw(ceiling);

				//rightWall
				int[] xLocsR = {700-(i*50), 650-(i*50), 650-(i*50), 700-(i*50)};
				int[] yLocsR = {100+(i*50), 150+(i*50), 650-(i*50), 700-(i*50)};
				Polygon rightWall = new Polygon(xLocsR, yLocsR, xLocsR.length);
				g2.setColor(Color.WHITE);
				if (player.getDir()==0)
					if (maze[player.getLoc().getR()-i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==1)
					if (maze[player.getLoc().getR()][player.getLoc().getC()+i] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==2)
					if (maze[player.getLoc().getR()+i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==3)
					if (maze[player.getLoc().getR()][player.getLoc().getC()-i] == 'F') g2.setColor(Color.GREEN);
				g2.fill(rightWall);
				g2.setColor(Color.BLACK);
				g2.draw(rightWall);

				//Floor
				int[] xLocsF = {100+(i*50), 700-(i*50), 650-(i*50), 150+(i*50)};
				int[] yLocsF = {700-(i*50), 700-(i*50), 650-(i*50), 650-(i*50)};
				Polygon floor = new Polygon(xLocsF, yLocsF, xLocsF.length);
				g2.setColor(Color.WHITE);
				if (player.getDir()==0)
					if (maze[player.getLoc().getR()-i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==1)
					if (maze[player.getLoc().getR()][player.getLoc().getC()+i] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==2)
					 if (maze[player.getLoc().getR()+i][player.getLoc().getC()] == 'F') g2.setColor(Color.GREEN);
				if (player.getDir()==3)
					if (maze[player.getLoc().getR()][player.getLoc().getC()-i] == 'F') g2.setColor(Color.GREEN);
				g2.fill(floor);
				g2.setColor(Color.BLACK);
				g2.draw(floor);

				//Turn
				if (player.getDir()==0)//up
				{
					if (player.getLoc().getC()-1>=0)
						if (maze[player.getLoc().getR()-i][player.getLoc().getC()-1] == ' ')//left turn
						{
							int[] xLocsG = {100+(i*50), 150+(i*50), 150+(i*50), 100+(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					if (player.getLoc().getC()+1<maze[0].length)
						if (maze[player.getLoc().getR()-i][player.getLoc().getC()+1] == ' ')//right turn
						{
							int[] xLocsG = {700-(i*50), 650-(i*50), 650-(i*50), 700-(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
				}
				if (player.getDir()==1)//right
				{
					if (player.getLoc().getR()-1>=0)
						if (maze[player.getLoc().getR()-1][player.getLoc().getC()+i] == ' ')//left turn
						{
							int[] xLocsG = {100+(i*50), 150+(i*50), 150+(i*50), 100+(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					if (player.getLoc().getR()+1<maze.length)
						if (maze[player.getLoc().getR()+1][player.getLoc().getC()+i] == ' ')//right turn
						{
							int[] xLocsG = {700-(i*50), 650-(i*50), 650-(i*50), 700-(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
				}
				if (player.getDir()==2)//down
				{
					if (player.getLoc().getC()+1<maze[0].length)
						if (maze[player.getLoc().getR()+i][player.getLoc().getC()+1] == ' ')//left turn
						{
							int[] xLocsG = {100+(i*50), 150+(i*50), 150+(i*50), 100+(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					if (player.getLoc().getC()-1>=0)
						if (maze[player.getLoc().getR()+i][player.getLoc().getC()-1] == ' ')//right turn
						{
							int[] xLocsG = {700-(i*50), 650-(i*50), 650-(i*50), 700-(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
				}
				if (player.getDir()==3)//left
				{
					if (player.getLoc().getR()+1<maze.length)
						if (maze[player.getLoc().getR()+1][player.getLoc().getC()-i] == ' ')//left turn
						{
							int[] xLocsG = {100+(i*50), 150+(i*50), 150+(i*50), 100+(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
					if (player.getLoc().getR()-1>=0)
						if (maze[player.getLoc().getR()-1][player.getLoc().getC()-i] == ' ')//right turn
						{
							int[] xLocsG = {700-(i*50), 650-(i*50), 650-(i*50), 700-(i*50)};
							int[] yLocsG = {150+(i*50), 150+(i*50), 650-(i*50), 650-(i*50)};
							Polygon turnRect = new Polygon(xLocsG, yLocsG, xLocsG.length);
							g2.setColor(Color.GRAY);
							g2.fill(turnRect);
							g2.setColor(Color.BLACK);
							g2.draw(turnRect);
						}
				}
			}
		} else {
			// DRAW MAZE
			g2.setColor(Color.GRAY);
			for(int c=0;c<maze[0].length;c++)
			for(int r=0;r<maze.length;r++){
				if (player.atLocation(r, c)){
					//EXPLORER
					/*g2.setColor(player.getColor());
					g2.fillRect(c*size+size,r*size+size,size,size);
					g2.setColor(Color.GRAY);*/
					if (player != null && player.atLocation(r,c)){
						//EXPLORER
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(player.getColor());
						g2.fill(player.getPoly());
						g2.setColor(Color.GRAY);
					}
				}
				if (player != null && player.atLocation(r,c)){
					//EXPLORER
					g2.fillRect(c*size+size,r*size+size,size,size);
					g2.setColor(player.getColor());
					g2.fill(player.getPoly());
					g2.setColor(Color.GRAY);
				}
				/*
				else if (udb != null && udb.atLocation(r,c))
				{   // NEW CODE FOR UpDownBot
						g2.setColor(Color.MAGENTA);
						g2.fillRect(c*size+size,r*size+size,size,size);
						g2.setColor(Color.GRAY);
				}
				*/
				else if (maze[r][c] == 'F'){
					//SET FINISH OR GOAL SQUARE
					g2.setColor(Color.GREEN);
					g2.fillRect(c*size+size,r*size+size,size,size);
					g2.setColor(Color.GRAY);
				}
				else if(maze[r][c]==' ') // OPEN SQUARE GRAY
					g2.fillRect(c*size+size,r*size+size,size,size);
				else // BLOCKED SQUARE GRAY OUTLINE
					g2.drawRect(c*size+size,r*size+size,size,size);
			}
		}
		if (debug){ // PRINT EXTRA INFO TO HELP DEBUG
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans", Font.PLAIN, 12));
			if (!is3D)
			{
				g2.drawString("Debug Messages",12, numRows*size+2*size);
				g2.drawString("dir = " + player.getDir(),12, numRows*size+2*size+16);
				g2.drawString("steps = " + player.getSteps(),12, numRows*size+2*size+32);
				g2.drawString("turns = " + player.getTurns(),12, numRows*size+2*size+48);
				g2.drawString("total moves = " + player.getMoves(),12, numRows*size+2*size+64);
			}
			g2.setColor(Color.GRAY);
		}
		if (won) {
			g2.setColor(Color.PINK);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 100));
			g2.drawString("YOU WON!!!", 112, 425);
		}
	}
	public void keyPressed(KeyEvent e)
	{
		player.move(e.getKeyCode(), maze);
		System.out.println("Moved to location " + player.getLoc());

		if (e.getKeyCode() == 32)
			is3D = !is3D;

		//check for win
		if (endLoc.equals(player.getLoc())) won = true;
		repaint();
	}
	public void keyReleased(KeyEvent e) //Required for interface, leave empty
	{
	}
	public void keyTyped(KeyEvent e) // Required for interface, leave open
	{
	}

	public void setBoard()
	{
		// Read maze from file and set to maze 2d array
		try {

			BufferedReader input = new BufferedReader(new FileReader("maze1.txt"));
			String text;
			int r = 0;
			while((text=input.readLine())!= null)
			{
				if (debug) System.out.println("len->" + text.length());
				for (int c = 0; c < text.toCharArray().length; c++)
				{
					maze[r][c] = text.charAt(c);
					if (text.charAt(c) == 'E')
					{
						player = new Explorer(new Location(r, c), dir, size, Color.RED);
						maze[r][c] = ' ';
					}
					if (text.charAt(c) == 'F')
						endLoc = new Location(r, c);
				}
				r++;
			}

		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

	}

	public void actionPerformed(ActionEvent e)
	{
		/*
		udb.move();
		repaint();
		if (player.getLoc().equals(udb.getLoc()))
		{
			System.out.println("You were eaten!");
			// set a boolean to alter screen (remove explorer and write message)
		}
		*/
	}


	public static void main(String[] args)
	{
		new MazeProjectTemplate();
	}
}