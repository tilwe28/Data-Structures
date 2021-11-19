//Anurag Tilwe
import java.util.*;
import java.lang.*;
import java.io.*;
public class Cars
{

	public static void main(String[]args)
	{

		ArrayList<Car> cars = new ArrayList<Car>();

		try {

			BufferedReader input = new BufferedReader(new FileReader("CarsInput.txt"));
			input.readLine();//heading
			String text;
			while ((text=input.readLine()) != null)
			{
				String[] car = text.split("\t");
				if (car[4].equals("NA"))
					car[4] = "0";
				cars.add(new Car(car[0], car[1], car[2], car[3], car[4], car[5], car[6], car[7], car[8]));
			}
		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}

		for (int i = 1; i <= 7; i++)
			organize(cars, i);

	}

	public static void organize(ArrayList<Car> cars, int dataType)
	{
		Car[] highest = new Car[3], lowest = new Car[3];

		if (dataType == 1)
		{
			highest = sortMPG(cars).get(0);
			lowest = sortMPG(cars).get(1);

			System.out.println("Highest MPG\t\t\t\t\tLowest MPG");
			print(highest, lowest);
		} else if (dataType == 2) {
			highest = sortCylinders(cars).get(0);
			lowest = sortCylinders(cars).get(1);

			System.out.println("Highest # Cylinders\t\t\t\tLowest Cylinders");
			print(highest, lowest);
		} else if (dataType == 3) {
			highest = sortDisplacement(cars).get(0);
			lowest = sortDisplacement(cars).get(1);

			System.out.println("Highest Displacement\t\t\t\tLowest Displacement");
			print(highest, lowest);
		} else if (dataType == 4) {
			highest = sortHorsepower(cars).get(0);
			lowest = sortHorsepower(cars).get(1);

			System.out.println("Highest Horsepower\t\t\t\tLowest Horsepower");
			print(highest, lowest);
		} else if (dataType == 5) {
			highest = sortWeight(cars).get(0);
			lowest = sortWeight(cars).get(1);

			System.out.println("Highest Weight\t\t\t\t\tLowest Weight");
			print(highest, lowest);
		} else if (dataType == 6) {
			highest = sortAcceleration(cars).get(0);
			lowest = sortAcceleration(cars).get(1);

			System.out.println("Highest Acceleration\t\t\t\tLowest Acceleration");
			print(highest, lowest);
		} else if (dataType == 7) {
			highest = sortYear(cars).get(0);
			lowest = sortYear(cars).get(1);

			System.out.println("Highest Year\t\t\t\t\tLowest Year");
			print(highest, lowest);
		}
		System.out.println();
	}

