package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helper.UUIDGenerator;

public class Restaurant {
	private String name;
	private Map<String, MenuItem> menu;
	int maxOrders;
	int currentOrderCount;
	List<Order> currentOrder;
	List<Order> completedOrder;
	public Restaurant(String name, List<MenuItem> menu, int maxOrder, double rating) {
		this.name = name;
		maxOrders = maxOrder;
		this.menu = new HashMap<String, MenuItem>();
		for(MenuItem menuItem: menu) {
			this.menu.put(menuItem.getItemName(), menuItem);
		}
		this.rating = rating;
		currentOrder = new ArrayList<Order>();
	}
	private double rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, MenuItem> getMenu() {
		return menu;
	}
	public void setMenu(Map<String, MenuItem> menu) {
		this.menu = menu;
	}
	public int getMaxOrders() {
		return maxOrders;
	}
	public void setMaxOrders(int maxOrders) {
		this.maxOrders = maxOrders;
	}
	public int getCurrentOrderCount() {
		return currentOrderCount;
	}
	public void setCurrentOrderCount(int currentOrders) {
		this.currentOrderCount = currentOrders;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Restaurant(String name, Map<String, MenuItem> menu, int maxOrders, int currentOrders, double rating) {
		super();
		this.name = name;
		this.menu = menu;
		this.maxOrders = maxOrders;
		this.currentOrderCount = currentOrders;
		this.rating = rating;
	}
	public Order addOrder(List<OrderItem> orderItems) {
		if(!canCompleteOrder(orderItems)) {
			return null;
		}
		int orderId = UUIDGenerator.getInstance().generateUUID();
		Order newOrder = new Order(orderItems, orderId, OrderStatus.ACCEPTED);
		newOrder.setRestaurant(this);
		currentOrder.add(newOrder);
		return newOrder;
	}
	public boolean canCompleteOrder(List<OrderItem> orderItems) {
		 if(currentOrderCount < maxOrders) {
			 return true;
		 }
		 return false;
	}
}
