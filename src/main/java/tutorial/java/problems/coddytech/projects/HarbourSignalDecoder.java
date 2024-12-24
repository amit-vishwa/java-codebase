package tutorial.java.problems.coddytech.projects;

public class HarbourSignalDecoder {

    public static void main(String args[]){
        System.out.println(harborSignalDecoder("111"));
        System.out.println(harborSignalDecoder("11100011100011"));
        System.out.println(harborSignalDecoder("1110001110001"));
        System.out.println(harborSignalDecoder("1111111111111111111111111"));
        System.out.println(harborSignalDecoder("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
        System.out.println(harborSignalDecoder("1010101010101010101010101"));
        System.out.println(harborSignalDecoder("111111111111111111111111111111"));
        System.out.println(harborSignalDecoder("111001000011110000111"));
    }

    public static String harborSignalDecoder(String signalPattern) {
        // Write code here
        String message = "";
        int count = 0;
        for(char c : signalPattern.toCharArray()){
            if(c == '1'){
                count++;
            }else{
                if(count != 0){
                    int unicode = count+64;
                    char ch = (char)(unicode>90?90:unicode);
                    message += String.valueOf(ch) + ".";
                    count = 0;
                }
            }
        }
        if(count != 0){
            int unicode = count+64;
            char ch = (char)(unicode>90?90:unicode);
            message += String.valueOf(ch);
            count = 0;
        }
        if(signalPattern.charAt(signalPattern.length()-1)=='0'){
            message = message.length()>1?message.substring(0,message.length()-1):message;
        }
        return message;
    }

}

