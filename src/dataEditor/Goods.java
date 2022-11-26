package dataEditor;
 public class Goods {
	private int id;
	private String name; 
	private String location; 
	private float num;
	private float price; 

	public Goods() {
		super();
	}
	
	public Goods(int id, String name, String location, Float num,float price) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.num = num;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public float getNum() {
		return num;
	}
	public float getPrice() {
		return price;
	}
	public float getTprice() {
		return num*price;
	}
}
