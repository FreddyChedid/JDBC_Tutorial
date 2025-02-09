import java.sql.*;

public class ListTables {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/store"; // Change port if needed
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "root"; // Replace with your PostgreSQL password

        // SQL query to get tables from the 'shop' schema
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'shop'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Tables in the 'shop' schema:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("table_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
