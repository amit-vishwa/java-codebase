package tutorial.java.jdbc;

/**
 * Loads the connection settings used by the standalone JDBC examples.
 */
public final class DatabaseConfig {

    private DatabaseConfig() {
    }

    public static String url() {
        return System.getenv().getOrDefault("JDBC_URL", "jdbc:mysql://localhost:3306/gfg");
    }

    public static String username() {
        return System.getenv().getOrDefault("JDBC_USERNAME", "root");
    }

    public static String password() {
        String password = System.getenv("JDBC_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Set JDBC_PASSWORD before running a JDBC example");
        }
        return password;
    }
}
