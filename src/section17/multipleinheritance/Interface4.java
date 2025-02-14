package section17.multipleinheritance;

public interface Interface4 {

	default void methodA() {
		System.out.println("Inside Method A of " + Interface4.class);
	}

}
