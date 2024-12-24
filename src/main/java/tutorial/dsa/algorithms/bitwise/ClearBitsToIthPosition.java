package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * */
public class ClearBitsToIthPosition {
    public static void main(String... args){
        int num = 254300;
        int i = 14;
        System.out.println("Number: "+num+", Position: "+i+"\n");
        clearLSBToIthBit(num, i);
        System.out.println();
        clearMSBToIthBit(num, i);
    }

    /**
     * 4) Clear all bits from LSB to ith bit
     * mask = ~((1 << i+1 ) - 1);
     * x &= mask;
     * Logic:
     * To clear all bits from LSB to i-th bit, we have to AND x with mask having LSB to i-th bit 0. To obtain such mask, first left shift 1 i times. Now if we minus 1 from that, all the bits from 0 to i-1 become 1 and remaining bits become 0. Now we can simply take the complement of mask to get all first i bits to 0 and remaining to 1.
     * Example:–
     * x = 29 (00011101) and we want to clear LSB to 3rd bit, total 4 bits
     * mask -> 1 << 4 -> 16(00010000)
     * mask -> 16 – 1 -> 15(00001111)
     * mask -> ~mask -> 11110000
     * x & mask -> 16 (00010000)
     * */
    private static void clearLSBToIthBit(int num, int i){
        int mask = ~((1 << i+1 ) - 1);
        System.out.println(num +" "+Integer.toBinaryString(num));
        System.out.println(mask +" "+Integer.toBinaryString(mask));
        num &= mask;
        System.out.println(num +" "+Integer.toBinaryString(num));
    }

    /**
     * 5) Clearing all bits from MSB to i-th bit
     * mask = (1 << i) - 1;
     * x &= mask;
     * Logic:
     * To clear all bits from MSB to i-th bit, we have to AND x with mask having MSB to i-th bit 0. To obtain such mask, first left shift 1 i times. Now if we minus 1 from that, all the bits from 0 to i-1 become 1 and the remaining bits become 0.
     * Example:
     * x = 215 (11010111) and we want to clear MSB to 4th bit, total 4 bits
     * mask -> 1 << 4 -> 16(00010000)
     * mask -> 16 – 1 -> 15(00001111)
     * x & mask -> 7(00000111)
     * */
    private static void clearMSBToIthBit(int num, int i){
        int mask = (1 << i) - 1;
        System.out.println(num +" "+Integer.toBinaryString(num));
        System.out.println(mask +" "+Integer.toBinaryString(mask));
        num &= mask;
        System.out.println(num +" "+Integer.toBinaryString(num));
    }
}
