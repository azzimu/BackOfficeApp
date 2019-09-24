/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raco
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    @Override
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        
       
	if (Catalogue.listOfWorks.isEmpty()){
        
        Artist artiste1 = new Artist ("Barr Jean Marc");
        Artist artiste2 = new Artist("Stalone");
        Artist artiste3 = new Artist("Jason");
        
        
        Work work1 = new Work("Le grand bleu");
        work1.setGenre("Decouverte");
        work1.setRelease(1995);
        work1.setSummary("Des oceans , une mer , un homme");
        work1.setMainArtist(artiste1);
        
        Work work2= new Work("Rambo");
        work2.setGenre("Action");
        work2.setRelease(1991);
        work2.setSummary("Du stalonne quoi ");
        work2.setMainArtist(artiste2);
        
        
        Work work3= new Work("Le transporteur");
        work3.setGenre("Action");
        work3.setRelease(1999);
        work3.setSummary("Du jason quoi ");
        work3.setMainArtist(artiste3);
        
         Catalogue.listOfWorks.add(work1);
        Catalogue.listOfWorks.add(work2);
        Catalogue.listOfWorks.add(work3);
        
    }
        
        
         //Transfert a la vue catalque.jsp avec le catalogue dans la requete
          /*RequestDispatcher disp =null;
          disp = request.getRequestDispatcher("/WEB-INF/catalogue.jsp");
          request.setAttribute("catalogue", Catalogue.listOfWorks);
          disp.forward(request, response);*/
          
          /*response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            
          
            
          ObjectMapper objectMapper = new ObjectMapper();
            
            
            objectMapper.writeValue(out, Catalogue.listOfWorks);*/
        
        
        
   
   
   
	}
        
        
        
        
        
        
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
