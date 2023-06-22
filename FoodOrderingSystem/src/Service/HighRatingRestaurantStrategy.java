package Service;

import java.util.List;

import Entity.OrderItem;
import Entity.Restaurant;
import Exception.NoRestaurantException;
import Interface.IRestaurantSelectionStrategy;

public class HighRatingRestaurantStrategy implements IRestaurantSelectionStrategy{
	private static HighRatingRestaurantStrategy instance;
	private HighRatingRestaurantStrategy() {

	}
	public static HighRatingRestaurantStrategy getInstance() {
		if(instance == null) {
			instance = new HighRatingRestaurantStrategy();
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
		double highestRating = 0;
		Restaurant highestRatingRestaurant = null;
		for(Restaurant restaurant: listOfRestaurants) {
			double restaurantRating = restaurant.getRating();
			if(highestRating < restaurantRating) {
				highestRatingRestaurant = restaurant;
				highestRating = restaurantRating;
			}
		}
		if(highestRatingRestaurant == null) {
			throw new NoRestaurantException("No Restaurant available matching the given order");
		}
		return highestRatingRestaurant;
	}
}

