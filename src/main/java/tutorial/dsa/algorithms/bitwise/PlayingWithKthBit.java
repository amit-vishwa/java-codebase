package tutorial.dsa.algorithms.bitwise;

/**
 * Refer : https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 * */
public class PlayingWithKthBit {
    public static void main(String... args){
        int num = 127;
        int k = 2;
        int res = 0;
        System.out.println(num +" "+Integer.toBinaryString(num) +" "+k);
        res = turnOffKthBit(num,k);
        System.out.println(res +" "+Integer.toBinaryString(res));
        res = turnOnKthBit(64,k);
        System.out.println(res +" "+Integer.toBinaryString(res));
        System.out.println(isKthBitSet(64,k));
        res = toggleKthBit(127,k);
        System.out.println(127 +" "+Integer.toBinaryString(res));
    }
    // 1) Turn Off kth bit in a number
    private static int turnOffKthBit(int n, int k) {
        return n & ~(1 << (k - 1));
    }
    // 2) Turn On kth bit in a number
    private static int turnOnKthBit(int n, int k) {
        return n | (1 << (k - 1));
    }
    // 3) Check if kth bit is set for a number
    private static boolean isKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }
    // 4) Toggle the kth bit
    private static int toggleKthBit(int n, int k) {
        return n ^ (1 << (k - 1));
    }
}