	public static ArrayList<Car[]> sortMPG(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			double mpg = cars.get(i).getMPG();

			if (mpg > highest[2].getMPG())
			{
				if (mpg > highest[1].getMPG())
				{
					if (mpg > highest[0].getMPG())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (mpg < lowest[2].getMPG())
			{
				if (mpg < lowest[1].getMPG())
				{
					if (mpg < lowest[0].getMPG())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}

	public static ArrayList<Car[]> sortCylinders(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			int cylinders = cars.get(i).getCylinders();

			if (cylinders > highest[2].getCylinders())
			{
				if (cylinders > highest[1].getCylinders())
				{
					if (cylinders > highest[0].getCylinders())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (cylinders < lowest[2].getCylinders())
			{
				if (cylinders < lowest[1].getCylinders())
				{
					if (cylinders < lowest[0].getCylinders())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}
	public static ArrayList<Car[]> sortDisplacement(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			double displacement = cars.get(i).getDisplacement();

			if (displacement > highest[2].getDisplacement())
			{
				if (displacement > highest[1].getDisplacement())
				{
					if (displacement > highest[0].getDisplacement())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (displacement < lowest[2].getDisplacement())
			{
				if (displacement < lowest[1].getDisplacement())
				{
					if (displacement < lowest[0].getDisplacement())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}
	public static ArrayList<Car[]> sortHorsepower(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			int horsepower = cars.get(i).getHorsepower();
			if (horsepower != 0)
			{
				if (horsepower > highest[2].getHorsepower())
				{
					if (horsepower > highest[1].getHorsepower())
					{
						if (horsepower > highest[0].getHorsepower())
						{
							Car temp0 = highest[0];
							highest[0] = cars.get(i);
							Car temp1 = highest[1];
							highest[1] = temp0;
							highest[2] = temp1;
						} else {
							Car temp1 = highest[1];
							highest[1] = cars.get(i);
							highest[2] = temp1;
						}
					} else highest[2] = cars.get(i);
				}
				if (horsepower < lowest[2].getHorsepower())
				{
					if (horsepower < lowest[1].getHorsepower())
					{
						if (horsepower < lowest[0].getHorsepower())
						{
							Car temp0 = lowest[0];
							lowest[0] = cars.get(i);
							Car temp1 = lowest[1];
							lowest[1] = temp0;
							lowest[2] = temp1;
						} else {
							Car temp1 = lowest[1];
							lowest[1] = cars.get(i);
							lowest[2] = temp1;
						}
					} else lowest[2] = cars.get(i);
				}
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}
	public static ArrayList<Car[]> sortWeight(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			int weight = cars.get(i).getWeight();

			if (weight > highest[2].getWeight())
			{
				if (weight > highest[1].getWeight())
				{
					if (weight > highest[0].getWeight())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (weight < lowest[2].getWeight())
			{
				if (weight < lowest[1].getWeight())
				{
					if (weight < lowest[0].getWeight())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}
	public static ArrayList<Car[]> sortAcceleration(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			double acceleration = cars.get(i).getAcceleration();

			if (acceleration > highest[2].getAcceleration())
			{
				if (acceleration > highest[1].getAcceleration())
				{
					if (acceleration > highest[0].getAcceleration())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (acceleration < lowest[2].getAcceleration())
			{
				if (acceleration < lowest[1].getAcceleration())
				{
					if (acceleration < lowest[0].getAcceleration())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}
	public static ArrayList<Car[]> sortYear(ArrayList<Car> cars)
	{
		ArrayList<Car[]> sorted = new ArrayList<Car[]>();
		Car[] highest = {new Car(0), new Car(0), new Car(0)}, lowest = {new Car(1), new Car(1), new Car(1)};
		for (int i = 0; i < cars.size(); i++)
		{
			double year = cars.get(i).getYear();

			if (year > highest[2].getYear())
			{
				if (year > highest[1].getYear())
				{
					if (year > highest[0].getYear())
					{
						Car temp0 = highest[0];
						highest[0] = cars.get(i);
						Car temp1 = highest[1];
						highest[1] = temp0;
						highest[2] = temp1;
					} else {
						Car temp1 = highest[1];
						highest[1] = cars.get(i);
						highest[2] = temp1;
					}
				} else highest[2] = cars.get(i);
			}
			if (year < lowest[2].getYear())
			{
				if (year < lowest[1].getYear())
				{
					if (year < lowest[0].getYear())
					{
						Car temp0 = lowest[0];
						lowest[0] = cars.get(i);
						Car temp1 = lowest[1];
						lowest[1] = temp0;
						lowest[2] = temp1;
					} else {
						Car temp1 = lowest[1];
						lowest[1] = cars.get(i);
						lowest[2] = temp1;
					}
				} else lowest[2] = cars.get(i);
			}
		}

		sorted.add(highest);
		sorted.add(lowest);

		return sorted;
	}

	public static void print(Car[] highest, Car[] lowest)
	{
		String tabs = "";
		for (int i = 0; i < 3; i++)
		{
			if (highest[i].getModel().length() >= 24)
				tabs = "\t\t\t";
			else if (highest[i].getModel().length() >= 16)
				tabs = "\t\t\t\t";
			else if (highest[i].getModel().length() >= 8)
				tabs = "\t\t\t\t\t";
			else tabs = "\t\t\t\t\t\t";
			System.out.println(highest[i].getModel() + tabs + lowest[i].getModel());
		}
	}

}