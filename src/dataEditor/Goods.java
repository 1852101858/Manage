package dataEditor;
 public class Goods {
	private String id; 
	private String name; 
	private String location; 
	private float num; 
	private String unit; 
	private float price; 
	private float tprice; 

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
		this.tprice = price*num;
	} 
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTprice() {
		return tprice;
	}
	public void setTprice(float tprice) {
		this.tprice = tprice;
	}
}
