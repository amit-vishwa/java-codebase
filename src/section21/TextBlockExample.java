package section21;

/**
 * Java 15 feature: 
 * TextBlocks are used to write string with as it is. 
 * They start with a new line
 */
public class TextBlockExample {

	public static void main(String args[]) {
		simpleMultiLineExample();
		textBlockMultiLineExample();
		textBlockMultiLineWithArgExample();
		sqlQueryExample();
		jsonStringExample();
	}

	private static void simpleMultiLineExample() {
		var multiline = "This is a\n" 
				+ " multiline string\n" 
				+ "  with new lines inside";
		System.out.println(multiline);
	}

	private static void textBlockMultiLineExample() {
		// spaces can be added or removed
		var textBlock = """
				This is a
				multiline string
				with new lines inside
				""";
		System.out.print(textBlock);
		var textBlock1 = """
				This is a
				 multiline string
				with new lines inside
				""";
		System.out.print(textBlock1);
		var textBlock2 = """
					This is a
					multiline string
					with new lines inside
				""";
		System.out.println(textBlock2);
	}

	private static void textBlockMultiLineWithArgExample() {
		var textBlock = """
				This is %s
				from Mumbai
				writing this code.
				""".formatted("Amit");
		System.out.println(textBlock);
	}

	private static void sqlQueryExample() {
		var sqlQuery = """
				SELECT * FROM Student
				WHERE age = %d
				AND name = "%s"
				""".formatted(28, "Amit");
		System.out.println(sqlQuery);
	}

	private static void jsonStringExample() {
		var jsonString = """
				{
				  "student": {
					"name": "%s",
					"age": %d
				  }
				}
				""".formatted("Amit", 28);
		System.out.println(jsonString);
	}

}
