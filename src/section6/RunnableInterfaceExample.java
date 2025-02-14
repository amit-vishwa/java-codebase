package section6;

/**
 * Refer:
 * https://qube.udemy.com/course/modern-java-learn-java-8-features-by-coding-it/learn/lecture/10462694#overview
 * Example: Implementing Runnable functional (i.e. single abstract method) interface using Java 8 and prior Java 8
 */
public class RunnableInterfaceExample implements Runnable {

	public void run() {
		System.out.println("6.Inside RunnableInterfaceExample class implementing Runnable interface");
	}

	public static void main(String[] args) {
		implementRunnableInterfaceUsingAnonymousClass();
		implementRunnableInterfaceUsingLambdaExpression();
		implementRunnableInterfaceUsingLambdaExpressions();
		passAnnonymousClassInThread();
		passLambdaExpressionInThread();
		executeRunUsingClassInstance();
	}

	private static void implementRunnableInterfaceUsingAnonymousClass() {
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable() { // annonymous class
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("1.Inside Annonymous class");
			}
		};
		new Thread(runnable).start();
	}

	private static void implementRunnableInterfaceUsingLambdaExpression() {
		// TODO Auto-generated method stub
		Runnable runnable = () -> System.out.println("2.Inside single line lambda expression");
		new Thread(runnable).start();
	}

	private static void implementRunnableInterfaceUsingLambdaExpressions() {
		// TODO Auto-generated method stub
		Runnable runnable = () -> {
			System.out.println("3.Inside multiple line lambda expression");
			System.out.println("3.Inside multiple line lambda expression");
		};
		new Thread(runnable).start();
	}

	private static void passAnnonymousClassInThread() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() { // annonymous
			@Override
			public void run() {
				System.out.println("4.Inside thread using annonymous class");
			}
		}).start();
	}

	private static void passLambdaExpressionInThread() {
		// TODO Auto-generated method stub
		new Thread(() -> System.out.println("5.Inside thread using lambda expression")).start();
	}

	private static void executeRunUsingClassInstance() {
		// TODO Auto-generated method stub
		RunnableInterfaceExample runnable = new RunnableInterfaceExample();
		new Thread(runnable).start();
	}

}
