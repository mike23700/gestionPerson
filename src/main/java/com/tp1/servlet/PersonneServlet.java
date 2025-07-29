package com.tp1.servlet;

import com.tp1.bean.Personne;
import com.tp1.bean.AccessDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/person")
public class PersonneServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        Personne personne = new Personne(nom, prenom);
        AccessDB db = new AccessDB();

        try {
            db.enregistrerPersonne(personne);
            request.setAttribute("message", "Succès : Personne enregistrée.");
            request.setAttribute("success", true);
        } catch (SQLException e) {
            request.setAttribute("message", "Erreur : " + e.getMessage());
            request.setAttribute("success", false);
        }

        request.setAttribute("personne", personne);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultat.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formulaire.jsp");
        dispatcher.forward(request, response);
    }
}
