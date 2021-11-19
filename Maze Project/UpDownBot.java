public class UpDownBot
{
	private String name;
	private Location loc;
	private char[][] maze;
	private boolean up;

	public UpDownBot(String name, char[][] maze, Location loc)
	{
		this.name = name;
		this.loc = loc;
		this.maze = maze;
		up = true;
	}

	public void move()
	{
		if (up)
			loc.setR(-1);
		else
			loc.setR(+1);
		System.out.println("Moved to  " + loc);
		up = !up;
	}

	public boolean atLocation(int r, int c)
	{
		return (loc.getR() == r && loc.getC() == c);
	}
	public Location getLoc()
	{
		return loc;
	}

}
