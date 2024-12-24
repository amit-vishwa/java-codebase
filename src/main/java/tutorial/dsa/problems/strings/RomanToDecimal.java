package tutorial.dsa.problems.strings;

import java.util.HashMap;

/**
 * Refer: https://www.geeksforgeeks.org/problems/roman-number-to-integer3201/1
 * */
public class RomanToDecimal {

    public static void main(String... args){
        System.out.println(romanToDecimal("XIV"));
        System.out.println(romanToDecimal("MMDCCCXCIII"));
        System.out.println(romanToDecimal("MIC"));
        System.out.println(romanToDecimals("XIV"));
        System.out.println(romanToDecimals("MMDCCCXCIII"));
        System.out.println(romanToDecimals("MIC"));
    }

    static int romanToDecimal(String s) {
        // code here
        int decimal = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    decimal++;
                    break;
                case 'V':
                    decimal = getValue(decimal, i, 5, s);
                    break;
                case 'X':
                    decimal = getValue(decimal, i, 10, s);
                    break;
                case 'L':
                    decimal = getValue(decimal, i, 50, s);
                    break;
                case 'C':
                    decimal = getValue(decimal, i, 100, s);
                    break;
                case 'D':
                    decimal = getValue(decimal, i, 500, s);
                    break;
                case 'M':
                    decimal = getValue(decimal, i, 1000, s);
                    break;
            }
        }
        return decimal;
    }

    private static int getValue(int decimal, int i, int value, String s){
        boolean performCheck = false;
        if(i != 0){
            String prevChar = s.charAt(i-1)+"";
            char ch = s.charAt(i);
            // String with roman numbers hierarchy system, starts with 5
            String romanChars = "VXLCDM";
            if(ch == 'V' && !romanChars.contains(prevChar)){
                performCheck = true;
            }
            // Reduce string by removing 1st character to perform hierarchy check
            romanChars = romanChars.substring(1);
            if(ch == 'X'){
                // If previous character is not present in current string (i.e. it is less in hierarchy) then perform check
                if(!romanChars.contains(prevChar)){
                    performCheck = true;
                }
            }
            romanChars = romanChars.substring(1);
            if(ch == 'L'){
                if(!romanChars.contains(prevChar)){
                    performCheck = true;
                }
            }
            romanChars = romanChars.substring(1);
            if(ch == 'C'){
                if(!romanChars.contains(prevChar)){
                    performCheck = true;
                }
            }
            romanChars = romanChars.substring(1);
            if(ch == 'D'){
                if(!romanChars.contains(prevChar)){
                    performCheck = true;
                }
            }
            romanChars = romanChars.substring(1);
            if(ch == 'M'){
                if(!romanChars.contains(prevChar)){
                    performCheck = true;
                }
            }
            if(performCheck){
                switch(prevChar){
                    // Reducing double values if previous character is less than current character in hierarchy
                    case "I":
                        decimal += value-1*2;
                        break;
                    case "V":
                        decimal += value-2*5;
                        break;
                    case "X":
                        decimal += value-2*10;
                        break;
                    case "L":
                        decimal += value-2*50;
                        break;
                    case "C":
                        decimal += value-2*100;
                        break;
                    case "D":
                        decimal += value-2*500;
                        break;
                    case "M":
                        decimal += value-2*1000;
                        break;
                    default:
                        // Add the whole value if previous character is not less than current character in hierarchy
                        decimal += value;
                }
            }
        }
        if(!performCheck){
            // Add the whole value if no check is required
            decimal += value;
        }
        return decimal;
    }

    // Another approach, refer https://www.geeksforgeeks.org/roman-number-to-integer/
    static int romanToDecimals(String str)
    {
        HashMap<Character, Integer> romanMap
                = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {

            // If the current value is less than the next
            // value, subtract current from next and add to
            // sum
            if (i + 1 < str.length()
                    && romanMap.get(str.charAt(i))
                    < romanMap.get(str.charAt(i + 1))) {
                sum += romanMap.get(str.charAt(i + 1))
                        - romanMap.get(str.charAt(i));

                // Skip the next symbol
                i++;
            }
            else {

                // Otherwise, add the current value to sum
                sum += romanMap.get(str.charAt(i));
            }
        }

        return sum;
    }


}
