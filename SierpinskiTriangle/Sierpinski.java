//Anurag Tilwe
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//STARTER FOR STUDENTS
public class Sierpinski extends JPanel implements KeyListener
{

	JFrame frame;
	ArrayList<Point> points;
	int currX, currY;

	public Sierpinski()
	{
		points = new ArrayList<Point>();

		frame = new JFrame("Sierpinski Triangle Simulator");
		frame.add(this);
		frame.setSize(1200, 700);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		/* Set Background Color you Wish */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//Print all points here
		points.add(new Point(200, 200, Color.GREEN));
	}

	public void addPoint()
	{

	}

	public void keyPressed(KeyEvent e)
	{
		//get a key to add 5 points at a time & speed process
		System.out.println(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args)
	{
		Sierpinski app = new Sierpinski();
	}

	//Write a simple ordered pair embedded class
	public class Point
	{
		int x, y;
		Color c;

		public Point(int x, int y, Color c)
		{
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

}
