package Service;

import Exception.NoSuchStrategyException;
import Interface.IRestaurantSelectionStrategy;

public class RestaurantStrategyService {
	private static RestaurantStrategyService instance;
	private RestaurantStrategyService() {

	}
	public static RestaurantStrategyService getInstance() {
		if(instance == null) {
			instance = new RestaurantStrategyService();
		}
		return instance;
	}
	public IRestaurantSelectionStrategy getRestaurantSelectionStrategy(String strategy) throws NoSuchStrategyException {
		if(strategy.equals("Low Cost")) {
			return LowCostRestaurantStrategy.getInstance();
		}
		else if(strategy.equals("High Rating")) {
			return HighRatingRestaurantStrategy.getInstance();
		}
		throw new NoSuchStrategyException("No such booking strategy ");
	}
}
