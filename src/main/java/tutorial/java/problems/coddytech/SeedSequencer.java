package tutorial.java.problems.coddytech;

public class SeedSequencer {
    public static void main(String... args){
        String response = seedSequencer(new String[]{"sunflower","tomato"},10);
        System.out.println(response.equals("11511711010210811111910111411611110997116111"));
        response = seedSequencer(new String[]{"rose","lily"},2);
        System.out.println(response.equals("11100101101111111001111001011101100110100111011001111001"));
        response = seedSequencer(new String[]{"apple","banana","cherry"},8);
        System.out.println(response.equals("141160160154145142141156141156141143150145162162171"));
        response = seedSequencer(new String[]{"pine","oak","maple","birch"},16);
        System.out.println(response.equals("70696e656f616b6d61706c656269726368"));
        response = seedSequencer(new String[]{},10);
        System.out.println(response.equals(""));
    }
    public static String seedSequencer(String[] seedList, int base) {
        // Write code here
        if(seedList.length == 0){
            return "";
        }
        String response = "";
        for(String s : seedList){
            for(int i = 0; i < s.length(); i++){
                Integer decimalValue = (int)s.charAt(i);
                switch(base){
                    case 2:
                        response += Integer.toBinaryString(decimalValue);
                        break;
                    case 8:
                        response += Integer.toOctalString(decimalValue);
                        break;
                    case 10:
                        response += decimalValue.toString();
                        break;
                    case 16:
                        response += Integer.toHexString(decimalValue);
                        break;
                }
            }
        }
        return response;
    }
}
