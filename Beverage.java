
public abstract class Beverage {
	private String name;
	private final double basePrice = 2;
	private final double ADDITIONAL = 1;
	TYPE type;
	SIZE size;	
	
	public Beverage() {
	}
	
	public Beverage(String name,TYPE type,SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}
	
	public abstract double calcPrice();
	
	public double getBasePrice() {
		return basePrice;
	}

	public double getADDITIONAL() {
		return ADDITIONAL;
	}

	public String toString() {
		return "Beverage name: " + name + ", Size: " + size;
	}
	
	public boolean equals(Beverage bev) {
		if(bev.getName() == name) {
			if(bev.getType() == type) {
				if(bev.getSize() == size) {
					return true;
				}
			}
		}
		return false;
	}

	public String getBevName() {
		return getName();
	}
	
	
	
	
	
}
