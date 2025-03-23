package reflection.section6;

import reflection.section6.auction.Auction;
import reflection.section6.auction.Bid;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifiersUsingReflection {

    public static void main(String[] args) {
        runAuction();
        printClassModifiers();
        printMethodModifiers();
        printFieldModifiers();
    }

    public static void printFieldModifiers(){
        System.out.println("********* Field modifiers ************\n");
        printFieldModifiers(Auction.class.getDeclaredFields());
    }

    public static void printFieldModifiers(Field[] fields){
        for(Field field : fields){
            int modifier = field.getModifiers();
            System.out.println("Field: " + field.getName() + ", Access modifier: "
                    + getAccessModifierName(modifier));
            if (Modifier.isSynchronized(modifier)){
                System.out.println(field.getName() + " is synchronized");
            }
            if (Modifier.isTransient(modifier)){
                System.out.println(field.getName() + " is transient and won't be serialized");
            }
            if (Modifier.isVolatile(modifier)){
                System.out.println(field.getName() + " is volatile");
            }
            if (Modifier.isFinal(modifier)){
                System.out.println(field.getName() + " is final");
            }
            System.out.println();
        }
    }

    public static void printMethodModifiers(){
        System.out.println("********* Method modifiers ************\n");
        printMethodModifiers(Auction.class.getDeclaredMethods());
    }

    public static void printMethodModifiers(Method[] methods){
        for(Method method : methods){
            int modifier = method.getModifiers();
            System.out.println("Method: " + method.getName() + ", Access modifier: "
                    + getAccessModifierName(modifier));
            if (Modifier.isSynchronized(modifier)){
                System.out.println(method.getName() + "() is synchronized");
            }else{
                System.out.println(method.getName() + "() is not synchronized");
            }
            System.out.println();
        }
    }

    public static void printClassModifiers(){
        System.out.println("\n********* Class modifiers ************\n");
        printClassModifiers(Bid.class);
        printClassModifiers(Auction.class);
        printClassModifiers(Bid.Builder.class);
        try {
            printClassModifiers(Class.forName("reflection.section6.auction.Bid$Builder$BidImpl"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        printClassModifiers(Serializable.class);
    }

    public static void printClassModifiers(Class<?> clazz){
        int modifier = clazz.getModifiers();
        System.out.println("Class: " + clazz.getSimpleName() + ", Access modifier: "
                + getAccessModifierName(modifier));
        if(Modifier.isAbstract(modifier)){
            System.out.println(clazz.getSimpleName() + " is an abstract class");
        }
        if(Modifier.isInterface(modifier)){
            System.out.println(clazz.getSimpleName() + " is an interface");
        }
        if(Modifier.isStatic(modifier)){
            System.out.println(clazz.getSimpleName() + " is a static class");
        }
        System.out.println();
    }

    private static String getAccessModifierName(int modifier){
        if(Modifier.isPublic(modifier)){
            return "public";
        }else if(Modifier.isPrivate(modifier)){
            return "private";
        }else if(Modifier.isProtected(modifier)){
            return "protected";
        }else{
            return "package-private";
        }
    }

    public static void runAuction(){
        Auction auction = new Auction();
        auction.startAuction();

        Bid bid1 = Bid.builder().setBidderName("Company1").setPrice(10).build();
        auction.addBid(bid1);
        Bid bid2 = Bid.builder().setBidderName("Company2").setPrice(15).build();
        auction.addBid(bid2);

        auction.stopAuction();

        System.out.println(auction.getAllBids());
        System.out.println("Highest bid: " + auction.getHighestBid().get());
    }

}
