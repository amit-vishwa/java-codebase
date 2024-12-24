package tutorial.dsa.algorithms.bitwise;

/**
 *
 * Refer: https://www.geeksforgeeks.org/bit-tricks-competitive-programming/
 *
 * */
public class CharCaseConversion {
    public static void main(String... args){
        char ch = 'S';

        /**
         * 8) Upper case English alphabet to lower case
         * ch |= ' ';
         * Logic: The bit representation of upper case and lower case English alphabets are –
         *
         * A -> 01000001          a -> 01100001
         * B -> 01000010          b -> 01100010
         * C -> 01000011          c -> 01100011
         *   .                               .
         *   .                               .
         * Z -> 01011010          z -> 01111010
         * As we can see if we set 5th bit of upper case characters, it will be converted into lower case character. We have to prepare a mask having 5th bit 1 and other 0 (00100000). This mask is bit representation of space character (‘ ‘). The character ‘ch’ then OR with mask.
         * Example:
         * ch = ‘A’ (01000001)
         * mask = ‘ ‘ (00100000)
         * ch | mask = ‘a’ (01100001)
         * Please refer Case conversion (Lower to Upper and Vice Versa) for details.
         * */
        System.out.println("Character: "+ch+", Upper to Lower: "+(ch |= ' '));

        /**
         * 9) Lower case English alphabet to upper case
         * ch &= '_’ ;
         * Logic: The bit representation of upper case and lower case English alphabets are –
         *
         * A -> 01000001                a -> 01100001
         * B -> 01000010                b -> 01100010
         * C -> 01000011                c -> 01100011
         * .                               .
         * .                               .
         * Z -> 01011010                z -> 01111010
         * As we can see if we clear 5th bit of lower-case characters, it will be converted into upper case character. We have to prepare a mask having 5th bit 0 and other 1 (11011111). This mask is bit representation of underscore character (‘_‘). The character ‘ch’ then AND with mask.
         * Example:
         * ch = ‘a’ (01100001)
         * mask = ‘_ ‘ (11011111)
         * ch & mask = ‘A’ (01000001)
         * Please refer Case conversion (Lower to Upper and Vice Versa) for details.
         * */
        ch = 'a';
        System.out.println("Character: "+ch+", Lower to Upper: "+(ch &= '_'));
    }
}
