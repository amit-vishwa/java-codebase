package reflection.section3;

import java.lang.reflect.Field;

/**
 * Get data from fields using reflection.
 * */
public class FieldsUsingReflection {

    public static void main(String[] args) {
        printDeclaredFieldInfo(Movie.class);
        printDeclaredFieldInfo(Category.class);
        printDeclaredFieldInfo(Movie.MovieStats.class);
        printFieldValue();
    }

    public static void printDeclaredFieldInfo(Class<?> clazz){
        System.out.println("\n**************** "+clazz.getSimpleName()+" ******************\n");
        for(Field field : clazz.getDeclaredFields()){
            System.out.println(String.format("Field name: %s, type: %s",
                    field.getName(), field.getType().getSimpleName()));
            System.out.println("Is synthetic field: " + field.isSynthetic());
            System.out.println();
        }
    }

    private static void printFieldValue() {
        Movie movie = new Movie("Jurassic Park", 2007, 15.78, true, Category.ADVENTURE);
        printDeclaredFieldValues(movie.getClass(), movie);
        System.out.println("Movie year: " + movie.year);
        try {
            // Since MINIMUM_PRICE is a static field, we can access it using null. No need to pass object reference.
            System.out.println("Minimum price: " + Movie.class.getDeclaredField("MINIMUM_PRICE").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void printDeclaredFieldValues(Class<? extends T> clazz, T instance){
        System.out.println("\n**************** "+clazz.getSimpleName()+" ******************\n");
        for(Field field : clazz.getDeclaredFields()){
            System.out.println(String.format("Field name: %s, type: %s",
                    field.getName(), field.getType().getSimpleName()));
            System.out.println("Is synthetic field: " + field.isSynthetic());
            try {
                System.out.println("Field value: " + field.get(instance));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
        }
    }

    public static class Movie extends Product{
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private double actualPrice;
        private Category category;

        public Movie(String name, int year, double price, boolean isReleased, Category category){
            super(name, year);
            this.category = category;
            this.isReleased = isReleased;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

        public class MovieStats{
            private double timesWatched;

            public MovieStats(double timesWatched){
                this.timesWatched = timesWatched;
            }

            public double getRevenue(){
                return timesWatched * actualPrice;
            }
        }
    }

    public static class Product{
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year){
            this.name = name;
            this.year = year;
        }
    }

    public enum Category{
        ADVENTURE, ACTION, COMEDY
    }

}
