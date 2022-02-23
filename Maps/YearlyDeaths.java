//Anurag Tilwe
public class YearlyDeaths
{

	private double deaths2009, deaths2010, deaths2011, deaths2012, deaths2013, deaths2014, deaths2015, deaths2016, deaths2017, deaths2018, deaths2019;

	public YearlyDeaths(double deaths2009, double deaths2010, double deaths2011, double deaths2012, double deaths2013, double deaths2014, double deaths2015, double deaths2016, double deaths2017, double deaths2018, double deaths2019)
	{
		this.deaths2009 = deaths2009;
		this.deaths2010 = deaths2010;
		this.deaths2011 = deaths2011;
		this.deaths2012 = deaths2012;
		this.deaths2013 = deaths2013;
		this.deaths2014 = deaths2014;
		this.deaths2015 = deaths2015;
		this.deaths2016 = deaths2016;
		this.deaths2017 = deaths2017;
		this.deaths2018 = deaths2018;
		this.deaths2019 = deaths2019;
	}

	public double getDeaths2009() { return deaths2009; }
	public double getDeaths2010() { return deaths2010; }
	public double getDeaths2011() { return deaths2011; }
	public double getDeaths2012() { return deaths2012; }
	public double getDeaths2013() { return deaths2013; }
	public double getDeaths2014() { return deaths2014; }
	public double getDeaths2015() { return deaths2015; }
	public double getDeaths2016() { return deaths2016; }
	public double getDeaths2017() { return deaths2017; }
	public double getDeaths2018() { return deaths2018; }
	public double getDeaths2019() { return deaths2019; }

	public void setDeaths2009(double d) { deaths2009 = d; }
	public void setDeaths2010(double d) { deaths2010 = d; }
	public void setDeaths2011(double d) { deaths2011 = d; }
	public void setDeaths2012(double d) { deaths2012 = d; }
	public void setDeaths2013(double d) { deaths2013 = d; }
	public void setDeaths2014(double d) { deaths2014 = d; }
	public void setDeaths2015(double d) { deaths2015 = d; }
	public void setDeaths2016(double d) { deaths2016 = d; }
	public void setDeaths2017(double d) { deaths2017 = d; }
	public void setDeaths2018(double d) { deaths2018 = d; }
	public void setDeaths2019(double d) { deaths2019 = d; }

	public double getAverageDeaths()
	{
		return (deaths2009+deaths2010+deaths2011+deaths2012+deaths2013+deaths2014+deaths2015+deaths2016+deaths2017+deaths2018+deaths2019)/11;
	}

	public String toString() { return getAverageDeaths()+" average deaths"; }
}