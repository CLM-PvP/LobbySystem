package de.clmpvp.clmpvp.scoreboard;

import java.sql.*;

public class MySQL {

    private String host, database, username, password;
    private int port;
    private Connection connection;

    public MySQL(String host, int port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        if (connection != null && !connection.isClosed()) return;
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("[MySQL] Connected to the database.");
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("[MySQL] Disconnected from the database.");
        }
    }

    public String getPlayerRank(String uuid) {
        String rank = "default"; // Standardwert, falls kein Rang gefunden wird.
        try {
            String query = "SELECT permission FROM luckperms_user_permissions " +
                    "WHERE uuid = ? AND permission LIKE 'group.%'";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uuid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Extrahiere den Gruppennamen (z.B. "group.admin" -> "admin").
                rank = rs.getString("permission").split("\\.")[1];
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rank;
    }

}
