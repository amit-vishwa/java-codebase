package tutorial.java.problems.coddytech;

// Medium level problem
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] a) {
        // Write code here
        if (a.length == 0) return "";
        String commonPrefix = a[0];
        for(int i = 1; i < a.length; i++){
            while(a[i].indexOf(commonPrefix) != 0){
                // shortening the length until whole prefix is found in comparing string
                commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
            }
        }
        return commonPrefix;
    }

    public static void main(String... args){
        System.out.println(longestCommonPrefix(new String[]{"something", "somehow", "somewhat"}));
        System.out.println(longestCommonPrefix(new String[]{"Hello Bob", "Hello Jake"}));
        System.out.println(longestCommonPrefix(new String[]{"example", "sample"}));
        System.out.println(longestCommonPrefix(new String[]{"maximum", "max", "minimum"}));
    }
}
