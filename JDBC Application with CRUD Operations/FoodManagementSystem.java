import java.sql.*;

public class FoodManagementSystem {

    static final String DB_PATH = "jdbc:mysql://localhost:3306/restaurant_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "KC08";

    public static Connection openConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String baseUrl = "jdbc:mysql://localhost:3306/";
        try (Connection temp = DriverManager.getConnection(baseUrl, USERNAME, PASSWORD);
             Statement st = temp.createStatement()) {

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS restaurant_db");
        }

        return DriverManager.getConnection(DB_PATH, USERNAME, PASSWORD);
    }

    public static void buildTables(Connection conn) throws Exception {
        try (Statement st = conn.createStatement()) {

            String tbl1 = "CREATE TABLE Restaurant (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(255), " +
                    "Address VARCHAR(255))";

            String tbl2 = "CREATE TABLE MenuItem (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(255), " +
                    "Price DOUBLE, " +
                    "ResId INT, " +
                    "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))";

            st.executeUpdate(tbl1);
            st.executeUpdate(tbl2);
        }
    }

    public static void loadData(Connection conn) throws Exception {

        String addRes = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        String addMenu = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";

        try (PreparedStatement rStmt = conn.prepareStatement(addRes);
             PreparedStatement mStmt = conn.prepareStatement(addMenu)) {

            Object[][] resData = {
                {1, "Cafe Java", "Block A"},
                {2, "Spice Garden", "Block B"},
                {3, "Burger Hub", "Block C"},
                {4, "Italiano", "Block D"},
                {5, "Mexican Grill", "Block E"},
                {6, "Snack Point", "Block F"},
                {7, "Ocean Sushi", "Block G"},
                {8, "Grill House", "Block H"},
                {9, "Healthy Bowl", "Block I"},
                {10, "Morning Cafe", "Block J"}
            };

            for (Object[] row : resData) {
                rStmt.setInt(1, (Integer) row[0]);
                rStmt.setString(2, (String) row[1]);
                rStmt.setString(3, (String) row[2]);
                rStmt.executeUpdate();
            }

            Object[][] menuData = {
                {201, "Latte", 60.0, 1},
                {202, "Espresso", 70.0, 1},
                {203, "Donut", 130.0, 1},
                {204, "Cheese Pizza", 240.0, 2},
                {205, "Veg Burger", 90.0, 3},
                {206, "White Pasta", 170.0, 4},
                {207, "Nachos", 85.0, 5},
                {208, "Porridge", 95.0, 10},
                {209, "Green Salad", 120.0, 9},
                {210, "BBQ Steak", 450.0, 8}
            };

            for (Object[] row : menuData) {
                mStmt.setInt(1, (Integer) row[0]);
                mStmt.setString(2, (String) row[1]);
                mStmt.setDouble(3, (Double) row[2]);
                mStmt.setInt(4, (Integer) row[3]);
                mStmt.executeUpdate();
            }

            System.out.println("✔ Data inserted successfully into both tables.");
        }
    }

    public static void showRestaurants(Connection conn) throws Exception {
        String sql = "SELECT * FROM Restaurant";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Restaurant List ---");
            System.out.printf("%-5s %-20s %-25s\n", "ID", "Name", "Address");

            while (rs.next()) {
                System.out.printf("%-5d %-20s %-25s\n",
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Address"));
            }
        }
    }

    public static void showMenuAfterInsert(Connection conn) throws Exception {
        String sql = "SELECT * FROM MenuItem";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Menu After Insert ---");
            printMenuTable(rs);
        }
    }

    public static void getAffordableItems(Connection conn) throws Exception {

        String sql = "SELECT * FROM MenuItem WHERE Price <= 100";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Items with Price <= 100 ---");
            printMenuTable(rs);
        }
    }

    public static void getCafeJavaMenu(Connection conn) throws Exception {

        String sql = "SELECT m.* FROM MenuItem m " +
                     "JOIN Restaurant r ON m.ResId = r.Id " +
                     "WHERE r.Name = 'Cafe Java'";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Cafe Java Menu ---");
            printMenuTable(rs);
        }
    }

    public static void revisePrices(Connection conn) throws Exception {

        String sql = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";

        try (Statement st = conn.createStatement()) {
            int count = st.executeUpdate(sql);
            System.out.println("\nUpdated rows: " + count);
        }

        ResultSet rs = conn.createStatement()
                .executeQuery("SELECT * FROM MenuItem ORDER BY Id");

        System.out.println("\n--- Menu After Price Update ---");
        printMenuTable(rs);
    }

    public static void removeItemsStartingP(Connection conn) throws Exception {

        String sql = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";

        try (Statement st = conn.createStatement()) {
            int count = st.executeUpdate(sql);
            System.out.println("\nDeleted rows: " + count);
        }

        ResultSet rs = conn.createStatement()
                .executeQuery("SELECT * FROM MenuItem ORDER BY Id");

        System.out.println("\n--- Menu After Deletion ---");
        printMenuTable(rs);
    }

    public static void finalMenu(Connection conn) throws Exception {

        ResultSet rs = conn.createStatement()
                .executeQuery("SELECT * FROM MenuItem");

        System.out.println("\n--- Final Menu Data ---");
        printMenuTable(rs);
    }

    public static void printMenuTable(ResultSet rs) throws Exception {

        System.out.printf("%-5s %-18s %-10s %-10s\n", "ID", "Item", "Price", "ResId");

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.printf("%-5d %-18s %-10.2f %-10d\n",
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("ResId"));
        }

        if (!found) {
            System.out.println("(No data available)");
        }
    }

    public static void main(String[] args) {

        System.out.println("Launching Food Management System...");

        try {
            Connection conn = openConnection();

            buildTables(conn);
            loadData(conn);

            showRestaurants(conn);
            showMenuAfterInsert(conn);

            getAffordableItems(conn);
            getCafeJavaMenu(conn);

            revisePrices(conn);
            removeItemsStartingP(conn);

            finalMenu(conn);

            conn.close();

            System.out.println("\n✔ Execution completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}