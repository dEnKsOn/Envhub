package dao;

import models.ActiviteDTO;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO {

    /**
     * Récupère les 5 dernières activités globales du système en combinant 
     * les tables Projet, DemandeProjet et Audit_Environnement.
     */
    public List<ActiviteDTO> getTimelineActivites() {
        List<ActiviteDTO> liste = new ArrayList<>();
        
        String sql = 
            "(SELECT CONCAT('Nouveau projet créé : ', nomProjet) AS description, dateLancement AS dateAction " +
            " FROM Projet) " +
            "UNION ALL " +
            "(SELECT CONCAT('Demande reçue de : ', COALESCE(entrepriseClient, nomClient)) AS description, dateSoumission AS dateAction " +
            " FROM DemandeProjet) " +
            "UNION ALL " +
            "(SELECT CONCAT('Modification (', action, ') sur un environnement') AS description, dateModif AS dateAction " +
            " FROM Audit_Environnement) " +
            "ORDER BY dateAction DESC LIMIT 5";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            // Formateur pour un bel affichage sur le Dashboard (ex: 31/05/2026 à 14:30)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
             
            while (rs.next()) {
                String description = rs.getString("description");
                java.sql.Timestamp date = rs.getTimestamp("dateAction");
                
                String dateFormatee = (date != null) ? sdf.format(date) : "Date inconnue";
                
                liste.add(new ActiviteDTO(description, dateFormatee));
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement de la timeline du Dashboard : " + e.getMessage());
        }
        
        return liste;
    }
}