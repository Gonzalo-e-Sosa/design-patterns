package design_patterns.creational.builder;

public class BuilderExample {
	public static void main(String[] args) {
		System.out.println("\n" + "BUILDER" + "\n");
		ProductBuilder productBuilder = new ProductBuilder();
		Director director = new Director(productBuilder);
	
		System.out.println("Creando producto simple...");
		director.makeSimple();
		Product simple = productBuilder.getResult();

		System.out.println("Creando producto coca cola...");	
		director.makeCocaCola(2500.00);	
		Product cocaCola = productBuilder.getResult();
		
		System.out.println(simple);
		System.out.println(cocaCola);
	}
}
