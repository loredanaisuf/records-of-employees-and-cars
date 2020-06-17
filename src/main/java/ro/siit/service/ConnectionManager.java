package ro.siit.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // static variable single_instance of type Singleton
    private static ConnectionManager single_instance = null;
    private Connection connection;


    // private constructor restricted to this class itself
    private ConnectionManager()
    {
        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("Url-ul pt DB este: " + System.getenv("JDBC_DATABASE_URL"));
            connection = DriverManager.getConnection(System.getenv("JDBC_DATABASE_URL"));

            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lori?user=postgres&password=Loredana12");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // static method to create instance of Singleton class
    public static ConnectionManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ConnectionManager();

        return single_instance;
    }

    public Connection getConnection(){
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
    }
}
