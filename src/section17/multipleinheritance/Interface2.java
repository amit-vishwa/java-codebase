package section17.multipleinheritance;

public interface Interface2 extends Interface1 {

	default void methodB() {
		System.out.println("Inside Method B of " + Interface2.class);
	}

	// this will take preference before Interface1 method call
	default void methodA() {
		System.out.println("Inside Method A of " + Interface2.class);
	}

}
