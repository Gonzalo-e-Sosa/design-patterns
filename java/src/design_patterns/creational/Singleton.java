package design_patterns.creational;

//Única instancia (acceso global)
//- No respeta el principio SOLID de responsabilidad única
public class Singleton{
	public static void main(String[] args) {
		EagerInitializedSingleton.example(args);
		StaticBlockSingleton.example(args);
		LazyInitializedSingleton.example(args);
	}
}

class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // Constructor privado para evitar que sea creado público y utilizado
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
    
    public static void example(String[] args) {
		System.out.println("\n" + "SINGLETON con inicialización eager" + "\n");
		
		System.out.println("Obteniendo instancia...");
		EagerInitializedSingleton singleton = EagerInitializedSingleton.getInstance();
		System.out.println("Obteniendo instancia...");
		EagerInitializedSingleton anotherSingleton = EagerInitializedSingleton.getInstance();
		
		System.out.println("Valor: " + singleton);
        System.out.println("Valor: " + anotherSingleton);
    }
}

class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // Bloque estático de inicialización para manejar excepciones
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
    
    public static void example(String[] args) {
		System.out.println("\n" + "SINGLETON con static block" + "\n");
		
		System.out.println("Obteniendo instancia...");
		StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
		System.out.println("Obteniendo instancia...");
		StaticBlockSingleton anotherSingleton = StaticBlockSingleton.getInstance();
		
		System.out.println("Valor: " + singleton);
        System.out.println("Valor: " + anotherSingleton);
	}
}

class LazyInitializedSingleton{
	private static LazyInitializedSingleton instance;
		
	private LazyInitializedSingleton() {};
	
	public static LazyInitializedSingleton getInstance(){
		if(instance == null) {
			instance = new LazyInitializedSingleton();
		}
		
		return instance;
	}
	
	public static void example(String[] args) {
		System.out.println("\n" + "SINGLETON con inicialización lazy" + "\n");
		
		System.out.println("Obteniendo instancia...");
		LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
		System.out.println("Obteniendo instancia...");
		LazyInitializedSingleton anotherSingleton = LazyInitializedSingleton.getInstance();
		
		System.out.println("Valor: " + singleton);
        System.out.println("Valor: " + anotherSingleton);
	}
}

class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
