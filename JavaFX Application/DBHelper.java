import java.sql.*;
import java.util.ArrayList;

public class DBHelper {

    static final String URL = "jdbc:mysql://localhost:3306/restaurant_db";
    static final String USER = "root";
    static final String PASS = "KC08"; // change this

    public static Connection connect() throws Exception {
        Connection temp = DriverManager.getConnection("jdbc:mysql://localhost:3306/", USER, PASS);
        temp.createStatement().executeUpdate("CREATE DATABASE IF NOT EXISTS restaurant_db");
        temp.close();
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTables(Connection con) throws Exception {
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurant(Id INT PRIMARY KEY, Name VARCHAR(100), Address VARCHAR(100))");
        st.executeUpdate("CREATE TABLE IF NOT EXISTS MenuItem(Id INT PRIMARY KEY, Name VARCHAR(100), Price DOUBLE, ResId INT, FOREIGN KEY(ResId) REFERENCES Restaurant(Id))");
    }

    public static void insertRestaurant(Connection c, int id, String name, String addr) throws Exception {
        PreparedStatement ps = c.prepareStatement("INSERT INTO Restaurant VALUES (?, ?, ?)");
        ps.setInt(1, id); ps.setString(2, name); ps.setString(3, addr);
        ps.executeUpdate();
    }

    public static ArrayList<String[]> getRestaurants(Connection c) throws Exception {
        ArrayList<String[]> list = new ArrayList<>();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM Restaurant");
        while (rs.next())
            list.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
        return list;
    }

    public static int updateRestaurant(Connection c, int id, String name, String addr) throws Exception {
        PreparedStatement ps = c.prepareStatement("UPDATE Restaurant SET Name=?, Address=? WHERE Id=?");
        ps.setString(1, name); ps.setString(2, addr); ps.setInt(3, id);
        return ps.executeUpdate();
    }

    public static int deleteRestaurant(Connection c, int id) throws Exception {
        PreparedStatement ps = c.prepareStatement("DELETE FROM Restaurant WHERE Id=?");
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public static void insertMenu(Connection c, int id, String name, double price, int rid) throws Exception {
        PreparedStatement ps = c.prepareStatement("INSERT INTO MenuItem VALUES (?, ?, ?, ?)");
        ps.setInt(1, id); ps.setString(2, name); ps.setDouble(3, price); ps.setInt(4, rid);
        ps.executeUpdate();
    }

    public static ArrayList<String[]> getMenu(Connection c) throws Exception {
        ArrayList<String[]> list = new ArrayList<>();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM MenuItem");
        while (rs.next())
            list.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
        return list;
    }

    public static int updateMenu(Connection c, int id, String name, double price, int rid) throws Exception {
        PreparedStatement ps = c.prepareStatement("UPDATE MenuItem SET Name=?, Price=?, ResId=? WHERE Id=?");
        ps.setString(1, name); ps.setDouble(2, price); ps.setInt(3, rid); ps.setInt(4, id);
        return ps.executeUpdate();
    }

    public static int deleteMenu(Connection c, int id) throws Exception {
        PreparedStatement ps = c.prepareStatement("DELETE FROM MenuItem WHERE Id=?");
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
}