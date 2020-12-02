
public class Smoothie extends Beverage{
	private boolean protien;
	private int fruits;
	private final double ADDITIONAL = 0.50;
	private double basePrice = 2.0;
	private double price;
	
	public Smoothie(String name, SIZE size, int fruits, boolean protien) {
		super(name, TYPE.SMOOTHIE, size);
		this.fruits = fruits;
		this.protien = protien;
	}
	

	public boolean getAddProtien() {
		return protien;
	}

	public void setProtein(boolean protien) {
		this.protien = protien;
	}

	public int getFruits() {
		return fruits;
	}

	public void setFruits(int fruits) {
		this.fruits = fruits;
	}

	@Override
	public double calcPrice() { 
			price = basePrice;
		if(size.equals(SIZE.MEDIUM)) {
			price += (ADDITIONAL * 2);
		}
		if(size.equals(SIZE.LARGE)) {
			price +=  basePrice;
		}
		if(protien == true) {
			price += (ADDITIONAL * 3);
		}
		if(getNumOfFruits() > 0) {
			price += getNumOfFruits() * ADDITIONAL;
		}
		return price;
		
	}
	
	public double getBasePrice() {
		return basePrice;

	}
	
	public boolean equals(Smoothie smoothie) {
		if(smoothie.fruits == fruits) {
			if(smoothie.protien == protien) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return super.toString() + 
				"Extra protein: " + getAddProtien() + "Number of Fruit: " + getNumOfFruits() +
				"Price: " + calcPrice();
	}


	public String getBevName() {
		return getName();
	}

	public int getNumOfFruits() {
		return fruits;
	}


	

}
