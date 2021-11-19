//Anurag Tilwe
public class Location
{
	private int row, col;

	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}//constructor

	//accsessor
	public int getR() { return row; }
	public int getC() { return col; }

	//increments
	public void setR(int a) { row += a; }
	public void setC(int a) { col += a; }

	//sets or overrides
	public void overrideR(int a) { row = a; }
	public void overrideC(int a) { col = a; }

	public boolean equals(Location other)//checks if other Location is equal to this Location with Location object parameter
	{
		if (other.getR() == row && other.getC() == col)
			return true;
		return false;
	}//equals
	public boolean equals(int otherR, int otherC)//same as other equals method but takes in row and col as parameters
	{
		if (otherR == row && otherC == col)
			return true;
		return false;
	}//equals

	public String toString()
	{
		return "(" + row + "," + col + ")";
	}//toString
}//Location