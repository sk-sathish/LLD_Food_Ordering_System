import java.util.ArrayList;
import java.util.List;

import Entity.MenuItem;
import Entity.OrderItem;
import Service.OrderService;
import Service.RestaurantService;

public class FoodOrderingSystemTester {
	public void runTester() {
		RestaurantService service = RestaurantService.getInstance();
		String restaurant[] = new String[4];
		String menuItemName[][] = new String[4][];
		double menuItemCost[][] = new double[4][];
		restaurant[0] = "Annapoorna";
		menuItemName[0] = new String[]{"Paneer Butter Masala", "Pani Poori", "Ghee Dosa", "Ven Pongal", "Idly", "Dosa"};
		menuItemCost[0] = new double[]{100, 50, 70, 60, 20, 65};
		restaurant[1] = "Anandhas";
		menuItemName[1] = new String[]{"Paneer Butter Masala", "Pani Poori", "Ghee Dosa", "Sakara Pongal", "Idly", "Dosa"};
		menuItemCost[1] = new double[]{100, 40, 60, 50, 15, 65};
		restaurant[2] = "Aryaas";
		menuItemName[2] = new String[]{"Paneer Butter Masala", "Pani Poori", "Podi Dosa", "Ven Pongal", "Idly", "Dosa", "Masala Dosa"};
		menuItemCost[2] = new double[]{100, 40, 75, 65, 25, 55, 80};
		restaurant[3] = "RHR";
		menuItemName[3] = new String[]{"Paneer Butter Masala", "Pani Poori", "Ghee Dosa", "Ven Pongal", "Idly", "Dosa", "Podi Idly"};
		menuItemCost[3] = new double[]{100, 50, 60, 80, 20, 65, 90};
		for(int i=0;i<4;i++) {
			String name = restaurant[i];
			List<MenuItem> list = new ArrayList<MenuItem>();
			for(int j=0;j<menuItemName[i].length;j++) {
				MenuItem menuItem = new MenuItem(menuItemName[i][j], menuItemCost[i][j], 5);
				list.add(menuItem);
			}
			service.addRestaurant(name, list, 3, i+1);
		}
		String lowCost = "Low Cost";
		String highRating = "High Rating";
		String itemNames[][] = new String[4][];
		int quantities[][] = new int[4][];
		itemNames[0] = new String[]{"Ghee Dosa", "Ven Pongal"};
		quantities[0] = new int[] {3,3};
		itemNames[1] = new String[]{"Podi Dosa", "Ven Pongal"};
		quantities[1] = new int[] {1,2};
		itemNames[2] = new String[] {"Paneer Butter Masala", "Pani Poori"};
		quantities[2] = new int[] {1,1};
		itemNames[3] = new String[] {"Ven Pongal", "Idly", "Dosa", "Masala Dosa"};
		quantities[3] = new int[] {2,2,2,2};
		OrderService orderService = OrderService.getInstance();
		for(int i=0;i<4;i++) {
			List<OrderItem> list = new ArrayList<OrderItem>();
			for(int j=0;j<itemNames[i].length;j++) {
				list.add(new OrderItem(itemNames[i][j], quantities[i][j]));
			}
			try {
				orderService.placeOrder(list, i%2==0?lowCost :highRating);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
