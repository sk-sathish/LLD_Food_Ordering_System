package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.MenuItem;
import Entity.OrderItem;
import Entity.Restaurant;

public class RestaurantService {
	private List<Restaurant> restaurants;
	private static RestaurantService instance;
	private RestaurantService() {
		restaurants = new ArrayList<Restaurant>();
	}
	public static RestaurantService getInstance() {
		if(instance == null) {
			instance = new RestaurantService();
		}
		return instance;
	}
	public boolean addRestaurant(String restaurantName, List<MenuItem> menuItems, int maxOrder, double rating) {
		//duplicate check
		Restaurant restaurant = new Restaurant(restaurantName, menuItems, maxOrder, rating);
		restaurants.add(restaurant);
		return true;
	}
	public boolean addMenuItem(String restaurantName, MenuItem menuItem) {
		//add menu
		return true;
	}
	public boolean updateMenuItem(String restaurantName, MenuItem menuItem) {
		//update menu item
		return true;
	}
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}
	public List<Restaurant> fetchRestaurantsWithAllOrderItems(List<OrderItem> orderItems){
		List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
		for(Restaurant restaurant: restaurants) {
			Map<String, MenuItem> menu = restaurant.getMenu();
			boolean containsAll = true;
			for(OrderItem orderItem: orderItems) {
				int quantity = 0;
				if(menu.containsKey(orderItem.getName())){
					MenuItem menuItem = menu.get(orderItem.getName());
					quantity = menuItem.getStock();
				}
				if(quantity<orderItem.getQuantity()) {
					containsAll = false;
					break;
				}
			}
			if(containsAll) {
				listOfRestaurants.add(restaurant);
			}
		}
		return listOfRestaurants;
	}
}
