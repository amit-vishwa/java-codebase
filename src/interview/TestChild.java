package interview;

import interview.test.TestParent;

public class TestChild extends TestParent {

	@Override // access can be higher than parent
	public String getName() {
		return "Raja";
	}
	
	@Override // access can be equal to parent
	public String getGender() {
		return "Male";
	}
	
	protected String getCity() {
		return "Mumbai";
	}
	
	Integer getAge() {
		return 28;
	}
	
}
