package com.tp1.bean;

import com.tp1.bean.Personne;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlusDB {
    private static final String URL = "jdbc:mysql://localhost:3306/personne?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Personne> listerPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        String query = "SELECT * FROM person";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                personnes.add(new Personne(nom, prenom));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personnes;
    }

    public Personne rechercherParNom(String nomRecherche) {
        String query = "SELECT * FROM person WHERE nom = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nomRecherche);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Personne(rs.getString("nom"), rs.getString("prenom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean supprimerParNom(String nomASupprimer) {
        String query = "DELETE FROM person WHERE nom = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nomASupprimer);
            int lignesAffectees = stmt.executeUpdate();
            return lignesAffectees > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

