package com.tp1.servlet;

import com.tp1.bean.PlusDB;
import com.tp1.bean.Personne;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/gestion")
public class GestionPersonneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String nom = request.getParameter("nom");
        PlusDB db = new PlusDB();

        switch (action) {
            case "liste":
                List<Personne> personnes = db.listerPersonnes();
                request.setAttribute("liste", personnes);
                break;

            case "rechercher":
                if (nom != null && !nom.isEmpty()) {
                    Personne personne = db.rechercherParNom(nom);
                    if (personne != null) {
                        request.setAttribute("personne", personne);
                    } else {
                        request.setAttribute("message", "Aucune personne trouvée.");
                    }
                }
                break;

            case "supprimer":
                if (nom != null && !nom.isEmpty()) {
                    boolean success = db.supprimerParNom(nom);
                    if (success) {
                        request.setAttribute("message", "Personne supprimée avec succès.");
                    } else {
                        request.setAttribute("message", "Aucune personne avec ce nom.");
                    }
                }
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gestion.jsp");
        dispatcher.forward(request, response);
    }
}
