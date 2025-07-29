package com.tp1.bean;

import java.sql.*;

public class AccessDB {
    private static final String URL = "jdbc:mysql://localhost:3306/personne";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void enregistrerPersonne(Personne personne) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String checkQuery = "SELECT * FROM person WHERE nom = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, personne.getNom());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    throw new SQLException("Ce nom existe déjà !");
                }
            }

            String insertQuery = "INSERT INTO person (nom, prenom) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, personne.getNom());
                insertStmt.setString(2, personne.getPrenom());
                insertStmt.executeUpdate();
            }
        }
    }
}
