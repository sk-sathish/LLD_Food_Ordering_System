package Entity;

public class MenuItem {
	String itemName;
	double price;
	int stock;
	
	public MenuItem(String itemName, double price, int stock) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
