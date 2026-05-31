package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DbConnection {
    
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("/home/jub-ubuntu/Documents/EnvHub/resources")            
            .filename("db.env")
            .ignoreIfMissing()
            .load();

    private static final String dbUser = dotenv.get("MYSQL_USER");
    private static final String dbPassword = dotenv.get("MYSQL_PASSWORD");
    private static final String dbHost = dotenv.get("MYSQL_HOST");
    private static final String dbPort = dotenv.get("DB_PORT");
    private static final String dbName = dotenv.get("MYSQL_DATABASE");

    // L'URL de connexion sécurisée avec SSL/TLS forcé
    private static final String URL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName 
                                      + "?useSSL=true"
                                      + "&requireSSL=true"
                                      + "&serverTimezone=UTC"
                                      + "&allowPublicKeyRetrieval=false"
                                      + "&verifyServerCertificate=false"
                                      + "&enabledTLSProtocols=TLSv1.2,TLSv1.3";

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