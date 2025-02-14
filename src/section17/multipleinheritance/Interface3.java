package section17.multipleinheritance;

public interface Interface3 {

	default void methodC() {
		System.out.println("Inside Method C of " + Interface3.class);
	}

}
