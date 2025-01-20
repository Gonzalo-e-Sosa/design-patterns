package design_patterns.creational.builder;

public interface Builder {
	void reset();
	void setId(String id);
	void setName(String name);
	void setPrice(Double price);
}