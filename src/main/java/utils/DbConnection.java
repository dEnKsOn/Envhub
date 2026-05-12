package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DbConnection {
    
    private static final Dotenv dotenv = Dotenv.configure()
            .filename("db.env")
            .ignoreIfMissing()
            .load();

    private static final String dbUser = dotenv.get("MYSQL_USER");
    private static final String dbPassword = dotenv.get("MYSQL_PASSWORD");
    private static final String dbHost = dotenv.get("MYSQL_HOST");
    private static final String dbPort = dotenv.get("MYSQL_PORT");
    private static final String dbName = dotenv.get("MYSQL_DATABASE");

    private static final String URL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName 
                                      + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            System.err.println("ERREUR : Driver JDBC manquant");
            throw new SQLException("Driver non trouvé", e);
        } catch (SQLException e) {
            System.err.println("ERREUR SQL : Impossible de se connecter à la base de données.");
            throw e;
        }
    }
}