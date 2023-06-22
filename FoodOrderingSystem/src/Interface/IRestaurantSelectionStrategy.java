package Interface;

import java.util.List;

import Entity.OrderItem;
import Entity.Restaurant;

public interface IRestaurantSelectionStrategy {
	public Restaurant getRestaurant(List<OrderItem> orderItems) throws Exception;
}
