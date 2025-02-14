package interview;

public class Test extends TestChild {

	@Override // default access can be equal to parent in same package
	Integer getAge() {
		return 30;
	}
	
//	@Override // access cannot be less than parent
//	private String getCity() {
//		return "Mumbai";
//	}
	
}
