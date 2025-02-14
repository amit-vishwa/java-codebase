package section12;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * The program demonstrates the use of Of, Iterate and Generate to create
 * streams
 */
public class StreamsCreateOperationsExample {

	public static void main(String[] args) {

		streamsOfExample();
		streamsIterateExample();
		streamsGenerateExample();

	}

	private static void streamsOfExample() {
		// TODO Auto-generated method stub
		Stream<String> stringStreams = Stream.of("Xyz", "Abc", "Pqr");
		stringStreams.forEach(System.out::println);
	}

	private static void streamsIterateExample() {
		// TODO Auto-generated method stub
		// Below will create infinite streams, so limit must be added
//		Stream<Integer> integerStreams = Stream.iterate(1, x -> x*x);
		Stream<Integer> integerStreams = Stream.iterate(1, x -> x * 2).limit(10);
		integerStreams.forEach(System.out::println);
	}

	private static void streamsGenerateExample() {
		// TODO Auto-generated method stub
		// Below will create infinite streams, so limit must be added
//		Stream<Integer> integerStreams = Stream.generate(() -> 2 * 2);
//		Supplier<Integer> supplier = () -> {
//			Random random = new Random();
//			return random.nextInt();
//		};
		Supplier<Integer> supplier = new Random()::nextInt;
		Stream<Integer> integerStreams = Stream.generate(supplier).limit(10);
		integerStreams.forEach(System.out::println);

	}

}
