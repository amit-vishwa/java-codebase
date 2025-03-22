package reflection.section3.codingExercise;

public class Test {

    public static void main(String[] args) {
        AccountSummary accountSummary = new AccountSummary("John", "Smith", (short) 20, 100_000);
        ObjectSizeCalculator objectSizeCalculator = new ObjectSizeCalculator();
        System.out.println(objectSizeCalculator.sizeOfObject(accountSummary));
    }

    public static class AccountSummary {
        private final String firstName;
        private final String lastName;
        private final short age;
        private final int salary;

        public AccountSummary(String firstName, String lastName, short age, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
        }
    }
}
