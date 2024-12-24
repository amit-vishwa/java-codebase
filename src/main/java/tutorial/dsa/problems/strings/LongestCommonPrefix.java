package tutorial.dsa.problems.strings;

/**
 * Refer: https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
 * */
public class LongestCommonPrefix {
    public static void main(String... args){
       System.out.println(longestCommonPrefix(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}));
       System.out.println(longestCommonPrefix(new String[]{"uhwemwrrazkvwvz", "edhgqdkflwhvslokr", "oyxqpntl", "wxsbas", "ihkmvqbkufcypqdnxjd"}));
        System.out.println(longestCommonPrefix(new String[]{"jyzvonn", "xh", "flixdx", "bkfnsuhyrjxcuteukso",
                "qclb", "qykwljvnddylpr", "wfhtexvuhlpgdiwjpeoy", "hxkmzpscshlquz", "kixnynohjaqjgrtz",
                "gyxghbndaeqxhiali", "klhwkqajxk", "owjqrlszgzknupp", "jbbwtrtoebqkgprro"}));
    }
    public static String longestCommonPrefix(String arr[]) {
        // code here
        if(arr.length == 1){
            return arr[0];
        }
        String longestCommonPrefix = "";
        String firstString = arr[0];
        int firstStringLength = firstString.length();
        for(int i = 1; i < arr.length; i++){
            int minStringLength = Math.min(arr[i].length(), firstStringLength);
            String commonPrefix = "";
            int index = 0;
            while(index <= minStringLength-1){
                if(arr[i].charAt(index) == firstString.charAt(index)){
                    commonPrefix += firstString.charAt(index);
                    index++;
                } else break;
            }
            if(index == 0){
                longestCommonPrefix = "";
                break;
            }
            if(commonPrefix.length() < firstStringLength){
                longestCommonPrefix = commonPrefix;
            }
        }
        return longestCommonPrefix;
    }
}
