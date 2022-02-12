//Anurag Tilwe
public class DrugUse
{
	//use is the percentage of those in the age group who used the drug
	//frequency is the amount of times a person in the age group used the drug
	private double alcohol_use, marijuana_use, cocaine_use, crack_use, heroin_use, hallucinogen_use, inhalant_use, painRelief_use, oxycontin_use, tranquilizer_use, stimulant_use, meth_use, sedative_use;
	private double alcohol_freq, marijuana_freq, cocaine_freq, crack_freq, heroin_freq, hallucinogen_freq, inhalant_freq, painRelief_freq, oxycontin_freq, tranquilizer_freq, stimulant_freq, meth_freq, sedative_freq;

	public DrugUse(double alcohol_use, double alcohol_freq, double marijuana_use, double marijuana_freq, double cocaine_use, double cocaine_freq, double crack_use, double crack_freq, double heroin_use, double heroin_freq, double hallucinogen_use, double hallucinogen_freq, double inhalant_use, double inhalant_freq, double painRelief_use, double painRelief_freq, double oxycontin_use, double oxycontin_freq, double tranquilizer_use, double tranquilizer_freq, double stimulant_use, double stimulant_freq, double meth_use, double meth_freq, double sedative_use, double sedative_freq)
	{
		this.alcohol_use = alcohol_use;
		this.marijuana_use = marijuana_use;
		this.cocaine_use = cocaine_use;
		this.crack_use = crack_use;
		this.heroin_use = heroin_use;
		this.hallucinogen_use = hallucinogen_use;
		this.inhalant_use = inhalant_use;
		this.painRelief_use = painRelief_use;
		this.oxycontin_use = oxycontin_use;
		this.tranquilizer_use = tranquilizer_use;
		this.stimulant_use = stimulant_use;
		this.meth_use = meth_use;
		this.sedative_use = sedative_use;
		this.alcohol_freq = alcohol_freq;
		this.marijuana_freq = marijuana_freq;
		this.cocaine_freq = cocaine_freq;
		this.crack_freq = crack_freq;
		this.heroin_freq = heroin_freq;
		this.hallucinogen_freq = hallucinogen_freq;
		this.inhalant_freq = inhalant_freq;
		this.painRelief_freq = painRelief_freq;
		this.oxycontin_freq = oxycontin_freq;
		this.tranquilizer_freq = tranquilizer_freq;
		this.stimulant_freq = stimulant_freq;
		this.meth_freq = meth_freq;
		this.sedative_freq = sedative_freq;
	}

	public double getAlcoholUse() { return alcohol_use; }
	public double getMarijuanaUse() { return marijuana_use; }
	public double getCocaineUse() { return cocaine_use; }
	public double getCrackUse() { return crack_use; }
	public double getHeroinUse() { return heroin_use; }
	public double getHallucinogenUse() { return hallucinogen_use; }
	public double getInhalantUse() { return inhalant_use; }
	public double getPainReliefUse() { return painRelief_use; }
	public double getOxycontinUse() { return oxycontin_use; }
	public double getTranquilizerUse() { return tranquilizer_use; }
	public double getStimulantUse() { return stimulant_use; }
	public double getMethUse() { return meth_use; }
	public double getSedativeUse() { return sedative_use; }
	public double getAlcoholFreq() { return alcohol_freq; }
	public double getMarijuanaFreq() { return marijuana_freq; }
	public double getCocaineFreq() { return cocaine_freq; }
	public double getCrackFreq() { return crack_freq; }
	public double getHeroinFreq() { return heroin_freq; }
	public double getHallucinogenFreq() { return hallucinogen_freq; }
	public double getInhalantFreq() { return inhalant_freq; }
	public double getPainReliefFreq() { return painRelief_freq; }
	public double getOxycontinFreq() { return oxycontin_freq; }
	public double getTranquilizerFreq() { return tranquilizer_freq; }
	public double getStimulantFreq() { return stimulant_freq; }
	public double getMethFreq() { return meth_freq; }
	public double getSedativeFreq() { return sedative_freq; }

	public double overallDrugUseFreq()
	{
		//Use of harder drugs like crack and cocaine are give more priority and will be counted more
		//Use of alcohol and marijuana will be counted less because they have less effects
		double overallUse = (alcohol_use*0.5) + (marijuana_use*0.9) + (cocaine_use*2) + (crack_use*2) + (heroin_use*2) + (hallucinogen_use*2) + (inhalant_use*3) + (painRelief_use*1.5) + (oxycontin_use*1.5) + (tranquilizer_use*2.5) + (stimulant_use*2.5) + (meth_use*2);
		double overallFreq = (alcohol_freq*0.1) + (marijuana_freq*0.25) + (cocaine_freq) + (crack_freq) + (heroin_freq) + (hallucinogen_freq) + (inhalant_freq*1.25) + (painRelief_freq*0.75) + (oxycontin_freq*0.75) + (tranquilizer_freq*1.25) + (stimulant_freq*1.25) + (meth_freq);
		return (overallUse*overallFreq)/25;
	}

	public String toString()
	{
		return "Alcohol: "+alcohol_use+"% and "+alcohol_freq
		+" times per year\nMarijuana: "+marijuana_use+"% and "+marijuana_freq
		+" times per year\nCocaine: "+cocaine_use+"% and "+cocaine_freq
		+" times per year\nCrack: "+crack_use+"% and "+crack_freq
		+" times per year\nHeroin: "+heroin_use+"% and "+heroin_freq
		+" times per year\nHallucinogen: "+hallucinogen_use+"% and "+hallucinogen_freq
		+" times per year\nInhalant: "+inhalant_use+"% and "+inhalant_freq
		+" times per year\nPain Relief: "+painRelief_use+"% and "+painRelief_freq
		+" times per year\nOxycontin: "+oxycontin_use+"% and "+oxycontin_freq
		+" times per year\nTranquilizer: "+tranquilizer_use+"% and "+tranquilizer_freq
		+" times per year\nStimulant: "+stimulant_use+"% and "+stimulant_freq
		+" times per year\nMeth: "+meth_use+"% and "+meth_freq
		+" times per year\nSedative: "+sedative_use+"% and "+sedative_freq
		+"times per year\nOVERALL: "+overallDrugUseFreq();
	}
}