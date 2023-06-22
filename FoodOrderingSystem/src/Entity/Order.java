package Entity;

import java.util.List;

public class Order {
	private List<OrderItem> orderItem;
	private int orderId;
	private OrderStatus status;
	private Restaurant restaurant;
	
	public Order(List<OrderItem> orderItem, int orderId, OrderStatus status) {
		super();
		this.orderItem = orderItem;
		this.orderId = orderId;
		this.status = status;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
