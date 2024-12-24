package tutorial.java.operators;

class AssignmentOperatorExample {
    public static void main(String[] args)
    {
        int num1 = 5, num2 = 3;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num1 += num2 = " + (num1 += num2));
        System.out.println("num1 -= num2 = " + (num1 -= num2));
        System.out.println("num1 *= num2 = " + (num1 *= num2));
        System.out.println("num1 /= num2 = " + (num1 /= num2));
        System.out.println("num1 %= num2 = " + (num1 %= num2));
    }
}
