import java.util.*;

public class BevShop implements BevShopInterfce{
	private List<Order> order = new ArrayList();
	Customer cust;
	Order anotherOrder;
	private int age;

	@Override
	public boolean validTime(int time) {
		if(MIN_TIME <= time && MAX_TIME >= time ) {
			return true;
		}
		return false;
	}

	@Override
	public boolean eligibleForMore() {
		if(anotherOrder.findNumOfBeveType(TYPE.ALCOHOL) < 3) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		cust = new Customer(customerName, customerAge);
		anotherOrder = new Order(time, day, cust);
		this.order.add(anotherOrder);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		anotherOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		anotherOrder.addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		anotherOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for(int a = 0; a < order.size(); a++) {
			if(order.get(a).getOrderNo() == orderNo) {
				return a;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double total = 0.0;
		for(int a = 0; a < order.size(); a++) {
			if(order.get(a).getOrderNo() == orderNo) {
				total = order.get(a).calcOrderTotal();
			}
		}
		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for(int a = 0; a < order.size(); a++) {
			total += order.get(a).calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		Order temporder;
		for(int a = 0; a < order.size(); a++) {
			for(int b = 0; b < order.size(); b++) {
				if(order.get(a).getOrderNo() < order.get(b).getOrderNo()) {
					temporder = order.get(a);
					order.set(a, order.get(b));
					order.set(b, temporder);
				}
			}
		}
		}
		
	

	@Override
	public Order getOrderAtIndex(int index) {
		return order.get(index);
	}
	
	public int getNumOfAlcoholDrink() {
		return anotherOrder.findNumOfBeveType(TYPE.ALCOHOL);
	}

	public Order getCurrentOrder() {
		return anotherOrder;
	}

	public boolean isMaxFruit(int i) {
		if(i > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	public Object totalNumOfMonthlyOrders() {
		return order.size();
	}
	
	public String toString() {
		String string = " ";
		for(int a = 0; a < order.size(); a++) {
			string += order.get(a).toString();
		}
		string += "Total Sale: " + totalMonthlySale();
		return string;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	

}
