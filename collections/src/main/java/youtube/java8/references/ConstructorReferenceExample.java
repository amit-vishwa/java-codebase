package youtube.java8.references;

import java.util.List;

/**
 * Constructor reference is similar to method reference, only it works with Constructor.
 * */
public class ConstructorReferenceExample {

    public static void main(String[] args) {
        List<String> mobiles = List.of("Samsung","Apple","Nokia");
        // traditional way of using lambda expression to get list of objects
        List<Mobile> mobileList = mobiles.stream().map(name -> new Mobile(name)).toList();
        System.out.println(mobileList);
        // getting list of objects using constructor reference
        List<Mobile> mobileLists = mobiles.stream().map(Mobile::new).toList();
        System.out.println(mobileLists);
    }

    static class Mobile{
        private String name;
        public Mobile(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            return "name="+name;
        }
    }

}
