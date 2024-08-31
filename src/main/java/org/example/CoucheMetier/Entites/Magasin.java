package org.example.CoucheMetier.Entites;

import org.example.CoucheMetier.Entites.Abstractions.Document;

import java.time.LocalDate;

public class Magasin extends Document {
    private Integer Numero;



    public Magasin(int id, String titre, String auteur, LocalDate datePublication, int nombreDePages, int Numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.Numero=Numero;
    }

    @Override
    public void emprunter() {
        if (!this.isStatus()) {
            this.setStatus(true);
            System.out.println("Le magazine a été emprunté avec succès.");

        }else{
            System.out.println("Le magazine est déjà emprunté.");

        }
    }

    @Override
    public void retourner() {
        if (this.isStatus()){
            this.setStatus(false);
            System.out.println("Le magazine a été retourné avec succès.");
        }else{
            System.out.println("Le magazine n'est pas emprunté.");

        }
    }

    @Override
    public void afficherDetails() {

        // Affichage des détails du document
        System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d |  %-12s | %-15s  %n",
                getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),
                (isStatus() ? "Emprunté" : "Disponible"),Numero);


        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

    }
    public void afficherDetailsMagsin() {


        System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s | %-15s %n",
                "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "Numero");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d |  %-12s | %-15s  %n",
                getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),
                (isStatus() ? "Emprunté" : "Disponible"),Numero);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");


    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", datePublication='" + getDatePublication() + '\'' +
                ", nombreDePages=" + getNombreDePages() +
                ", Numero=" + Numero +

                '}';
    }
}
