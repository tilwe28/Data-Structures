//Anurag Tilwe
public class Car
{

	private String model, origin;
	private int cylinders, horsepower, weight, year;
	private double mpg, displacement, acceleration;

	public Car(String model, String mpg, String cylinders, String displacement, String horsepower, String weight, String acceleration, String year, String origin)
	{
		this.model = model;
		this.mpg= Double.parseDouble(mpg);
		this.cylinders = Integer.parseInt(cylinders);
		this.displacement = Double.parseDouble(displacement);
		this.horsepower = Integer.parseInt(horsepower);
		this.weight = Integer.parseInt(weight);
		this.acceleration = Double.parseDouble(acceleration);
		this.year = Integer.parseInt(year);
		this.origin = origin;
	}

	public Car(int s)
	{
		if (s == 0)
		{
			model = "";
			mpg = Double.MIN_VALUE;
			cylinders = Integer.MIN_VALUE;
			displacement = Double.MIN_VALUE;
			horsepower = Integer.MIN_VALUE;
			weight = Integer.MIN_VALUE;
			acceleration = Double.MIN_VALUE;
			year = Integer.MIN_VALUE;
			origin = "";
		} else if (s == 1) {
			model = "";
			mpg = Double.MAX_VALUE;
			cylinders = Integer.MAX_VALUE;
			displacement = Double.MAX_VALUE;
			horsepower = Integer.MAX_VALUE;
			weight = Integer.MAX_VALUE;
			acceleration = Double.MAX_VALUE;
			year = Integer.MAX_VALUE;
			origin = "";
		}
	}

	public String getModel()
	{
		return model;
	}
	public double getMPG()
	{
		return mpg;
	}
	public int getCylinders()
	{
		return cylinders;
	}
	public double getDisplacement()
	{
		return displacement;
	}
	public int getHorsepower()
	{
		return horsepower;
	}
	public int getWeight()
	{
		return weight;
	}
	public double getAcceleration()
	{
		return acceleration;
	}
	public int getYear()
	{
		return year;
	}
	public String getOrigin()
	{
		return origin;
	}

	public String toString()
	{
		return model + "\t" + mpg + "\t" + cylinders + "\t" + displacement + "\t" + horsepower + "\t" + weight + "\t" + acceleration + "\t" + year + "\t" + origin;
	}

}