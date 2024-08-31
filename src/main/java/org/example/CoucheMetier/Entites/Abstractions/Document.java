package org.example.CoucheMetier.Entites.Abstractions;

import org.example.CoucheMetier.Entites.Livre;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public abstract class Document {
    private Integer id;
    private String titre;
    private String auteur;
    private LocalDate datePublication;
    private int nombreDePages;
    private  boolean Status;

    public Document(){

    }
    public Document(int id, String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.Status=false;
    }
    public abstract void emprunter();
    public abstract void retourner();
    public abstract void afficherDetails();

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", datePublication='" + datePublication + '\'' +
                ", nombreDePages=" + nombreDePages +
                '}';
    }

}
