package design_patterns.creational.builder;

import java.util.Date;

public class Director {
	private Builder builder;
		
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void changeBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public void makeSimple() {
		this.builder.reset();
		this.builder.setId("" + (new Date().getTime()));
	}
	
	public void makeCocaCola(Double price) {
		this.builder.reset();
		this.builder.setId("" + (new Date().getTime()));
		this.builder.setName("Coca-Cola");
		this.builder.setPrice(price);	
	}
}
