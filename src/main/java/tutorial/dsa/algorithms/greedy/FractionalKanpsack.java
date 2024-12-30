package tutorial.dsa.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Refer: https://www.geeksforgeeks.org/fractional-knapsack-problem/
 *
 * Fractional knapsack algorithm: Find the maximum total value of items that can be placed in the knapsack,
 * allowing fractional inclusion of items.
 *
 * Fractional Knapsack Problem using Greedy algorithm:
 * An efficient solution is to use the Greedy approach.
 * The basic idea of the greedy approach is to calculate the ratio profit/weight for each item and sort the item on the
 * basis of this ratio. Then take the item with the highest ratio and add them as much as we can (can be the whole element
 * or a fraction of it).
 * This will always give the maximum profit because, in each step it adds an element such that this is the maximum possible
 * profit for that much weight.
 *
 * Check the below illustration for a better understanding:
 * Consider the example: arr[] = {{100, 20}, {60, 10}, {120, 30}}, W = 50.
 * Sorting: Initially sort the array based on the profit/weight ratio. The sorted array will be {{60, 10}, {100, 20}, {120, 30}}.
 * Iteration:
 * For i = 0, weight = 10 which is less than W. So add this element in the knapsack. profit = 60 and remaining W = 50 – 10 = 40.
 * For i = 1, weight = 20 which is less than W. So add this element too. profit = 60 + 100 = 160 and remaining W = 40 – 20 = 20.
 * For i = 2, weight = 30 is greater than W. So add 20/30 fraction = 2/3 fraction of the element.
 * Therefore profit = 2/3 * 120 + 160 = 80 + 160 = 240 and remaining W becomes 0.
 * So the final profit becomes 240 for W = 50.
 *
 * Follow the given steps to solve the problem using the above approach:
 * Calculate the ratio (profit/weight) for each item.
 * Sort all the items in decreasing order of the ratio.
 * Initialize res = 0, curr_cap = given_cap.
 * Do the following for every item i in the sorted order:
 * If the weight of the current item is less than or equal to the remaining capacity then add the value of that item into the result
 * Else add the current item as much as we can and break out of the loop.
 * Return res.
 *
 * Time Complexity: O(N * logN)
 * Auxiliary Space: O(N)
 * */
public class FractionalKanpsack {

    public static void main(String[] args)
    {

        ItemValue[] arr = { new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 30) };

        int capacity = 50;

        double maxValue = getMaxValue(arr, capacity);

        // Function call
        System.out.println(maxValue);
    }

    // Item value class
    static class ItemValue {

        int profit, weight;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }

    private static double getMaxValue(ItemValue[] arr, int capacity) {
        double res = 0;
        // Sorting items by profit/weight ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1,
                               ItemValue item2)
            {
                double cpr1 = (double)item1.profit / (double)item1.weight;
                double cpr2 = (double)item2.profit / (double)item2.weight;
                return cpr1 < cpr2 ? 1 : -1;
            }
        });
        for(int i = 0; i < arr.length; i++){
            if(arr[i].weight <= capacity){
                res += arr[i].profit;
                capacity -= arr[i].weight;
            }else{
                double fraction = ((double) capacity / (double) arr[i].weight);
                res += arr[i].profit * fraction;
                capacity -= (int) (arr[i].weight * fraction);
            }
        }
        return res;
    }

}
