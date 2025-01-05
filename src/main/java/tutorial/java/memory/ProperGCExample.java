package tutorial.java.memory;

/**
 * Refer: https://www.geeksforgeeks.org/garbage-collection-java/?ref=next_article
 *
 * Garbage collection in Java is an automatic memory management process that helps Java programs run efficiently. Java programs
 * compile to bytecode that can be run on a Java Virtual Machine (JVM). When Java programs run on the JVM, objects in the heap,
 * which is a portion of memory dedicated to the program. Eventually, some objects will no longer be needed. The garbage collector
 * finds these unused objects and deletes them to free up memory.
 *
 * In C/C++, programmers have to manually create and delete objects, which can sometimes lead to memory leaks and errors when
 * there isn’t enough memory available. This happens when unused objects are not deleted properly.
 *
 * Real-World Example
 * Let’s take a real-life example, where we use the concept of the garbage collector.
 *
 * Question: Suppose you go for the internship at GeeksForGeeks, and you were told to write a program to count the number of employees working in the company(excluding interns). To make this program, you have to use the concept of a garbage collector.
 *
 * This is the actual task you were given at the company:
 *
 * Write a program to create a class called Employee having the following data members.
 *
 * 1. An ID for storing unique id allocated to every employee.
 * 2. Name of employee.
 * 3. Age of an employee.
 *
 * Also, provide the following methods:
 *
 * A parameterized constructor to initialize name and age. The ID should be initialized in this constructor.
 * A method show() to display ID, name, and age.
 * A method showNextId() to display the ID of the next employee.
 *
 *
 * Now garbage collector will see 2 objects free. Now to decrement nextId, garbage collector will call method to finalize() only
 * when we programmers have overridden it in our class. And as mentioned previously, we have to request garbage collector, and
 * for this, we have to write the following 3 steps before closing brace of sub-block.
 * Set references to null(i.e X = Y = null;)
 * Call, System.gc();
 * Call, System.runFinalization();
 * */
public class ProperGCExample {

    public static void main(String[] args) {

        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);
        E.show();
        F.show();
        G.show();
        E.showNextId();
        F.showNextId();
        G.showNextId();

        {
            // It is sub block to keep
            // all those interns.
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
            X = Y = null;
            System.gc();
            System.runFinalization();
        }
        E.showNextId();
    }

}

// Correct code to count number
// of employees excluding interns.
class Employee {

    private int ID;
    private String name;
    private int age;
    private static int nextId = 1;
    // it is made static because it
    // is keep common among all and
    // shared by all objects

    public Employee(String name, int age) {

        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }

    public void show()
    {
        System.out.println("Id=" + ID + "\nName=" + name
                + "\nAge=" + age);
    }

    public void showNextId()
    {
        System.out.println("Next employee id will be="
                + nextId);
    }

    protected void finalize()
    {
        --nextId;
        // In this case,
        // gc will call finalize()
        // for 2 times for 2 objects.
    }
}
