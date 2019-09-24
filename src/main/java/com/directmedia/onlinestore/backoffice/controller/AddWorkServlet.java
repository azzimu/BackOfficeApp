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
import java.util.Optional;
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
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        boolean success=true;
        
        String titre = request.getParameter("titre");
        String annee = request.getParameter("annee");
        String genre = request.getParameter("genre");
        String resume = request.getParameter("resume");
        String artiste = request.getParameter("artiste");
        
        
        Work work = new Work(titre);
        work.setGenre(genre);
        work.setSummary(resume);
        
        Artist artist = new Artist (artiste);
        work.setMainArtist(artist);
        work.setRelease(Integer.parseInt(annee));
        
        
        System.out.println ("LIST " + Catalogue.listOfWorks);
        
           
          try {
            work.setRelease(Integer.parseInt(annee));
             
        
            } catch (NumberFormatException nfe){
              /*disp = request.getRequestDispatcher("/work-add-failure");
               disp.forward(request, response);*/
              success=false;
           }
          
          
         /* for (Work w:Catalogue.listOfWorks){
              if(work.getTitle().equals(w.getTitle()) && work.getRelease() == w.getRelease() && work.getMainArtist().getName().equals(w.getMainArtist().getName())){
                  success=false;
              }
          }*/
         
         Optional<Work> optionalWork =   Catalogue.listOfWorks.stream().filter(w->work.getTitle().equals(w.getTitle()) && work.getRelease() == w.getRelease() && work.getMainArtist().getName().equals(w.getMainArtist().getName())).findAny();
      
      if (optionalWork.isPresent()){
          success=false;
      }
          
          RequestDispatcher disp =null;
            
            if (success){
                Catalogue.listOfWorks.add(work);
                disp = request.getRequestDispatcher("/work-add-success");
                request.setAttribute("identifiantOeuvre", work.getId());
               
            }else {
                disp = request.getRequestDispatcher("/work-add-failure");
               
            }
            disp.forward(request, response);
            
            
           
            
        
        
        
  
       
        
        
        
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
}
