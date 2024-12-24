package tutorial.dsa.algorithms.backtracking;

/**
 *
 * Refer: https://www.geeksforgeeks.org/backtracking-algorithms/
 *
 * Backtracking algorithms are like problem-solving strategies that help explore different options to find the
 * best solution. They work by trying out different paths and if one doesn't work, they backtrack and try another
 * until they find the right one. It's like solving a puzzle by testing different pieces until they fit together
 * perfectly.
 *
 *
 * Refer for code:  https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 * Permutations of given String
 * Last Updated : 18 Sep, 2024
 * Given a string S, the task is to write a program to print all permutations of a given string.
 *
 * A permutation also called an “arrangement number” or “order,” is a rearrangement of the elements of an
 * ordered list S into a one-to-one correspondence with S itself. A string of length N has N! permutations.
 *
 * Examples:
 *
 * Input: S = “ABC”
 * Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”
 *
 * Input: S = “XY”
 * Output: “XY”, “YX”
 *
 * Follow the given steps to solve the problem:
 *
 * Create a function permute() with parameters as input string and starting index of the string
 * Call this function with values input string and starting index, idx as 0
 * In this function, if idx becomes size of the string then print the same string
 * Else run a for loop from idx to size – 1 and swap the current element in the for loop with the s[idx]
 * Then again call this same function by increasing the value of idx by 1
 * After that again swap the previously swapped values to initiate backtracking
 *
 * Time Complexity: O(N * N!) Note that there are N! permutations and it requires O(N) time to print
 * a permutation.
 * Auxiliary Space: O(N)
 * */
public class StringPermutations {
    static void swap(StringBuilder string, int index1, int index2){
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }
    static void permute(StringBuilder string, int index){
        // Base case
        if(index == string.length() - 1){
            System.out.println(string);
            return;
        }
        for(int i = index; i < string.length(); i++){
            // Swapping
            swap(string, index, i);
            // First idx+1 characters fixed
            permute(string, index+1);
            // Backtrack
            swap(string, index, i);
        }
    }
    public static void main(String... args){
        permute(new StringBuilder("ABC"),0);
    }
}
