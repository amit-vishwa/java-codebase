package section17.multipleinheritance;

public interface Interface1 {

	default void methodA() {
		System.out.println("Inside Method A of " + Interface1.class);
	}

}
