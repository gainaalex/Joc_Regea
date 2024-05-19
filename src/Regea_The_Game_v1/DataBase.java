package Regea_The_Game_v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    // Method to connect to the database
    private Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String url = "jdbc:sqlite:newDataBase.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS INFOS (\n"
                + " x INTEGER NOT NULL,\n"
                + " y INTEGER NOT NULL,\n"
                + " life INTEGER NOT NULL\n"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(int num1, int num2, int num3) {
        String sql = "INSERT INTO INFOS(x, y, life) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, num1);
            pstmt.setInt(2, num2);
            pstmt.setInt(3, num3);
            pstmt.executeUpdate();
            //System.out.println("Data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAll() {
        String sql = "SELECT  x, y, life FROM INFOS";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("x") + "\t" +
                        rs.getInt("y") + "\t" +
                        rs.getInt("life"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int getWorldTileX()
    {
        String sql = "SELECT x FROM INFOS";
        int x=0;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            x=rs.getInt("x");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    public int getWorldTileY()
    {
        String sql = "SELECT y FROM INFOS";
        int y=0;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            y=rs.getInt("y");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;
    }

    public int getLife()
    {
        String sql = "SELECT life FROM INFOS";
        int x=0;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            x=rs.getInt("life");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }
    public void deleteAllRows() {
        String sql = "DELETE FROM INFOS";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
