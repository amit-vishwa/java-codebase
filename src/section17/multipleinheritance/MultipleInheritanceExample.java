package section17.multipleinheritance;

/**
 * Multiple interfaces can be implemented to achieve multiple inheritance. If
 * child class is implementing the default method from parent interface then
 * compiler will give preference to overridden method. If child interface is
 * implementing the default method from parent interface then compiler will give
 * preference to overridden method. The least preference will be given to
 * default method in interface
 */
public class MultipleInheritanceExample implements Interface1, Interface2, Interface3 {

//	@Override // this will take 1st preference
//	public void methodA() {
//		System.out.println("Inside Method A of " + MultipleInheritanceExample.class);
//	}

	public static void main(String[] args) {
		MultipleInheritanceExample object = new MultipleInheritanceExample();
		object.methodA();
		object.methodB();
		object.methodC();
	}

}
