package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;


public class DbConnection {
    // Charger les variables d'environnement à partir du fichier .env
    private static final Dotenv dotenv = Dotenv.load();
    private static final String dbUser = dotenv.get("MYSQL_USER");
    private static final String dbPassword = dotenv.get("MYSQL_PASSWORD");
    private static final String dbHost = dotenv.get("MYSQL_HOST");
    private static final String dbPort = dotenv.get("MYSQL_PORT");
    private static final String dbName = dotenv.get("MYSQL_DATABASE");

    private static final String URL = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + dbName;
    private static final String USERNAME = dbUser;
    private static final String PASSWORD = dbPassword;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }
    }
}
