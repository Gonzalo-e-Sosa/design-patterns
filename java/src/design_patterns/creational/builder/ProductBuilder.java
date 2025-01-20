package design_patterns.creational.builder;

class Product{
	private String id = "";
	private String name = "";
	private double price = 0;
	
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
		this.name= name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws Exception {
		if(price <= 0) 
			throw new Exception("Price must be greater than 0.");
		this.price = price;
	}
	
	public String toString() {
		return "[Product]: { id: " + this.id + ", name: " + this.name + ", price: " + this.price + " }";
	}
}

public class ProductBuilder implements Builder{
	private Product result = null;
	
	Product getResult() {
		Product product = this.result;
		this.reset();
		return product;
	}

	@Override
	public void reset() {
		this.result = new Product();
	}

	@Override
	public void setId(String id)  {
		this.result.setId(id);
	}
	
	@Override
	public void setName(String name) {
		this.result.setName(name);
	}
	
	@Override
	public void setPrice(Double price) {
		try {
			this.result.setPrice(price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
