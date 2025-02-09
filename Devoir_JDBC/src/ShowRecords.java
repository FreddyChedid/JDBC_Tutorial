import java.sql.*;

public class ShowRecords {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/store"; // Your PostgreSQL database
        String user = "postgres"; // Your PostgreSQL username
        String password = "root"; // Your PostgreSQL password

        // Query to fetch records from the 'products' table
        String query = "SELECT * FROM shop.products"; // Change table name as needed

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Records in the 'products' table:");

            // Fetch and display records
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String barcode = rs.getString("barcode");

                System.out.printf("ID: %d, Name: %s, Description: %s, Price: %.2f, Quantity: %d, Barcode: %s%n",
                        id, name, description, price, quantity, barcode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
