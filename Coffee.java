
public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double ADDITIONAL = 1.0;
	private final double basePrice = 2.0;
	private double extra = 0.50;
	private double price;
	
	
	public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
		super(name, TYPE.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public void extraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public double getBasePrice() {
		return basePrice;
	}
	
	public String getBevName() {
		return getName();
	}

	public double calcPrice() {
		price = basePrice;
		if(size.equals(SIZE.MEDIUM)) {
			price += ADDITIONAL;
		}
		if(size.equals(SIZE.LARGE)) {
			price +=  basePrice;
		}
		if(extraSyrup == true) {
			price +=  extra;
		}
		if(extraShot == true) {
			price += extra;
		}
		return price;
		
	}
	
	public void extraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public boolean equals(Coffee coffee) {
		if(coffee.getExtraSyrup() == extraSyrup) {
			if(coffee.getExtraShot() == extraShot) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"Extra shot: " + getExtraShot() + "Extra syrup: " + getExtraSyrup() +
				"Price: " + calcPrice();
	}

	


	

}
