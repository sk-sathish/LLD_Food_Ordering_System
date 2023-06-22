package Service;

import java.util.ArrayList;
import java.util.List;

import Entity.Order;
import Entity.OrderItem;
import Entity.Restaurant;
import Exception.RestaurantBusyException;
import Interface.IRestaurantSelectionStrategy;

public class OrderService {
	private List<Order> orders;
	private static OrderService instance;
	private OrderService() {
		orders = new ArrayList<Order>();
	}
	public static OrderService getInstance() {
		if(instance == null) {
			instance = new OrderService();
		}
		return instance;
	}
	public void placeOrder(List<OrderItem> orderItems, String restaurantSectionStrategy) throws Exception {
		IRestaurantSelectionStrategy strategy = RestaurantStrategyService.getInstance().getRestaurantSelectionStrategy(restaurantSectionStrategy);
		Restaurant restaurant = strategy.getRestaurant(orderItems);
		Order order = restaurant.addOrder(orderItems);
		if(order == null) {
			throw new RestaurantBusyException("Restaurant Busy, Please try after sometime");
		}
		else {			
			orders.add(order);
			System.out.println("Order placed with order id - "+order.getOrderId()+" at "+order.getRestaurant().getName());
		}
	}
}
