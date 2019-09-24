/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.resources;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author raco
 */
@Path("/work")
public class WorkResource {
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Work> liste (){
        
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
        
        
        
    return Catalogue.listOfWorks;
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@Context UriInfo info) {
        String title = info.getQueryParameters().getFirst("title");
        String genre= info.getQueryParameters().getFirst("genre");
        int  release = Integer.parseInt(info.getQueryParameters().getFirst("release"));
        String summary = info.getQueryParameters().getFirst("summary");
        String artiste = info.getQueryParameters().getFirst("artiste");
        
        Work nouvelleOeuvre = new Work();
        nouvelleOeuvre.setGenre(genre);
        nouvelleOeuvre.setRelease(release);
        nouvelleOeuvre.setTitle(title);
        nouvelleOeuvre.setMainArtist(new Artist(artiste));
        
       Catalogue.listOfWorks.add(nouvelleOeuvre);
        return Response.status(Response.Status.CREATED).build();
    }
    
    
}
