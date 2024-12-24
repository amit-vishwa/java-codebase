package tutorial.dsa.algorithms.recursion;

/**
 *
 * Refer: https://www.geeksforgeeks.org/introduction-to-recursion-2/, https://geeksforgeeks.org/tail-recursion/
 *
 * What is Recursion?
 * The process in which a function calls itself directly or indirectly is called recursion and the corresponding
 * function is called a recursive function. Using a recursive algorithm, certain problems can be solved quite
 * easily. Examples of such problems are Towers of Hanoi (TOH), Inorder/Preorder/Postorder Tree Traversals, DFS
 * of Graph, etc. A recursive function solves a particular problem by calling itself with different parameters to
 * solve smaller subproblems of the original problem. The called function may further call itself and this process
 * might continue forever. So it is essential to know that we should provide a certain case in order to terminate
 * this recursion process. We can say that every time the function calls itself with a simpler version of the
 * original problem and moves toward the termination case or base case.
 *
 * How are recursive functions stored in memory?
 * Recursion uses more memory, because the recursive function adds to the stack with each recursive call, and keeps
 * the values there until the call is finished. The recursive function uses LIFO (LAST IN FIRST OUT) Structure
 * just like the stack data structure.
 *
 * What is the base condition in recursion?
 * In the recursive program, the solution to the base (termination) case is provided and the solution to the bigger problem is
 * expressed in terms of smaller problems.
 *
 * What is the difference between direct and indirect recursion?
 * A function fun is called direct recursive if it calls the same function fun. A function fun is called indirect
 * recursive if it calls another function say fun_new and fun_new calls fun directly or indirectly.
 *
 * What is Tail and Non-tail Recursion?
 * Tail recursion has defined as a recursive function in which the recursive call is the last statement that is
 * executed by the function. So basically nothing is left to execute after the recursion call.
 * A non-tail recursion is defined as a recursive function in which the recursive call is not the last statement
 * that is executed by function, there are still some statements left to be executed.
 *
 * How memory is allocated to different function calls in recursion?
 * When any function is called from main(), the memory is allocated to it on the stack. A recursive function calls
 * itself, the memory for a called function has allocated on top of memory allocated to the calling function and a
 * different copy of local variables are created for each function call. When the base case has reached, the
 * function returns its value to the function by whom it is called and memory is de-allocated and the process continues.
 *
 * */
public class RecursionExample {
    public static void main(String... args){
        System.out.println("1.Direct recursion example (factorial of numbers):");
        directRecursionExample();
        System.out.println();
        System.out.println("2.Indirect recursion example (submission of numbers):");
        indirectRecursionExample();
    }

    static void directRecursionExample(){
        System.out.print("i.Tailored recursion example: ");
        System.out.println(tailoredRecursionExample(10, 1));
        System.out.print("ii.Non-tailored recursion example: ");
        System.out.println(" => " + nonTailoredRecursionExample(5));
    }

    static int nonTailoredRecursionExample(int n){
        System.out.print(n + " ");
        if(n < 2){
            return n;
        }
        return n * nonTailoredRecursionExample(n - 1);
    }

    static int tailoredRecursionExample(int n, int res){
        System.out.print(n + ", " + res + " | ");
        if(n < 2){
            return res;
        }
        return tailoredRecursionExample(n - 1, n * res);
    }

    static void indirectRecursionExample(){
        // Output comes after solving bracket operations first as recursion creates new brackets
        System.out.println("Sum of 10 numbers: " + recursiveFunctionOne(10));
    }

    static int recursiveFunctionOne(int n){
        System.out.println("recursiveFunctionOne() called with value: " + n);
        if(n < 1){
            return n;
        }
        return n + recursiveFunctionTwo(n-1);
    }

    static int recursiveFunctionTwo(int n){
        System.out.println("recursiveFunctionTwo() called with value: " + n);
        return n - recursiveFunctionOne(n-1);
    }

}
