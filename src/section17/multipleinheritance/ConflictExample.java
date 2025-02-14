package section17.multipleinheritance;

/**
 * While implementing multiple interfaces, if they have same methods then there
 * is a conflict and compiler fails to decide which method to call. In such
 * cases the conflicting method from interfaces must be overridden to resolve
 * the conflict.
 */
public class ConflictExample implements Interface1, Interface4 {

	@Override
	public void methodA() {
		System.out.println("Inside Method A from " + ConflictExample.class);
		// below will call methodA from Interface1
		Interface1.super.methodA();
	}

	public static void main(String[] args) {
		ConflictExample object = new ConflictExample();
		object.methodA();
	}

}
