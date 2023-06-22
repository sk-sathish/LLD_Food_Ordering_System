package Service;

import java.util.List;
import java.util.Map;

import Entity.MenuItem;
import Entity.OrderItem;
import Entity.Restaurant;
import Exception.NoRestaurantException;
import Interface.IRestaurantSelectionStrategy;

public class LowCostRestaurantStrategy implements IRestaurantSelectionStrategy{
	private static LowCostRestaurantStrategy instance;
	private LowCostRestaurantStrategy() {

	}
	public static LowCostRestaurantStrategy getInstance() {
		if(instance == null) {
			instance = new LowCostRestaurantStrategy();
		}
		return instance;
	}
	@Override
	public Restaurant getRestaurant(List<OrderItem> orderItems) throws NoRestaurantException {
		RestaurantService restaurantService = RestaurantService.getInstance();
		List<Restaurant> listOfRestaurants = restaurantService.fetchRestaurantsWithAllOrderItems(orderItems);
		if(listOfRestaurants.isEmpty()) {
			throw new NoRestaurantException("No Restaurant available matching the given order");
		}
		double lowestPrice = Double.MAX_VALUE;
		Restaurant lowCostRestaurant = null;
		for(Restaurant restaurant: listOfRestaurants) {
			double total = 0;
			Map<String, MenuItem> menu = restaurant.getMenu();
			for(OrderItem orderItem: orderItems) {
				MenuItem menuItem = menu.get(orderItem.getName());
				int availableQuantity = menuItem.getStock();
				int requiredQuantity = orderItem.getQuantity();
				menuItem.setStock(availableQuantity-requiredQuantity);
				total += requiredQuantity*menuItem.getPrice();
				if(total < lowestPrice) {
					lowestPrice = total;
					lowCostRestaurant = restaurant;
				}
			}
		}
		if(lowCostRestaurant == null) {
			throw new NoRestaurantException("No Restaurant available matching the given order");
		}
		return lowCostRestaurant;
	}
}
