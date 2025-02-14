package section25;

public class AnimalService {

	// using type pattern
	public String retrieveName(Animal animal) {
		return switch (animal) {
		case null -> "none";
		case Cat cat -> cat.name();
		case Dog dog -> dog.name();
		};
	}

	// using record pattern
	public String retrieveNameAndColor(Animal animal) {
		return switch (animal) {
		case null -> "none"; // this is not mandatory but should be added to handle NPE
		// direct record can be used instead of casting and binding variable
		case Cat(String name, String color) -> name + color;
		case Dog(String name, String color) -> name + color;
		};
	}

	// using guarded pattern
	public String retrieveData(Animal animal) {
		return switch (animal) {
		case null -> "none"; // this handled null pointer exception
		// added more checks in guarded pattern
		case Cat(String name, String color) when name == null -> "none";
		case Cat(String name, String color) -> name;
		case Dog(String name, String color) when color == null -> "transparent";
		case Dog(String name, String color) -> color;
		};
	}

}
