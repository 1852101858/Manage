package dataEditor;
 public class Goods {
	private String id; 
	private String name; 
	private String location; 
	private float num; 
	private String unit; 
	private float price; 

	public Goods() {
		super();
	}
	
	public Goods(String id, String name, String location, Float num, String unit ,float price) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.num = num;
		this.unit = unit;
		this.price = price;
	}

	public String getId() {
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
	public String getUnit() {
		return unit;
	}
	public float getPrice() {
		return price;
	}
	public float getTprice() {
		return num*price;
	}
}
