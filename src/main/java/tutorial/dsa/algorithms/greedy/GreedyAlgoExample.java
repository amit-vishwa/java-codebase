package tutorial.dsa.algorithms.greedy;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-greedy-algorithm-data-structures-and-algorithm-tutorials/
 *
 * Example:
 * Let’s say you have a set of coins with values [1, 2, 5, 10] and you need to give minimum number of coin to someone change for 39.
 *
 * The greedy algorithm for making change would work as follows:
 * Step-1: Start with the largest coin value that is less than or equal to the amount to be changed. In this case, the largest coin less than or equal to 39 is 10.
 * Step- 2: Subtract the largest coin value from the amount to be changed, and add the coin to the solution. In this case, subtracting 10 from 39 gives 29, and we add one 10-coin to the solution.
 * Repeat steps 1 and 2 until the amount to be changed becomes 0.
 *
 * The greedy algorithm is not always the optimal solution for every optimization problem,
 * as shown in the example below.
 * - When using the greedy approach to make change for the amount 20 with the coin denominations [18, 1, 10],
 * the algorithm starts by selecting the largest coin value that is less than or equal to the target amount.
 * - In this case, the largest coin is 18, so the algorithm selects one 18 coin. After subtracting 18 from 20,
 * the remaining amount is 2.
 * - At this point, the greedy algorithm chooses the next largest coin less than or equal to 2, which is 1.
 * - It then selects two 1 coins to make up the remaining amount. So, the greedy approach results in using
 * one 18 coin and two 1 coins.
 * - However, the greedy approach fails to find the optimal solution in this case. Although it uses three
 * coins, a better solution would have been to use two 10 coins, resulting in a total of only two coins
 * (10 + 10 = 20).
 * */
public class GreedyAlgoExample {
    static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int res = 0;

        // Start from the coin with highest denomination
        for (int i = n - 1; i >= 0; i--) {
            if (amount >= coins[i]) {

                // Find the maximum number of ith coin we can use
                int cnt = (amount / coins[i]);

                // Add the count to result
                res += cnt;

                // Subtract the corresponding amount from
                // the total amount
                amount -= (cnt * coins[i]);
            }

            // Break if there is no amount left
            if (amount == 0)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 10, 1};
        int amount = 39;
        System.out.println(minCoins(coins, amount));
        int[] newCoins = {18, 1, 10};
        int newAmount = 20;
        System.out.println(minCoins(newCoins, newAmount));
    }
}
