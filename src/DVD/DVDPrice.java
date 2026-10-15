package DVD;

public enum DVDPrice {

	NEW(150),
	NORAML(100),
	OlD(50);
	
	private int price;
	
	DVDPrice(int price) {
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}
}
