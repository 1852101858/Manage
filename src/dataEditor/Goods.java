package dataEditor;
 public class Goods {
	private int id;
	private String name; 
	private String location; 
	private float num;
	private float price;
	private String date;

	public Goods() {
		super();
	}
	
	public Goods(int id, String name, String location, Float num,float price,String date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.num = num;
		this.price = price;
		this.date=date;
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

	 public String getDate() {
		 return date;
	}
 }
