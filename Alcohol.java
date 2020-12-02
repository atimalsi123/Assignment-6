
public class Alcohol extends Beverage{
	private boolean weekend;
	private final double ADDITIONAL = 0.60;
	private final double basePrice = 2.0;
	private double add = 1.0;
	private double price;

	public Alcohol(String name, SIZE size, boolean weekend) {
		super(name, TYPE.ALCOHOL, size);
		this.weekend = weekend;
	}
	
	public Alcohol(String name, SIZE size) {
		super(name, TYPE.ALCOHOL, size);
	}
	
	public Alcohol(String name, TYPE type, SIZE size) {
		super(name, TYPE.ALCOHOL, size);
	}
	
	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public double getBasePrice() {
		return basePrice;
	}
	
	public double calcPrice() {
		price = basePrice;
		if(size.equals(SIZE.MEDIUM)) {
			price += 1.0;
		}
		if(size.equals(SIZE.LARGE)) {
			price +=  2.0;
		}
		if(isWeekend()) {
			price +=  0.60;
		}
		return price;
		
	}
	
	public boolean equals(Alcohol alcohol) {
		if(alcohol.weekend == weekend) {
				return true;
			}
		return false;	
	}
	@Override
	public String toString() {
		return super.toString() + "Available on the Weekend: " + isWeekend() +
				 "Price: " + calcPrice();
	}

	public String getBevName() {
		return getName();
	}


}
