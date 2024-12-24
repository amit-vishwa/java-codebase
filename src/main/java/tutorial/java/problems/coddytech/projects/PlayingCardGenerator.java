package tutorial.java.problems.coddytech.projects;

import java.util.Arrays;

public class PlayingCardGenerator {
    public static void main(String... args){
//        PrintCard.printCard();
//        PrintCard.printAceCard();
//        PrintCard.printACard("club");
//        PrintCard.printCard(10,"club");
        PrintCard.printCards(new Integer[]{1,2,3},new String[]{"heart", "club", "spade"});
    }
}

class PrintCard {

    public static void printCard() {
        // Write code here
        System.out.print("╔");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╗");
        for(int i = 0; i < 7; i++){
            System.out.println("║         ║");
        }
        System.out.print("╚");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╝");
    }

    public static void printAceCard() {
        // Write code here
        System.out.print("╔");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╗");
        for(int i = 0; i < 7; i++){
            if(i == 0){
                System.out.println("║ A       ║");
            }
            else if(i == 3){
                System.out.println("║    ♥    ║");
            }
            else if(i == 6){
                System.out.println("║       A ║");
            }
            else System.out.println("║         ║");
        }
        System.out.print("╚");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╝");
    }

    public static void printACard(String card) {
        // Write code here
        System.out.print("╔");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╗");
        String symbol;
        switch(card){
            case "club":
                symbol = "♣";
                break;
            case "diamond":
                symbol = "♦";
                break;
            case "heart":
                symbol = "♥";
                break;
            case "spade":
                symbol = "♠";
                break;
            default:
                symbol = " ";
        }
        for(int i = 0; i < 7; i++){
            if(i == 0){
                System.out.println("║ A       ║");
            }
            else if(i == 3){
                System.out.println("║    " + symbol + "    ║");
            }
            else if(i == 6){
                System.out.println("║       A ║");
            }
            else System.out.println("║         ║");
        }
        System.out.print("╚");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╝");
    }

    /////////////////////////////////////////////////////////////////////////////////////

    public static String getCardSymbol(String card){
        String symbol = "";
        switch(card){
            case "club":
                symbol = "♣";
                break;
            case "diamond":
                symbol = "♦";
                break;
            case "heart":
                symbol = "♥";
                break;
            case "spade":
                symbol = "♠";
                break;
            default:
                symbol = " ";
        }
        return symbol;
    }

    public static String getCardName(Integer cardNum){
        String name = "";
        switch(cardNum){
            case 1:
                name = "A";
                break;
            case 11:
                name = "J";
                break;
            case 12:
                name = "Q";
                break;
            case 13:
                name = "K";
                break;
            default:
                name = " ";
        }
        if(name == " "){
            for(int i = 2; i <= 10; i++){
                if(cardNum == i){
                    name = i+"";
                    break;
                }
            }
        }
        return name;
    }

    public static void printCard(Integer cardNum, String card) {
        // Write code here
        System.out.print("╔");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╗");
        String symbol = getCardSymbol(card);
        String name  = getCardName(cardNum);
        for(int i = 0; i < 7; i++){
            if(i == 0){
                if(name.equals("10")){
                    System.out.println("║ "+name+"      ║");
                }else
                    System.out.println("║ "+name+"       ║");
            }
            else if(i == 3){
                System.out.println("║    " + symbol + "    ║");
            }
            else if(i == 6){
                if(name.equals("10")){
                    System.out.println("║      "+name+" ║");
                }else
                    System.out.println("║       "+name+" ║");
            }
            else System.out.println("║         ║");
        }
        System.out.print("╚");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.println("╝");
    }

    public static void printUpper(){
        System.out.print("╔");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.print("╗");
    }

    public static void printLower(){
        System.out.print("╚");
        for(int i = 0; i < 9; i++){
            System.out.print("═");
        }
        System.out.print("╝");
    }

    public static void printMiddle(Integer[] cardNum, String[] card){
        for(int i = 0; i < 7; i++){
            if(i == 0){
                for(int j = 0; j < cardNum.length; j++){
                    String name  = getCardName(cardNum[j]);
                    if(name.equals("10")){
                        System.out.print("║ "+name+"      ║");
                    }else {
                        System.out.print("║ "+name+"       ║");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            else if(i == 3){
                for(int j = 0; j < cardNum.length; j++){
                    String symbol = getCardSymbol(card[j]);
                    System.out.print("║    " + symbol + "    ║");
                    System.out.print(" ");
                }
                System.out.println();
            }
            else if(i == 6){
                for(int j = 0; j < cardNum.length; j++){
                    String name  = getCardName(cardNum[j]);
                    if(name.equals("10")){
                        System.out.print("║      "+name+" ║");
                    }else
                        System.out.print("║       "+name+" ║");
                    System.out.print(" ");
                }
                System.out.println();
            }
            else{
                for(int j = 0; j < cardNum.length; j++){
                    System.out.print("║         ║");
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static void printCards(Integer[] cardNum, String[] card) {
        // Write code here
        for(int i = 0; i < cardNum.length; i++){
            printUpper();
            System.out.print(" ");
        }
        System.out.println();

        printMiddle(cardNum, card);

        for(int i = 0; i < cardNum.length; i++){
            printLower();
            System.out.print(" ");
        }
    }

}