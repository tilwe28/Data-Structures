/* Anurag Tilwe */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// STARTER FOR STUDENTS
public class Sierpinski extends JPanel implements KeyListener
{

	JFrame frame;
	ArrayList<Point> points;
	int currX, currY;

	Polygon triangle;

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

		// Print all points here
		g.setColor(Color.WHITE);

		// 3 corners of triangle
		points.add(new Point(100, frame.getHeight()-100, g.getColor())); // Bottom left
		points.add(new Point(frame.getWidth()/2, 100, g.getColor())); // Top
		points.add(new Point(frame.getWidth()-100, frame.getHeight()-100, g.getColor())); // Bottom right

		// Setting triangle polygon
		int[] xValues = new int[points.size()], yValues = new int[points.size()];
		for (int i = 0; i < points.size(); i++)
		{
			xValues[i] = points.get(i).x;
			yValues[i] = points.get(i).y;
		}
		triangle = new Polygon(xValues, yValues, 3);

		// Adding random start point
		g.setColor(Color.GREEN);
		int randX, randY;
		do {
			randX = (int)(Math.random()*((frame.getWidth()-100-100)+1))+100;
			randY = (int)(Math.random()*((100-(frame.getHeight()-100))+1))+(frame.getHeight()-100);
		} while (!triangle.contains(randX, randY));
		points.add(new Point(randX, randY, g.getColor()));
		g.setColor(Color.WHITE);


		for (int i = 3; i < 100000; i++)
			addPoint(points.get(i), g.getColor());

		for (Point p : points)
		{
			g.setColor(p.c);
			g.fillOval(p.x, p.y, 2, 2);
		}
	}

	public void addPoint(Point lastP, Color c)
	{
		int randCorner = (int)(Math.random()*((2-0)+1))+0;
		int newX = (points.get(randCorner).x + lastP.x)/2, newY = (points.get(randCorner).y + lastP.y)/2;
		points.add(new Point(newX, newY, c));
	}

	public void keyPressed(KeyEvent e)
	{
		// get a key to add 5 points at a time & speed process
		System.out.println(e.getKeyCode());
		addPoint(points.get(points.size()-1), Color.BLUE);
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args)
	{
		Sierpinski app = new Sierpinski();
	}

	// Write a simple ordered pair embedded class
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
