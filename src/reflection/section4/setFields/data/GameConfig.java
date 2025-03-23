package reflection.section4.setFields.data;

import java.util.Random;

public class GameConfig {

    // static final field cannot be set at runtime
//    private final static int releaseYear = 2000;

    // when final value is initialized, that value is used instead of runtime value
    // resolution to assign runtime value instead of constant using constructor
//    private final int releaseYear = 2000;
//    private final int releaseYear;

    private int releaseYear;
    private String gameName;
    private double price;

//    public GameConfig() {
//        // now runtime value will be used and not get overridden
//        Random random = new Random();
//        this.releaseYear = random.nextInt(2000);
//    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGameName() {
        return gameName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "releaseYear=" + releaseYear +
                ", gameName='" + gameName + '\'' +
                ", price=" + price +
                '}';
    }

}
