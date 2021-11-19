//Anurag Tilwe
import java.awt.*;
public class Explorer
{

	//variables and values
	private Location loc;
	private int dir, size, steps = 0, turns = 0;
	private Color color;
	private boolean debug = true;

	//constructor
	public Explorer(Location loc, int dir, int size, Color color)
	{
		this.loc = loc;
		this.dir = dir;
		this.size = size;
		this.color = color;
	}//constructor


	//accessor methods
	public Location getLoc() { return loc; }
	public int getDir() { return dir; }
	public int getSize() { return size; }
	public Color getColor() { return color; }
	public boolean getDebug() { return debug; }

	public int getSteps() { return steps; }
	public int getTurns() { return turns; }
	public int getMoves() { return steps+turns; }

	public void setLoc(Location other)
	{
		loc.overrideR(other.getR());
		loc.overrideC(other.getC());
	}
	public void setLoc(int r, int c)
	{
			loc.overrideR(r);
			loc.overrideC(c);
	}


	//checks if location is at a certain spot given a row and col
	public boolean atLocation(int r, int c)
	{
		return (r == loc.getR() && c == loc.getC());
	}//atLocation

	//moves the explorer depending on the key that's pressed
	public void move(int key, char[][] maze)
	{
		int row = loc.getR(), col = loc.getC();//sets row and col to current loc
		 if (debug) System.out.println(key);//prints debug statements if debug is on
		//forward
		if(key==38)//up arrow
		{
			//0=up 1=right 2=down 3=left
			if(dir==0 && row > 0 && maze[row-1][col] != '#' && maze[row-1][col] != 'D'){
				// Move Explorer up and set previous space to blank
				loc.setR(-1);
			}
			if(dir==1 && col < maze[0].length-1 && maze[row][col+1] != '#' && maze[row][col+1] != 'D'){
				// Move Explorer right and set previous space to blank
				loc.setC(1);
			}
			if(dir==2 && row < maze.length-1 && maze[row+1][col] != '#' && maze[row+1][col] != 'D'){
				// Move Explorer left and set previous space to blank
				loc.setR(1);
			}
			if(dir==3 && col > 0 && maze[row][col-1] != '#' && maze[row][col-1] != 'D'){
				// Move Explorer down and set previous space to blank
				loc.setC(-1);
			}
			steps++;
		}
		if(key==39)//right arrow rotates right
		{
			dir++;
			if(dir>3)
				dir=0;
			turns++;
		}
		if(key==37)//left arrow rotates left
		{
			dir--;
			if(dir<0)
				dir=3;
			turns++;
		}
	}//move

	public Polygon getPoly(){//makes explorer into a triangle that points to direction
		int r=getLoc().getR();
		int c=getLoc().getC();
		Polygon arrowHead = new Polygon();
		//redraws to point in directon
		if (dir == 0){
			arrowHead.addPoint( c*size+size,r*size+2*size);
			arrowHead.addPoint( (int)(c*size+size*1.5), (r*size+size));
			arrowHead.addPoint( c*size+size*2,r*size+size*2);
		}
		if (dir == 1 ){
			arrowHead.addPoint( c*size+size,r*size+size);
			arrowHead.addPoint( c*size+size*2, (int)(r*size+size*1.5));
			arrowHead.addPoint( c*size+size,r*size+size*2);
		}
		if (dir == 2 ){
			arrowHead.addPoint( c*size+size,r*size+size);
			arrowHead.addPoint( (int)(c*size+size*1.5), (r*size+size*2));
			arrowHead.addPoint( c*size+2*size,r*size+size);
		}
		if (dir == 3 ){
			arrowHead.addPoint( c*size+2*size,r*size+size);
			arrowHead.addPoint( c*size+size, (int)(r*size+size*1.5));
			arrowHead.addPoint( c*size+2*size,r*size+2*size);
		}
		return arrowHead;
	}//Polygon

}//Explorer