package tutorial.dsa.problems.strings;

/**
 * Refer: https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 *
 *     roman.put(1, 'I');
 *     roman.put(5, 'V');
 *     roman.put(10, 'X');
 *     roman.put(50, 'L');
 *     roman.put(100, 'C');
 *     roman.put(500, 'D');
 *     roman.put(1000, 'M');
 *     roman.put(5000, 'G');
 *     roman.put(10000, 'H');
 * */
public class DecimalToRoman {
    public static void main(String args[]){
        System.out.println(getRomanFromDecimal(9));
        System.out.println(getRomanFromDecimal(40));
        System.out.println(getRomanFromDecimal(1904));
        System.out.println(getRomanFromDecimal(1234));
        System.out.println(getRomanFromDecimal(3549));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(40));
        System.out.println(intToRoman(1904));
        System.out.println(intToRoman(1234));
        System.out.println(intToRoman(3549));
    }

    private static String getRomanFromDecimal(int number){
        StringBuilder roman = new StringBuilder();
        while(number>0){
            if(number>=10000){
                roman.append("H");
                number -= 10000;
            }
            else if(number>=9000){
                roman.append("MH");
                number -= 9000;
            }
            else if(number>=5000){
                roman.append("G");
                number -= 5000;
            }
            else if(number>=4000){
                roman.append("MG");
                number -= 4000;
            }
            else if(number>=1000){
                roman.append("M");
                number -= 1000;
            }
            else if(number>=900){
                roman.append("CM");
                number -= 900;
            }
            else if(number>=500){
                roman.append("D");
                number -= 500;
            }
            else if(number>=400){
                roman.append("CD");
                number -= 400;
            }
            else if(number>=100){
                roman.append("C");
                number -= 100;
            }
            else if(number>=90){
                roman.append("XC");
                number -= 90;
            }
            else if(number>=50){
                roman.append("L");
                number -= 50;
            }
            else if(number>=40){
                roman.append("XL");
                number -= 40;
            }
            else if(number>=10){
                roman.append("X");
                number -= 10;
            }
            else if(number==9){
                roman.append("IX");
                number -= 9;
            }
            else if(number>=5){
                roman.append("V");
                number -= 5;
            }
            else if(number==4){
                roman.append("IV");
                number -= 4;
            }
            else{
                roman.append("I");
                number--;
            }
        }
        return roman.toString();
    }

    // Another easy approach
    static String intToRoman(int num)
    {
        // storing roman values of digits from 0-9
        // when placed at different places
        String m[] = { "", "M", "MM", "MMM", "MG", "G",
                "GM", "GMM", "GMMM", "MH", "H" };
        String c[] = { "",  "C",  "CC",  "CCC",  "CD",
                "D", "DC", "DCC", "DCCC", "CM" };
        String x[] = { "",  "X",  "XX",  "XXX",  "XL",
                "L", "LX", "LXX", "LXXX", "XC" };
        String i[] = { "",  "I",  "II",  "III",  "IV",
                "V", "VI", "VII", "VIII", "IX" };

        // Converting to roman
        String thousands = m[(num % 10000) / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        String ans = thousands + hundreds + tens + ones;

        return ans;
    }
}
