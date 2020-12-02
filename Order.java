import java.util.*;

public class Order implements OrderInterface , Comparable<Order>{
	private int orderNum;
	private int orderTime;
	DAY orderDay;
	private Customer customer;
	private List<Beverage> bev = new ArrayList<>();
	private Coffee coffee;
	private Smoothie smoothie;
	private Alcohol alcohol;
	private boolean weekend;
	
	public Order(int orderTime, DAY orderDay, Customer customer) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		this.orderNum = (randomNum());
	}
	
	public int randomNum() {
		Random random = new Random();
		int randomNum = random.nextInt(90000 - 10000 + 1) + 10000;
		return randomNum;
	}

	public Customer getCustomer() {
		Customer newCustomer = new Customer(customer.getName(), customer.getAge());
		return newCustomer;
	}

	public List<Beverage> getBev() {
		return bev;
	}

	public void setBev(List<Beverage> bev) {
		this.bev = bev;
	}

	public void setOrderNo(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}


	@Override
	public int compareTo(Order order) {
		if(order.getOrderNo() < orderNum) {
			return 1;
		}
		if(order.getOrderNo() > orderNum) {
			return -1;
		}
		if(order.getOrderNo() == orderNum) {
			return 0;
		}
		return orderNum;
	}

	@Override
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return bev.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		bev.add(coffee);

	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean weekend = false;
		if(isWeekend()) {
			weekend = true;
		}
		bev.add(new Alcohol(bevName, size, weekend));
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int fruits, boolean protien) {
		smoothie = new Smoothie(bevName, size, fruits, protien);
		bev.add(smoothie);
		
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(int a = 0; a < bev.size(); a++) {
			total += bev.get(a).calcPrice();
		}
		return total;
	}
	
	@Override
	public int findNumOfBeveType(TYPE type) {
		int num = 0;
		for (int a = 0; a < bev.size(); a++) {
			if(bev.get(a).getType() == type) {
				num += 1;
			}
		}
		return num;
	}
	public int getTotalItems() {
		return bev.size();
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	
	public String toString() {
		return getCustomer().getName() + " " + 
			   getOrderDay() + " " + getOrderNo() + " " +   
			   getCustomer().getAge() + " " +
			   getOrderTime() + " " + bev + " " + calcOrderTotal();

		
		
	}


	public int getOrderNo() {
		return orderNum;
	}

	

	

	}
